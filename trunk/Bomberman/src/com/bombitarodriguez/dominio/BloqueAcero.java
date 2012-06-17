package com.bombitarodriguez.dominio;

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
}