package com.bombitarodriguez.dominio;

import java.util.HashMap;

import com.bombitarodriguez.excepciones.FueraDelMapaException;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;

/**
 * 
 * @author Mauro
 *
 */
public class Mapa {
	
	static private Mapa mapa;
	HashMap<Posicion, Casillero> mapaCasillero;
	
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
	
	
}
