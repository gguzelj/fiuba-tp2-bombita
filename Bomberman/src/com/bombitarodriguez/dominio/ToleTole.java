package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.vista.factory.VistaToleTole;

/**
 * 
 * @author Mauro
 *
 */
public class ToleTole extends Bomba {
	
	public ToleTole() {
		this.destruccion = Constante.DESTRUCCION_TOLETOLE;
		this.retardo = Constante.TIMER_TOLETOLE;
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_TOLETOLE;
	}

	public ToleTole(Double retardo){
		this.destruccion = Constante.DESTRUCCION_TOLETOLE;
		this.retardo = retardo;
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_TOLETOLE;
	}

	@Override
	public Imagen vistaDeObjeto() {
		return new VistaToleTole();
	}
	
}
