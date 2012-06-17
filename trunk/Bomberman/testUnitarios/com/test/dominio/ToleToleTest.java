package com.test.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;

public class ToleToleTest {

	@Test
	public void testReaccionarConBombita(){
		Integer vida = new Integer(3);
		assertTrue(new ToleTole().reaccionarCon(new Bombita(vida)));
	}

	@Test
	public void testReaccionarConCecilio(){
		assertTrue(new ToleTole().reaccionarCon(new Cecilio()));
	}
	
	@Test
	public void testReaccionarConLopezReggae(){
		assertTrue(new ToleTole().reaccionarCon(new LosLopezReggae()));
	}
	
	@Test
	public void testReaccionarConLopezReggaeAlado(){
		assertTrue(new ToleTole().reaccionarCon(new LosLopezReggaeAlado()));
	}
	
	@Test
	public void testReaccionarConBloqueCemento(){
		assertFalse(new ToleTole().reaccionarCon(new BloqueCemento()));
	}
	
	@Test
	public void testReaccionarConBloqueLadrillo(){
		assertFalse(new ToleTole().reaccionarCon(new BloqueLadrillo()));
	}
	
	@Test
	public void testReaccionarConBloqueAcero() {
		assertFalse(new ToleTole().reaccionarCon(new BloqueAcero()));
	}
	
	@Test
	public void testReaccionarConChala(){
		assertFalse(new ToleTole().reaccionarCon(new Chala()));
	}
	
	@Test
	public void testReaccionarConArticuloToleTole(){
		assertFalse(new ToleTole().reaccionarCon(new ArticuloToleTole()));
	}
	
	@Test
	public void testReaccionarConTimer(){
		assertFalse(new ToleTole().reaccionarCon(new Timer()));
	}
	
	@Test
	public void testReaccionarConBombaMolotov(){
		assertTrue(new ToleTole().reaccionarCon(new Molotov()));
	}
	
	@Test
	public void testReaccionarConBombaToleTole(){
		assertTrue(new ToleTole().reaccionarCon(new ToleTole()));
	}
	
	@Test
	public void testReaccionarConProyectil(){
		assertFalse(new ToleTole().reaccionarCon(new Proyectil()));	
	}
	
	@Test
	public void testReaccionarConExplosion(){
		ToleTole toleTole = new ToleTole();
		Casillero casillero = new Casillero(new Posicion(1,1));
		
		casillero.agregarObjeto(toleTole);
				
		assertTrue(toleTole.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.getObjetos().isEmpty());
	}
}
