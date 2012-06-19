package com.bombitarodriguez.dominio;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

/**
 * 
 * @author Mauro
 *
 */
public class BloqueLadrillo extends Obstaculo implements ObjetoVivo, ObjetoPosicionable {

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
	public void vivir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
