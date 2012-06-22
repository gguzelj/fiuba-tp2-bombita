package com.bombitarodriguez.dominio;

import java.util.Iterator;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;

/**
 * 
 * @author Mauro
 *
 */
public class Bombita extends Personaje{
	
	private Integer vida;
	
	public Bombita(Integer vida) {
		this.vida = vida;
		this.resistencia = 0;
		this.velocidad = Constante.VELOCIDAD_CAMINA;
		this.factoryArma = new FactoryMolotov();
	}
	
	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		this.quitarVida();
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		this.quitarVida();
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		this.quitarVida();
		return true;
	}

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		this.quitarVida();
		return true;
	}
	
	public void quitarVida() {
		vida -= 1;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	@Override
	public void usarArma() {
		plantarBomba();
	}

	private void plantarBomba() {
		getCasillero().agregarObjeto(factoryArma.getArmaInstanciada());
	}
	
	@Override
	protected Boolean reaccionarConTodos(Iterator<ObjetoReaccionable> iterador) {
		Boolean permitePasar = true;
		while (iterador.hasNext() && (permitePasar)) {
			permitePasar = iterador.next().reaccionarCon(this);
		}
		return permitePasar;
	}

}
