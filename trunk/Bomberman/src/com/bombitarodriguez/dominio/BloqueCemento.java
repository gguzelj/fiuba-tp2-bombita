package com.bombitarodriguez.dominio;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;

/**
 * 
 * @author Mauro
 *
 */
public class BloqueCemento extends Obstaculo {
	
	public BloqueCemento(ObjetoReaccionable objeto) {
		this.objeto = objeto;
		this.durabilidad = Juego.DURABILIDAD_BLOQUE_CEMENTO;
	}
	
	public void destruirse() {
		if(objeto != null)
			casilleroContenedor.agregarObjeto(objeto);
		quitarObjeto();
	}
	
	/**
	 * El obstaculo pasa a contener el objeto recibido por 
	 * parametro
	 * @param objeto
	 */
	public void agregarObjeto(ObjetoReaccionable objeto) {
		this.objeto = objeto;
	}
	
	/**
	 * Desvincula el objeto que contiene el obstaculo
	 */
	public void quitarObjeto() {
		objeto = null;	
	}
}
