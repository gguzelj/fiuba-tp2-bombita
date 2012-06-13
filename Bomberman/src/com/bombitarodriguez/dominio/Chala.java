package com.bombitarodriguez.dominio;

/**
 * 
 * @author Mauro 
 *
 */
public class Chala extends Articulo {

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.setVelocidad(Juego.VELOCIDAD_CORRE);
		casilleroContenedor.quitarObjeto(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		// TODO Definir
		return null;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		// TODO Definir
		return null;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		// TODO Definir
		return null;
	}

	@Override
	public Posicion getPosicion() {
		return casilleroContenedor.getPosicion();
	}
}
