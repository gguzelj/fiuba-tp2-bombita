package com.bombitarodriguez.dominio;

public class FactoryMolotov extends FactoryArma {

	@Override
	public Arma instanciarArma() {
		return new Molotov();
	}

}
