package com.bombitarodriguez.dominio;

import java.util.Iterator;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;

/**
 * 
 * @author Mauro
 *
 */
public class Cecilio extends Personaje {
	
	public Cecilio(Integer velocidad) {
		this.resistencia = Constante.RESISTENCIA_CECILIO;
		this.velocidad = Constante.VELOCIDAD_CAMINA;
	}	

	

//	@Override
//	public Boolean reaccionarCon(Proyectil proyectil) {
//		// TODO Debería atacar a Cecilio?
//		return false;
//	}

	@Override
	protected Boolean reaccionarConTodos(Iterator<ObjetoReaccionable> iterador) {
		// TODO Reacciona con todos¿?
		return null;
	}
	
	@Override
	public void usarArma() {
		plantarBomba();
		
	}

	private void plantarBomba() {
		getCasillero().agregarObjeto(factoryArma.getArmaInstanciada());
		
	}
}
