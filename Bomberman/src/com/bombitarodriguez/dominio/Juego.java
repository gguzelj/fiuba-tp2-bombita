package com.bombitarodriguez.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bombitarodriguez.utils.Random;

/**
 * 
 * @author Mauro
 * 
 */
public class Juego {
	
	public final static Integer CANTIDAD_CASILLEROS = 225;
	
	private Integer cantidadEnemigos = 3;
	private Integer cantidadObstaculos = 100;
	private Integer cantidadArticulos = 21;
	
	List<Casillero> casillerosConObstaculos;


	public void inicializarJuego() {
		crearMapa();
	}

	private void crearMapa() {
		Integer numColumnas = (int) Math.sqrt(CANTIDAD_CASILLEROS);
		crearCasillerosVacios(numColumnas);
		Random.iniciarRandom();
		agregarObstaculos(numColumnas);
		agregarArticulos();
		agregarPersonajes();
	}

	public void crearCasillerosVacios(Integer numColumnas) {
		Casillero casillero = null;
		Posicion posicion = null;
		
		for (int x = 1; x <= numColumnas; x++) {

			for (int y = 1; y <= numColumnas; y++) {
				posicion = new Posicion(x, y);
				casillero = new Casillero(posicion);
				Mapa.getMapa().agregarCasillero(posicion, casillero);
			}
		}

	}

	private void agregarObstaculos(Integer tope) {
		Posicion posicion = null;
		Casillero casillero = null;
		Integer restoObstaculos;
		casillerosConObstaculos = new ArrayList<Casillero>();
		// agrego ncantidadObstaculos/2 obstaculos de ladrillo 
		for (int x = 0; x <= cantidadObstaculos/2; x++) {
			posicion = Random.getPosicionAlAzar(tope);
			casillero = Mapa.getMapa().getCasillero(posicion);
			casillero.agregarObjeto(new BloqueLadrillo(null));
			casillerosConObstaculos.add(casillero);
		}
		restoObstaculos = cantidadObstaculos / 2;
		// agrego ncantidadObstaculos/4 obstaculos de cemento
		for (int x = 0; x <= restoObstaculos/2; x++) {
			posicion = Random.getPosicionAlAzar(tope);
			casillero = Mapa.getMapa().getCasillero(posicion);
			casillero.agregarObjeto(new BloqueCemento(null));
			casillerosConObstaculos.add(casillero);
		}
	
		// agrego ncantidadObstaculos/4 obstaculos de Acero
		for (int x = 0; x <= restoObstaculos/2; x++) {
			posicion = Random.getPosicionAlAzar(tope);
			casillero = Mapa.getMapa().getCasillero(posicion);
			casillero.agregarObjeto(new BloqueAcero());
			casillerosConObstaculos.add(casillero);
		}
	}
	
	private void agregarArticulos() {
		int posicionCasilleroConObstaculo = 0;
		Casillero casilleroConObstaculo = null;
		Obstaculo obstaculo = null;
		Collections.shuffle(casillerosConObstaculos);
		// agrego ncantidadArticulos/3 articulos Chala
		for (int x = 0; x <= cantidadArticulos/3; x++) {
			casilleroConObstaculo = casillerosConObstaculos.get(posicionCasilleroConObstaculo ++);
			obstaculo = (Obstaculo) casilleroConObstaculo.getObjetos().get(0);
			// Hasta obtener un bloque no sea de acero
			while (obstaculo.getDurabilidad() == null) {
				casilleroConObstaculo = casillerosConObstaculos.get(posicionCasilleroConObstaculo ++);
				obstaculo = (Obstaculo) casilleroConObstaculo.getObjetos().get(0);
			}
			obstaculo.setObjeto(new Chala());
		}
		// agrego ncantidadArticulos/3 articulos timer
		for (int x = 0; x <= cantidadArticulos/3; x++) {
			casilleroConObstaculo = casillerosConObstaculos.get(posicionCasilleroConObstaculo ++);
			obstaculo = (Obstaculo) casilleroConObstaculo.getObjetos().get(0);
			// Hasta obtener un bloque no sea de acero
			while (obstaculo.getDurabilidad() == null) {
				casilleroConObstaculo = casillerosConObstaculos.get(posicionCasilleroConObstaculo ++);
				obstaculo = (Obstaculo) casilleroConObstaculo.getObjetos().get(0);
			}
			obstaculo.setObjeto(new Timer());
		}	
		
		// agrego ncantidadArticulos/3 articulos toletole
		for (int x = 0; x <= cantidadArticulos/3; x++) {
			casilleroConObstaculo = casillerosConObstaculos.get(posicionCasilleroConObstaculo ++);
			obstaculo = (Obstaculo) casilleroConObstaculo.getObjetos().get(0);
			// Hasta obtener un bloque no sea de acero
			while (obstaculo.getDurabilidad() == null) {
				casilleroConObstaculo = casillerosConObstaculos.get(posicionCasilleroConObstaculo ++);
				obstaculo = (Obstaculo) casilleroConObstaculo.getObjetos().get(0);
			}
			obstaculo.setObjeto(new ArticuloToleTole());
		}
		
		//Agrego la salida a un bloque de ladrillo o cemento
		casilleroConObstaculo = casillerosConObstaculos.get(posicionCasilleroConObstaculo ++);
		obstaculo = (Obstaculo) casilleroConObstaculo.getObjetos().get(0);
		// Hasta obtener un bloque no sea de acero
		while (obstaculo.getDurabilidad() == null) {
			casilleroConObstaculo = casillerosConObstaculos.get(posicionCasilleroConObstaculo ++);
			obstaculo = (Obstaculo) casilleroConObstaculo.getObjetos().get(0);
		}
		obstaculo.setObjeto(new Salida());
	}
	
	private void agregarPersonajes() {
		Casillero casilleroBombita = Mapa.getMapa().getCasillero(new Posicion(1,1));
		casilleroBombita.agregarObjeto(new Bombita(1));
		Casillero casillero = null;
		Posicion posicion = null;
		Integer numColumnas = (int) Math.sqrt(CANTIDAD_CASILLEROS);
		// Agrego los cecilios
		for (int x = 0; x <= cantidadEnemigos/3; x ++) {
			posicion = Random.getPosicionAlAzar(numColumnas);
			casillero = Mapa.getMapa().getCasillero(posicion);
			casillero.agregarObjeto(new Cecilio());
		}
		// Agrego los lopezReggae
		for (int x = 0; x <= cantidadEnemigos/3; x ++) {
			posicion = Random.getPosicionAlAzar(numColumnas);
			casillero = Mapa.getMapa().getCasillero(posicion);
			casillero.agregarObjeto(new LosLopezReggae());
		}
		// Agrego los lopezReggaeAlado
		for (int x = 0; x <= cantidadEnemigos/3; x ++) {
			posicion = Random.getPosicionAlAzar(numColumnas);
			casillero = Mapa.getMapa().getCasillero(posicion);
			casillero.agregarObjeto(new LosLopezReggaeAlado());
		}
		
	}
	
}


