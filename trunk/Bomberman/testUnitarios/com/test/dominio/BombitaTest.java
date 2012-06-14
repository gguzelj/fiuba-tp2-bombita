package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.bombitarodriguez.dominio.*;

public class BombitaTest {
	
	Posicion posicionInicial;
	Posicion posicionFinal;   	
	Casillero casilleroInicial;
	Casillero casilleroFinal;	
	Bombita bombita;
	Integer vida;
	
	@Before
	public void setUp(){
		vida = new Integer(1);
		posicionInicial = new Posicion(1, 1);
		posicionFinal = new Posicion(1,2);
		casilleroInicial = new Casillero(posicionInicial);
		casilleroFinal = new Casillero(posicionFinal);
		bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
	}
	
	@Test
	public void testMover_CasilleroVacio() {
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);	
		bombita.moverArriba();
		assertEquals(bombita.getPosicion(), posicionFinal);			
	}
	
	@Test
	public void testMeMuevoYCasilleroQuedaVacio(){
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);	
		bombita.moverArriba();		
		Integer cantidadDeObjetos = casilleroInicial.getObjetos().size();
		assertEquals(cantidadDeObjetos, new Integer(0));
	}
	
	
	

	@Test
	public void testQuitarVidaBombita() {		
		Integer vidaInicial = bombita.getVida();
		bombita.quitarVida();
		assertEquals(bombita.getVida(),new Integer(vidaInicial-1));		
	}
	
	
	
	@Test
	public void testMover_CasilleroBloqueAcero() {
		casilleroFinal.agregarObjeto(new BloqueAcero());
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);		
		bombita.moverArriba();
		assertEquals(bombita.getPosicion(),posicionInicial);		
	}
	
	@Test
	public void testMover_CasilleroBombaMolotov() {
		casilleroFinal.agregarObjeto(new Molotov());
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);	
		bombita.moverArriba();	
		assertEquals(bombita.getPosicion(),posicionFinal);		
	}
	
	@Test
	public void testMover_CasilleroCecilio() {
		casilleroFinal.agregarObjeto(new Cecilio(2));
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		bombita.moverArriba();	
		assertEquals(bombita.getVida() , new Integer(0));		

	}	

	@Test
	public void testPlantarBomba() {
		bombita.usarArma();
		Integer cantidadObjetos = bombita.getCasillero().getObjetos().size();
		assertEquals(cantidadObjetos, new Integer(2));
		
	}
	
	@Test
	public void testPorDefaultColocaMolotov(){
		bombita.usarArma();
		assertTrue(bombita.getCasillero().getObjetos().get(1) instanceof Molotov);
	}
	
	@Test
	public void testAtributoChala(){
		casilleroFinal.agregarObjeto(new Chala());
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		bombita.moverArriba();
		
		assertEquals(bombita.getVelocidad(),new Integer(2));
	}
	
	@Test
	public void testAtributoToleTole(){
		casilleroFinal.agregarObjeto(new ArticuloToleTole());
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		
		bombita.moverArriba();
		
		FactoryArma arma = bombita.getFactoryArma();
		
		assertTrue( arma.getArmaInstanciada() instanceof ToleTole);
	}
	
	@Test
	public void testBombitaColocaBombaYSeMueve(){
		
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		bombita.usarArma();
		bombita.moverArriba();
		Integer cantidadDeObjetos = casilleroInicial.getObjetos().size();
		assertEquals(cantidadDeObjetos, new Integer(1));
		
	}
}
