package com.bombitarodriguez.dominio;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;

/**
 * 
 * @author Mauro
 *
 */
public abstract class Obstaculo implements ObjetoReaccionable{

	protected Casillero casillero;
	
	protected Integer durabilidad;
	
	protected ObjetoReaccionable objeto;

	public Integer getDurabilidad() {
		return durabilidad;
	}

	public void setDurabilidad(Integer durabilidad) {
		this.durabilidad = durabilidad;
	}
	
	public Casillero getCasillero() {
		return casillero;
	}

	public void setCasillero(Casillero casillero) {
		this.casillero = casillero;
	}

	public ObjetoReaccionable getObjeto() {
		return objeto;
	}

	public void setObjeto(ObjetoReaccionable objeto) {
		this.objeto = objeto;
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
	public Boolean reaccionarCon(Bomba bomba) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(Proyectil proyectil) {
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
	
	@Override
	public Boolean reaccionarCon(Explosion explosion){
		Integer durabilidadRestante = (getDurabilidad() - explosion.getDestruccion());
		if(durabilidadRestante <= 0){ 
			this.destruirse();
			return true;
		}
		this.setDurabilidad(durabilidadRestante);
		return false;
	}	
	
	public void destruirse() {
		if(objeto != null)
			casillero.agregarObjeto(objeto);
		casillero.quitarObjeto(this);
		
		
	}
	
	/**
	 * Desvincula el objeto que contiene el obstaculo
	 */
	public void quitarObjeto() {
		objeto = null;	
		
	}
}
