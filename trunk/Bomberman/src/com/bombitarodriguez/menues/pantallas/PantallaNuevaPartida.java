package com.bombitarodriguez.menues.pantallas;

import com.bombitarodriguez.controller.menues.pantallas.ControlKeyPressedPantallaNuevaPartida;
import com.bombitarodriguez.vista.VentanaPrincipal;
import com.bombitarodriguez.vista.factory.menues.pantallas.VistaPantallaNuevaPartida;


public class PantallaNuevaPartida extends Pantalla{

	public PantallaNuevaPartida(int posX, int posY, VentanaPrincipal ventana) {
		super(posX, posY, ventana);
		
		/*Seteamos la posicion en la pantalla principal*/
		this.setX(posX);
		this.setY(posY);
	
		/*Agregamos su vista*/
		this.setVistaPantalla(new VistaPantallaNuevaPartida());
		this.getVistaPantalla().setPosicionable(this);
		
		/*Agregamos su controlador*/
		this.setControlador(new ControlKeyPressedPantallaNuevaPartida(this));
		
		/*Agregamos la pantalla a objetosDibujables*/
		this.getVentanaPrincipal().agregarDibujable(this.getVistaPantalla());
	}

	public void mostrar() {
//		this.getVentanaPrincipal().
	}

	public void crearJuego() {
		Integer primerNivel = new Integer(1);
		this.getVentanaPrincipal().getJuego().crearJuego(primerNivel);
	}
}
