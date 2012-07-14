package com.bombitarodriguez.menues.items;

import com.bombitarodriguez.menues.Menu;
import com.bombitarodriguez.vista.factory.menues.items.VistaItemGuardarPartida;


public class ItemGuardarPartida extends Item{
	
	public ItemGuardarPartida(Menu menuPadre, int posX, int posY){

		super(menuPadre);
		this.setX(posX);
		this.setY(posY);

		this.setVistaItem(new VistaItemGuardarPartida());
		this.getVistaItem().setPosicionable(this);
	}
	

	@Override
	public void seleccionar() {

		this.getMenuPadre().getVentanaPrincipal().getJuego().guardarPartida();
		System.out.println("partida guardada");
		
		
	}
}
