package com.bombitarodriguez.dominio;

/**
 * 
 * @author Mauro
 *
 */
public class Posicion {
	
	private Integer posX;
	
	private Integer posY;
	
	public Posicion(Integer x, Integer y) {
		this.posX = x;
		this.posY = y;
	}
	
	@Override
	public int hashCode() {
		return Integer.parseInt(posX.toString() + posY.toString());	
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getPosX().equals(((Posicion) obj).getPosX()) && (this.getPosY().equals(((Posicion) obj).getPosY())));
	}
	
	public Integer getPosX() {
		return posX;
	}

	public void setPosX(Integer posX) {
		this.posX = posX;
	}

	public Integer getPosY() {
		return posY;
	}

	public void setPosY(Integer posY) {
		this.posY = posY;
	}
	
}
