package com.bombitarodriguez.menues;

import com.bombitarodriguez.controller.ControladorBombita;
import com.bombitarodriguez.controller.menues.ControladorMenu;
import com.bombitarodriguez.menues.items.ItemGuardarPartida;
import com.bombitarodriguez.menues.items.ItemReanudar;
import com.bombitarodriguez.menues.items.ItemSalirDelJuego;
import com.bombitarodriguez.menues.pantallas.Pantalla;
import com.bombitarodriguez.vista.VentanaPrincipal;
import com.bombitarodriguez.vista.factory.menues.VistaMenuPausa;

public class MenuPausa extends Menu {

	
	public Pantalla pantalla;
	
	public MenuPausa(VentanaPrincipal ventanaPrincipal, Pantalla pantalla) {
		
		super(ventanaPrincipal);

		this.pantalla = pantalla;
		
		/*Seteamos la posicion en la pantalla principal*/
		this.setX(ventanaPrincipal.getHeight() / 2);
		this.setY(ventanaPrincipal.getWidth() / 2);
		
		/*Agregamos su vista*/
		this.setVistaMenu(new VistaMenuPausa());
		this.getVistaMenu().setPosicionable(this);

		/* Creamos los items de las opciones del menu principal */
		this.agregarItem(new ItemReanudar(this,getX(),250));
		this.agregarItem(new ItemGuardarPartida(this,getX(),300));
		this.agregarItem(new ItemSalirDelJuego(this,getX(),350));
		
	}
	
	@Override
	public void activarControl() {
		this.setControlador(new ControladorMenu(this));
		this.getVentanaPrincipal().setControladorActivo(this.getControlador());
	}
	
}
