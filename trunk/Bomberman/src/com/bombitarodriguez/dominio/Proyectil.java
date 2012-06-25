package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.vista.factory.dominio.VistaProyectil;

/**
 * 
 * @author Mauro
 *
 */
public class Proyectil extends Arma {

	public Proyectil(Double retardo) {
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_PROYECTIL;
		this.destruccion = Constante.DESTRUCCION_PROYECTIL;
		this.retardo = retardo;
	}

	public Proyectil() {
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_PROYECTIL;
		this.destruccion = Constante.DESTRUCCION_PROYECTIL;
		this.retardo = Constante.TIMER_PROYECTIL;
	}

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

	@Override
	public Imagen vistaDeObjeto() {
		return new VistaProyectil();
	}
}
