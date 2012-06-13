package com.bombitarodriguez.dominio;

import java.util.Iterator;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;

/**
 * 
 * @author Mauro
 *
 */
public class LosLopezReggae extends Personaje {

	

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		// TODO Acá se termina el juego
		return false;
	}


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

}
