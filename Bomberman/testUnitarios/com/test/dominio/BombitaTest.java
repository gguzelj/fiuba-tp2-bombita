package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;
import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;

public class BombitaTest {

	@Test
	public void testReaccionarConBombita(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new Bombita(vida)));
	}
	
	@Test
	public void testReaccionarConCecilio(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertTrue(bombita.reaccionarCon(new Cecilio()));
		assertTrue(bombita.getVida() == 2);
	}
	
	@Test
	public void testReaccionarConLopezReggae(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertTrue(bombita.reaccionarCon(new LosLopezReggae()));
		assertTrue(bombita.getVida() == 2);
	}
	
	@Test
	public void testReaccionarConLopezReggaeAlado(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertTrue(bombita.reaccionarCon(new LosLopezReggaeAlado()));
		assertTrue(bombita.getVida() == 2);
	}
	
	@Test
	public void testReaccionarConBloqueCemento(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new BloqueCemento()));
	}
	
	@Test
	public void testReaccionarConBloqueLadrillo(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new BloqueLadrillo()));
	}
	
	@Test
	public void testReaccionarConChala(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new Chala()));
	}
	
	@Test
	public void testReaccionarConArticuloToleTole(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new ArticuloToleTole()));
	}
	
	@Test
	public void testReaccionarConTimer(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new Timer()));
	}
	
	@Test
	public void testReaccionarConBombaMolotov(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new Molotov()));
	}
	
	@Test
	public void testReaccionarConBombaToleTole(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new ToleTole()));
	}
	
	@Test
	public void testReaccionarConProyectil(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new Proyectil()));		
	}
	
	@Test
	public void testReaccionarConExplosion(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertTrue(bombita.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(bombita.getVida() == 2);
	}
	
	@Test
	public void testGetPosicion(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		
		casillero.agregarObjeto(bombita);
		assertEquals(bombita.getPosicion(),posicion);	
	}
	
	@Test
	public void testUsarArma(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		
		casillero.agregarObjeto(bombita);
		assertTrue(casillero.getObjetos().size() == 1);
		
		bombita.usarArma();
		assertTrue(casillero.getObjetos().size() == 2);
	}
	
	@Test
	public void testQuitarVida() {		
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);

		bombita.quitarVida();
		assertEquals(bombita.getVida(),new Integer(vida-1));		
	}
	
	@Test
	public void testReaccionarConTodos(){
		//TODO El metodo es protected
	}
}
