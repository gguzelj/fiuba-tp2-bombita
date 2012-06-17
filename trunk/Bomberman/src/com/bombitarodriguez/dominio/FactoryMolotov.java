package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Constante;

public class FactoryMolotov extends FactoryArma {

	public FactoryMolotov() {
		this.retardo = Constante.TIMER_MOLOTOV;
	}
	
	public FactoryMolotov(Double nuevoRetardo) {
		this.retardo = nuevoRetardo;
	}

	@Override
	public Arma instanciarArma() {
		return new Molotov(retardo);
	}
}
