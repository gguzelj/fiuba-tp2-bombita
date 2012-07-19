package com.bombitarodriguez.menues.items;

import com.bombitarodriguez.menues.Menu;
import com.bombitarodriguez.menues.pantallas.PantallaPartida;
import com.bombitarodriguez.vista.factory.menues.items.VistaItemCargarPartida;


public class ItemCargarPartida extends Item{
	
	public ItemCargarPartida(Menu menuPadre, int posX, int posY){

		super(menuPadre);
		this.setX(posX);
		this.setY(posY);

		this.setVistaItem(new VistaItemCargarPartida());
		this.getVistaItem().setPosicionable(this);
	}
	

	@Override
	public void seleccionar() {
		PantallaPartida pantallaPartida = new PantallaPartida(0, 0, this.getMenuPadre().getVentanaPrincipal());
		try {
			pantallaPartida.cargarJuego();
		} catch (Exception e) {
			System.out.println("No se encuentra el archivo para restaurar la partida");
			return;
		}
		this.getMenuPadre().borrar();
		pantallaPartida.activarControl();
		pantallaPartida.mostrar();
	}

}
