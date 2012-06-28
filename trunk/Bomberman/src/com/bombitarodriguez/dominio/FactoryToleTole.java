package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Constante;

public class FactoryToleTole extends FactoryArma {

	public FactoryToleTole() {
		this.retardo = Constante.TIMER_TOLETOLE;
	}
	
	public FactoryToleTole(Double nuevoRetardo) {
		this.retardo = nuevoRetardo;
	}
		
	@Override
	public Arma instanciarArma() {
		return new ToleTole(retardo);
	}
}
