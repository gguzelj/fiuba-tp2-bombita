package com.bombitarodriguez.dominio;

public abstract class FactoryArma {
	
	public Arma getArmaInstanciada() {
		return instanciarArma();
	}

	public abstract Arma instanciarArma();
	
}
