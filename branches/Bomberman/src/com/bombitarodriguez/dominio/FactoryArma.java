package com.bombitarodriguez.dominio;

public abstract class FactoryArma {
	
	protected Double retardo;
	
	public Arma getArmaInstanciada() {
		return instanciarArma();
	}
	
	public abstract Arma instanciarArma();
	
	public void setRetardo(Double nuevoRetardo) {
		this.retardo = nuevoRetardo;
	}
	
	public Double getRetardo() {
		return retardo;
	}
		
}
