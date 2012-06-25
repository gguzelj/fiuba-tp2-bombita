package com.bombitarodriguez.menues.items;

import com.bombitarodriguez.menues.Menu;
import com.bombitarodriguez.vista.factory.menues.items.VistaItemCargarPartida;


public class ItemCargarPartida extends ItemMenu{
	
	public ItemCargarPartida(Menu menuPadre, int PosX, int PosY){

		super(menuPadre);
		this.setX(400);
		this.setY(200);

		this.setVistaItem(new VistaItemCargarPartida());
		this.getVistaItem().setPosicionable(this);
		this.getVistaItem().itemOut();
	}
	

	@Override
	public void seleccionar() {

//		MenuNuevaPartida menuNuevaPartida = new MenuNuevaPartida(this.getVentanaPrincipal(), this.getMenuDelItem());
//		menuNuevaPartida.mostrar();
	}
}
