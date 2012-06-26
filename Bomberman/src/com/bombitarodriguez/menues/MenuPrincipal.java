package com.bombitarodriguez.menues;

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
		this.setX(250);
		this.setY(250);
		
		/*Agregamos su vista*/
		this.setVistaMenu(new VistaMenuPrincipal());
		this.getVistaMenu().setPosicionable(this);

		/* Creamos los items de las opciones del menu principal */
		this.agregarItem(new ItemNuevaPartida(this,400,100));
		this.agregarItem(new ItemCargarPartida(this,400,200));
		this.agregarItem(new ItemSalirDelJuego(this,400,300));
		
		/*Agregamos su controlador*/
		this.setControlador(new ControladorMenu(this));
		
	}

	@Override
	public void activarControl() {
		this.setControlador(new ControladorMenu(this));
		this.getVentanaPrincipal().setControladorActivo(this.getControlador());
	}
}