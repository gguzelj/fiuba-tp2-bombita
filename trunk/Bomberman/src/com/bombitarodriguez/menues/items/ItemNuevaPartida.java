package com.bombitarodriguez.menues.items;

import com.bombitarodriguez.menues.Menu;
import com.bombitarodriguez.menues.pantallas.PantallaPartida;
import com.bombitarodriguez.vista.factory.menues.items.VistaItemNuevaPartida;


public class ItemNuevaPartida extends Item {

	public ItemNuevaPartida(Menu menuPadre, int posX, int posY){

		super(menuPadre);
		this.setX(posX);
		this.setY(posY);
		this.itemOver();
		
		this.setVistaItem(new VistaItemNuevaPartida());
		this.getVistaItem().setPosicionable(this);
 		
	}
	
	public void seleccionar(){
		
		this.getMenuPadre().borrar();
		PantallaPartida pantallaPartida = new PantallaPartida(0, 0, this.getMenuPadre().getVentanaPrincipal());
		pantallaPartida.mostrar();
		pantallaPartida.crearJuego();
		pantallaPartida.activarControl();
		
	}
}
