package com.bombitarodriguez.utils;

public class Constante {
	
	/**
	 * Constantes del juego
	 */
	//durabilidad bloques
	public final static Integer DURABILIDAD_BLOQUE_CEMENTO = 10;
	public final static Integer DURABILIDAD_BLOQUE_LADRILLO = 5;
	//resistencia enemigos
	public final static Integer RESISTENCIA_CECILIO = 5;
	public final static Integer RESISTENCIA_LOSLOPEZREGGAE = 10;
	public final static Integer RESISTENCIA_LOSLOPEZREGGAE_ALADO = 5;
	//velocidad de los personajes
	public final static Integer VELOCIDAD_CAMINA = 10;
	public final static Integer VELOCIDAD_CORRE = 25;
	//constantes de las armas
	public final static Integer ONDA_EXPANSIVA_MOLOTOV = 1;
	public final static Integer ONDA_EXPANSIVA_TOLETOLE = 2;
	public final static Integer ONDA_EXPANSIVA_PROYECTIL = 2;	
	
	public final static Double TIMER_MOLOTOV = 20D;
	public final static Double TIMER_TOLETOLE = 10D;
	public final static Double TIMER_PROYECTIL = 10D;
	
	public final static Integer DESTRUCCION_MOLOTOV = 5;
	public final static Integer DESTRUCCION_TOLETOLE = 0;
	public static final Integer DESTRUCCION_PROYECTIL = 10;	
	//lista con los nombres de los mapa
	public static final Integer PRIMER_MAPA = 1;
	//directorio de los mapas
	public static String DIRECTORIO_MAPAS = "\\resources\\mapas";
	//directorio de las imagenes
	public static String DIRECTORIO_IMAGENES = "/com/bombitarodriguez/vista/imagenes";
	public static final Integer PIXELS_POR_CASILLERO = 50;
	// dimensiones de la ventana
	public static final Integer DIMENSION_VENTANA = 600;
	// nombre del archivo para cargar/guardar la partida
	public static final String NOMBRE_ARCHIVO_PARTIDA = "bombita-save.xml";
	// cantidad de niveles de juego
	public static final Integer CANTIDAD_DE_NIVELES = 3;


}
