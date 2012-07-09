package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro
 */
public class BloqueAcero extends Obstaculo {

	public BloqueAcero(){
		this.id = Identificaciones.bloqueAcero;
	}
	
	/**
	 * Ante una explosion de una bomba ToleTole, el
	 * BloqueAcero se destruye. (Asumimos que la destruccion
	 * de la ToleTole es equivalente a 0 )
	 */
	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		if (explosion.getDestruccion() == 0) {
			this.destruirse();
			Mapa.objetoParaBorrar(this);
			return true;
		}
		return false;
	}
}