package com.bombitarodriguez.dominio;

import java.util.Iterator;


import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.vista.factory.dominio.VistaLopezReggae;
import com.bombitarodriguez.vista.factory.dominio.VistaLopezReggaeAlado;

/**
 * 
 * @author Mauro
 *
 */
public class LosLopezReggae extends Personaje {
		
	public LosLopezReggae() {
		this.resistencia = Constante.RESISTENCIA_LOSLOPEZREGGAE;
		this.velocidad = Constante.VELOCIDAD_CORRE;
		this.factoryArma = new FactoryProyectil();
		this.vistaPersonaje = new VistaLopezReggae();

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
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.reaccionarCon(this);
		return true;
	}
	
	@Override
	protected Boolean reaccionarConTodos(Iterator<ObjetoReaccionable> iterador) {
		Boolean permitePasar = true;
		while (iterador.hasNext() && (permitePasar)) {
			permitePasar = iterador.next().reaccionarCon(this);
		}
		return permitePasar;
	}

	@Override
	public Imagen vistaDeObjeto() {
		return vistaPersonaje;
	}
}
