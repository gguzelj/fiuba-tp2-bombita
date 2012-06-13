package com.bombitarodriguez.dominio;

import java.util.Iterator;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;

/**
 * 
 * @author Mauro
 *
 */
public class Cecilio extends Personaje {
	
	public Cecilio(Integer velocidad) {
		this.resistencia = Juego.RESISTENCIA_CECILIO;
		this.velocidad = Juego.VELOCIDAD_CAMINA;
	}	

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		// TODO Acá se termina el juego
		bombita.quitarVida();
		return false;
	}

	@Override
	public Boolean reaccionarCon(Proyectil proyectil) {
		// TODO Debería atacar a Cecilio?
		return false;
	}

	@Override
	protected Boolean reaccionarConTodos(Iterator<ObjetoReaccionable> iterador) {
		// TODO Reacciona con todos¿?
		return null;
	}
}
