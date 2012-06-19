package com.bombitarodriguez.vista;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class VentanaInicio extends Ventana {
	
	private static final long serialVersionUID = 1L;
	private ControladorJuego controladorBomberman;
	private KeyPressedObservador controlKeyPressActivo;
	
	public VentanaInicio(ControladorJuego controladorBomberman) {
		super(Resolucion.ancho, Resolucion.alto, controladorBomberman);
		this.setTitle("Bombita Rodriguez");
		this.setResizable(false);
		this.controladorBomberman = controladorBomberman;
		this.controlKeyPressActivo = null;
	}

}
