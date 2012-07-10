package com.bombitarodriguez.vista.factory.menues.items;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaItem extends Imagen {

	private Imagen imagenOut;
	private Imagen imagenOver;
	
	public VistaItem(Imagen imagenOut, Imagen imagenOver) {
		this.imagenOut = imagenOut;
		this.imagenOver = imagenOver;
		this.itemOut();
	}
	
	public VistaItem(Imagen imagen) {
		this.imagenOut = imagen;
		this.imagenOver = imagen;
	}
	
	public void itemOut() {
		this.setImagenDiferente(this.imagenOut);
	}
	
	public void itemOver() {
		this.setImagenDiferente(this.imagenOver);
	}
	
	public Imagen getImagenOut(){
		return this.imagenOut;
	}
	
	public Imagen getImagenOver(){
		return this.imagenOver;
	}
}
