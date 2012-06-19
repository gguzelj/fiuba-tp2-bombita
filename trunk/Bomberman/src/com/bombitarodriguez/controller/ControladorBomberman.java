package com.bombitarodriguez.controller;


import ar.uba.fi.algo3.titiritero.ControladorJuego;

import com.bombitarodriguez.acciones.AccionAbstracta;
import com.bombitarodriguez.acciones.AccionMovimiento;
import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.dominio.Personaje;
import com.bombitarodriguez.utils.Direccion;

public class ControladorBomberman extends ControladorJuego {
	
	AccionAbstracta accion;
	Personaje bombita;
	
	public ControladorBomberman(boolean activarReproductor, Personaje bombita) {
		super(activarReproductor);
		this.bombita = bombita;
	}


	public void requestMover(Personaje personaje, Direccion direccion) {
		
		accion = new AccionMovimiento(personaje, direccion);
		accion.ejectuarAccion();
	}
	
	public void requestCrearMapa() {
		
	}
	

}
