package com.bombitarodriguez.dominio;

import java.util.HashMap;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
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
	
	public void chequearEstado (Casillero casillero){
		
	}
	 public Posicion getNuevaPosicion(Posicion posicionActual, Direccion direccion) {
		 switch (direccion) {
	     	case ABAJO : {
	            return new Posicion(posicionActual.getPosX(), posicionActual.getPosY() - 1);
	        }

	        case IZQUIERDA : {
	            return new Posicion(posicionActual.getPosX() - 1, posicionActual.getPosY());
	        }

	        case ARRIBA : {
	            return new Posicion(posicionActual.getPosX() , posicionActual.getPosY() + 1);
	        }

	        case DERECHA : {
	            return new Posicion(posicionActual.getPosX() + 1, posicionActual.getPosY());
	        }

	        default : {
	            throw new AssertionError("direccion no soportada");
	        }
	    }
	}
	
	
}
