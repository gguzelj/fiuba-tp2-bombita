package com.bombitarodriguez.dominio;

import java.util.Iterator;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;
import com.bombitarodriguez.utils.Identificaciones;

/**
 * 
 * @author Mauro
 * 
 */
public class Bombita extends Personaje {

	private Integer vida;
	private Direccion direccionAMover = null;
	private Boolean atacar = false;

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
		
		this.destruirse();
		this.quitarVida();
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
			this.moverseConEstrategia(direccionAMover);
			direccionAMover = null;
		}
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
