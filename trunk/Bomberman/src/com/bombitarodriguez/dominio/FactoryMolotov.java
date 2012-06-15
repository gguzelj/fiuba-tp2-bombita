package com.bombitarodriguez.dominio;

public class FactoryMolotov extends FactoryArma {

	public FactoryMolotov() {
	}
	
	public FactoryMolotov(Double nuevoRetardo) {
		this.nuevoRetardo = nuevoRetardo;
	}

	@Override
	public Arma instanciarArma() {
		return new Molotov(nuevoRetardo);
	}


}
