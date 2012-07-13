package com.bombitarodriguez.dominio;

import java.awt.Point;
import java.util.List;

import ar.uba.fi.algo3.titiritero.Direccion;

import com.bombitarodriguez.excepciones.FueraDelMapaException;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro
 */
public class Proyectil extends Arma {

	private Direccion direccion;
	private Posicion posicionActual;
	private Point puntoActual = new Point();
	private Point puntoFinal = new Point();

	public Proyectil(Double retardo, Direccion direccion, Posicion posicion) {
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_PROYECTIL;
		this.destruccion = Constante.DESTRUCCION_PROYECTIL;
		this.retardo = retardo;
		this.id = Identificaciones.proyectil;
		this.direccion = direccion;
		this.posicionActual = posicion;
		puntoActual.x = Constante.PIXELS_POR_CASILLERO * posicion.getPosX();
		puntoActual.y = Constante.PIXELS_POR_CASILLERO * posicion.getPosY();
		puntoFinal = puntoActual;
	}

	public Proyectil(Direccion direccion, Posicion posicion) {
		this.ondaExpansiva = Constante.ONDA_EXPANSIVA_PROYECTIL;
		this.destruccion = Constante.DESTRUCCION_PROYECTIL;
		this.retardo = Constante.TIMER_PROYECTIL;
		this.id = Identificaciones.proyectil;
		this.direccion = direccion;
		this.posicionActual = posicion;
		puntoActual.x = Constante.PIXELS_POR_CASILLERO * posicion.getPosX();
		puntoActual.y = Constante.PIXELS_POR_CASILLERO * posicion.getPosY();
		puntoFinal = puntoActual;
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
	public Boolean reaccionarCon(LopezReggae lopezReggae) {
		this.explotar();
		return false;
	}

	@Override
	public Boolean reaccionarCon(LopezReggaeAlado lopezReggaeAlado) {
		this.explotar();
		return false;
	}

	@Override
	public void vivir() {

		if (puntoActual.equals(puntoFinal)) {
			this.calcularNuevoPuntoFinal();
		}
		
		switch (this.direccion) {
		case ARRIBA:
			puntoActual.y ++;
			break;
		case ABAJO:
			puntoActual.y --;
			break;
		case DERECHA:
			puntoActual.x ++;
			break;
		case IZQUIERDA:
			puntoActual.x --;
			break;
		}


	}

	private void calcularNuevoPuntoFinal() {
		try {
			this.posicionActual = Mapa.getMapa().getNuevaPosicion(posicionActual, direccion);
		} catch (FueraDelMapaException e) {
			this.explotar();
			return;
		}

		Mapa.getMapa().reposicionar(this, new Casillero(posicionActual));

		if (!puedoMover(this.getCasillero()))
			this.explotar();
		
		puntoFinal.x = Constante.PIXELS_POR_CASILLERO * posicionActual.getPosX();
		puntoFinal.y = Constante.PIXELS_POR_CASILLERO * posicionActual.getPosY();
	}

	private boolean puedoMover(Casillero casillero) {
		return reaccionarConTodos(casillero.getObjetos());
	}

	/**
	 * Reacciono con todos los objetos que recibo por parametro. Si alguno de
	 * estos objetos no me permite pasar, devuelvo false
	 */
	private boolean reaccionarConTodos(List<Objeto> objetos) {

		Boolean puedoPasar = true;

		for (Objeto objeto : objetos) {
			if (!objeto.reaccionarCon(this))
				puedoPasar = false;
		}

		return puedoPasar;
	}

	@Override
	public Boolean reaccionarCon(Proyectil proyectil){
		return true;
	}
}
