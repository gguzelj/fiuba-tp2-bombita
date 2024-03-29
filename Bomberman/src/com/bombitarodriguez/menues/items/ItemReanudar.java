package com.bombitarodriguez.menues.items;

import com.bombitarodriguez.menues.Menu;
import com.bombitarodriguez.menues.MenuPausa;
import com.bombitarodriguez.vista.factory.menues.items.VistaItemReanudar;


public class ItemReanudar extends Item{
	
	public ItemReanudar(Menu menuPadre, int posX, int posY){

		super(menuPadre);
		this.setX(posX);
		this.setY(posY);
		this.itemOver();
		
		this.setVistaItem(new VistaItemReanudar());
		this.getVistaItem().setPosicionable(this);
	}
	

	@Override
	public void seleccionar() {
		
		this.getMenuPadre().getVentanaPrincipal().getJuego().getControlador().setEstaPausado(false);
		this.getMenuPadre().borrar();
		((MenuPausa)this.getMenuPadre()).pantalla.activarControl();

	}
}
