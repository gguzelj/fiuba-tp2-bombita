package com.bombitarodriguez.controller.menues;

import java.awt.event.KeyEvent;

import com.bombitarodriguez.menues.Menu;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControladorMenu implements KeyPressedObservador {

	protected Menu menu;
	protected int itemActual;
	protected int cantidadDeItems;

	public ControladorMenu(Menu menu) {
		this.menu = menu;
		this.itemActual = 0;
		this.cantidadDeItems = this.menu.getItems().size();
	}

	@Override
	public void keyPressed(KeyEvent event) {

		switch (event.getKeyCode()) {

		case KeyEvent.VK_DOWN:
			this.menu.getItems().get(itemActual).getVistaItem().itemOut();
			this.itemActual++;
			this.validarIndice();
			this.menu.getItems().get(itemActual).getVistaItem().itemOver();
			break;

		case KeyEvent.VK_UP:
			this.menu.getItems().get(itemActual).getVistaItem().itemOut();
			this.itemActual--;
			this.validarIndice();
			this.menu.getItems().get(itemActual).getVistaItem().itemOver();
			break;

		case KeyEvent.VK_ENTER:
			this.menu.getItems().get(itemActual).seleccionar();
			break;
		}
	}
	
	/*Validacion para verificar que el indice se encuentre dentro de los items*/
	protected void validarIndice() {
		if (this.itemActual < 0)
			this.itemActual = this.cantidadDeItems - 1;
		else if(this.itemActual > (this.cantidadDeItems - 1))
			this.itemActual = 0;
	}
}
