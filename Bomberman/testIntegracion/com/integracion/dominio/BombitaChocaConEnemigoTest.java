package com.integracion.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.dominio.Casillero;
import com.bombitarodriguez.dominio.Cecilio;
import com.bombitarodriguez.dominio.LosLopezReggae;
import com.bombitarodriguez.dominio.LosLopezReggaeAlado;
import com.bombitarodriguez.dominio.Mapa;
import com.bombitarodriguez.dominio.Posicion;
import com.bombitarodriguez.utils.Direccion;

public class BombitaChocaConEnemigoTest {

	@Test
	public void testMoverHastaUnCecilio() {
		Integer vida = new Integer(4);
		//Creo a Bombita y lo agrego a un casillero
		Posicion posicionInicial = new Posicion(1, 1);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);
		
		//Creo al enemigo y lo agrego al casillero de arriba del que está bombita
		Posicion posicionFinal = new Posicion(1,2);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Cecilio ceci = new Cecilio();
		casilleroFinal.agregarObjeto(ceci);
		
		//Agrego ambos Casilleros
		Mapa.getMapa().agregarCasillero(posicionFinal,casilleroFinal);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
	
		bombita.moverseConEstrategia(Direccion.ARRIBA);
		assertEquals(bombita.getVida(), new Integer(3));
		
	}
	
	@Test
	public void testMoverHastaUnLopezReggae() {
		Integer vida = new Integer(4);
		//Creo a Bombita y lo agrego a un casillero
		Posicion posicionInicial = new Posicion(1, 1);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);
		
		//Creo al enemigo y lo agrego al casillero de arriba del que está bombita
		Posicion posicionFinal = new Posicion(1,2);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		LosLopezReggae lope = new LosLopezReggae();
		casilleroFinal.agregarObjeto(lope);
		
		//Agrego ambos Casilleros
		Mapa.getMapa().agregarCasillero(posicionFinal,casilleroFinal);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
	
		bombita.moverseConEstrategia(Direccion.ARRIBA);
		assertEquals(bombita.getVida(), new Integer(3));
		
	}
	
	@Test
	public void testMoverHastaUnLopezReggaeAlado() {
		Integer vida = new Integer(4);
		//Creo a Bombita y lo agrego a un casillero
		Posicion posicionInicial = new Posicion(1, 1);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);
		
		//Creo al enemigo y lo agrego al casillero de arriba del que está bombita
		Posicion posicionFinal = new Posicion(1,2);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		LosLopezReggaeAlado lopeAlado = new LosLopezReggaeAlado();
		casilleroFinal.agregarObjeto(lopeAlado);
		
		//Agrego ambos Casilleros
		Mapa.getMapa().agregarCasillero(posicionFinal,casilleroFinal);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
	
		bombita.moverseConEstrategia(Direccion.ARRIBA);
		assertEquals(bombita.getVida(), new Integer(3));
		
	}

}
