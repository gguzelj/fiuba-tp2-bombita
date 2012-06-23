package com.bombitarodriguez.controller;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.utils.Direccion;

public class ControladorBomberman implements KeyPressedObservador{

	private final Bombita bombita;
	
	public ControladorBomberman(Bombita bombita){
		this.bombita = bombita;
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		switch (event.getKeyCode())
		{
			case KeyEvent.VK_DOWN:
				bombita.setDireccionAMover(Direccion.ABAJO);
				break;
			
			case KeyEvent.VK_LEFT:
				bombita.setDireccionAMover(Direccion.IZQUIERDA);
				break;
			
			case KeyEvent.VK_UP:
				bombita.setDireccionAMover(Direccion.ARRIBA);
				break;
		
			case KeyEvent.VK_RIGHT:
				bombita.setDireccionAMover(Direccion.DERECHA);
				break;
			
			case KeyEvent.VK_SPACE:
				bombita.atacar();
				break;

			default:
				break;
		}
	}

	
}
