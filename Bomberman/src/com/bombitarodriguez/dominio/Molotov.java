package com.bombitarodriguez.dominio;



import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.vista.factory.dominio.VistaMolotov;

/**
 * 
 * @author Mauro
 *
 */
public class Molotov extends Bomba{

	public Molotov() {
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_MOLOTOV;
		this.retardo = Constante.TIMER_MOLOTOV;
		this.destruccion = Constante.DESTRUCCION_MOLOTOV;
		this.vistaArma = new VistaMolotov();
	}
	
	public Molotov(Double retardo) {
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_MOLOTOV;
		this.destruccion = Constante.DESTRUCCION_MOLOTOV;
		this.retardo = retardo;
		this.vistaArma = new VistaMolotov();

	}

	@Override
	public Imagen vistaDeObjeto() {
		return this.vistaArma;
	}

	@Override
	public void vivir() {
		retardo--;
		if (retardo==0){
			this.explotar();
		}
		
	}

}
