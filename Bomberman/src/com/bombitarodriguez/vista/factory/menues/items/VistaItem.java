package com.bombitarodriguez.vista.factory.menues.items;

import com.bombitarodriguez.menues.items.Item;

import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaItem extends Imagen {

	private Imagen imagenOut;
	private Imagen imagenOver;
    private Posicionable posicionable;
	
	public VistaItem(Imagen imagenOut, Imagen imagenOver) {
		this.imagenOut = imagenOut;
		this.imagenOver = imagenOver;
		this.itemOut();
	}
	
	public VistaItem(Imagen imagen) {
		this.imagenOut = imagen;
		this.imagenOver = imagen;
	}
	
	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Item item = (Item) posicionable;
		
		if(item.isOver()){
			this.itemOver();
		} else {
			this.itemOut();
		}
			
		super.dibujar(superficeDeDibujo);
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

	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;
		super.setPosicionable(posicionable);
	}
}
