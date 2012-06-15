package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Direccion;

public class MapaTest {

	@Test
	public void testGetCasillero() {
		Posicion  posicion = new Posicion(1,1);
		Casillero casillero1 = new Casillero(posicion);
		Mapa.getMapa().agregarCasillero(posicion, casillero1);
		Casillero casillero2 = Mapa.getMapa().getCasillero(posicion);
		
		assertEquals(casillero1 , casillero2);		
		
	}
	
	@Test
	public void testReposicionar() {
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(1,2);
		
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		
		Bombita bombitaPosicionInicial = new Bombita(1);
		casilleroInicial.agregarObjeto(bombitaPosicionInicial);
		
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		
		Mapa.getMapa().intentarMovimiento(bombitaPosicionInicial, Direccion.ARRIBA);
		
		casilleroFinal = Mapa.getMapa().getCasillero(posicionFinal);
		Bombita bombitaPosicionFinal = (Bombita) casilleroFinal.getObjetos().get(0);
		
		assertEquals(bombitaPosicionInicial, bombitaPosicionFinal);
		
	}
	
}
