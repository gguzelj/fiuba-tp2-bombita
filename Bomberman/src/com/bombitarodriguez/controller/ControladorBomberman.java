package com.bombitarodriguez.controller;


import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.utils.Direccion;

public class ControladorBomberman implements KeyPressedObservador {

	private final Bombita bombita;
	
	public ControladorBomberman(Bombita bombita){
		this.bombita = bombita;
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		switch (event.getKeyCode())
		{
			case KeyEvent.VK_DOWN:
				bombita.moverseConEstrategia(Direccion.ABAJO);
				System.out.println("ABAJO");
				break;
			
			case KeyEvent.VK_LEFT:
				bombita.moverseConEstrategia(Direccion.IZQUIERDA);
				System.out.println("Izq");
				break;
			
			case KeyEvent.VK_UP:
				bombita.moverseConEstrategia(Direccion.ARRIBA);
				System.out.println("ARR");
				break;
		
			case KeyEvent.VK_RIGHT:
				bombita.moverseConEstrategia(Direccion.DERECHA);
				System.out.println("DER");
				break;
			
			case KeyEvent.VK_SPACE:
				bombita.usarArma();
				System.out.println("ESP");
				break;

			default:
				break;
		}
	}

	
	
	
	
	
	
	
//	AccionAbstracta accion;
//	Personaje bombita;
//	
//	public ControladorBomberman(boolean activarReproductor, Personaje bombita) {
//		super(activarReproductor);
//		this.bombita = bombita;
//	}
//
//
//	public void requestMover(Personaje personaje, Direccion direccion) {
//		
//		accion = new AccionMovimiento(personaje, direccion);
//		accion.ejectuarAccion();
//	}
//	
//	public void requestCrearMapa() {
//		
//	}
	

}
