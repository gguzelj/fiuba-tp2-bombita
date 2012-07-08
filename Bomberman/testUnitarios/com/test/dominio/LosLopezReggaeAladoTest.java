package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;
import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;

public class LosLopezReggaeAladoTest {

	@Test
	public void testReaccionarConBombita(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		assertTrue(lopezReggaeAlado.reaccionarCon(bombita));
		assertTrue(bombita.getVida() == 2);
	}
	
	@Test
	public void testReaccionarConCecilio(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new Cecilio()));
	}
	
	@Test
	public void testReaccionarConlopezReggae(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new LosLopezReggae()));
	}
	
	@Test
	public void testReaccionarConlopezReggaeAlado(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new LosLopezReggaeAlado()));
	}
	
	@Test
	public void testReaccionarConBloqueCemento(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new BloqueCemento()));
	}
	
	@Test
	public void testReaccionarConBloqueLadrillo(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new BloqueLadrillo()));
	}
	
	@Test
	public void testReaccionarConBloqueAcero(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new BloqueAcero()));
	}
	
	@Test
	public void testReaccionarConChala(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new ArticuloChala()));
	}
	
	@Test
	public void testReaccionarConArticuloToleTole(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new ArticuloToleTole()));
	}
	
	@Test
	public void testReaccionarConTimer(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new ArticuloTimer()));
	}
	
	@Test
	public void testReaccionarConBombaMolotov(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new Molotov()));
	}
	
	@Test
	public void testReaccionarConBombaToleTole(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new ToleTole()));
	}
	
	@Test
	public void testReaccionarConProyectil(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new Proyectil()));		
	}
	
	@Test
	public void testReaccionarConExplosion(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		Casillero casillero = new Casillero(new Posicion(1,1));
		casillero.agregarObjeto(lopezReggaeAlado);
		
		assertTrue(lopezReggaeAlado.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.getObjetos().size() == 0);
		assertTrue(lopezReggaeAlado.getResistencia() == (Constante.RESISTENCIA_LOSLOPEZREGGAE_ALADO - Constante.DESTRUCCION_MOLOTOV));
	}
	
	@Test
	public void testGetPosicion(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		
		casillero.agregarObjeto(lopezReggaeAlado);
		assertEquals(lopezReggaeAlado.getPosicion(),posicion);	
	}
	
	@Test
	public void testUsarArma(){
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		
		casillero.agregarObjeto(lopezReggaeAlado);
		assertTrue(casillero.getObjetos().size() == 1);
		
		lopezReggaeAlado.usarArma();
		assertTrue(casillero.getObjetos().size() == 2);
	}
}
