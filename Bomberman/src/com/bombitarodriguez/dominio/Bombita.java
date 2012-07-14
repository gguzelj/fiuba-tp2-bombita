package com.bombitarodriguez.dominio;

import java.util.Iterator;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro
 */
public class Bombita extends Personaje {

	private Integer vida;

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
	
	@Override
	public void atacar() {
		this.atacar = true;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}
	
}
