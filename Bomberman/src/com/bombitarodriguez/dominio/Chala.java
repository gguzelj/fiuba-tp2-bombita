package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Constante;

/**
 * 
 * @author Mauro 
 *
 */
public class Chala extends Articulo {

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.setVelocidad(Constante.VELOCIDAD_CORRE);
		casillero.quitarObjeto(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		cecilio.setVelocidad(Constante.VELOCIDAD_CORRE);
		casillero.quitarObjeto(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		losLopezReggae.setVelocidad(Constante.VELOCIDAD_CORRE);
		casillero.quitarObjeto(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		losLopezReggaeAlado.setVelocidad(Constante.VELOCIDAD_CORRE);
		casillero.quitarObjeto(this);
		return true;
	}
}
