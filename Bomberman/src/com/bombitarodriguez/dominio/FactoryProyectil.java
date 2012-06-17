package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Constante;

public class FactoryProyectil extends FactoryArma {

	public FactoryProyectil(){
		this.retardo = Constante.TIMER_PROYECTIL;		
	}
	
	public FactoryProyectil(Double nuevoRetardo) {
		this.retardo = nuevoRetardo;
	}

	@Override
	public Arma instanciarArma() {
		return new Proyectil(retardo);
	}
}
