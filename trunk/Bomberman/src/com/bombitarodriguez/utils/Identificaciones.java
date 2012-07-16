package com.bombitarodriguez.utils;


/**
 * En esta clase nos encargamos de definir los IDs 
 * de los objetos que se utilizaran en el modelo del juego
 */
public class Identificaciones {

//	  	-1 cecilio
//		-2 losLopezReggae
//		-3 losLopezReggaeAlado
//		0 casillero vacio
//		1 bombita
//		2 bloque ladrillo
//		3 bloqueCemento
//		4 bloqueAcero
//		17 vidas
//		18 Armas
//		21 chala dentro de bloqueLadrillo
//		22 timer dentro de bloqueLadrillo
//		23 toletole dentro de bloqueLadrillo
//		24 salida dentro de bloqueLadrillo
//		31 chala dentro de bloqueCemento
//		32 timer dentro de bloqueCemento
//		33 toletole dentro de bloqueCemento
//		34  salida dentro de bloqueCemento
		
	/*Personajes*/	
	public static final int bombita = 1;
	public static final int cecilio = -1;
	public static final int lopezReggae = -2;
	public static final int lopezReggaeAlado = -3;
	
	/*Obstaculos*/
	public static final int bloqueLadrillo = 2;
	public static final int bloqueCemento = 3;
	public static final int bloqueAcero = 4;
	
	/*Articulos*/
	public static final int articuloChala = 5;
	public static final int articuloTimer = 6;
	public static final int articuloToleTole = 7;
	
	/*Salida*/
	public static final int salida = 8;
	
	/*Armas*/
	public static final int molotov = 9;
	public static final int toleTole = 10;
	public static final int proyectil = 11;
	
	/*Indicador de vidas*/
	public static final int vidas = 17;
	public static final int armas = 18;
	
	/*Explosion*/
	public static final int explosion = 12;

	/*Ids para el parseo de mapas*/
	public static final int casilleroVacio = 0;
	
	public static final int chalaEnBLoqueLadrillo = 21;
	public static final int timerEnBloqueLadrillo = 22;
	public static final int toleToleEnBloqueLadrillo = 23;
	public static final int salidaEnBloqueLadrillo = 24;
	
	public static final int chalaEnBLoqueCemento = 31;
	public static final int timerEnBloqueCemento = 32;
	public static final int toleToleEnBloqueCemento = 33;
	public static final int salidaEnBloqueCemento = 34;
	
}