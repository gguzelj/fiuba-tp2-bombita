package com.bombitarodriguez.utils;

import java.awt.Point;

import com.bombitarodriguez.dominio.Posicion;

public class Transformacion {

	/**
	 * A la hora de mostrar las imagenes por pantallas, necesitamos saber la
	 * posicion exacta en pixeles. Este metodo se encarga de devolver el punto
	 * en el cual debe ser dibujada alguna figura.
	 */
	public static Point transformarAPixeles(Posicion posicion) {
		return new Point((posicion.getPosX() * Constante.PIXELS_POR_CASILLERO),
				(posicion.getPosY() * Constante.PIXELS_POR_CASILLERO));
	}
	
	/**
	 * Devuelve la transformacion de una posicion a pixeles.
	 * Se tiene en cuenta el desplazamiento hecho por la clase imagen a la
	 * hora de dibujar las imagenes.
	 */
	public static Integer transformarAPixeles(Integer posX) {
		return (posX * Constante.PIXELS_POR_CASILLERO) + 26;
	}

}
