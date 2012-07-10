package com.bombitarodriguez.controller;

import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.utils.Direccion;

public class ControladorBombita implements KeyPressedObservador{

	private final Bombita bombita;
	
	public ControladorBombita(Bombita bombita){
		this.bombita = bombita;
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		switch (event.getKeyCode())
		{
			case KeyEvent.VK_DOWN:
				bombita.moverseConEstrategia(Direccion.ARRIBA);
				break;
			
			case KeyEvent.VK_LEFT:
				bombita.moverseConEstrategia(Direccion.IZQUIERDA);
				break;
			
			case KeyEvent.VK_UP:
				bombita.moverseConEstrategia(Direccion.ABAJO);
				break;
		
			case KeyEvent.VK_RIGHT:
				bombita.moverseConEstrategia(Direccion.DERECHA);
				break;
			
			case KeyEvent.VK_SPACE:
				bombita.atacar();
				break;

			default:
				break;
		}
	}

	@Override
	public void keyRelease(KeyEvent arg0) {
	}
}
