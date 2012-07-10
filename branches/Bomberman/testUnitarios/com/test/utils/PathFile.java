package com.test.utils;
import java.io.File;
import java.io.IOException;

/**
 * 
 * @author Mauro
 * Nos permite obtener el path absoluto
 */

public class PathFile {
	
	/**
	 * 
	 * @return el directorio actual
	 */
	public static String getPathActual() {
			File directorio = new File (".");
			try {
				return directorio.getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		
		}
	
	/**
	 * 
	 * @param rutaParciales
	 * @return directorio actual con las rutas parciales concatenadas
	 */
	public static String getPathActual(String... rutaParciales) {
		File directorio = new File (".");
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(directorio.getCanonicalPath());
			for (String rutaParcial: rutaParciales) {
				sb.append(rutaParcial);
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	
	}
		
	}