package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.vista.factory.dominio.VistaChala;

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

	@Override
	public Imagen vistaDeObjeto() {
		return new VistaChala();
	}
}
