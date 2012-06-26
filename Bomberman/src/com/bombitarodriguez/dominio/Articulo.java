package com.bombitarodriguez.dominio;	

import ar.uba.fi.algo3.titiritero.Posicionable;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Transformacion;
import com.bombitarodriguez.vista.factory.dominio.VistaAbstracta;

/**
 * 
 * @author Mauro
 *
 */
public abstract class Articulo implements ObjetoReaccionable, Posicionable {

	protected Casillero casillero;
	
	protected VistaAbstracta vista;
	
	public VistaAbstracta getVista() {
		return vista;
	}

	public void setVista(VistaAbstracta vista) {
		this.vista = vista;
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
	
	@Override
	public int getX() {
		return Transformacion.transformarAPixeles(casillero.getPosicion().getPosX());
	}

	@Override
	public int getY() {
		return Transformacion.transformarAPixeles(casillero.getPosicion().getPosY());
	}
	
	
}
