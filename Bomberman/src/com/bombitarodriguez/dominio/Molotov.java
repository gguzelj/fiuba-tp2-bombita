package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.vista.factory.dominio.VistaMolotov;

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

	@Override
	public Imagen vistaDeObjeto() {
		return new VistaMolotov();
	}
}
