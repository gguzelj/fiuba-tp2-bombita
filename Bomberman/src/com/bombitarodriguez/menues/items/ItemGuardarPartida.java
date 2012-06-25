package com.bombitarodriguez.menues.items;

import com.bombitarodriguez.menues.Menu;
import com.bombitarodriguez.vista.factory.menues.items.VistaItemGuardarPartida;


public class ItemGuardarPartida extends ItemMenu{
	
	public ItemGuardarPartida(Menu menuPadre, int posX, int posY){

		super(menuPadre);
		this.setX(posX);
		this.setY(posY);

		this.setVistaItem(new VistaItemGuardarPartida());
		this.getVistaItem().setPosicionable(this);
		this.getVistaItem().itemOut();
	}
	

	@Override
	public void seleccionar() {

//		MenuNuevaPartida menuNuevaPartida = new MenuNuevaPartida(this.getVentanaPrincipal(), this.getMenuDelItem());
//		menuNuevaPartida.mostrar();
	}
}
