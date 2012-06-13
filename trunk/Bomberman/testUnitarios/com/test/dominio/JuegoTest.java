package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.Juego;
import com.bombitarodriguez.dominio.Mapa;

public class JuegoTest {

	@Test
	public void testInicializarJuego() {
		Juego juego = new Juego();
		juego.inicializarJuego();
		
		assertEquals(Mapa.getMapa().getMapaCasillero().size(), 225);
	}

}
