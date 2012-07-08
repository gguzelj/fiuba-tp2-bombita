package com.bombitarodriguez.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mauro
 */
public class Casillero {
	
	private List<Objeto> objetos;

	private Posicion posicion;
	
	public Casillero(Posicion posicion) {
		this.objetos = new ArrayList<Objeto>();
		this.posicion = posicion;
	}
	
	public void agregarObjeto(Objeto objeto) {
		objetos.add(objeto);
		objeto.setCoordenadas(this.getPosicion().getPosX(), this.getPosicion().getPosY());
		objeto.setCasillero(this);
	}
	
	public Boolean estaVacio() {
		return objetos.isEmpty();
	}
	
	public void quitarObjeto(Objeto objeto) {
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
	
	public List<Objeto> getObjetos() {
		return objetos;
	}
}
