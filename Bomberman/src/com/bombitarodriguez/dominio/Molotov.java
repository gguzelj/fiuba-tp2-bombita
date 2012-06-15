package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Constante;

/**
 * 
 * @author Mauro
 *
 */
public class Molotov extends Bomba {

	public Molotov() {
		this.retardo = retardo;
	}
	
	public Molotov(Double retardo) {
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_MOLOTOV;
		this.retardo = retardo;
	}


}
