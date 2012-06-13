package com.bombitarodriguez.dominio;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;

/**
 * 
 * @author Mauro
 *
 */
public abstract class Arma implements ObjetoReaccionable {
	
	protected Casillero casilleroContenedor;
	
	protected Integer destruccion;
	
	protected Integer retardo;
	
	protected Integer ondaExpansiva;

	public Integer getDestruccion() {
		return destruccion;
	}

	public void setDestruccion(Integer destruccion) {
		this.destruccion = destruccion;
	}

	public Integer getRetardo() {
		return retardo;
	}

	public void setRetardo(Integer retardo) {
		this.retardo = retardo;
	}

	public Integer getOndaExpansiva() {
		return ondaExpansiva;
	}

	public void setOndaExpansiva(Integer ondaExpansiva) {
		this.ondaExpansiva = ondaExpansiva;
	}
	
	public Casillero getCasillero() {
		return casilleroContenedor;
	}
	
	@Override
	public void setCasillero(Casillero casillero) {
		casilleroContenedor = casillero;
	}

	@Override
	public Posicion getPosicion() {
		return casilleroContenedor.getPosicion();
	}

	@Override
	public Boolean reaccionarCon(Bombita bombita){
		return false;
	}
	@Override
	public Boolean reaccionarCon(Cecilio cecilio){
		return false;
	}
	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae){
		return false;
	}
	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado){
		return false;
	}
	@Override
	public Boolean reaccionarCon(Proyectil proyectil){
		return false;
	}
	@Override
	public Boolean reaccionarCon(BloqueCemento bloqueCemento){
		return false;
	}
	@Override
	public Boolean reaccionarCon(BloqueAcero bloqueAcero){
		return false;
	}
	@Override
	public Boolean reaccionarCon(BloqueLadrillo bloqueLadrillo){
		return false;
	}
	@Override
	public Boolean reaccionarCon(Chala chala){
		return false;
	}
	@Override
	public Boolean reaccionarCon(ArticuloToleTole articuloBombaToleTole){
		return false;
	}
	@Override
	public Boolean reaccionarCon(Timer timer){
		return false;
	}	

}
