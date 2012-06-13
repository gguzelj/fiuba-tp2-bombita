package com.bombitarodriguez.dominio;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;

/**
 * 
 * @author Mauro
 *
 */
public class BloqueLadrillo extends Obstaculo {

	public BloqueLadrillo(ObjetoReaccionable objeto) {
		this.objeto = objeto;
		this.durabilidad = Juego.DURABILIDAD_BLOQUE_LADRILLO;
	}
	
	public void destruirse() {
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
