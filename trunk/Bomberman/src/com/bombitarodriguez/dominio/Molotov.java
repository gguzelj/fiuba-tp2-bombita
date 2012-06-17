package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Constante;

/**
 * 
 * @author Mauro
 *
 */
public class Molotov extends Bomba {

	public Molotov() {
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_MOLOTOV;
		this.retardo = Constante.TIMER_MOLOTOV;
		this.destruccion = Constante.DESTRUCCION_MOLOTOV;
	}
	
	public Molotov(Double retardo) {
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_MOLOTOV;
		this.destruccion = Constante.DESTRUCCION_MOLOTOV;
		this.retardo = retardo;
	}
}
