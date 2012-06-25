package com.bombitarodriguez.menues;

import com.bombitarodriguez.menues.items.ItemGuardarPartida;
import com.bombitarodriguez.menues.items.ItemNuevaPartida;
import com.bombitarodriguez.menues.items.ItemSalirDelJuego;
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
		this.agregarItem(new ItemNuevaPartida(this,getX(),250));
		this.agregarItem(new ItemGuardarPartida(this,getX(),300));
		this.agregarItem(new ItemSalirDelJuego(this,getX(),350));
		
//		/*Agregamos su controlador*/
//		this.setControlador(new ControlKeyPressedMenuPrincipal(this));
		
	}
}
