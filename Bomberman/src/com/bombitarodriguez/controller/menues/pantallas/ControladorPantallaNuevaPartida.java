package com.bombitarodriguez.controller.menues.pantallas;

import java.awt.event.KeyEvent;

import com.bombitarodriguez.controller.ControladorBombita;
import com.bombitarodriguez.menues.MenuPausa;
import com.bombitarodriguez.menues.pantallas.PantallaNuevaPartida;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControladorPantallaNuevaPartida implements KeyPressedObservador {

	private PantallaNuevaPartida pantalla;
	private ControladorBombita controladorBombita;

	public ControladorPantallaNuevaPartida(PantallaNuevaPartida pantalla) {
		this.pantalla = pantalla;
		this.controladorBombita = pantalla.getVentanaPrincipal().getJuego().getControlador().getControladorBombita();
	}

	@Override
	public void keyPressed(KeyEvent event) {

		/* Le pasamos el evento al controlador de Bombita */
		controladorBombita.keyPressed(event);

		switch (event.getKeyCode()) {

		case KeyEvent.VK_P:
			this.pantalla.getVentanaPrincipal().getJuego().getControlador().setEstaPausado(true);
			MenuPausa menuPausa = new MenuPausa(this.pantalla.getVentanaPrincipal(), this.pantalla);
			menuPausa.mostrar();
			break;
			
		}
	}

	@Override
	public void keyRelease(KeyEvent arg0) {
	}

}
