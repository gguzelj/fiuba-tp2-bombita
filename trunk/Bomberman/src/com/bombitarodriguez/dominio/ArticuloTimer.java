package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro
 */
public class ArticuloTimer extends Articulo {

	public ArticuloTimer(){
		this.id = Identificaciones.articuloTimer;
	}
	
	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.getFactoryArma().setRetardo(aplicarRetardo(bombita));
		casillero.quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		cecilio.getFactoryArma().setRetardo(aplicarRetardo(cecilio));
		casillero.quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
 		losLopezReggae.getFactoryArma().setRetardo(aplicarRetardo(losLopezReggae));
		casillero.quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		losLopezReggaeAlado.getFactoryArma().setRetardo(aplicarRetardo(losLopezReggaeAlado));
		casillero.quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}
	
	private Double aplicarRetardo(Personaje personaje) {
		return (personaje.getFactoryArma().getRetardo() * 0.85);
	}
}
