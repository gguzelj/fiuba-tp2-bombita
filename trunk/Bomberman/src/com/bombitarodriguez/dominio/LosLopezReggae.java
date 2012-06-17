package com.bombitarodriguez.dominio;

import java.util.Iterator;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;

/**
 * 
 * @author Mauro
 *
 */
public class LosLopezReggae extends Personaje {
		
	public LosLopezReggae() {
		this.resistencia = Constante.RESISTENCIA_LOSLOPEZREGGAE;
		this.velocidad = Constante.VELOCIDAD_CORRE;
		this.factoryArma = new FactoryProyectil();
	}	

	@Override
	public void usarArma() {
		lanzarProyectil();
	}
	
	public void lanzarProyectil(){
		getCasillero().agregarObjeto(factoryArma.getArmaInstanciada());		
	}
	
	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		resistencia = resistencia - (explosion.getDestruccion());
		if (resistencia <= 0) destruirse();
		return true;
	}
	
	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.reaccionarCon(this);
		return true;
	}
	
	@Override
	protected Boolean reaccionarConTodos(Iterator<ObjetoReaccionable> iterador) {
		Boolean permitePasar = true;
		while (iterador.hasNext() && (permitePasar)) {
			permitePasar = iterador.next().reaccionarCon(this);
		}
		return permitePasar;
	}
}