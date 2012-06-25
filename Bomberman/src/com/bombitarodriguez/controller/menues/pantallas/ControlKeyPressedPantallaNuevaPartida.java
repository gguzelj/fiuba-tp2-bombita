package com.bombitarodriguez.controller.menues.pantallas;

import java.awt.event.KeyEvent;

import com.bombitarodriguez.menues.pantallas.PantallaNuevaPartida;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControlKeyPressedPantallaNuevaPartida implements KeyPressedObservador {

	private PantallaNuevaPartida pantalla;
	
	
	public ControlKeyPressedPantallaNuevaPartida(PantallaNuevaPartida pantalla) {
		this.pantalla = pantalla;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

	}

	@Override
	public void keyRelease(KeyEvent arg0) {
	}

}
