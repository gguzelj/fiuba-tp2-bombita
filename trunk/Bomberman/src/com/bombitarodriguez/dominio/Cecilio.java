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
	
	public Cecilio() {
		this.resistencia = Constante.RESISTENCIA_CECILIO;
		this.velocidad = Constante.VELOCIDAD_CAMINA;
		this.factoryArma = new FactoryMolotov();
	}	

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

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		resistencia = resistencia - (explosion.getDestruccion());
		if (resistencia <= 0) destruirse();
		return true;
	}
	
	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.reaccionarCon(this);
		return true;
	}
}
