package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;

public class PosicionTest {
	
	@Test
	public void testCalcularCoordenadasDerecha() {		
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(2,1);
				
		Casillero casillero = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(1);	
		casillero.agregarObjeto(bombita);
		
		assertEquals(posicionFinal, Posicion.calcularPosicionDerecha(bombita, 1));
	}
	
	@Test
	public void testCalcularCoordenadasIzquierda() {
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(0,1);
				
		Casillero casillero = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(1);	
		casillero.agregarObjeto(bombita);		
		
		assertEquals(posicionFinal, Posicion.calcularPosicionIzquierda(bombita, 1));
	}	

	@Test
	public void testCalcularCoordenadasArriba() {
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(1,2);
				
		Casillero casillero = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(1);	
		casillero.agregarObjeto(bombita);		
		
		assertEquals(posicionFinal, Posicion.calcularPosicionArriba(bombita, 1));
	}	
	
	@Test
	public void testCalcularCoordenadasAbajo() {
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(1,0);
				
		Casillero casillero = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(1);	
		casillero.agregarObjeto(bombita);		
		
		assertEquals(posicionFinal, Posicion.calcularPosicionAbajo(bombita, 1));
	}	
}
