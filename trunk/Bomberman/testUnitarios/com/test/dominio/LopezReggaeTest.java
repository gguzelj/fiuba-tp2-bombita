package com.test.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;

public class LopezReggaeTest {

	@Test
	public void testReaccionarConBombita(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		LosLopezReggae lopezReggae = new LosLopezReggae();
		assertTrue(lopezReggae.reaccionarCon(bombita));
		assertTrue(bombita.getVida() == 2);
	}
	
	@Test
	public void testReaccionarConCecilio(){
		LosLopezReggae lopezReggae = new LosLopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new Cecilio()));
	}
	
	@Test
	public void testReaccionarConLopezReggae(){
		LosLopezReggae lopezReggae = new LosLopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new LosLopezReggae()));
	}
	
	@Test
	public void testReaccionarConLopezReggaeAlado(){
		LosLopezReggae lopezReggae = new LosLopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new LosLopezReggaeAlado()));
	}
	
	@Test
	public void testReaccionarConBloqueCemento(){
		LosLopezReggae lopezReggae = new LosLopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new BloqueCemento()));
	}
	
	@Test
	public void testReaccionarConBloqueLadrillo(){
		LosLopezReggae lopezReggae = new LosLopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new BloqueLadrillo()));
	}
	
	@Test
	public void testReaccionarConChala(){
		LosLopezReggae lopezReggae = new LosLopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new Chala()));
	}
	
	@Test
	public void testReaccionarConArticuloToleTole(){
		LosLopezReggae lopezReggae = new LosLopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new ArticuloToleTole()));
	}
	
	@Test
	public void testReaccionarConTimer(){
		LosLopezReggae lopezReggae = new LosLopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new Timer()));
	}
	
	@Test
	public void testReaccionarConBombaMolotov(){
		LosLopezReggae lopezReggae = new LosLopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new Molotov()));
	}
	
	@Test
	public void testReaccionarConBombaToleTole(){
		LosLopezReggae lopezReggae = new LosLopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new ToleTole()));
	}
	
	@Test
	public void testReaccionarConProyectil(){
		LosLopezReggae lopezReggae = new LosLopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new Proyectil()));		
	}
	
	@Test
	public void testReaccionarConExplosion(){
		LosLopezReggae lopezReggae = new LosLopezReggae();
		Casillero casillero = new Casillero(new Posicion(1,1));
		casillero.agregarObjeto(lopezReggae);
		
		assertTrue(lopezReggae.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.getObjetos().size() == 1);
		assertTrue(lopezReggae.getResistencia() == 5);
	}
	
	@Test
	public void testGetPosicion(){
		LosLopezReggae lopezReggae = new LosLopezReggae();
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		
		casillero.agregarObjeto(lopezReggae);
		assertEquals(lopezReggae.getPosicion(),posicion);	
	}
	
	@Test
	public void testUsarArma(){
		LosLopezReggae lopezReggae = new LosLopezReggae();
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		
		casillero.agregarObjeto(lopezReggae);
		assertTrue(casillero.getObjetos().size() == 1);
		
		lopezReggae.usarArma();
		assertTrue(casillero.getObjetos().size() == 2);
	}
}
