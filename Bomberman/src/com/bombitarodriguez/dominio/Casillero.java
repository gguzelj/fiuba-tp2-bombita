package com.bombitarodriguez.dominio;

import java.util.ArrayList;
import java.util.List;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;

/**
 * 
 * @author Mauro
 *
 */
public class Casillero {
	
	private List<ObjetoReaccionable> objetos;

	private Posicion posicion;
	
	public Casillero(Posicion posicion) {
		this.objetos = new ArrayList<ObjetoReaccionable>();
		this.posicion = posicion;
	}
	
	public void agregarObjeto(ObjetoReaccionable objeto) {
		objetos.add(objeto);
		objeto.setCoordenadas(this.getPosicion().getPosX(), this.getPosicion().getPosY());
		objeto.setCasillero(this);
	}
	
	public Boolean estaVacio() {
		return objetos.isEmpty();
	}
	
	public void quitarObjeto(ObjetoReaccionable objeto) {
		objetos.remove(objeto);
		objeto.setCoordenadas(this.getPosicion().getPosX(), this.getPosicion().getPosY());
		objeto.setCasillero(null);
	}
	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public List<ObjetoReaccionable> getObjetos() {
		return objetos;
	}
}
