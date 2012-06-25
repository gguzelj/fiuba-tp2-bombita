package com.bombitarodriguez.controller.menues;

import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

import com.bombitarodriguez.menues.MenuPrincipal;

public class ControlKeyPressedMenuPrincipal implements KeyPressedObservador {

	private MenuPrincipal menuPrincipal;
	private int itemActual;
	private int cantidadDeItems;

	public ControlKeyPressedMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
		this.itemActual = 0;
		this.cantidadDeItems = this.menuPrincipal.getItems().size();
	}

	@Override
	public void keyPressed(KeyEvent event) {

		switch (event.getKeyCode()) {

		case KeyEvent.VK_DOWN:
			this.menuPrincipal.getItems().get(itemActual).getVistaItem().itemOut();
			this.itemActual--;
			this.validarIndice();
			this.menuPrincipal.getItems().get(itemActual).getVistaItem().itemOver();
			break;

		case KeyEvent.VK_UP:
			this.menuPrincipal.getItems().get(itemActual).getVistaItem().itemOut();
			this.itemActual++;
			this.validarIndice();
			this.menuPrincipal.getItems().get(itemActual).getVistaItem().itemOver();
			break;

		case KeyEvent.VK_ENTER:
			this.menuPrincipal.getItems().get(itemActual).seleccionar();
			break;
		}

	}

	/*Validacion para verificar que el indice se encuentre dentro de los items*/
	private void validarIndice() {
		if (this.itemActual < 0)
			this.itemActual = this.cantidadDeItems - 1;
		else if(this.itemActual > (this.cantidadDeItems - 1))
			this.itemActual = 0;
	}

	@Override
	public void keyRelease(KeyEvent arg0) {
	}
}
