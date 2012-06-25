package com.bombitarodriguez.menues.pantallas;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

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
//		this.setControlador(new ControlKeyPressedMenuPrincipal(this));
		
		/*Agregamos la pantalla a objetosDibujables*/
		this.getVentanaPrincipal().agregarDibujable(this.getVistaPantalla());
	}

	public void mostrar() {
//		this.getVentanaPrincipal().
	}
}
