package com.bombitarodriguez.dominio;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bombitarodriguez.excepciones.FueraDelMapaException;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;
import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro
 */
public class Bombita extends Personaje {

	private Integer vida;
	private Direccion direccionAMover = null;
	private Boolean atacar = false;
	private Point puntoActual = new Point();
	private Point puntoFinal = new Point();

	public Bombita(Integer vida) {
		this.vida = vida;
		this.resistencia = 0;
		this.velocidad = Constante.VELOCIDAD_CAMINA;
		this.factoryArma = new FactoryMolotov();
		this.id = Identificaciones.bombita;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		this.quitarVida();
		System.out.println("PERDI VIDA: Me quedan:" + this.vida);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LopezReggae lopezReggae) {
		this.quitarVida();
		System.out.println("PERDI VIDA: Me quedan:" + this.vida);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LopezReggaeAlado lopezReggaeAlado) {
		this.quitarVida();
		System.out.println("PERDI VIDA: Me quedan:" + this.vida);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		this.quitarVida();
		System.out.println("PERDI VIDA: Me quedan:" + this.vida);
		return true;
	}

	public void quitarVida() {
		vida -= 1;
	}

	@Override
	public Arma usarArma() {
		return plantarBomba();
	}

	private Arma plantarBomba() {
		Arma armaInstanciada = factoryArma.getArmaInstanciada();
		getCasillero().agregarObjeto(armaInstanciada);
		return armaInstanciada;
	}

	@Override
	protected Boolean reaccionarConTodos(Iterator<Objeto> iterador) {
		Boolean permitePasar = true;
		while (iterador.hasNext() && (permitePasar)) {
			permitePasar = iterador.next().reaccionarCon(this);
		}
		return permitePasar;
	}

	/**
	 * Guardo la direccion a la que tengo que moverme. Cuando el juego ejecute
	 * el metodo vivir(), se ejecuta la accion de moverConEstrategia()
	 */
	public void setDireccionAMover(Direccion direccionAMover) {
		this.direccionAMover = direccionAMover;
	}

	/**
	 * Guardo la sentencia de atacar. Cuando el juego ejecute vivir(), se llama
	 * al metodo usarArma()
	 */
	public void atacar() {
		this.atacar = true;
	}

	@Override
	public void vivir() {
		if (atacar == true) {
			Mapa.objetoParaAgregar(this.usarArma());
			atacar = false;
		}

		if (this.direccionAMover != null) {
			
			switch(this.direccionAMover){
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
				direccionAMover = null;
			}
		}
	}
	
	@Override
	public void moverseConEstrategia(Direccion direccion) {
		
		if(this.direccionAMover != null)
			return;
		
		/*Esto pide un refactor a gritos...*/
		puntoActual.x = Constante.PIXELS_POR_CASILLERO * getPosicion().getPosX();
		puntoActual.y = Constante.PIXELS_POR_CASILLERO * getPosicion().getPosY();
		
		if(puedoMoverConEstrategia(direccion)){
			this.setDireccionAMover(direccion);
			puntoFinal.x = Constante.PIXELS_POR_CASILLERO * getPosicion().getPosX();
			puntoFinal.y = Constante.PIXELS_POR_CASILLERO * getPosicion().getPosY();
		}
	}

	@Override
	public int getX() {
		return puntoActual.x;
	}

	@Override
	public int getY() {	
		return puntoActual.y;
	}
	
	/**
	 * Recibo una direccion, e intento realizar el movimiento.
	 * Devuelvo el resultado de esta operacion
	 * @param direccion
	 * @return
	 */
	public Boolean puedoMoverConEstrategia(Direccion direccion) {

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
	
	public Direccion getDireccionAMover() {
		return direccionAMover;
	}


	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}
	
}
