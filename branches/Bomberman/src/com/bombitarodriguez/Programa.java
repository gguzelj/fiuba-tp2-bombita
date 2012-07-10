package com.bombitarodriguez;

import com.bombitarodriguez.dominio.Juego;

public class Programa {

	private static Juego juego;
	
	public static void main(String[] args) {
		
		juego = new Juego();
		juego.iniciarJuego();
		
	}

}
