package com.bombitarodriguez.dominio;

public abstract class FactoryArma {
	
	protected Double nuevoRetardo;
	
	
	public Arma getArmaInstanciada() {
		return instanciarArma();
	}
	
	public abstract Arma instanciarArma();
	
	protected void setNuevoRetardo(Double nuevoRetardo) {
		this.nuevoRetardo = nuevoRetardo;
	}
	
	protected Double getNuevoRetardo() {
		return nuevoRetardo;
	}
		
}
