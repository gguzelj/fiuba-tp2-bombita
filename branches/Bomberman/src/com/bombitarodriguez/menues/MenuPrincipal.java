package com.bombitarodriguez.menues;

import ar.uba.fi.algo3.titiritero.Direccion;

import com.bombitarodriguez.controller.menues.ControladorMenu;
import com.bombitarodriguez.menues.items.ItemCargarPartida;
import com.bombitarodriguez.menues.items.ItemNuevaPartida;
import com.bombitarodriguez.menues.items.ItemSalirDelJuego;
import com.bombitarodriguez.vista.VentanaPrincipal;
import com.bombitarodriguez.vista.factory.menues.VistaMenuPrincipal;

public class MenuPrincipal extends Menu {

	public MenuPrincipal(VentanaPrincipal ventanaPrincipal) {
		
		super(ventanaPrincipal);
		
		/*Seteamos la posicion en la pantalla principal*/
		this.setX(ventanaPrincipal.getWidth() / 2);
		this.setY(ventanaPrincipal.getHeight() / 2);
		
		/*Agregamos su vista*/
		this.setVistaMenu(new VistaMenuPrincipal());
		this.getVistaMenu().setPosicionable(this);

		/* Creamos los items de las opciones del menu principal */
		this.agregarItem(new ItemNuevaPartida(this,450,150));
		this.agregarItem(new ItemCargarPartida(this,450,250));
		this.agregarItem(new ItemSalirDelJuego(this,450,350));
		
		/*Agregamos su controlador*/
		this.setControlador(new ControladorMenu(this));
		
	}

	@Override
	public void activarControl() {
		this.setControlador(new ControladorMenu(this));
		this.getVentanaPrincipal().setControladorActivo(this.getControlador());
	}

	@Override
	public Direccion getDireccion() {
		// TODO Auto-generated method stub
		return null;
	}
}