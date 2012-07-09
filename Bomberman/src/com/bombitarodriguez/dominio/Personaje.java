package com.bombitarodriguez.dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import com.bombitarodriguez.excepciones.FueraDelMapaException;
import com.bombitarodriguez.interfaces.Armado;
import com.bombitarodriguez.interfaces.StrategyMovimiento;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;

/**
 * Clase de la cual heredan todos los personajes del juego:
 * -Bombita
 * -Cecilio
 * -LopezReggae
 * -LopezReggaeAlado
 */
public abstract class Personaje extends Objeto implements Armado, StrategyMovimiento{

	protected Integer resistencia;
	protected Integer velocidad;
	protected FactoryArma factoryArma;
	
	protected abstract Boolean reaccionarConTodos(Iterator<Objeto> iterador);

	public Integer getResistencia() {
		return resistencia;
	}

	public void setResistencia(Integer resistencia) {
		this.resistencia = resistencia;
	}

	public Integer getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}

	public FactoryArma getFactoryArma() {
		return factoryArma;
	}

	public void setFactoryArma(FactoryArma factoryArma) {
		this.factoryArma = factoryArma;
	}

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.quitarVida();
		return false;
	}

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		
		if (explosion.destruccion == Constante.DESTRUCCION_TOLETOLE) {
			Mapa.objetoParaBorrar(this);
			destruirse();
			resistencia = 0;
		} else {
			resistencia = resistencia - explosion.getDestruccion();
			if (resistencia <= 0) {
				Mapa.objetoParaBorrar(this);
				destruirse();
			}
		}

		return true;
	}

	public void destruirse() {
		getCasillero().quitarObjeto(this);
	}

	@Override
	public void moverseConEstrategia(Direccion direccion) {

		Posicion nuevaPosicion;
		try {
			nuevaPosicion = Mapa.getMapa().getNuevaPosicion(this.getPosicion(),	direccion);
		} catch (FueraDelMapaException e) {
			// No se relaciona con los objetos del mapa
			return;
		}
		Casillero casilleroProximo = Mapa.getMapa().getCasillero(nuevaPosicion);
		// Creo una copia de la lista sobre la cual voy a iterar, ya que se
		// puede modificar
		List<Objeto> copiaObjetosCasillero = new ArrayList<Objeto>();
		copiaObjetosCasillero.addAll(casilleroProximo.getObjetos());
		Iterator<Objeto> iterador = copiaObjetosCasillero.iterator();
		if (reaccionarConTodos(iterador)) {
			Mapa.getMapa().reposicionar(this, casilleroProximo);
		}
	}

	@Override
	public void vivir() {
		
		if (puedeReaccionar()) {
			Integer randomReaccionar = new Random().nextInt(5);
			if (randomReaccionar == 3) {
			Integer randomMovimiento = new Random().nextInt(10);
			switch (randomMovimiento) {
			case 1:
				this.moverseConEstrategia(Direccion.DERECHA);
				break;
			case 2:
				this.moverseConEstrategia(Direccion.IZQUIERDA);
				break;
			case 3:
				this.moverseConEstrategia(Direccion.ARRIBA);
				break;
			case 4:
				this.moverseConEstrategia(Direccion.ABAJO);
				break;
			case 5:		
				Integer randomBomba = new Random().nextInt(10);
				if (randomBomba == 3) {
				Arma arma = this.usarArma();
				if(arma != null)
					Mapa.objetoParaAgregar(arma);
				}
				break;
				}
			}
		}
	}

	public boolean puedeReaccionar() {
		return (this.resistencia > 0);
	}
}
