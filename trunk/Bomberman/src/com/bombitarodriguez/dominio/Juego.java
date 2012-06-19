package com.bombitarodriguez.dominio;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bombitarodriguez.utils.Constante;

/**
 * 
 * @author Mauro
 * 
 */
public class Juego {
	
	public void inicializarJuego() {
		
		crearMapa(Constante.DIRECTORIO_MAPAS, 1);
	}

	private void crearMapa(File f, Integer nivelJuego) {
		StringBuilder nombreContenedorMapa = new StringBuilder();
		nombreContenedorMapa.append(nivelJuego.toString());
		nombreContenedorMapa.append(".mapa");
		File file = Constante.DIRECTORIO_MAPAS;
		file = new File(f.getPath() + File.separatorChar
	                + nombreContenedorMapa + File.separatorChar + nivelJuego.toString() + ".xml");
		
		Mapa.getMapa().crearMapa(f); 
		
		
	}

//	public void crearCasillerosVacios(Integer numColumnas) {
//		Casillero casillero = null;
//		Posicion posicion = null;
//		
//		for (int x = 1; x <= numColumnas; x++) {
//
//			for (int y = 1; y <= numColumnas; y++) {
//				posicion = new Posicion(x, y);
//				casillero = new Casillero(posicion);
//				Mapa.getMapa().agregarCasillero(posicion, casillero);
//			}
//		}
//
//	}

	
}


