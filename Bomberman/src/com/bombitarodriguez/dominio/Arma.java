package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.Posicionable;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Transformacion;

/**
 * 
 * @author Mauro
 *
 */
public abstract class Arma implements ObjetoReaccionable, Posicionable {
	
	protected Casillero casillero;
	
	protected Integer destruccion;
	
	protected Double retardo;
	
	protected Integer ondaExpansiva;

	public void explotar(){
		Explosion explosion = new Explosion(getDestruccion(),getOndaExpansiva());
		
		this.getCasillero().agregarObjeto(explosion);
		this.getCasillero().quitarObjeto(this);
		
		explosion.causarEstragos();
	}
	
	public Integer getDestruccion() {
		return destruccion;
	}

	public void setDestruccion(Integer destruccion) {
		this.destruccion = destruccion;
	}

	public Double getRetardo() {
		return retardo;
	}

	public void setRetardo(Double retardo) {
		this.retardo = retardo;
	}

	public Integer getOndaExpansiva() {
		return ondaExpansiva;
	}

	public void setOndaExpansiva(Integer ondaExpansiva) {
		this.ondaExpansiva = ondaExpansiva;
	}
	
	public Casillero getCasillero() {
		return casillero;
	}
	
	@Override
	public void setCasillero(Casillero casillero) {
		this.casillero = casillero;
	}

	@Override
	public Posicion getPosicion() {
		return casillero.getPosicion();
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
	public Boolean reaccionarCon(Bomba bomba){
		return false;
	}
	
	@Override
	public Boolean reaccionarCon(Proyectil proyectil){
		return false;
	}
	
	@Override
	public Boolean reaccionarCon(Explosion explosion){
		this.explotar();
		return true;
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
	
	@Override
	public int getX() {
		return Transformacion.transformarAPixeles(casillero.getPosicion().getPosX());
	}

	@Override
	public int getY() {	
		return Transformacion.transformarAPixeles(casillero.getPosicion().getPosY());
	}
	

}
