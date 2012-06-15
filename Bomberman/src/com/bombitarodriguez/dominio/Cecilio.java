package com.bombitarodriguez.dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;

/**
 * 
 * @author Mauro
 *
 */
public class Cecilio extends Personaje {
	
	public Cecilio(Integer velocidad) {
		this.resistencia = Constante.RESISTENCIA_CECILIO;
		this.velocidad = Constante.VELOCIDAD_CAMINA;
	}	

	

//	@Override
//	public Boolean reaccionarCon(Proyectil proyectil) {
//		// TODO Debería atacar a Cecilio?
//		return false;
//	}

	@Override
	protected Boolean reaccionarConTodos(Iterator<ObjetoReaccionable> iterador) {
		// TODO Reacciona con todos¿?
		return null;
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
		Posicion nuevaPosicion = Mapa.getMapa().getNuevaPosicion(this.getPosicion(), direccion);
		Casillero casilleroProximo = Mapa.getMapa().getCasillero(nuevaPosicion);
		// Creo una copia de la lista sobre la cual voy a iterar, ya que se puede modificar
		List<ObjetoReaccionable> copiaObjetosCasillero = new ArrayList<ObjetoReaccionable>();
		copiaObjetosCasillero.addAll(casilleroProximo.getObjetos());
		Iterator<ObjetoReaccionable> iterador = copiaObjetosCasillero.iterator();
		if (reaccionarConTodos(iterador)) {
			Mapa.getMapa().reposicionar(this, casilleroProximo);
		}
		
	}


	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		resistencia = resistencia - (explosion.getDestruccion());
		return true;
	}
}
