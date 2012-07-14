package com.bombitarodriguez.menues.items;

import com.bombitarodriguez.menues.Menu;
import com.bombitarodriguez.vista.factory.menues.items.VistaItemSalirDelJuego;

public class ItemSalirDelJuego  extends Item{
	
	public ItemSalirDelJuego(Menu menuPadre, int posX, int posY){

		super(menuPadre);
		this.setX(posX);
		this.setY(posY);

		this.setVistaItem(new VistaItemSalirDelJuego());
		this.getVistaItem().setPosicionable(this);
	}
	
	@Override
	public void seleccionar() {
		System.exit(0);
	}
}