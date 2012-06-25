package com.bombitarodriguez.dominio;



import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.vista.factory.dominio.VistaBloqueCemento;

/**
 * 
 * @author Mauro
 *
 */
public class BloqueCemento extends Obstaculo {
	
	public BloqueCemento(){
		this.objeto = null;
		this.durabilidad = Constante.DURABILIDAD_BLOQUE_CEMENTO;
	}
	
	public BloqueCemento(ObjetoReaccionable objeto) {
		this.objeto = objeto;
		this.durabilidad = Constante.DURABILIDAD_BLOQUE_CEMENTO;
	}
	
	/**
	 * El obstaculo pasa a contener el objeto recibido por 
	 * parametro
	 * @param objeto
	 */
	public void agregarObjeto(ObjetoReaccionable objeto) {
		this.objeto = objeto;
	}

	@Override
	public Imagen vistaDeObjeto() {
		return new VistaBloqueCemento();
	}
	
}
