package com.bombitarodriguez.dominio;

public class FactoryProyectil extends FactoryArma {

	public FactoryProyectil(){
		
	}
	
	public FactoryProyectil(Double nuevoRetardo) {
		this.nuevoRetardo = nuevoRetardo;
	}

	@Override
	public Arma instanciarArma() {
		return new Proyectil(nuevoRetardo);
	}
}
