package com.bombitarodriguez.controller;

import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.titiritero.Direccion;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

import com.bombitarodriguez.dominio.Bombita;

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
				bombita.mover(Direccion.ARRIBA);
				break;
			
			case KeyEvent.VK_LEFT:
				bombita.mover(Direccion.IZQUIERDA);
				break;
			
			case KeyEvent.VK_UP:
				bombita.mover(Direccion.ABAJO);
				break;
		
			case KeyEvent.VK_RIGHT:
				bombita.mover(Direccion.DERECHA);
				break;
			
			case KeyEvent.VK_SPACE:
				bombita.atacar();
				break;

			default:
				break;
		}
	}
}
