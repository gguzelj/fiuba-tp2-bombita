package com.bombitarodriguez.menues.pantallas;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.controller.menues.pantallas.ControladorPantallaNuevaPartida;
import com.bombitarodriguez.vista.VentanaPrincipal;
import com.bombitarodriguez.vista.factory.menues.VistaPantallaNuevaPartida;


public class PantallaNuevaPartida extends Pantalla{

	public PantallaNuevaPartida(int posX, int posY, VentanaPrincipal ventana) {

		super(posX, posY, ventana);
		
		/*Seteamos la posicion en la pantalla principal*/
		this.setX(ventana.getHeight() / 2);
		this.setY(ventana.getWidth() / 2);
		
		this.vistaPantallaNuevaPartida = new VistaPantallaNuevaPartida();
		this.vistaPantallaNuevaPartida.setPosicionable(this);

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
	
	
	public void mostrar(){
		this.getVentanaPrincipal().agregarDibujable(this.getVistaPantalla());	
	}
	
}
