package com.bombitarodriguez.menues.items;

import com.bombitarodriguez.menues.Menu;
import com.bombitarodriguez.menues.pantallas.PantallaNuevaPartida;
import com.bombitarodriguez.vista.factory.menues.items.VistaItemNuevaPartida;


public class ItemNuevaPartida extends ItemMenu {

	public ItemNuevaPartida(Menu menuPadre, int PosX, int PosY){

		super(menuPadre);
		this.setX(400);
		this.setY(100);

		this.setVistaItem(new VistaItemNuevaPartida());
		this.getVistaItem().setPosicionable(this);
		this.getVistaItem().itemOver();
		
	}
	
	public void seleccionar(){
		
		this.getMenuPadre().borrar();
		PantallaNuevaPartida pantalla = new PantallaNuevaPartida(this.getMenuPadre().getX(),
																 this.getMenuPadre().getY(),
																 this.getMenuPadre().getVentanaPrincipal());
		pantalla.mostrar();
	}
}
