package com.bombitarodriguez.menues.items;

import com.bombitarodriguez.menues.Menu;
import com.bombitarodriguez.menues.MenuPausa;
import com.bombitarodriguez.vista.factory.menues.items.VistaItemReanudar;


public class ItemReanudar extends ItemMenu{
	
	public ItemReanudar(Menu menuPadre, int posX, int posY){

		super(menuPadre);
		this.setX(posX);
		this.setY(posY);

		this.setVistaItem(new VistaItemReanudar());
		this.getVistaItem().setPosicionable(this);
		this.getVistaItem().itemOver();
	}
	

	@Override
	public void seleccionar() {
		
		this.getMenuPadre().borrar();
		((MenuPausa)this.getMenuPadre()).pantalla.activarControl();

	}
}
