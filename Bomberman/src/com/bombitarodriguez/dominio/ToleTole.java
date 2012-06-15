package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Constante;

/**
 * 
 * @author Mauro
 *
 */
public class ToleTole extends Bomba {
	
	public ToleTole() {
		this.retardo = Constante.TIMER_TOLETOLE;
	}

	public ToleTole(Double retardo){
		this.destruccion = Constante.DESTRUCCION_TOLETOLE;
		this.retardo = retardo;
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_TOLETOLE;
	}
	
}
