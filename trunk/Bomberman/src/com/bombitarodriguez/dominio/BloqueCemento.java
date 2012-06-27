package com.bombitarodriguez.dominio;



import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.vista.factory.dominio.VistaBloqueCemento;
import com.bombitarodriguez.vista.factory.dominio.VistaBloqueLadrillo;

/**
 * 
 * @author Mauro
 *
 */
public class BloqueCemento extends Obstaculo {
	
	public BloqueCemento(){
		this.objeto = null;
		this.durabilidad = Constante.DURABILIDAD_BLOQUE_CEMENTO;
		this.vistaObstaculo = new VistaBloqueCemento();
	}
	
	public BloqueCemento(ObjetoReaccionable objeto) {
		this.objeto = objeto;
		this.durabilidad = Constante.DURABILIDAD_BLOQUE_CEMENTO;
		this.vistaObstaculo = new VistaBloqueCemento();
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
		return this.vistaObstaculo;
	}

	@Override
	public void vivir() {
		// TODO Auto-generated method stub
		
	}
	
}
