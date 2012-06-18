package com.integracion.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.Arma;
import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.dominio.Casillero;
import com.bombitarodriguez.dominio.Cecilio;
import com.bombitarodriguez.dominio.Juego;
import com.bombitarodriguez.dominio.Mapa;
import com.bombitarodriguez.dominio.Molotov;
import com.bombitarodriguez.dominio.Posicion;

public class AtaqueAEnemigoTest {

//	@Test
	public void testEnemigoEstaFueraDelAlcanceYNoPierdeResistencia() {
		Integer vida = new Integer(4);
		//Creo a Bombita y lo agrego a un casillero
		Juego juego = new Juego();
		Mapa.getMapa().crearCasillerosVacios(10);
		
		Posicion posicionInicial = new Posicion(5, 5);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);

		Posicion posicionEnemigo = new Posicion(1,1);
		Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
		Cecilio ceci = new Cecilio();
		casilleroEnemigo.agregarObjeto(ceci);
		
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);
		
		bombita.usarArma();
		Arma arma = (Molotov)bombita.getCasillero().getObjetos().get(1);
		arma.explotar();
		ceci = (Cecilio) Mapa.getMapa().getCasillero(posicionEnemigo).getObjetos().get(0);
		assertEquals (ceci.getResistencia(),new Integer(5));
		//assertTrue(bombita.getCasillero().getObjetos().get(1) instanceof null);
			
	}
	
	
//	@Test
	public void testEnemigoEstaEnElAlcanceYSIPierdeResistencia() {
		Integer vida = new Integer(4);
		//Creo a Bombita y lo agrego a un casillero
		Juego juego = new Juego();
		Mapa.getMapa().crearCasillerosVacios(10);
		
		Posicion posicionInicial = new Posicion(5, 5);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);

		Posicion posicionEnemigo = new Posicion(5,4);
		Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
		Cecilio ceci = new Cecilio();
		casilleroEnemigo.agregarObjeto(ceci);
		
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);
		
		bombita.usarArma();
		Arma arma = (Molotov)bombita.getCasillero().getObjetos().get(1);
		arma.explotar();
		ceci = (Cecilio) Mapa.getMapa().getCasillero(posicionEnemigo).getObjetos().get(0);
		assertEquals (ceci.getResistencia(),new Integer(0));
		
			
	}
	
//	@Test
//	public void testEnemigoMuereYEsBorrado() {
//		Integer vida = new Integer(4);
//		//Creo a Bombita y lo agrego a un casillero
//		Posicion posicionInicial = new Posicion(1, 1);
//		Casillero casilleroInicial = new Casillero(posicionInicial);
//		Bombita bombita = new Bombita(vida);
//		casilleroInicial.agregarObjeto(bombita);
//
//		Posicion posicionEnemigo = new Posicion(1,2);
//		Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
//		Cecilio ceci = new Cecilio(5);
//		casilleroEnemigo.agregarObjeto(ceci);
//		
//		bombita.usarArma();
//		Molotov bomba = (Molotov) bombita.getCasillero().getObjetos().get(1);
//		bomba.explotar();
//		assertEquals (ceci.getResistencia(), new Integer(5));
//	}
//	
}
