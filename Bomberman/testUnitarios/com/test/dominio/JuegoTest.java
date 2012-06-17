package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.Juego;
import com.bombitarodriguez.dominio.Mapa;
import com.bombitarodriguez.dominio.Posicion;

public class JuegoTest {

	@Test
	public void testInicializarJuego() {
		Juego juego = new Juego();
		juego.inicializarJuego();
		
		assertEquals(Mapa.getMapa().getMapaCasillero().size(), 400);
	}
	
	@Test
	public void testCrearCasillerosVacios(){
		Juego game = new Juego();
		game.crearCasillerosVacios(3);
	
		for (int x = 1; x <= 3; x++){
			Posicion pos = new Posicion (x,1);
			assertEquals(Mapa.getMapa().getCasillero(pos).getObjetos().size(), 0);
		}
	
		for (int x = 1; x <= 3; x++){
			Posicion pos = new Posicion (x,2);
			assertEquals(Mapa.getMapa().getCasillero(pos).getObjetos().size(), 0);
		}
		
		for (int x = 1; x <= 3; x++){
			Posicion pos = new Posicion (x,3);
			assertEquals(Mapa.getMapa().getCasillero(pos).getObjetos().size(), 0);
		}
		
	}
}
