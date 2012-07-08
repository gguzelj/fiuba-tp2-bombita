package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.utils.Identificaciones;
import com.bombitarodriguez.utils.Transformacion;

/**
 * @author Mauro
 */
public class Salida extends Objeto implements Posicionable, ObjetoVivo{

	protected Integer posX;
	protected Integer posY;
	
	public Salida(){
		this.id = Identificaciones.salida;
	}
	
	@Override
	public Posicion getPosicion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCasillero(Casillero casillero) {
		// TODO Auto-generated method stub
	}

	@Override
	public Boolean reaccionarCon(Bombita bombita){
		ControladorBomberman.setGanoElNivel(true);
		return true;
	}
	@Override
	public Boolean reaccionarCon(Cecilio cecilio){
		return true;
	}
	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae){
		return true;
	}
	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado){
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
	public Boolean reaccionarCon(Bomba bomba) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(Proyectil proyectil) {
		return false;
	}	

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		return true;
	}
	
	public void destruirse(Objeto objeto){
		
	}

	@Override
	public int getId() {
		return this.id;
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

	@Override
	public void vivir() {
	}
}
