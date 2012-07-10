package com.bombitarodriguez.dominio;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.bombitarodriguez.excepciones.FueraDelMapaException;
import com.bombitarodriguez.persistencia.PersistenciaPartidaXML;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;
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
	static private Integer dimension;
	private Posicion posicionBombita;
	private Integer nivelJuegoActual;
	private static List<Objeto> objetosParaAgregar = new ArrayList<Objeto>();
	private static List<Objeto> objetosParaBorrar = new ArrayList<Objeto>();
	
	public static Integer getDimension() {
		return dimension;
	}

	public static void setDimension(Integer dimension) {
		Mapa.dimension = dimension;
	}

	private Mapa() {
		mapaCasillero = new HashMap<Posicion, Casillero>();
	}
	
	static public Mapa getMapa() {
		if (mapa == null) {
			mapa = new Mapa();
		}
		return mapa;
	}
	
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

	public HashMap<Posicion, Casillero> getMapaCasillero() {
		return mapaCasillero;
	}

	public void setMapaCasillero(HashMap<Posicion, Casillero> mapaCasillero) {
		this.mapaCasillero = mapaCasillero;
	}
	
	public void crearMapa(File file) {
		List<String> objetosACrear = Parser.parsearMapXML(file);
		
		/*Durante la creacion del mapa, guardo su dimension*/
		Mapa.setDimension(objetosACrear.size());
		
		crearCasillerosVacios(objetosACrear.size());
		Integer coordenadaY = 0;
		for (Integer y = 0; y < objetosACrear.size(); y ++) {
			String[] objetosDeUnaFila = Parser.parsearLista(objetosACrear.get(y));
			crearObjetosEnElMapa(objetosDeUnaFila, ++ coordenadaY);
		}		
	}
	
	public void cargarPartida() {
		PersistenciaPartidaXML persistencia = new PersistenciaPartidaXML(Constante.NOMBRE_ARCHIVO_PARTIDA);
		persistencia.cargarDominioDeXML();
	}
	
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
