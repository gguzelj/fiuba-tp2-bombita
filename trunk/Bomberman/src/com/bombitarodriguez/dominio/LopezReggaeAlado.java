package com.bombitarodriguez.dominio;

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
public class LopezReggaeAlado extends Personaje {
	
	public LopezReggaeAlado() {
		this.resistencia = Constante.RESISTENCIA_LOSLOPEZREGGAE_ALADO;
		this.velocidad = Constante.VELOCIDAD_CAMINA;
		this.factoryArma = new FactoryMolotov();
		this.id = Identificaciones.lopezReggaeAlado;
	}	
	
	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.reaccionarCon(this);
		return true;
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
		List<Objeto> copiaObjetosAReaccionar = new ArrayList<Objeto>();
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

}
