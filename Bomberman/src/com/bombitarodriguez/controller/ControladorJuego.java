package com.bombitarodriguez.controller;

import com.bombitarodriguez.acciones.AccionAbstracta;
import com.bombitarodriguez.acciones.AccionMovimiento;
import com.bombitarodriguez.dominio.Personaje;
import com.bombitarodriguez.utils.Direccion;

public class ControladorJuego {
	
	AccionAbstracta accion;
	
	public void requestMover(Personaje personaje, Direccion direccion) {
		
		accion = new AccionMovimiento(personaje, direccion);
		accion.ejectuarAccion();
	}
	
	public void requestCrearMapa() {
		
	}

}
