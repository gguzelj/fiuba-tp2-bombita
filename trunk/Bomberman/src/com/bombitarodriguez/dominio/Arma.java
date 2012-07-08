package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import com.bombitarodriguez.utils.Transformacion;

/**
 * @author Mauro
 */
public abstract class Arma extends Objeto implements Posicionable, ObjetoVivo {
	
	protected Casillero casillero;
	protected Integer destruccion;
	protected Double retardo;
	protected Integer ondaExpansiva;
	protected Integer posX;
	protected Integer posY;

	public void explotar(){
		Explosion explosion = new Explosion(getDestruccion(),getOndaExpansiva());
		
		this.getCasillero().agregarObjeto(explosion);
		this.getCasillero().quitarObjeto(this);
		
		explosion.causarEstragos();

		Mapa.objetoParaBorrar(this);
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
		this.getCasillero().quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
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
	public Boolean reaccionarCon(ArticuloChala chala){
		return false;
	}
	
	@Override
	public Boolean reaccionarCon(ArticuloToleTole articuloBombaToleTole){
		return false;
	}
	@Override
	public Boolean reaccionarCon(ArticuloTimer timer){
		return false;
	}	
	
	@Override
	public int getX() {
		return Transformacion.transformarAPixeles(getPosX());
	}

	@Override
	public int getY() {	
		return Transformacion.transformarAPixeles(getPosY());
	}
	
	@Override
	public void setCoordenadas(Integer x, Integer y) {
		posX = x;
		posY = y;
	}
	
	public Integer getPosX() {
		return posX;
	}
	
	public Integer getPosY() {
		return posY;
	}

}
