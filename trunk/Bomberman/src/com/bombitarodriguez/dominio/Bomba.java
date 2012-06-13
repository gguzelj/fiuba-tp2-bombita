package com.bombitarodriguez.dominio;

/**
 * 
 * @author Mauro
 *
 */
public abstract class Bomba extends Arma {
	
	Boolean estaActiva = false;
	
	/**
	 * Activa la bomba.
	 * @return la bomba con su nuevo estado.
	 */
	abstract Bomba detonar();

}
