package com.bombitarodriguez.dominio;

/**
 * 
 * @author Mauro
 *
 */
public class Proyectil extends Arma {

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		this.explotar();
		return false;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		this.explotar();
		return false;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		this.explotar();
		return false;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		this.explotar();
		return false;
	}
}
