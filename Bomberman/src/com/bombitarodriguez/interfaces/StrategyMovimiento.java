package com.bombitarodriguez.interfaces;

import ar.uba.fi.algo3.titiritero.Direccion;

/**
 * Interfaz para definir la estrategia que utilizara el personaje
 * para moverse }
 * Devolvemos un Boolean para confirmar si podemos movernos
 * en esa direccion, o no
 */
public interface StrategyMovimiento {
	
	public Boolean moverseConEstrategia(Direccion direccion);

}
