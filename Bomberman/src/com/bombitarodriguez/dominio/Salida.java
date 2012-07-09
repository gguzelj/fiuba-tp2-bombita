package com.bombitarodriguez.dominio;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro
 */
public class Salida extends Objeto{

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
}
