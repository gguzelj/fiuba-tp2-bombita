package com.test.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;

public class ChalaTest {

	@Test
	public void testReaccionarConBombita() {
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		Casillero casillero = new Casillero(new Posicion(1,1));
		Chala chala = new Chala();
		
		casillero.agregarObjeto(chala);
		assertTrue(chala.reaccionarCon(bombita));
		assertTrue(chala.getCasillero() == null);
		assertTrue(bombita.getVelocidad() == Constante.VELOCIDAD_CORRE);
	}

	@Test
	public void testReaccionarConCecilio() {
		Cecilio cecilio = new Cecilio();
		Casillero casillero = new Casillero(new Posicion(1,1));
		Chala chala = new Chala();
		
		casillero.agregarObjeto(chala);
		assertTrue(chala.reaccionarCon(cecilio));
		assertTrue(chala.getCasillero() == null);
		assertTrue(cecilio.getVelocidad() == Constante.VELOCIDAD_CORRE);
	}

	@Test
	public void testReaccionarConLopezReggae() {
		LosLopezReggae losLopezReggae = new LosLopezReggae();
		Casillero casillero = new Casillero(new Posicion(1,1));
		Chala chala = new Chala();
		
		casillero.agregarObjeto(chala);
		assertTrue(chala.reaccionarCon(losLopezReggae));
		assertTrue(chala.getCasillero() == null);
		assertTrue(losLopezReggae.getVelocidad() == Constante.VELOCIDAD_CORRE);
	}

	@Test
	public void testReaccionarConLopezReggaeAlado() {
		LosLopezReggaeAlado losLopezReggaeAlado = new LosLopezReggaeAlado();
		Casillero casillero = new Casillero(new Posicion(1,1));
		Chala chala = new Chala();
		
		casillero.agregarObjeto(chala);
		assertTrue(chala.reaccionarCon(losLopezReggaeAlado));
		assertTrue(chala.getCasillero() == null);
		assertTrue(losLopezReggaeAlado.getVelocidad() == Constante.VELOCIDAD_CORRE);
	}

	@Test
	public void testReaccionarConBloqueCemento() {
		assertFalse(new Chala().reaccionarCon(new BloqueCemento()));
	}

	@Test
	public void testReaccionarConBloqueLadrillo() {
		assertFalse(new Chala().reaccionarCon(new BloqueLadrillo()));
	}
	
	@Test
	public void testReaccionarConBloqueAcero() {
		assertFalse(new Chala().reaccionarCon(new BloqueAcero()));
	}

	@Test
	public void testReaccionarConChala() {
		assertFalse(new Chala().reaccionarCon(new Chala()));
	}

	@Test
	public void testReaccionarConArticuloToleTole() {
		assertFalse(new Chala().reaccionarCon(new ArticuloToleTole()));
	}

	@Test
	public void testReaccionarConTimer() {
		assertFalse(new Chala().reaccionarCon(new Timer()));
	}

	@Test
	public void testReaccionarConBombaMolotov() {
		assertFalse(new Chala().reaccionarCon(new Molotov()));
	}

	@Test
	public void testReaccionarConBombaToleTole() {
		assertFalse(new Chala().reaccionarCon(new ToleTole()));
	}

	@Test
	public void testReaccionarConProyectil() {
		assertFalse(new Chala().reaccionarCon(new Proyectil()));
	}

	@Test
	public void testReaccionarConExplosion() {
		Casillero casillero = new Casillero(new Posicion(1,1));
		Chala chala = new Chala();
		
		casillero.agregarObjeto(chala);
		assertTrue(chala.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.estaVacio());
	}
}