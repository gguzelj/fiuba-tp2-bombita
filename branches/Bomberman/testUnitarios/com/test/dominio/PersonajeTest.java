package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.dominio.Casillero;
import com.bombitarodriguez.dominio.Cecilio;
import com.bombitarodriguez.dominio.Mapa;
import com.bombitarodriguez.dominio.Posicion;

public class PersonajeTest {

	@Test
	public void getPosiciontest() {
		Posicion posicionDelObstaculo = new Posicion (8,5);
		Casillero casilleroDelObstaculo= new Casillero (posicionDelObstaculo);
		Bombita bombi = new Bombita(5);
		casilleroDelObstaculo.agregarObjeto(bombi);
		assertEquals (bombi.getPosicion().getPosX(),new Integer(8));
		assertEquals (bombi.getPosicion().getPosY(),new Integer(5));
		
	}
	
	public void destruirseTest(){
		Posicion posicionEnemigo = new Posicion(5,3);
		Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
		
		Cecilio cecilio = new Cecilio();
		casilleroEnemigo.agregarObjeto(cecilio);
		Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);
		cecilio.destruirse();
		Casillero casilleroLuegoDeDestruccion = Mapa.getMapa().getCasillero(posicionEnemigo);
		
		assertTrue(casilleroLuegoDeDestruccion.estaVacio());
		
	}
}
