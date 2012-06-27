package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.vista.factory.dominio.VistaBloqueAcero;


/**
 * 
 * @author Mauro
 * 
 */
public class BloqueAcero extends Obstaculo {

	public BloqueAcero(){
		this.vistaObstaculo = new VistaBloqueAcero();
	}
	
	//Se supone que las ToleTole tienen una destruccion == 0
	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		if (explosion.getDestruccion() == 0) {
			this.destruirse();
			ControladorBomberman.borrarObjeto(this);
			return true;
		}
		return false;
	}

	@Override
	public Imagen vistaDeObjeto() {
		return this.vistaObstaculo;
	}

	@Override
	public void vivir() {
		// TODO Auto-generated method stub
		
	}

}