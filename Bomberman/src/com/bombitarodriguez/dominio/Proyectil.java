package com.bombitarodriguez.dominio;

import java.util.List;
import com.bombitarodriguez.excepciones.FueraDelMapaException;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;
import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro
 */
public class Proyectil extends Arma {

	private Direccion direccion;
	private Posicion posicionActual;
	
	public Proyectil(Double retardo, Direccion direccion, Posicion posicion) {
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_PROYECTIL;
		this.destruccion = Constante.DESTRUCCION_PROYECTIL;
		this.retardo = retardo;
		this.id = Identificaciones.proyectil;
		this.direccion = direccion;
		this.posicionActual = posicion;
	}

	public Proyectil(Direccion direccion, Posicion posicion) {
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_PROYECTIL;
		this.destruccion = Constante.DESTRUCCION_PROYECTIL;
		this.retardo = Constante.TIMER_PROYECTIL;
		this.id = Identificaciones.proyectil;
		this.direccion = direccion;
		this.posicionActual = posicion;
	}

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		this.explotar();
		return false;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		this.explotar();
		return false;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		this.explotar();
		return false;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		this.explotar();
		return false;
	}

	@Override
	public void vivir() {
		
		try {
			this.posicionActual = Mapa.getMapa().getNuevaPosicion(posicionActual, direccion);
		} catch (FueraDelMapaException e) {
			this.explotar();
			return;
		}	
		
		Mapa.getMapa().reposicionar(this, new Casillero(posicionActual));

		if(!puedoMover(this.getCasillero()))
			this.explotar();
	}
	
	private boolean puedoMover(Casillero casillero) {
		return reaccionarConTodos(casillero.getObjetos());
	}
	
	/**
	 * Reacciono con todos los objetos que recibo por parametro.
	 * Si alguno de estos objetos no me permite pasar, devuelvo false
	 */
	private boolean reaccionarConTodos(List<Objeto> objetos) {
		
		Boolean puedoPasar = true;
		
		for(Objeto objeto : objetos){
			if(!objeto.reaccionarCon(this))
				puedoPasar = false;
		}
		
		return puedoPasar;
	}
}
