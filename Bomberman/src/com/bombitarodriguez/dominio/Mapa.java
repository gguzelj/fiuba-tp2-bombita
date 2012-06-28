package com.bombitarodriguez.dominio;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.bombitarodriguez.excepciones.FueraDelMapaException;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.persistencia.PersistenciaPartidaXML;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;
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
	
	
	public Casillero getCasillero(Posicion posicion) {
		return mapa.mapaCasillero.get(posicion);
	}
	
	public void intentarMovimiento(Personaje personaje, Direccion direccion) {
		personaje.moverseConEstrategia(direccion);

	}
	
	public void reposicionar(ObjetoReaccionable objetoAMover, Casillero casilleroAOcupar) {
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
			Integer codigoObjeto = Integer.parseInt(objetosDeUnaFila[x]);
			Casillero casillero = null;
			switch(codigoObjeto) {
			case -3:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new LosLopezReggaeAlado());
				break;
			case -2:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new LosLopezReggae());
				break;
			case -1:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new Cecilio());
				break;
			case 0:  
				++ coordenadaX;
				break;
			case 1:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new Bombita(3));
				break;
			case 2:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueLadrillo());
				break;
			case 3:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueCemento());
				break;
			case 4:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueAcero());
				break;
			case 21:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueLadrillo(new Chala()));
				break;
			case 22:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueLadrillo(new Timer()));
				break;
			case 23:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueLadrillo(new ArticuloToleTole()));
				break;
			case 24:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueLadrillo(new Salida()));
				break;
			case 31:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueCemento(new Chala()));
				break;
			case 32:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueCemento(new Timer()));
				break;
			case 33:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueCemento(new ArticuloToleTole()));
				break;
			case 34:  
				casillero = getCasillero(new Posicion(++ coordenadaX,y));
				casillero.agregarObjeto(new BloqueCemento(new Salida()));
				break;
			default: throw new AssertionError("no existe objeto para este codigo: " + codigoObjeto);
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
	
	
}
