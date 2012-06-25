package com.bombitarodriguez.menues.pantallas;

import com.bombitarodriguez.controller.menues.pantallas.ControlKeyPressedPantallaNuevaPartida;
import com.bombitarodriguez.menues.MenuPausa;
import com.bombitarodriguez.vista.VentanaPrincipal;
import com.bombitarodriguez.vista.factory.menues.pantallas.VistaPantallaNuevaPartida;


public class PantallaNuevaPartida extends Pantalla{

	public PantallaNuevaPartida(int posX, int posY, VentanaPrincipal ventana) {
		super(posX, posY, ventana);
		
		/*Seteamos la posicion en la pantalla principal*/
		this.setX(ventana.getHeight() / 2);
		this.setY(ventana.getWidth() / 2);
	
		/*Agregamos su vista*/
		this.setVistaPantalla(new VistaPantallaNuevaPartida());
		this.getVistaPantalla().setPosicionable(this);
		this.getVentanaPrincipal().agregarDibujable(this.getVistaPantalla());
		
		/*Creamos el nuevo juego*/
		this.crearJuego();
		
		/*Agregamos su controlador*/
		this.setControlador(new ControlKeyPressedPantallaNuevaPartida(this));
		this.getVentanaPrincipal().setearControladorActivo(this.getControlador());

	}

	public void crearJuego() {
		Integer primerNivel = new Integer(1);
		this.getVentanaPrincipal().getJuego().crearJuego(primerNivel);
	}

	public void juegoEnPausa() {
		this.getVentanaPrincipal().getJuego().getControlador().detenerJuego();
		MenuPausa menuPausa = new MenuPausa(this.getVentanaPrincipal());
		this.getVentanaPrincipal().agregarMenu(menuPausa);
		
	}
}
