package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;

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
		// TODO Auto-generated method stub
		return null;
	}
}
