package com.bombitarodriguez.dominio;

import java.awt.Rectangle;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class Nivel implements Posicionable{
	protected Rectangle cuerpo;
	int pos = 0;
	
	public Nivel(int unAncho, int unAlto){
		cuerpo = new Rectangle(0, 0, unAncho, unAlto);
	}

	@Override
	public int getX() {
		if(pos >= 100)
			return pos--;
		
		return pos++;
	}

	@Override
	public int getY() {
		if(pos >= 100)
			return pos--;
		return pos++;
	}
}
