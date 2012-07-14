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
		this.cantidadDeItems = this.menu.getCantidadDeItems();
	}

	@Override
	public void keyPressed(KeyEvent event) {

		switch (event.getKeyCode()) {

		case KeyEvent.VK_DOWN:
			this.itemOut();
			this.itemActual++;
			this.validarIndice();
			this.itemOver();
			break;

		case KeyEvent.VK_UP:
			this.itemOut();
			this.itemActual--;
			this.validarIndice();
			this.itemOver();
			break;

		case KeyEvent.VK_ENTER:
			this.itemSeleccionar();
			break;
		}
	}

	/**
	 * Seleccionamos el item actual
	 */
	private void itemSeleccionar() {
		this.menu.itemSeleccionar(itemActual);
	}

	/**
	 * El cursor pasa sobre el item actual
	 */
	private void itemOver() {
		this.menu.itemOver(itemActual);
	}

	/**
	 * El cursor se va del item actual
	 */
	private void itemOut() {
		this.menu.itemOut(itemActual);
	}
	
	/**
	 * Validacion para verificar que el indice 
	 * se encuentre dentro de los items
	 */
	protected void validarIndice() {
		if (this.itemActual < 0)
			this.itemActual = this.cantidadDeItems - 1;
		else if(this.itemActual > (this.cantidadDeItems - 1))
			this.itemActual = 0;
	}
}
