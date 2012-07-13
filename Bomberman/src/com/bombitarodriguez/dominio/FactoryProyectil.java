package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.Direccion;

import com.bombitarodriguez.utils.Constante;

public class FactoryProyectil extends FactoryArma {

	public FactoryProyectil(){
		this.retardo = Constante.TIMER_PROYECTIL;		
	}
	
	public FactoryProyectil(Double nuevoRetardo) {
		this.retardo = nuevoRetardo;
	}

	public Arma instanciarArma(Direccion direccion, Posicion posicion) {
		return new Proyectil(retardo, direccion, posicion);
	}

	@Override
	public Arma instanciarArma() {
		return null;
	}
}
