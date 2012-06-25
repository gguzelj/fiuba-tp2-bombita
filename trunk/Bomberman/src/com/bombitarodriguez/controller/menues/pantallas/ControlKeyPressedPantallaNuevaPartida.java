package com.bombitarodriguez.controller.menues.pantallas;

import java.awt.event.KeyEvent;

import com.bombitarodriguez.controller.ControladorBombita;
import com.bombitarodriguez.menues.pantallas.PantallaNuevaPartida;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControlKeyPressedPantallaNuevaPartida implements KeyPressedObservador {

	private PantallaNuevaPartida pantalla;
	private ControladorBombita controladorBombita;

	public ControlKeyPressedPantallaNuevaPartida(PantallaNuevaPartida pantalla) {
		this.pantalla = pantalla;
		this.controladorBombita = pantalla.getVentanaPrincipal().getJuego().getControlador().getControladorBombita(); 
	}

	@Override
	public void keyPressed(KeyEvent event) {

		controladorBombita.keyPressed(event);
		
		switch (event.getKeyCode()) {

		case KeyEvent.VK_P:
			/*Pausamos el juego*/
			pantalla.juegoEnPausa();
			break;

		case KeyEvent.VK_UP:
			break;

		case KeyEvent.VK_ENTER:
			break;
		}
	}

	@Override
	public void keyRelease(KeyEvent arg0) {
	}

}
