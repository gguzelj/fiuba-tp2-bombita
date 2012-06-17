package com.bombitarodriguez.dominio;	

import com.bombitarodriguez.interfaces.ObjetoReaccionable;

/**
 * 
 * @author Mauro
 *
 */
public abstract class Articulo implements ObjetoReaccionable {

	protected Casillero casillero;
	
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
	public Boolean reaccionarCon(Explosion explosion) {
		this.getCasillero().quitarObjeto(this);
		return true;
	}
}
