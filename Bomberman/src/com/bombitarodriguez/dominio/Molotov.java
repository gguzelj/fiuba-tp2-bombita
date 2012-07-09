package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro
 */
public class Molotov extends Bomba{

	public Molotov() {
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_MOLOTOV;
		this.retardo = Constante.TIMER_MOLOTOV;
		this.destruccion = Constante.DESTRUCCION_MOLOTOV;
		this.id = Identificaciones.molotov;
	}
	
	public Molotov(Double retardo) {
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_MOLOTOV;
		this.destruccion = Constante.DESTRUCCION_MOLOTOV;
		this.retardo = retardo;
		this.id = Identificaciones.molotov;
	}

	@Override
	public void vivir() {
		retardo--;
		if (retardo <= 0){
			this.explotar();
		}
	}

}
