package com.bombitarodriguez.dominio;

/**
 * 
 * @author Mauro
 *
 */
public class Timer extends Articulo {

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		Double nuevoRetardo = aplicarRetardo(bombita);
		bombita.getFactoryArma().setNuevoRetardo(nuevoRetardo);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		Double nuevoRetardo = aplicarRetardo(cecilio);
		cecilio.getFactoryArma().setNuevoRetardo(nuevoRetardo);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		Double nuevoRetardo = aplicarRetardo(losLopezReggae);
		losLopezReggae.getFactoryArma().setNuevoRetardo(nuevoRetardo);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		Double nuevoRetardo = aplicarRetardo(losLopezReggaeAlado);
		losLopezReggaeAlado.getFactoryArma().setNuevoRetardo(nuevoRetardo);
		return true;
	}


	private Double aplicarRetardo(Personaje personaje) {
		Double retardoActual = personaje.getFactoryArma().getNuevoRetardo();
		Double porcentajeRetardo = (retardoActual * 0.85);
		return (retardoActual - porcentajeRetardo);
	}

}
