package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro
 */
public class BloqueLadrillo extends Obstaculo{

	public BloqueLadrillo(){
		this.objeto = null;
		this.durabilidad = Constante.DURABILIDAD_BLOQUE_LADRILLO;	
		this.id = Identificaciones.bloqueLadrillo;
	}
	
	public BloqueLadrillo(Objeto objeto) {
		this.objeto = objeto;
		this.durabilidad = Constante.DURABILIDAD_BLOQUE_LADRILLO;
		this.id = Identificaciones.bloqueLadrillo;
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
	public void vivir() {
	}
	
}
