package com.bombitarodriguez.dominio;

import com.bombitarodriguez.vista.factory.dominio.VistaBloqueAcero;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

/**
 * 
 * @author Mauro
 * 
 */
public class BloqueAcero extends Obstaculo {

	//Se supone que las ToleTole tienen una destruccion == 0
	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		if (explosion.getDestruccion() == 0) {
			this.destruirse();
			return true;
		}
		return false;
	}

	@Override
	public Imagen vistaDeObjeto() {
		return new VistaBloqueAcero();
	}

}