package com.bombitarodriguez.dominio;

public class FactoryToleTole extends FactoryArma {

	public FactoryToleTole() {
	}
	
	public FactoryToleTole(Double nuevoRetardo) {
		this.nuevoRetardo = nuevoRetardo;
	}
		
	@Override
	public Arma instanciarArma() {
		return new ToleTole(nuevoRetardo);
	}

}
