package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.utils.Identificaciones;
import com.bombitarodriguez.utils.Transformacion;

/**
 * @author Mauro
 */
public class Salida extends Objeto implements ObjetoVivo{

	protected Integer posX;
	protected Integer posY;
	
	public Salida(){
		this.id = Identificaciones.salida;
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
	public Boolean reaccionarCon(Explosion explosion) {
		return true;
	}
	
	public void destruirse(Objeto objeto){
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
