package com.bombitarodriguez.menues.pantallas;

import com.bombitarodriguez.controller.menues.pantallas.ControladorPantallaNuevaPartida;
import com.bombitarodriguez.vista.VentanaPrincipal;


public class PantallaNuevaPartida extends Pantalla{

	public PantallaNuevaPartida(int posX, int posY, VentanaPrincipal ventana) {

		super(posX, posY, ventana);
		
		/*Seteamos la posicion en la pantalla principal*/
		this.setX(ventana.getHeight() / 2);
		this.setY(ventana.getWidth() / 2);

	}

	public void crearJuego() {
		Integer primerNivel = new Integer(1);
		this.getVentanaPrincipal().getJuego().crearJuego(primerNivel);
	}

	
	@Override
	public void activarControl() {
		this.setControlador(new ControladorPantallaNuevaPartida(this));
		this.getVentanaPrincipal().setControladorActivo(this.getControlador());
	}
	
}
