package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro
 */
public class ArticuloToleTole extends Articulo {
	
	public ArticuloToleTole(){
		this.id = Identificaciones.articuloToleTole;
	}
	

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.setFactoryArma(new FactoryToleTole());
		this.getCasillero().quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		cecilio.setFactoryArma(new FactoryToleTole());
		this.getCasillero().quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		losLopezReggae.setFactoryArma(new FactoryToleTole());
		this.getCasillero().quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		losLopezReggaeAlado.setFactoryArma(new FactoryToleTole());
		this.getCasillero().quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}

	@Override
	public int getId() {
		return this.id;
	}
}
