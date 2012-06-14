package com.bombitarodriguez.dominio;

/**
 * 
 * @author Mauro
 *
 */
public class Molotov extends Bomba {
	
	@Override
	Bomba detonar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void calcularCasillerosAfectados(){
		
	}
	
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
	public Boolean reaccionarCon(Arma arma) {
		return true;
	}

	@Override
	public Posicion getPosicion() {
		// TODO Auto-generated method stub
		return null;
	}
}
