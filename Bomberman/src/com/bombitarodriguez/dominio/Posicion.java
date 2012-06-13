package com.bombitarodriguez.dominio;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;

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
		return (this.getPosX() == ((Posicion) obj).getPosX()) && (this.getPosY() == ((Posicion) obj).getPosY());
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
	
	public static Posicion calcularPosicionDerecha(ObjetoReaccionable objeto, Integer aumento) {
		Posicion posicionActual = objeto.getPosicion();
		return new Posicion(posicionActual.getPosX() + aumento,posicionActual.getPosY());
	}

	public static Posicion calcularPosicionIzquierda(ObjetoReaccionable objeto, Integer aumento) {
		Posicion posicionActual = objeto.getPosicion();
		return new Posicion(posicionActual.getPosX() - aumento,posicionActual.getPosY());
	}

	public static Posicion calcularPosicionArriba(ObjetoReaccionable objeto, Integer aumento) {
		Posicion posicionActual = objeto.getPosicion();
		return new Posicion(posicionActual.getPosX(),posicionActual.getPosY() + aumento);
	}

	public static Posicion calcularPosicionAbajo(ObjetoReaccionable objeto, Integer aumento) {
		Posicion posicionActual = objeto.getPosicion();
		return new Posicion(posicionActual.getPosX(),posicionActual.getPosY() - aumento);
	}
}
