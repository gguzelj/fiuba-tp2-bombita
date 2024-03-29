package com.bombitarodriguez.menues;

import java.util.ArrayList;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.controller.menues.ControladorMenu;
import com.bombitarodriguez.menues.items.Item;
import com.bombitarodriguez.vista.VentanaPrincipal;
import com.bombitarodriguez.vista.factory.menues.VistaMenuPrincipal;


public abstract class Menu implements Posicionable{

	protected VentanaPrincipal ventanaPrincipal;
	protected Imagen vistaMenu;
	protected ArrayList<Item> Items;
	protected KeyPressedObservador keyPressControl;
	protected int posX;
	protected int posY;
	protected ControladorBomberman controlador;
	
	public Menu(VentanaPrincipal ventanaPrincipal){
		this.ventanaPrincipal = ventanaPrincipal;
		this.Items = new ArrayList<Item>();
	}

	public void setControlador(ControladorMenu controlador) {
		this.keyPressControl = controlador;
	}
	
	public KeyPressedObservador getControlador() {
		return this.keyPressControl;
	}
	
	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}
	
	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
	
	public void setVistaMenu(VistaMenuPrincipal vistaMenu) {
		this.vistaMenu = vistaMenu;
	}
	
	public Imagen getVistaMenu() {
		return this.vistaMenu;
	}
	
	public void setVistaMenu(Imagen vistaMenu) {
		this.vistaMenu = vistaMenu;
	}
	
	public void agregarItem(Item item) {
		this.Items.add(item);
	}
	
	public void borrarItem(Item item) {
		this.Items.remove(item);
	}
	
	public ArrayList<Item> getItems() {
		return Items;
	}
	
	@Override
	public int getX() {
		return this.posX;
	}

	@Override
	public int getY() {
		return this.posY;
	}
	
	public void setX(int x){
		this.posX = x;
	}
	
	public void setY(int y){
		this.posY = y;
	}

	public void mostrar() {
		this.getVentanaPrincipal().agregarMenu(this);	
		this.activarControl();
	}
	
	public void borrar() {
		this.getVentanaPrincipal().quitarMenu(this);
	}
	
	public abstract void activarControl();

	public int getCantidadDeItems() {
		return getItems().size();
	}

	public void itemSeleccionar(int itemActual) {
		getItems().get(itemActual).seleccionar();	
	}

	public void itemOver(int itemActual) {
		getItems().get(itemActual).itemOver();
	}

	public void itemOut(int itemActual) {
		getItems().get(itemActual).itemOut();
	}
	
}
