package com.bombitarodriguez.dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.excepciones.FueraDelMapaException;
import com.bombitarodriguez.interfaces.Armado;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.interfaces.StrategyMovimiento;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;
import com.bombitarodriguez.utils.Transformacion;

/**
 * 
 * @author Mauro
 * 
 */
public abstract class Personaje implements ObjetoReaccionable, Armado,
		StrategyMovimiento, Posicionable, ObjetoVivo {

	protected Casillero casilleroContenedor;
	protected Integer resistencia;
	protected Integer velocidad;
	protected FactoryArma factoryArma;
	protected Integer posX;
	protected Integer posY;
	protected Imagen vistaPersonaje;

	/**
	 * Permite reaccionar con todos los objetos de un casillero(Public solamente
	 * para ser testead)
	 * 
	 * @param iterador
	 * @return true si se puede mover, false caso contrario
	 */
	protected abstract Boolean reaccionarConTodos(
			Iterator<ObjetoReaccionable> iterador);

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

	public Casillero getCasillero() {
		return casilleroContenedor;
	}

	@Override
	public Posicion getPosicion() {
		return casilleroContenedor.getPosicion();
	}

	@Override
	public void setCasillero(Casillero casillero) {
		casilleroContenedor = casillero;
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
	public Boolean reaccionarCon(Cecilio cecilio) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(Bomba bomba) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		
		if (explosion.destruccion == Constante.DESTRUCCION_TOLETOLE) {
			ControladorBomberman.borrarObjeto(this);
			destruirse();
			resistencia = 0;
		} else {
			resistencia = resistencia - explosion.getDestruccion();
			if (resistencia <= 0) {
				ControladorBomberman.borrarObjeto(this);
				destruirse();
			}
		}

		return true;
	}

	@Override
	public Boolean reaccionarCon(BloqueCemento bloqueCemento) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(BloqueAcero bloqueAcero) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(BloqueLadrillo bloqueLadrillo) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(Chala chala) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(ArticuloToleTole articuloBombaToleTole) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(Timer timer) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(Proyectil proyectil) {
		return false;
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
		List<ObjetoReaccionable> copiaObjetosCasillero = new ArrayList<ObjetoReaccionable>();
		copiaObjetosCasillero.addAll(casilleroProximo.getObjetos());
		Iterator<ObjetoReaccionable> iterador = copiaObjetosCasillero.iterator();
		if (reaccionarConTodos(iterador)) {
			Mapa.getMapa().reposicionar(this, casilleroProximo);
		}
	}

	@Override
	public void vivir() {
		
		if (puedeReaccionar()) {
//			Integer randomReaccionar = new Random().nextInt(5);
//			if (randomReaccionar == 3) {
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
//				Integer randomBomba = new Random().nextInt(10);
//				if (randomBomba == 3) {
				Arma arma = this.usarArma();
				if(arma != null)
					ControladorBomberman.agregarObjeto(arma);
//				}
				break;
				}
//			}
		}
	}

	@Override
	public int getX() {
		return Transformacion.transformarAPixeles(getPosX());
	}

	@Override
	public int getY() {
		return Transformacion.transformarAPixeles(getPosY());
	}

	@Override
	public void setCoordenadas(Integer x, Integer y) {
		posX = x;
		posY = y;
	}

	public Integer getPosX() {
		return posX;
	}

	public Integer getPosY() {
		return posY;
	}

	public boolean puedeReaccionar() {
		return (this.resistencia > 0);
	}
}
