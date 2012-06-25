package com.bombitarodriguez.menues.items;

import com.bombitarodriguez.menues.Menu;
import com.bombitarodriguez.vista.factory.menues.items.VistaItemCargarPartida;
import com.bombitarodriguez.vista.factory.menues.items.VistaItemGuardarPartida;
import com.bombitarodriguez.vista.factory.menues.items.VistaItemReanudar;


public class ItemReanudar extends ItemMenu{
	
	public ItemReanudar(Menu menuPadre, int posX, int posY){

		super(menuPadre);
		this.setX(posX);
		this.setY(posY);

		this.setVistaItem(new VistaItemReanudar());
		this.getVistaItem().setPosicionable(this);
		this.getVistaItem().itemOut();
	}
	

	@Override
	public void seleccionar() {

//		MenuNuevaPartida menuNuevaPartida = new MenuNuevaPartida(this.getVentanaPrincipal(), this.getMenuDelItem());
//		menuNuevaPartida.mostrar();
	}
}
