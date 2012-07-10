package com.bombitarodriguez.dominio;	

/**
 * De esta clase heredan todos los Atributos del juego:
 * -ArticuloChala
 * -ArticuloTimer
 * -ArticuloToleTole
 */
public abstract class Articulo extends Objeto{
	
	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		this.getCasillero().quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}
}
