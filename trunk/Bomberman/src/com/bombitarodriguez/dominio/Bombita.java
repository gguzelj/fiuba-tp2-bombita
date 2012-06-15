package com.bombitarodriguez.dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;

/**
 * 
 * @author Mauro
 *
 */
public class Bombita extends Personaje {
	
	private Integer vida;
	
	public Bombita(Integer vida) {
		this.vida = vida;
		this.resistencia = 0;
		this.velocidad = Constante.VELOCIDAD_CAMINA;
		this.factoryArma = new FactoryMolotov();
	}
	
	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		quitarVida();
		getCasillero().quitarObjeto(cecilio);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		quitarVida();
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		quitarVida();
		return true;
	}

//	@Override
//	public Boolean reaccionarCon(Proyectil proyectil) {
//		// TODO Acá se termina el juego!!
//		return true;
//	}

	public void quitarVida() {
		vida -= 1;
	}

	@Override
	protected Boolean reaccionarConTodos(Iterator<ObjetoReaccionable> iterador) {
		Boolean permitePasar = true;
		while (iterador.hasNext() && (permitePasar)) {
			permitePasar = iterador.next().reaccionarCon(this);
		}
		return permitePasar;
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
	public void moverseConEstrategia(Direccion direccion) {
		Posicion nuevaPosicion = Mapa.getMapa().getNuevaPosicion(this.getPosicion(), direccion);
		Casillero casilleroProximo = Mapa.getMapa().getCasillero(nuevaPosicion);
		// Creo una copia de la lista sobre la cual voy a iterar, ya que se puede modificar
		List<ObjetoReaccionable> copiaObjetosCasillero = new ArrayList<ObjetoReaccionable>();
		copiaObjetosCasillero.addAll(casilleroProximo.getObjetos());
		Iterator<ObjetoReaccionable> iterador = copiaObjetosCasillero.iterator();
		if (reaccionarConTodos(iterador)) {
			Mapa.getMapa().reposicionar(this, casilleroProximo);
		}
		
	}

	@Override
	public Boolean reaccionarCon(Arma arma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		// TODO Auto-generated method stub
		return null;
	}
}
