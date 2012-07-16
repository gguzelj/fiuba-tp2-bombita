package com.bombitarodriguez.dominio;

import java.util.Iterator;

import com.bombitarodriguez.excepciones.IdInexistente;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Identificaciones;
import com.bombitarodriguez.vista.factory.dominio.FactoryVistas;
import com.bombitarodriguez.vista.factory.dominio.VistaVidas;

/**
 * @author Mauro
 */
public class Bombita extends Personaje {

	private Integer vida;
	private VistaVidas vistaVidas;

	public Bombita(Integer vida) {
		this.vida = vida;
		this.resistencia = 0;
		this.velocidad = Constante.VELOCIDAD_CAMINA;
		this.factoryArma = new FactoryMolotov();
		this.id = Identificaciones.bombita;
		try {
			this.vistaVidas = (VistaVidas) FactoryVistas.getVistaPorId(Identificaciones.vidas);
		} catch (IdInexistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		switch (vida) {
		case 3:
			vistaVidas.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/heart3.png");
			break;
			
		case 2:
			vistaVidas.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/heart2.png");
			break;
			
		case 1:
			vistaVidas.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/heart1.png");
			break;
		
		
		case 0:
			vistaVidas.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/heart0.png");
			break;
	     }
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

	public VistaVidas getVistaVidas() {
		return vistaVidas;
	}

	public void setVistaVidas(VistaVidas vistaVidas) {
		this.vistaVidas = vistaVidas;
	}
	
}
