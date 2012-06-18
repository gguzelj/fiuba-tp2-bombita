package com.bombitarodriguez;

import java.io.File;

import com.bombitarodriguez.dominio.Mapa;
import com.bombitarodriguez.utils.Constante;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer nivelJuego = 1;
		StringBuilder nombreContenedorMapa = new StringBuilder();
		nombreContenedorMapa.append(nivelJuego.toString());
		nombreContenedorMapa.append(".mapa");
		File f = new File(Constante.DIRECTORIO_MAPAS.getPath() + File.separatorChar
	                + nombreContenedorMapa + File.separatorChar + nivelJuego.toString() + ".xml");
		Mapa.getMapa().crearCasillerosVacios(10);
		Mapa.getMapa().crearMapa(f); 
	}

}
