package com.test.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;

public class LopezReggaeTest {

	@Test
	public void testReaccionarConBombita(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		LopezReggae lopezReggae = new LopezReggae();
		assertTrue(lopezReggae.reaccionarCon(bombita));
		assertTrue(bombita.getVida() == 2);
	}
	
	@Test
	public void testReaccionarConCecilio(){
		LopezReggae lopezReggae = new LopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new Cecilio()));
	}
	
	@Test
	public void testReaccionarConLopezReggae(){
		LopezReggae lopezReggae = new LopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new LopezReggae()));
	}
	
	@Test
	public void testReaccionarConLopezReggaeAlado(){
		LopezReggae lopezReggae = new LopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new LopezReggaeAlado()));
	}
	
	@Test
	public void testReaccionarConBloqueCemento(){
		LopezReggae lopezReggae = new LopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new BloqueCemento()));
	}
	
	@Test
	public void testReaccionarConBloqueLadrillo(){
		LopezReggae lopezReggae = new LopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new BloqueLadrillo()));
	}
	
	@Test
	public void testReaccionarConBloqueAcero(){
		LopezReggae lopezReggae = new LopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new BloqueAcero()));
	}
	
	@Test
	public void testReaccionarConChala(){
		LopezReggae lopezReggae = new LopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new ArticuloChala()));
	}
	
	@Test
	public void testReaccionarConArticuloToleTole(){
		LopezReggae lopezReggae = new LopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new ArticuloToleTole()));
	}
	
	@Test
	public void testReaccionarConTimer(){
		LopezReggae lopezReggae = new LopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new ArticuloTimer()));
	}
	
	@Test
	public void testReaccionarConBombaMolotov(){
		LopezReggae lopezReggae = new LopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new Molotov()));
	}
	
	@Test
	public void testReaccionarConBombaToleTole(){
		LopezReggae lopezReggae = new LopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new ToleTole()));
	}
	
	@Test
	public void testReaccionarConProyectil(){
		LopezReggae lopezReggae = new LopezReggae();
		assertFalse(lopezReggae.reaccionarCon(new Proyectil(Direccion.ARRIBA, new Posicion(1,1))));		
	}
	
	@Test
	public void testReaccionarConExplosion(){
		LopezReggae lopezReggae = new LopezReggae();
		Casillero casillero = new Casillero(new Posicion(1,1));
		casillero.agregarObjeto(lopezReggae);
		
		assertTrue(lopezReggae.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.getObjetos().size() == 1);
		assertTrue(lopezReggae.getResistencia() == (Constante.RESISTENCIA_LOSLOPEZREGGAE - Constante.DESTRUCCION_MOLOTOV));
	}
	
	@Test
	public void testGetPosicion(){
		LopezReggae lopezReggae = new LopezReggae();
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		
		casillero.agregarObjeto(lopezReggae);
		assertEquals(lopezReggae.getPosicion(),posicion);	
	}
	
	@Test
	public void testUsarArma(){
		LopezReggae lopezReggae = new LopezReggae();
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		
		casillero.agregarObjeto(lopezReggae);
		assertTrue(casillero.getObjetos().size() == 1);
		
		
		lopezReggae.moverseConEstrategia(Direccion.ARRIBA);
		lopezReggae.usarArma();
		assertTrue(casillero.getObjetos().size() == 2);
	}
}
