package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.bombitarodriguez.dominio.*;

public class ExplosionTest {

	Posicion posicionInicial;
	Posicion posicionIzquierda;
	Posicion posicionDerecha;
	Posicion posicionArriba;
	Posicion posicionAbajo;
	Casillero casilleroInicial;
	Casillero casilleroIzquierda;
	Casillero casilleroDerecha;
	Casillero casilleroArriba;
	Casillero casilleroAbajo;
	Molotov molotov;
	
	@Before
	public void setUp(){
		posicionInicial = new Posicion(1,1);
		posicionAbajo = new Posicion(1,2);
		posicionArriba = new Posicion(1,0);
		posicionIzquierda = new Posicion(0,1);
		posicionDerecha = new Posicion(2,1);
		casilleroIzquierda = new Casillero(posicionIzquierda);
		casilleroDerecha = new Casillero(posicionDerecha);
		casilleroArriba = new Casillero(posicionArriba);
		casilleroAbajo = new Casillero(posicionAbajo);
		molotov = new Molotov();
		casilleroInicial = new Casillero(posicionInicial);
	}
	
	@Test
	public void explosionMolotovConBloqueLadrillo(){
		casilleroIzquierda.agregarObjeto(new BloqueLadrillo());
		casilleroDerecha.agregarObjeto(new BloqueLadrillo());
		casilleroArriba.agregarObjeto(new BloqueLadrillo());
		casilleroAbajo.agregarObjeto(new BloqueLadrillo());
		
		Mapa.getMapa().agregarCasillero(posicionIzquierda, casilleroIzquierda);
		Mapa.getMapa().agregarCasillero(posicionDerecha, casilleroDerecha);
		Mapa.getMapa().agregarCasillero(posicionArriba, casilleroArriba);
		Mapa.getMapa().agregarCasillero(posicionAbajo, casilleroAbajo);
		
		casilleroInicial.agregarObjeto(molotov);
		molotov.explotar();
		
		//Luego de esta explosion no deberia quedar ningun bloque en los casilleros aleda�os
		assertTrue(Mapa.getMapa().getCasillero(posicionIzquierda).getObjetos().isEmpty());
		assertTrue(Mapa.getMapa().getCasillero(posicionDerecha).getObjetos().isEmpty());
		assertTrue(Mapa.getMapa().getCasillero(posicionArriba).getObjetos().isEmpty());
		assertTrue(Mapa.getMapa().getCasillero(posicionAbajo).getObjetos().isEmpty());
	}
	
	@Test
	public void explosionMolotovConBloqueCemento(){
		casilleroIzquierda.agregarObjeto(new BloqueCemento());
		casilleroDerecha.agregarObjeto(new BloqueCemento());
		casilleroArriba.agregarObjeto(new BloqueCemento());
		casilleroAbajo.agregarObjeto(new BloqueCemento());
		
		Mapa.getMapa().agregarCasillero(posicionIzquierda, casilleroIzquierda);
		Mapa.getMapa().agregarCasillero(posicionDerecha, casilleroDerecha);
		Mapa.getMapa().agregarCasillero(posicionArriba, casilleroArriba);
		Mapa.getMapa().agregarCasillero(posicionAbajo, casilleroAbajo);
		
		casilleroInicial.agregarObjeto(molotov);
		molotov.explotar();
		
		//Luego de esta primer explosion, deberian quedar todos los bloque en los casilleros aleda�os
		assertFalse(Mapa.getMapa().getCasillero(posicionIzquierda).getObjetos().isEmpty());
		assertFalse(Mapa.getMapa().getCasillero(posicionDerecha).getObjetos().isEmpty());
		assertFalse(Mapa.getMapa().getCasillero(posicionArriba).getObjetos().isEmpty());
		assertFalse(Mapa.getMapa().getCasillero(posicionAbajo).getObjetos().isEmpty());
	
		casilleroInicial.agregarObjeto(molotov);
		molotov.explotar();
		
		//Luego de esta segunda explosion, deberian desaparecer todos los obstaculos del mapa
		assertTrue(Mapa.getMapa().getCasillero(posicionIzquierda).getObjetos().isEmpty());
		assertTrue(Mapa.getMapa().getCasillero(posicionDerecha).getObjetos().isEmpty());
		assertTrue(Mapa.getMapa().getCasillero(posicionArriba).getObjetos().isEmpty());
		assertTrue(Mapa.getMapa().getCasillero(posicionAbajo).getObjetos().isEmpty());

	}
			
}
