package com.bombitarodriguez.dominio;

public class FactoryToleTole extends FactoryArma {

	public FactoryToleTole() {
	}
	
	public FactoryToleTole(Double nuevoRetardo) {
		this.retardo = nuevoRetardo;
	}
		
	@Override
	public Arma instanciarArma() {
		return new ToleTole(retardo);
	}
}
