package com.bombitarodriguez.dominio;

import java.util.ArrayList;
import java.util.Iterator;
import com.bombitarodriguez.excepciones.FueraDelMapaException;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;

/**
 * 
 * @author Mauro
 *
 */
public class LosLopezReggae extends Personaje {
	
	
	public LosLopezReggae() {
		this.resistencia = Constante.RESISTENCIA_LOSLOPEZREGGAE;
		this.velocidad = Constante.VELOCIDAD_CAMINA;
	}	

	@Override
	protected Boolean reaccionarConTodos(Iterator<ObjetoReaccionable> iterador) {
		// TODO Definir
		return null;
	}
	
	@Override
	public void usarArma() {
		lanzarProyectil();
	}
	
	public void lanzarProyectil() {
		getCasillero().agregarObjeto(factoryArma.getArmaInstanciada());		
	}
	
	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		resistencia = resistencia - (explosion.getDestruccion());
		if (resistencia <= 0) destruirse();
		return true;
	}



}
