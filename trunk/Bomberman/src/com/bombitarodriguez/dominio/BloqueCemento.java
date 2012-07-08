package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro
 */
public class BloqueCemento extends Obstaculo {
	
	public BloqueCemento(){
		this.objeto = null;
		this.durabilidad = Constante.DURABILIDAD_BLOQUE_CEMENTO;
		this.id = Identificaciones.bloqueCemento;
	}
	
	public BloqueCemento(Objeto objeto) {
		this.objeto = objeto;
		this.durabilidad = Constante.DURABILIDAD_BLOQUE_CEMENTO;
		this.id = Identificaciones.bloqueCemento;
	}
	
	/**
	 * El obstaculo pasa a contener el objeto recibido por 
	 * parametro
	 * @param objeto
	 */
	public void agregarObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void vivir() {
	}
}
