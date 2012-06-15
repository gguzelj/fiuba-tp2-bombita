package com.bombitarodriguez.dominio;

/**
 * 
 * @author Mauro
 *
 */
public abstract class Bomba extends Arma {
	
	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		return true;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		return true;
	}

	@Override
	public Boolean reaccionarCon(Bomba bomba) {
		return true;
	}	
}
