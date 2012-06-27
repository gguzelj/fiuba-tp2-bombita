package com.bombitarodriguez.dominio;

import java.util.Iterator;



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

	@Override
	public void moverseConEstrategia(Direccion direccion) {
		Boolean casilleroValido = false;
		Posicion nuevaPosicion;
		try {
			nuevaPosicion = Mapa.getMapa().getNuevaPosicion(this.getPosicion(), direccion);
		} catch (FueraDelMapaException e) {
			// No se relaciona con los objetos del mapa
			return;
		}
		Casillero casilleroProximo = Mapa.getMapa().getCasillero(nuevaPosicion);
		Posicion posicionParcial;
		Iterator<ObjetoReaccionable> iterador; 
		while (!casilleroValido){
			iterador = casilleroProximo.getObjetos().iterator();
			if (reaccionarConTodos(iterador)) {
				casilleroValido = true;
			}
			else {
				posicionParcial = nuevaPosicion;
				try {
					nuevaPosicion = Mapa.getMapa().getNuevaPosicion(posicionParcial, direccion);
				} catch (FueraDelMapaException e) {
					// No se relaciona con los objetos del mapa
					return;
				}
				casilleroProximo = Mapa.getMapa().getCasillero(nuevaPosicion);
			}
		}	
	 	Mapa.getMapa().reposicionar(this, casilleroProximo);
	}

	@Override
	public Imagen vistaDeObjeto() {
		return vistaPersonaje;
	}
}
