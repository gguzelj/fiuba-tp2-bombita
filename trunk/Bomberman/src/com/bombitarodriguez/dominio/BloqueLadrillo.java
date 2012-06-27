package com.bombitarodriguez.dominio;


import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.vista.factory.dominio.VistaBloqueLadrillo;

/**
 * 
 * @author Mauro
 *
 */
public class BloqueLadrillo extends Obstaculo{

	public BloqueLadrillo(){
		this.objeto = null;
		this.durabilidad = Constante.DURABILIDAD_BLOQUE_LADRILLO;	
		this.vistaObstaculo = new VistaBloqueLadrillo();
	}
	
	public BloqueLadrillo(ObjetoReaccionable objeto) {
		this.objeto = objeto;
		this.durabilidad = Constante.DURABILIDAD_BLOQUE_LADRILLO;
		this.vistaObstaculo = new VistaBloqueLadrillo();
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
