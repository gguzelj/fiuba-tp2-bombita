package com.bombitarodriguez.dominio;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import ar.uba.fi.algo3.titiritero.Direccion;

import com.bombitarodriguez.excepciones.FueraDelMapaException;
import com.bombitarodriguez.interfaces.Armado;
import com.bombitarodriguez.interfaces.StrategyMovimiento;
import com.bombitarodriguez.utils.Constante;

/**
 * Clase de la cual heredan todos los personajes del juego: -Bombita -Cecilio
 * -LopezReggae -LopezReggaeAlado
 */
public abstract class Personaje extends Objeto implements Armado,
		StrategyMovimiento {

	protected Integer resistencia;
	protected Integer velocidad;
	protected FactoryArma factoryArma;
	protected Direccion direccion = null;
	protected Boolean atacar = false;
	protected Point puntoActual = new Point();
	protected Point puntoFinal = new Point();

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

	/**
	 * Recibo una direccion, e intento realizar el movimiento. Devuelvo el
	 * resultado de esta operacion
	 * 
	 * @param direccion
	 * @return
	 */
	public Boolean moverseConEstrategia(Direccion direccion) {

		Posicion nuevaPosicion;
		try {
			nuevaPosicion = Mapa.getMapa().getNuevaPosicion(this.getPosicion(),	direccion);
		} catch (FueraDelMapaException e) {
			// No se relaciona con los objetos del mapa
			return false;
		}
		Casillero casilleroProximo = Mapa.getMapa().getCasillero(nuevaPosicion);
		// Creo una copia de la lista sobre la cual voy a iterar, ya que se
		// puede modificar
		List<Objeto> copiaObjetosCasillero = new ArrayList<Objeto>();
		copiaObjetosCasillero.addAll(casilleroProximo.getObjetos());
		Iterator<Objeto> iterador = copiaObjetosCasillero.iterator();
		if (reaccionarConTodos(iterador)) {
			Mapa.getMapa().reposicionar(this, casilleroProximo);
			return true;
		}
		return false;
	}

	@Override
	public void vivir() {

		this.seleccionarAccion();
		this.ejecutarAccion();

	}

	private void ejecutarAccion() {
		if (atacar == true) {
			Mapa.objetoParaAgregar(this.usarArma());
			atacar = false;
		}

		if (this.direccion != null) {
			
			switch(this.direccion){
			case ARRIBA:
				puntoActual.y += this.velocidad;
				break;
			case ABAJO:
				puntoActual.y -= this.velocidad;
				break;
			case DERECHA:
				puntoActual.x += this.velocidad;
				break;
			case IZQUIERDA:
				puntoActual.x -= this.velocidad;
				break;
			}
			
			if(puntoActual.equals(puntoFinal)){
				direccion = null;
			}
		}
	}

	/**
	 * Metodo para seleccionar alguna accion a realizar.
	 */
	private void seleccionarAccion() {
		if (puedeReaccionar()) {
			switch (new Random().nextInt(10)) {
			case 1:
				this.mover(Direccion.DERECHA);
				break;
			case 2:
				this.mover(Direccion.IZQUIERDA);
				break;
			case 3:
				this.mover(Direccion.ARRIBA);
				break;
			case 4:
				this.mover(Direccion.ABAJO);
				break;
			case 5:
				this.atacar();
				break;
			}
		}
	}

	public void mover(Direccion direccion) {

		if (this.direccion != null)
			return;

		puntoActual.x = Constante.PIXELS_POR_CASILLERO * getPosicion().getPosX();
		puntoActual.y = Constante.PIXELS_POR_CASILLERO * getPosicion().getPosY();

		if ( moverseConEstrategia(direccion) ) {
			this.setDireccion(direccion);
			puntoFinal.x = Constante.PIXELS_POR_CASILLERO * getPosicion().getPosX();
			puntoFinal.y = Constante.PIXELS_POR_CASILLERO * getPosicion().getPosY();
		}
	}

	/**
	 * Guardo la sentencia de atacar. Cuando el juego ejecute vivir(), se llama
	 * al metodo usarArma()
	 */
	public void atacar() {
		
		/**
		 * Random para evitar que el personaje ataque demasiadas veces
		 */
		switch (new Random().nextInt(4)) {
		case 1:
			this.atacar = true;
			break;
		default:
			break;
		}
	}
		

	/**
	 * Solamente podemos ejecutar una accion si el personaje esta vivo.
	 * 
	 * @return
	 */
	public boolean puedeReaccionar() {
		return (this.resistencia > 0);
	}

	/**
	 * Guardo la direccion a la que tengo que moverme. Cuando el juego ejecute
	 * el metodo vivir(), se ejecuta la accion de moverConEstrategia()
	 */
	public void setDireccion(Direccion direccionAMover) {
		this.direccion = direccionAMover;
	}
	
	@Override
	public Direccion getDireccion(){
		return direccion;
	}
	
	@Override
	public int getX() {
		return puntoActual.x;
	}

	@Override
	public int getY() {	
		return puntoActual.y;
	}
}
