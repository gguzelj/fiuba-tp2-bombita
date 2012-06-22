package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.vista.factory.VistaBloqueAcero;
import com.bombitarodriguez.vista.factory.VistaBloqueLadrillo;

/**
 * 
 * @author Mauro
 *
 */
public class BloqueLadrillo extends Obstaculo{

	public BloqueLadrillo(){
		this.objeto = null;
		this.durabilidad = Constante.DURABILIDAD_BLOQUE_LADRILLO;		
	}
	
	public BloqueLadrillo(ObjetoReaccionable objeto) {
		this.objeto = objeto;
		this.durabilidad = Constante.DURABILIDAD_BLOQUE_LADRILLO;
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
		return new VistaBloqueLadrillo();
	}
	
}
