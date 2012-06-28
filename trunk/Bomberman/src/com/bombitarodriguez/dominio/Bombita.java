package com.bombitarodriguez.dominio;

import java.util.Iterator;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;
import com.bombitarodriguez.vista.factory.dominio.VistaBombita;

/**
 * 
 * @author Mauro
 * 
 */
public class Bombita extends Personaje {

	private Integer vida;
	// TODO ver si se puede subir a personaje
	private Direccion direccionAMover = null;
	private Boolean atacar = false;

	public Bombita(Integer vida) {
		this.vida = vida;
		this.resistencia = 0;
		this.velocidad = Constante.VELOCIDAD_CAMINA;
		this.factoryArma = new FactoryMolotov();

	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		this.quitarVida();
		// ControladorBomberman.setEstaEnEjecucion(false);
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
	public Boolean reaccionarCon(Chala chala) {
		return true;
	}

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		
		this.destruirse();
		//		this.quitarVida();
		return true;
	}

	public void quitarVida() {
		vida -= 1;
		// Mapa.getMapa().reposicionar(this, Mapa.getMapa().getCasillero(new
		// Posicion(1,1)));
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
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
	protected Boolean reaccionarConTodos(Iterator<ObjetoReaccionable> iterador) {
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
			ControladorBomberman.agregarObjeto(this.usarArma());
			atacar = false;
		}

		if (this.direccionAMover != null) {
			this.moverseConEstrategia(direccionAMover);
			direccionAMover = null;
		}

	}

	public Imagen vistaDeObjeto() {
		return new VistaBombita();
	}

	public Direccion getDireccionAMover() {
		return direccionAMover;
	}

}
