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


//private Imagen imagenOut;
//private Imagen imagenOver;
//private Imagen imagenActual = new Imagen();
//
//
//public VistaItem(Imagen imgOut, Imagen imgOver){
//	this.imagenOut = imgOut;
//	this.imagenOver	= imgOver;		
//	this.itemOut();
//}
//
//
//public void setPosicionable(Posicionable posicionable) {
//	this.imagenOut.setPosicionable(posicionable);
//	this.imagenOver.setPosicionable(posicionable);
//}
//
//public Imagen getImagenActual(){
//	return this.imagenActual;
//}
//
//public void itemOut(){
//	this.imagenActual = this.imagenOut;
////	this.imagenActual.setImagenDiferente(this.imagenOut);
//}
//
//public void itemOver(){
//	this.imagenActual = this.imagenOver;
////	this.imagenActual.setImagenDiferente(this.imagenOver);
//}

