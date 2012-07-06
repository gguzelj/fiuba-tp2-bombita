package com.bombitarodriguez.dominio;

import java.util.Iterator;


import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;
import com.bombitarodriguez.vista.factory.dominio.VistaLopezReggae;
import com.bombitarodriguez.vista.factory.dominio.VistaLopezReggaeAlado;

/**
 * @author Mauro
 */
public class LosLopezReggae extends Personaje {
		
	private Direccion ultimaDireccion;
	private FactoryProyectil factoryArma; 
	
	public LosLopezReggae() {
		this.resistencia = Constante.RESISTENCIA_LOSLOPEZREGGAE;
		this.velocidad = Constante.VELOCIDAD_CORRE;
		this.factoryArma = new FactoryProyectil();
		this.vistaPersonaje = new VistaLopezReggae();

	}	
	
	@Override
	public Arma usarArma() {

		Proyectil proyectil = (Proyectil) lanzarProyectil();
		
		if(proyectil != null){
			getCasillero().agregarObjeto(proyectil);
			ControladorBomberman.agregarObjeto(proyectil);
		}
		
		return null;
	}

	private Arma lanzarProyectil() {
		if(this.ultimaDireccion == null)
			return null;
		return this.factoryArma.instanciarArma(this.ultimaDireccion, this.casilleroContenedor.getPosicion());
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

	@Override
	public Imagen vistaDeObjeto() {
		return vistaPersonaje;
	}

	@Override
	public void moverseConEstrategia(Direccion direccion) {
		super.moverseConEstrategia(direccion);
		this.ultimaDireccion = direccion;
	}

}
