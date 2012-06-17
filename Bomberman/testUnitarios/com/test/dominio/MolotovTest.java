package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;

public class MolotovTest {

	@Test
	public void testReaccionarConBombita(){
		Integer vida = new Integer(3);
		assertTrue(new Molotov().reaccionarCon(new Bombita(vida)));
	}

	@Test
	public void testReaccionarConCecilio(){
		assertTrue(new Molotov().reaccionarCon(new Cecilio()));
	}
	
	@Test
	public void testReaccionarConLopezReggae(){
		assertTrue(new Molotov().reaccionarCon(new LosLopezReggae()));
	}
	
	@Test
	public void testReaccionarConLopezReggaeAlado(){
		assertTrue(new Molotov().reaccionarCon(new LosLopezReggaeAlado()));
	}
	
	@Test
	public void testReaccionarConBloqueCemento(){
		assertFalse(new Molotov().reaccionarCon(new BloqueCemento()));
	}
	
	@Test
	public void testReaccionarConBloqueLadrillo(){
		assertFalse(new Molotov().reaccionarCon(new BloqueLadrillo()));
	}
	
	@Test
	public void testReaccionarConBloqueAcero() {
		assertFalse(new Molotov().reaccionarCon(new BloqueAcero()));
	}
	
	@Test
	public void testReaccionarConChala(){
		assertFalse(new Molotov().reaccionarCon(new Chala()));
	}
	
	@Test
	public void testReaccionarConArticuloToleTole(){
		assertFalse(new Molotov().reaccionarCon(new ArticuloToleTole()));
	}
	
	@Test
	public void testReaccionarConTimer(){
		assertFalse(new Molotov().reaccionarCon(new Timer()));
	}
	
	@Test
	public void testReaccionarConBombaMolotov(){
		assertTrue(new Molotov().reaccionarCon(new Molotov()));
	}
	
	@Test
	public void testReaccionarConBombaToleTole(){
		assertTrue(new Molotov().reaccionarCon(new ToleTole()));
	}
	
	@Test
	public void testReaccionarConProyectil(){
		assertFalse(new Molotov().reaccionarCon(new Proyectil()));	
	}
	
	@Test
	public void testReaccionarConExplosion(){
		Molotov molotov = new Molotov();
		Casillero casillero = new Casillero(new Posicion(1,1));
		
		casillero.agregarObjeto(molotov);
				
		assertTrue(molotov.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.getObjetos().isEmpty());
	}
}
