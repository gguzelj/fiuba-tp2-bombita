package com.bombitarodriguez.dominio;

/**
 * Clase de la cual heredan las bombas del juego:
 * -Molotov
 * -ToleTole
 */
public abstract class Bomba extends Arma {
	
	@Override
	public void vivir() {
		retardo--;
		if (retardo <= 0){
			this.explotar();
		}
	}
	
}
