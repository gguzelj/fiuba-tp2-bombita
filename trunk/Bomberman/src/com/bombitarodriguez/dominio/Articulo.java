package com.bombitarodriguez.dominio;	

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import com.bombitarodriguez.utils.Transformacion;

/**
 * 
 * @author Mauro
 *
 */
public abstract class Articulo extends Objeto implements ObjetoVivo{

	protected Integer posX;
	protected Integer posY;
	
	@Override
	public Boolean reaccionarCon(Explosion explosion) {
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
	
	@Override
	public void vivir() {
	}
}
