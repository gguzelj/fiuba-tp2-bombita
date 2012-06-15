package com.bombitarodriguez.dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Direccion;

/**
 * 
 * @author Mauro
 *
 */
public class LosLopezReggae extends Personaje {

	@Override
	protected Boolean reaccionarConTodos(Iterator<ObjetoReaccionable> iterador) {
		// TODO Definir
		return null;
	}
	
	@Override
	public void usarArma() {
		lanzarProyectil();
		
	}
	
	public void lanzarProyectil() {
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
	public Boolean reaccionarCon(Arma arma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		// TODO Auto-generated method stub
		return null;
	}

}
