package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro
 */
public class ToleTole extends Bomba {
	
	public ToleTole() {
		this.destruccion = Constante.DESTRUCCION_TOLETOLE;
		this.retardo = Constante.TIMER_TOLETOLE;
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_TOLETOLE;
		this.id = Identificaciones.toleTole;
	}

	public ToleTole(Double retardo){
		this.destruccion = Constante.DESTRUCCION_TOLETOLE;
		this.retardo =  Constante.TIMER_TOLETOLE;
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_TOLETOLE;
		this.id = Identificaciones.toleTole;
	}

}
