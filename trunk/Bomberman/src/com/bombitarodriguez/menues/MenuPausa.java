package com.bombitarodriguez.menues;

import com.bombitarodriguez.vista.VentanaPrincipal;
import com.bombitarodriguez.vista.factory.menues.VistaMenuPausa;

public class MenuPausa extends Menu {

	public MenuPausa(VentanaPrincipal ventanaPrincipal) {
		super(ventanaPrincipal);

		/*Seteamos la posicion en la pantalla principal*/
		this.setX(ventanaPrincipal.getHeight() / 2);
		this.setY(ventanaPrincipal.getWidth() / 2);
		
		/*Agregamos su vista*/
		this.setVistaMenu(new VistaMenuPausa());
		this.getVistaMenu().setPosicionable(this);

		/* Creamos los items de las opciones del menu principal */
//		this.agregarItem(new ItemNuevaPartida(this,400,100));
//		this.agregarItem(new ItemCargarPartida(this,400,200));
//		this.agregarItem(new ItemSalirDelJuego(this,400,300));
//		
//		/*Agregamos su controlador*/
//		this.setControlador(new ControlKeyPressedMenuPrincipal(this));
		
	}
	
	
	
}
