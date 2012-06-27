package com.bombitarodriguez.menues.items;

import com.bombitarodriguez.menues.Menu;
import com.bombitarodriguez.menues.pantallas.PantallaNuevaPartida;
import com.bombitarodriguez.vista.factory.menues.items.VistaItemCargarPartida;


public class ItemCargarPartida extends ItemMenu{
	
	public ItemCargarPartida(Menu menuPadre, int posX, int posY){

		super(menuPadre);
		this.setX(posX);
		this.setY(posY);

		this.setVistaItem(new VistaItemCargarPartida());
		this.getVistaItem().setPosicionable(this);
		this.getVistaItem().itemOut();
	}
	

	@Override
	public void seleccionar() {

		this.getMenuPadre().borrar();
		PantallaNuevaPartida pantallaNuevaPartida = new PantallaNuevaPartida(0, 0, this.getMenuPadre().getVentanaPrincipal());
		pantallaNuevaPartida.mostrar();
		pantallaNuevaPartida.cargarJuego();
		pantallaNuevaPartida.activarControl();
		
	}
}
