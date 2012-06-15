package com.bombitarodriguez.dominio;

import java.util.Iterator;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Direccion;


/**
 * 
 * @author Mauro
 *
 */
public class LosLopezReggaeAlado extends Personaje {
	
	@Override
	protected Boolean reaccionarConTodos(Iterator<ObjetoReaccionable> iterador) {
		Boolean permitePasar = true;
		while (iterador.hasNext() && (permitePasar)) {
			permitePasar = iterador.next().reaccionarCon(this);
		}
		return permitePasar;
	}
	
	@Override
	public void usarArma() {
		plantarBomba();
		
	}

	private void plantarBomba() {
		getCasillero().agregarObjeto(factoryArma.getArmaInstanciada());
		
	}


	@Override
	public void moverseConEstrategia(Direccion direccion) {
		Boolean casilleroValido = false;
		Posicion nuevaPosicion = Mapa.getMapa().getNuevaPosicion(this.getPosicion(), direccion);
		Casillero casilleroProximo = Mapa.getMapa().getCasillero(nuevaPosicion);
		Posicion posicionParcial;
		Iterator<ObjetoReaccionable> iterador; 
		while (!casilleroValido){
			iterador = casilleroProximo.getObjetos().iterator();
			if (reaccionarConTodos(iterador)) {
				casilleroValido = true;
			}
			else {
				posicionParcial = nuevaPosicion;
				nuevaPosicion = Mapa.getMapa().getNuevaPosicion(posicionParcial, direccion);
				casilleroProximo = Mapa.getMapa().getCasillero(nuevaPosicion);
			}
		}	
	 	Mapa.getMapa().reposicionar(this, casilleroProximo);
		
	}



	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		// TODO Auto-generated method stub
		return null;
	}


}
