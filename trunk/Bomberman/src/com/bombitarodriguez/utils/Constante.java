package com.bombitarodriguez.utils;

import java.io.File;

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
	public final static Integer VELOCIDAD_CAMINA = 1;
	public final static Integer VELOCIDAD_CORRE = 2;
	//constantes de las armas
	public final static Integer ONDA_EXPANSIVA_MOLOTOV = 3;
	public final static Integer ONDA_EXPANSIVA_TOLETOLE = 6;
	public final static Integer ONDA_EXPANSIVA_PROYECTIL = 6;	
	public final static Double TIMER_MOLOTOV = 1D;
	public final static Double TIMER_TOLETOLE = 5D;
	public final static Double TIMER_PROYECTIL = 5D;
	public final static Integer DESTRUCCION_MOLOTOV = 5;
	public final static Integer DESTRUCCION_TOLETOLE = 0;
	public static final Integer DESTRUCCION_PROYECTIL = 10;	//lista con los nombres de los mapa
	public static final Integer PRIMER_MAPA = 1;
	//directorio de los mapas
	public static File DIRECTORIO_MAPAS;
	static{
	        String path = Constante.class.getProtectionDomain()
	                        .getCodeSource().getLocation().getPath();
	        File f = new File(path);
	        f = f.getParentFile();
	        f = new File(f.getPath() + "/resources/mapas");
	        DIRECTORIO_MAPAS = f;
	    }
	
	//
	public static final Integer PIXELS_POR_CASILLERO = 50;

}
