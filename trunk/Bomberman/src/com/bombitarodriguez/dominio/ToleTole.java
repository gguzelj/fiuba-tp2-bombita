package com.bombitarodriguez.dominio;


import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.vista.factory.dominio.VistaToleTole;

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
		this.vistaArma = new VistaToleTole();
	}

	public ToleTole(Double retardo){
		this.destruccion = Constante.DESTRUCCION_TOLETOLE;
//		this.retardo = retardo;
		this.retardo =  Constante.TIMER_TOLETOLE;
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_TOLETOLE;
		this.vistaArma = new VistaToleTole();
	}

	@Override
	public Imagen vistaDeObjeto() {
		return this.vistaArma;
	}

	@Override
	public void vivir() {
		retardo--;
		if (retardo <= 0){
			this.explotar();
		}
	}
	
}
