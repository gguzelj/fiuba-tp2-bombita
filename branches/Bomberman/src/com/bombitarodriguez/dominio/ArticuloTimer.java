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
	public Boolean reaccionarCon(LopezReggae lopezReggae) {
 		lopezReggae.getFactoryArma().setRetardo(aplicarRetardo(lopezReggae));
		casillero.quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LopezReggaeAlado lopezReggaeAlado) {
		lopezReggaeAlado.getFactoryArma().setRetardo(aplicarRetardo(lopezReggaeAlado));
		casillero.quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}
	
	private Double aplicarRetardo(Personaje personaje) {
		return (personaje.getFactoryArma().getRetardo() * 0.85);
	}
}
