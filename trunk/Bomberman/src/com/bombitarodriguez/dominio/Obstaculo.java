package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Constante;

/**
 * Clase de la cual heredan los obstaculos del juego:
 * -BloqueAcero
 * -BloqueCemento
 * -BloqueLadrillo
 */
public abstract class Obstaculo extends Objeto {

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

	/**
	 * Un obstaculo se destruye ante una explosion, si su destruccion
	 * es mayor a la resistencia del bloque.
	 * En caso de que la explosion sea de una ToleTole, el bloque se destruye
	 * automaticamentes
	 */
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

	/**
	 * Al destruirse el objeto, se agrega el objeto
	 * contenido (En caso de que el mismo contenga algun
	 * objeto)
	 */
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
}
