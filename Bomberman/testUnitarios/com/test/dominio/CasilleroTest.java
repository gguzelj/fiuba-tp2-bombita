package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.dominio.Casillero;
import com.bombitarodriguez.dominio.Posicion;

public class CasilleroTest {

	@Test
	public void testAgregarObjeto() {
		Casillero casillero = new Casillero(new Posicion(1,1));
		Bombita bombita = new Bombita(1);
		casillero.agregarObjeto(bombita);
		assertEquals(1, casillero.getObjetos().size());
		assertEquals(bombita, casillero.getObjetos().get(0));
	}

	@Test
	public void testEstaVacio() {
		Casillero casillero = new Casillero(new Posicion(1,1));
		assertTrue(casillero.estaVacio());
	}

	@Test
	public void testQuitarObjeto() {
		Casillero casillero = new Casillero(new Posicion(1,1));
		Bombita bombita = new Bombita(1);
		casillero.agregarObjeto(bombita);
		casillero.quitarObjeto(bombita);
		assertTrue(casillero.estaVacio());
	}

}
