package com.bombitarodriguez.dominio;

public class FactoryToleTole extends FactoryArma {

	@Override
	public Arma instanciarArma() {
		return new ToleTole();
	}

}
