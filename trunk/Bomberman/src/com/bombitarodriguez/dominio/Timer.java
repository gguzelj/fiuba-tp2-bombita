package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.vista.factory.dominio.VistaTimer;


/**
 * 
 * @author Mauro
 *
 */
public class Timer extends Articulo {

	public Timer(){
		this.vistaArticulo = new VistaTimer();
	}
	
	
	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.getFactoryArma().setRetardo(aplicarRetardo(bombita));
		casillero.quitarObjeto(this);
		ControladorBomberman.borrarObjeto(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		cecilio.getFactoryArma().setRetardo(aplicarRetardo(cecilio));
		casillero.quitarObjeto(this);
		ControladorBomberman.borrarObjeto(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
 		losLopezReggae.getFactoryArma().setRetardo(aplicarRetardo(losLopezReggae));
		casillero.quitarObjeto(this);
		ControladorBomberman.borrarObjeto(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		losLopezReggaeAlado.getFactoryArma().setRetardo(aplicarRetardo(losLopezReggaeAlado));
		casillero.quitarObjeto(this);
		ControladorBomberman.borrarObjeto(this);
		return true;
	}
	
	private Double aplicarRetardo(Personaje personaje) {
		return (personaje.getFactoryArma().getRetardo() * 0.85);
	}

	@Override
	public Imagen vistaDeObjeto() {
		return this.vistaArticulo;
	}
}
