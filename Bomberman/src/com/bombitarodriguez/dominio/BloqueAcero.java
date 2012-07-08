package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro
 */
public class BloqueAcero extends Obstaculo {

	public BloqueAcero(){
		this.id = Identificaciones.bloqueAcero;
	}
	
	//Se supone que las ToleTole tienen una destruccion == 0
	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		if (explosion.getDestruccion() == 0) {
			this.destruirse();
			Mapa.objetoParaBorrar(this);
			return true;
		}
		return false;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void vivir() {
	}

}