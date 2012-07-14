package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;
import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;
import ar.uba.fi.algo3.titiritero.Direccion;

public class LosLopezReggaeAladoTest {

	@Test
	public void testReaccionarConBombita(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		assertTrue(lopezReggaeAlado.reaccionarCon(bombita));
		assertTrue(bombita.getVida() == 2);
	}
	
	@Test
	public void testReaccionarConCecilio(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new Cecilio()));
	}
	
	@Test
	public void testReaccionarConlopezReggae(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new LopezReggae()));
	}
	
	@Test
	public void testReaccionarConlopezReggaeAlado(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new LopezReggaeAlado()));
	}
	
	@Test
	public void testReaccionarConBloqueCemento(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new BloqueCemento()));
	}
	
	@Test
	public void testReaccionarConBloqueLadrillo(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new BloqueLadrillo()));
	}
	
	@Test
	public void testReaccionarConBloqueAcero(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new BloqueAcero()));
	}
	
	@Test
	public void testReaccionarConChala(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new ArticuloChala()));
	}
	
	@Test
	public void testReaccionarConArticuloToleTole(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new ArticuloToleTole()));
	}
	
	@Test
	public void testReaccionarConTimer(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new ArticuloTimer()));
	}
	
	@Test
	public void testReaccionarConBombaMolotov(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new Molotov()));
	}
	
	@Test
	public void testReaccionarConBombaToleTole(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new ToleTole()));
	}
	
	@Test
	public void testReaccionarConProyectil(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		assertFalse(lopezReggaeAlado.reaccionarCon(new Proyectil(Direccion.ARRIBA, new Posicion(1,1))));		
	}
	
	@Test
	public void testReaccionarConExplosion(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		Casillero casillero = new Casillero(new Posicion(1,1));
		casillero.agregarObjeto(lopezReggaeAlado);
		
		assertTrue(lopezReggaeAlado.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.getObjetos().size() == 0);
		assertTrue(lopezReggaeAlado.getResistencia() == (Constante.RESISTENCIA_LOSLOPEZREGGAE_ALADO - Constante.DESTRUCCION_MOLOTOV));
	}
	
	@Test
	public void testGetPosicion(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		
		casillero.agregarObjeto(lopezReggaeAlado);
		assertEquals(lopezReggaeAlado.getPosicion(),posicion);	
	}
	
	@Test
	public void testUsarArma(){
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		
		casillero.agregarObjeto(lopezReggaeAlado);
		assertTrue(casillero.getObjetos().size() == 1);
		
		lopezReggaeAlado.usarArma();
		assertTrue(casillero.getObjetos().size() == 2);
	}
}
