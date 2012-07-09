package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Transformacion;

/**
 * @author Mauro
 */
public abstract class Obstaculo extends Objeto implements ObjetoVivo{

	protected Integer durabilidad;
	protected Objeto objeto;
	protected Integer posX;
	protected Integer posY;

	public Integer getDurabilidad() {
		return durabilidad;
	}

	public void setDurabilidad(Integer durabilidad) {
		this.durabilidad = durabilidad;
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		Integer durabilidadRestante = (getDurabilidad() - explosion.getDestruccion());
		if ((durabilidadRestante <= 0) || (explosion.getDestruccion() == Constante.DESTRUCCION_TOLETOLE)) {
			this.destruirse();
			Mapa.objetoParaBorrar(this);
			return true;
		}
		this.setDurabilidad(durabilidadRestante);
		return false;
	}

	public void destruirse() {
		if (objeto != null){
			casillero.agregarObjeto(objeto);
			Mapa.objetoParaAgregar(objeto);
		}
			
		casillero.quitarObjeto(this);
	}

	/**
	 * Desvincula el objeto que contiene el obstaculo
	 */
	public void quitarObjeto() {
		objeto = null;
	}
	
	@Override
	public int getX() {
		return Transformacion.transformarAPixeles(getPosX());
	}

	@Override
	public int getY() {	
		return Transformacion.transformarAPixeles(getPosY());
	}
	
	@Override
	public void setCoordenadas(Integer x, Integer y) {
		posX = x;
		posY = y;
	}
	
	public Integer getPosX() {
		return posX;
	}
	
	public Integer getPosY() {
		return posY;
	}
}
