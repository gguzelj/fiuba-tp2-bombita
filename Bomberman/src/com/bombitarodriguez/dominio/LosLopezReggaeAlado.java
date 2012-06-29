package com.bombitarodriguez.dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.excepciones.FueraDelMapaException;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;
import com.bombitarodriguez.vista.factory.dominio.VistaLopezReggaeAlado;


/**
 * 
 * @author Mauro
 *
 */
public class LosLopezReggaeAlado extends Personaje {
	
	public LosLopezReggaeAlado() {
		this.resistencia = Constante.RESISTENCIA_LOSLOPEZREGGAE_ALADO;
		this.velocidad = Constante.VELOCIDAD_CAMINA;
		this.factoryArma = new FactoryMolotov();
		this.vistaPersonaje = new VistaLopezReggaeAlado();
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
	public Arma usarArma() {
		return plantarBomba();
	}

	private Arma plantarBomba() {
		 Arma armaInstanciada = factoryArma.getArmaInstanciada();
		getCasillero().agregarObjeto(armaInstanciada);
		return armaInstanciada;
	
	}

	/**
	 * La logica de este personaje consiste en tratar de moverse a la direccion indicada.
	 * Si algun objeto en ese casillero no le permite moverse, busca el proximo.
	 * (Se realiza una copia de los objetos a iterar porque en los reaccionarCon puede 
	 * llegar a modificarse la misma lista que se itera)
	 */
	@Override
	public void moverseConEstrategia(Direccion direccion) {
		List<ObjetoReaccionable> copiaObjetosAReaccionar = new ArrayList<ObjetoReaccionable>();
		Boolean casilleroValido = false;
		Posicion nuevaPosicion;
		
		try {
			nuevaPosicion = Mapa.getMapa().getNuevaPosicion(this.getPosicion(), direccion);
		} catch (FueraDelMapaException e) {
			return;
		}
		
		Casillero casilleroProximo = Mapa.getMapa().getCasillero(nuevaPosicion);
		copiaObjetosAReaccionar.clear();
		copiaObjetosAReaccionar.addAll(casilleroProximo.getObjetos());
		
		while (!casilleroValido){
			if (reaccionarConTodos(copiaObjetosAReaccionar.iterator())) {
				casilleroValido = true;
			}
			else {
				try {
					nuevaPosicion = Mapa.getMapa().getNuevaPosicion(nuevaPosicion, direccion);
				} catch (FueraDelMapaException e) {
					return;
				}
				
				casilleroProximo = Mapa.getMapa().getCasillero(nuevaPosicion);
				copiaObjetosAReaccionar.clear();
				copiaObjetosAReaccionar.addAll(casilleroProximo.getObjetos());
			}
			
		}	
		
	 	Mapa.getMapa().reposicionar(this, casilleroProximo);
	}

	@Override
	public Imagen vistaDeObjeto() {
		return vistaPersonaje;
	}
}
