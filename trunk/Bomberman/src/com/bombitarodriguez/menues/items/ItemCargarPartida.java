package com.bombitarodriguez.menues.items;

import com.bombitarodriguez.menues.Menu;
import com.bombitarodriguez.menues.pantallas.PantallaPartida;
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
		PantallaPartida pantallaPartida = new PantallaPartida(0, 0, this.getMenuPadre().getVentanaPrincipal());
		pantallaPartida.mostrar();
		pantallaPartida.cargarJuego();
		pantallaPartida.activarControl();
		
	}
}
