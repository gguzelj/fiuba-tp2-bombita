package com.bombitarodriguez.utils;

import java.util.ArrayList;
import java.util.List;

import com.bombitarodriguez.dominio.Posicion;

public class Random {
	
	private static List<Posicion> posicionesYaSalidas;
	
	static public void iniciarRandom() {
		posicionesYaSalidas = new ArrayList<Posicion>();
		// bombita arranca en esta posicion
		posicionesYaSalidas.add(new Posicion(1, 1));
	}
	
	static public Posicion getPosicionAlAzar(Integer tope) {
		
		Posicion posicion = null;
		Boolean yaSalio = true;
		
		while (yaSalio) {
			Integer x = ((int)(Math.random() * tope)) + 1;
			Integer y = ((int)(Math.random() * tope)) + 1;
			posicion = new Posicion (x, y);
			yaSalio = posicionesYaSalidas.contains(posicion);
		}
		posicionesYaSalidas.add(posicion);
		return posicion;
	}

	public static List<Posicion> getPosicionesYaSalidas() {
		return posicionesYaSalidas;
	}

	public static void setPosicionesYaSalidas(List<Posicion> posicionesYaSalidas) {
		Random.posicionesYaSalidas = posicionesYaSalidas;
	}
	
	

}
