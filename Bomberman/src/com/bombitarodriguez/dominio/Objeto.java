package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;

import com.bombitarodriguez.interfaces.Identificable;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Transformacion;

/**
 * Clase abstracta de la que heredan todos los objetos del juego.
 * Esta implementa las interfaces:
 * 
 * Identificable: Porque todo objeto del mapa tiene que poder ser identificado
 * con un ID unico para cada clase. Esto permite al modelo abstaerse de la vista, 
 * y que la clase FacrotyVistas pueda identificar a cada objeto para devolver su vista
 * correspondiente
 * 
 * ObjetoReaccionable: Porque cada objeto del mapa tiene que poder reaccionar ante
 * cualquier otro objeto.
 */
public abstract class Objeto implements ObjetoReaccionable, Identificable ,Posicionable, ObjetoVivo {
	
	protected int id;
	protected Casillero casillero;
	protected Integer posX;
	protected Integer posY;
	
	public Casillero getCasillero() {
		return casillero;
	}

	public void setCasillero(Casillero casillero) {
		this.casillero = casillero;
	}
	
	public Posicion getPosicion() {
		return casillero.getPosicion();		
	}

	public void setPosicion(Posicion posicion){
		casillero.setPosicion(posicion);
	}
	
	/**
	 * Este metodo es necesario para integrar el modelo al titiritero.
	 * Si no se llama este metodo cuando se saca o agrega un objeto a un casillero,
	 * el objeto pierde referencia de donde esta ubicado, y no puede ser dibujado.
	 */
	public void setCoordenadas(Integer x, Integer y) {
		posX = x;
		posY = y;
	}

	/**
	 * Metodo de interfaz Posicionable.
	 * Aplicamos una transformacion, para pasar la ubicacion
	 * de casilleros a pixeles
	 */
	@Override
	public int getX() {
		return Transformacion.transformarAPixeles(posX);
	}

	/**
	 * Metodo de interfaz Posicionable.
	 * Aplicamos una transformacion, para pasar la ubicacion
	 * de casilleros a pixeles
	 */
	@Override
	public int getY() {	
		return Transformacion.transformarAPixeles(posY);
	}
	
	/**
	 * Metodo de interfaz Identificable.
	 * Devolvemos el ID que identifica al objeto
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Metodo de interfaz ObjetoReaccionable
	 */
	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		return false;
	}

	/**
	 * Metodo de interfaz ObjetoReaccionable
	 */
	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		return false;
	}

	/**
	 * Metodo de interfaz ObjetoReaccionable
	 */
	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		return false;
	}

	/**
	 * Metodo de interfaz ObjetoReaccionable
	 */
	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		return false;
	}

	/**
	 * Metodo de interfaz ObjetoReaccionable
	 */
	@Override
	public Boolean reaccionarCon(Bomba bomba) {
		return false;
	}

	/**
	 * Metodo de interfaz ObjetoReaccionable
	 */
	@Override
	public Boolean reaccionarCon(Proyectil proyectil) {
		return false;
	}

	/**
	 * Metodo de interfaz ObjetoReaccionable
	 */
	@Override
	public Boolean reaccionarCon(BloqueCemento bloqueCemento) {
		return false;
	}

	/**
	 * Metodo de interfaz ObjetoReaccionable
	 */
	@Override
	public Boolean reaccionarCon(BloqueAcero bloqueAcero) {
		return false;
	}

	/**
	 * Metodo de interfaz ObjetoReaccionable
	 */
	@Override
	public Boolean reaccionarCon(BloqueLadrillo bloqueLadrillo) {
		return false;
	}

	/**
	 * Metodo de interfaz ObjetoReaccionable
	 */
	@Override
	public Boolean reaccionarCon(ArticuloChala chala) {
		return false;
	}

	/**
	 * Metodo de interfaz ObjetoReaccionable
	 */
	@Override
	public Boolean reaccionarCon(ArticuloToleTole articuloBombaToleTole) {
		return false;
	}

	/**
	 * Metodo de interfaz ObjetoReaccionable
	 */
	@Override
	public Boolean reaccionarCon(ArticuloTimer timer) {
		return false;
	}
	
	/**
	 * Metodo de intefaz ObjetoVivo
	 * En el juego, todos los objetos del mapa son vivos, 
	 * y solamente aquellos objetos que tengan que vivir
	 * redefinen este metodo
	 */
	@Override
	public void vivir() {
	}
}
