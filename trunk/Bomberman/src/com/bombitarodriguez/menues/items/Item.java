package com.bombitarodriguez.menues.items;


import com.bombitarodriguez.menues.Menu;
import com.bombitarodriguez.vista.factory.menues.items.VistaItem;

import ar.uba.fi.algo3.titiritero.Direccion;
import ar.uba.fi.algo3.titiritero.Posicionable;

public abstract class Item implements Posicionable{

	private VistaItem vistaItem;
	private Menu menuPadre;
	private int posX;
	private int posY;
	private boolean isOver = false;
	
	public Item(Menu menuPadre){
		this.menuPadre = menuPadre; 
	}
	
	@Override
	public int getX() {
		return posX;
	}

	@Override
	public int getY() {
		return posY;
	}
	
	public void setX(int x){
		this.posX = x;
	}
	
	public void setY(int y){
		this.posY = y;
	}
	
	public VistaItem getVistaItem() {
		return vistaItem;
	}

	public void setVistaItem(VistaItem vistaItem) {
		this.vistaItem = vistaItem;
	}
	
	public Menu getMenuPadre(){
		return this.menuPadre;
	}
	
	@Override
	public Direccion getDireccion() {
		return null;
	}
	
	public abstract void seleccionar();

	public boolean isOver() {
		return isOver;
	}

	public void itemOver() {
		isOver = true;
	}
	
	public void itemOut() {
		isOver = false;
	}
}
