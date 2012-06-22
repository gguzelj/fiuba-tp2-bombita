package com.bombitarodriguez.controller;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

import com.bombitarodriguez.acciones.AccionAbstracta;
import com.bombitarodriguez.acciones.AccionMovimiento;
import com.bombitarodriguez.dominio.Personaje;
import com.bombitarodriguez.utils.Direccion;

public class ControladorJuegoBomberman extends ControladorJuego {
	
	private SuperficieDeDibujo superficieDeDibujo;
	
	
	public ControladorJuegoBomberman(boolean activarReproductor) {
		super(activarReproductor);
	}

	AccionAbstracta accion;
	
	public void requestMover(Personaje personaje, Direccion direccion) {
		
		accion = new AccionMovimiento(personaje, direccion);
		accion.ejectuarAccion();
	}
	
	public void requestCrearMapa() {
		
	}

}
