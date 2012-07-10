package com.bombitarodriguez.dominio;

import java.util.Iterator;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;
import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro
 */
public class LopezReggae extends Personaje {
		
	private Direccion ultimaDireccion;
	private FactoryProyectil factoryArma; 
	
	public LopezReggae() {
		this.resistencia = Constante.RESISTENCIA_LOSLOPEZREGGAE;
		this.velocidad = Constante.VELOCIDAD_CORRE;
		this.factoryArma = new FactoryProyectil();
		this.id = Identificaciones.lopezReggae;
	}	
	
	@Override
	public Arma usarArma() {

		Proyectil proyectil = (Proyectil) lanzarProyectil();
		
		if(proyectil != null){
			getCasillero().agregarObjeto(proyectil);
			return proyectil;
		}
		
		return null;
	}

	private Arma lanzarProyectil() {
		if(this.ultimaDireccion == null)
			return null;
		return this.factoryArma.instanciarArma(this.ultimaDireccion, getPosicion());
	}

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.reaccionarCon(this);
		return true;
	}
	
	@Override
	protected Boolean reaccionarConTodos(Iterator<Objeto> iterador) {
		Boolean permitePasar = true;
		while (iterador.hasNext() && (permitePasar)) {
			permitePasar = iterador.next().reaccionarCon(this);
		}
		return permitePasar;
	}

	@Override
	public void moverseConEstrategia(Direccion direccion) {
		super.moverseConEstrategia(direccion);
		this.ultimaDireccion = direccion;
	}
	
	@Override
	public FactoryArma getFactoryArma() {
		return this.factoryArma;
	}
}
