package com.bombitarodriguez.dominio;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import ar.uba.fi.algo3.titiritero.Direccion;

import com.bombitarodriguez.excepciones.ArchivoSaveNoEncontrado;
import com.bombitarodriguez.excepciones.FueraDelMapaException;
import com.bombitarodriguez.persistencia.PersistenciaPartidaXML;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Identificaciones;
import com.bombitarodriguez.utils.Parser;

/**
 * 
 * @author Mauro
 *
 */
public class Mapa {
	
	static private Mapa mapa;
	HashMap<Posicion, Casillero> mapaCasillero;
	private Posicion posicionBombita;
	private Integer nivelJuegoActual;
	private static List<Objeto> objetosParaAgregar = new ArrayList<Objeto>();
	private static List<Objeto> objetosParaBorrar = new ArrayList<Objeto>();

	private Mapa() {
		mapaCasillero = new HashMap<Posicion, Casillero>();
	}
	
	static public Mapa getMapa() {
		if (mapa == null) {
			mapa = new Mapa();
		}
		return mapa;
	}
	
	/**
	 * Agregamos una nueva entrada al HashMap
	 * @param posicion
	 * @param casillero
	 */
	public void agregarCasillero(Posicion posicion, Casillero casillero) {
		mapa.mapaCasillero.put(posicion, casillero);
	}
	
	/**
	 * Devuelvo el casillero de la posicion recibida 
	 */
	public Casillero getCasillero(Posicion posicion) {
		return mapa.mapaCasillero.get(posicion);
	}
	
	/**
	 * Reposiciono un objeto del mapa en un nuevo casillero 
	 */
	public void reposicionar(Objeto objetoAMover, Casillero casilleroAOcupar) {
		Casillero casilleroObj = getCasillero(objetoAMover.getPosicion());
		casilleroObj.quitarObjeto(objetoAMover);
		objetoAMover.setCasillero(casilleroAOcupar);
		casilleroAOcupar.agregarObjeto(objetoAMover);
	}

	/**
	 * Metodo utilizado en tests de persistencia
	 * @return
	 */
	public HashMap<Posicion, Casillero> getMapaCasillero() {
		return mapaCasillero;
	}
	
	/**
	 * Iniciamos la creacion del mapa, parseando el archivo XML recibido
	 * @param file
	 */
	public void crearMapa(File file) {
		List<String> objetosACrear = Parser.parsearMapXML(file);
		
		crearCasillerosVacios(objetosACrear.size());
		Integer coordenadaY = 0;
		for (Integer y = 0; y < objetosACrear.size(); y ++) {
			String[] objetosDeUnaFila = Parser.parsearLista(objetosACrear.get(y));
			crearObjetosEnElMapa(objetosDeUnaFila, ++ coordenadaY);
		}		
	}
	
	public void cargarPartida() throws ArchivoSaveNoEncontrado {
		PersistenciaPartidaXML persistencia = new PersistenciaPartidaXML(Constante.NOMBRE_ARCHIVO_PARTIDA);
		persistencia.cargarDominioDeXML();
	}
	
	/**
	 * Cargamos el mapa con casilleros vacios en la cantidad
	 * de columnas indicadas
	 * @param numColumnas
	 */
	public void crearCasillerosVacios(Integer numColumnas) {
		Casillero casillero = null;
		Posicion posicion = null;
		
		for (int x = 1; x <= numColumnas; x++) {

			for (int y = 1; y <= numColumnas; y++) {
				posicion = new Posicion(x, y);
				casillero = new Casillero(posicion);
				Mapa.getMapa().agregarCasillero(posicion, casillero);
			}
		}
	}
	
	/**
	 * Creamos los objetos de una determinada fila del archivo XML parseado
	 * @param objetosDeUnaFila
	 * @param y
	 */
	private void crearObjetosEnElMapa(String[] objetosDeUnaFila, Integer y) {
		Integer coordenadaX = 0;
		
		for (Integer x = 0; x < objetosDeUnaFila.length; x ++) {
			Integer IdObjeto = Integer.parseInt(objetosDeUnaFila[x]);
			Casillero casillero = null;
			switch(IdObjeto) {
			case Identificaciones.lopezReggaeAlado:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new LopezReggaeAlado());
				break;
			case Identificaciones.lopezReggae:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new LopezReggae());
				break;
			case Identificaciones.cecilio:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new Cecilio());
				break;
			case Identificaciones.casilleroVacio:  
				++ coordenadaX;
				break;
			case Identificaciones.bombita:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new Bombita(3));
				break;
			case Identificaciones.bloqueLadrillo:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueLadrillo());
				break;
			case Identificaciones.bloqueCemento:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueCemento());
				break;
			case Identificaciones.bloqueAcero:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueAcero());
				break;
			case Identificaciones.chalaEnBLoqueLadrillo:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueLadrillo(new ArticuloChala()));
				break;
			case Identificaciones.timerEnBloqueLadrillo:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueLadrillo(new ArticuloTimer()));
				break;
			case Identificaciones.toleToleEnBloqueLadrillo:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueLadrillo(new ArticuloToleTole()));
				break;
			case Identificaciones.salidaEnBloqueLadrillo:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueLadrillo(new Salida()));
				break;
			case Identificaciones.chalaEnBLoqueCemento:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueCemento(new ArticuloChala()));
				break;
			case Identificaciones.timerEnBloqueCemento:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueCemento(new ArticuloTimer()));
				break;
			case Identificaciones.toleToleEnBloqueCemento:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueCemento(new ArticuloToleTole()));
				break;
			case Identificaciones.salidaEnBloqueCemento:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueCemento(new Salida()));
				break;
			default: throw new AssertionError("no existe objeto para este codigo: " + IdObjeto);
			}
		}	
	}
	
	/**
	 * Entregamos una nueva posicion, partiendo de una direccion recibida.
	 * Si la nueva posicion se encuentra fuera del mapa, se lanza una excepcion
	 * @param posicionActual
	 * @param direccion
	 * @return
	 * @throws FueraDelMapaException
	 */
	public Posicion getNuevaPosicion(Posicion posicionActual, Direccion direccion) throws FueraDelMapaException {
		Posicion posicion = null;
		switch (direccion) {
	    	case ABAJO : {
	            posicion = new Posicion(posicionActual.getPosX(), posicionActual.getPosY() - 1);
	            break;
	        }

	        case IZQUIERDA : {
	        	posicion = new Posicion(posicionActual.getPosX() - 1, posicionActual.getPosY());
	        	break;
	        }

	        case ARRIBA : {
	        	posicion = new Posicion(posicionActual.getPosX() , posicionActual.getPosY() + 1);
	        	break;
	        }

	        case DERECHA : {
	            posicion = new Posicion(posicionActual.getPosX() + 1, posicionActual.getPosY());
	            break;
	        }
	    }
	    
		if (fueraDeRango(posicion)) {
			throw new FueraDelMapaException("Posicion fuera del mapa");
	    }
		return posicion;
	}

	/**
	 * Validamos que la posicion recibida sea una posicion valida para el mapa
	 * @param posicion
	 * @return
	 */
	private Boolean fueraDeRango(Posicion posicion) {
		if( (posicion.getPosX() < 0) || ( posicion.getPosY() < 0 ))
			return true;
		
		return ( this.getCasillero(posicion) == null );
	}
	
	public Iterator<Entry<Posicion, Casillero>> getEntryIterator() {
		return Mapa.getMapa().getMapaCasillero().entrySet().iterator();
	}

	public static void setMapa(Mapa mapa) {
		Mapa.mapa = mapa;
	}

	public Posicion getPosicionBombita() {
		return posicionBombita;
	}

	/**
	 * Cuando guardamos la partida, es necesario saber la posicion
	 * en donde queda bombita, para poder utilizarlo cuando se vuelva a
	 * cargar la partida
	 * @param posicionBombita
	 */
	public void setPosicionBombita(Posicion posicionBombita) {
		this.posicionBombita = posicionBombita;
	}
	
	public Integer getNivelJuegoActual() {
		return nivelJuegoActual;
	}
	
	public void setNivelJuegoActual(Integer nivelJuegoActual) {
		this.nivelJuegoActual = nivelJuegoActual;
	}

	/**
	 * Agrego el objeto recibido a la lista de objetos para
	 * agregar 
	 */
	public static void objetoParaAgregar(Objeto objeto) {
		objetosParaAgregar.add(objeto);
	}
	
	/**
	 * Metodo llamado por el controlador. Devuelve la lista con los
	 * objetos para agregar en el juego
	 */
	public static List<Objeto> getObjetosParaAgregar() {
		List<Objeto> lista = objetosParaAgregar;
		objetosParaAgregar = new ArrayList<Objeto>();
		return lista;
	}
	
	/**
	 * Agrego el objeto recibido a la lista de objetos para
	 * Borrar
	 */
	public static void objetoParaBorrar(Objeto objeto){
		objetosParaBorrar.add(objeto);
	}

	/**
	 * Metodo llamado por el controlador. Devuelve la lista con los
	 * objetos para borrar en el juego
	 */
	public static List<Objeto> getObjetosParaBorrar() {
		List<Objeto> lista = objetosParaBorrar;
		objetosParaBorrar = new ArrayList<Objeto>();
		return lista;
	}
}
