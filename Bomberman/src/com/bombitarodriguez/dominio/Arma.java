package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import com.bombitarodriguez.utils.Transformacion;

/**
 * @author Mauro
 */
public abstract class Arma extends Objeto implements ObjetoVivo {
	
	protected Integer destruccion;
	protected Double retardo;
	protected Integer ondaExpansiva;
	protected Integer posX;
	protected Integer posY;

	public void explotar(){
		Explosion explosion = new Explosion(getDestruccion(),getOndaExpansiva());
		
		this.getCasillero().agregarObjeto(explosion);
		this.getCasillero().quitarObjeto(this);
		
		explosion.causarEstragos();

		Mapa.objetoParaBorrar(this);
	}
	
	@Override
	public Boolean reaccionarCon(Explosion explosion){
		this.getCasillero().quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
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
	public Integer getDestruccion() {
		return destruccion;
	}

	public void setDestruccion(Integer destruccion) {
		this.destruccion = destruccion;
	}

	public Double getRetardo() {
		return retardo;
	}

	public void setRetardo(Double retardo) {
		this.retardo = retardo;
	}

	public Integer getOndaExpansiva() {
		return ondaExpansiva;
	}

	public void setOndaExpansiva(Integer ondaExpansiva) {
		this.ondaExpansiva = ondaExpansiva;
	}
}
