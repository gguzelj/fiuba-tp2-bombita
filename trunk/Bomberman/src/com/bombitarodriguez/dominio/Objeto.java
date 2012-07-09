package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.Posicionable;

import com.bombitarodriguez.interfaces.Identificable;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;

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
public abstract class Objeto implements ObjetoReaccionable, Identificable ,Posicionable {
	
	protected int id;
	protected Casillero casillero;
	
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
	
	public int getId() {
		return this.id;
	}
	

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(Bomba bomba) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(Proyectil proyectil) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(BloqueCemento bloqueCemento) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(BloqueAcero bloqueAcero) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(BloqueLadrillo bloqueLadrillo) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(ArticuloChala chala) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(ArticuloToleTole articuloBombaToleTole) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(ArticuloTimer timer) {
		return false;
	}
}
