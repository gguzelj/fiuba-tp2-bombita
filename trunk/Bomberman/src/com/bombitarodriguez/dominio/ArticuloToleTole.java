package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.vista.factory.dominio.VistaArticuloToleTole;


/**
 * 
 * @author Mauro
 * 
 */
public class ArticuloToleTole extends Articulo {
	
	public ArticuloToleTole(){
		this.vistaArticulo = new VistaArticuloToleTole();
	}
	

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.setFactoryArma(new FactoryToleTole());
		this.getCasillero().quitarObjeto(this);
		ControladorBomberman.borrarObjeto(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		cecilio.setFactoryArma(new FactoryToleTole());
		this.getCasillero().quitarObjeto(this);
		ControladorBomberman.borrarObjeto(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		losLopezReggae.setFactoryArma(new FactoryToleTole());
		this.getCasillero().quitarObjeto(this);
		ControladorBomberman.borrarObjeto(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		losLopezReggaeAlado.setFactoryArma(new FactoryToleTole());
		this.getCasillero().quitarObjeto(this);
		ControladorBomberman.borrarObjeto(this);
		return true;
	}

	@Override
	public Imagen vistaDeObjeto() {
		return this.vistaArticulo;
	}

}
