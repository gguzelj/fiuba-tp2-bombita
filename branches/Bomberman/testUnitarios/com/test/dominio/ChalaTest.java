package com.test.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;

public class ChalaTest {

	@Test
	public void testReaccionarConBombita() {
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		Casillero casillero = new Casillero(new Posicion(1,1));
		ArticuloChala chala = new ArticuloChala();
		
		casillero.agregarObjeto(chala);
		assertTrue(chala.reaccionarCon(bombita));
		assertTrue(chala.getCasillero() == null);
		assertTrue(bombita.getVelocidad() == Constante.VELOCIDAD_CORRE);
	}

	@Test
	public void testReaccionarConCecilio() {
		Cecilio cecilio = new Cecilio();
		Casillero casillero = new Casillero(new Posicion(1,1));
		ArticuloChala chala = new ArticuloChala();
		
		casillero.agregarObjeto(chala);
		assertTrue(chala.reaccionarCon(cecilio));
		assertTrue(chala.getCasillero() == null);
		assertTrue(cecilio.getVelocidad() == Constante.VELOCIDAD_CORRE);
	}

	@Test
	public void testReaccionarConLopezReggae() {
		LopezReggae lopezReggae = new LopezReggae();
		Casillero casillero = new Casillero(new Posicion(1,1));
		ArticuloChala chala = new ArticuloChala();
		
		casillero.agregarObjeto(chala);
		assertTrue(chala.reaccionarCon(lopezReggae));
		assertTrue(chala.getCasillero() == null);
		assertTrue(lopezReggae.getVelocidad() == Constante.VELOCIDAD_CORRE);
	}

	@Test
	public void testReaccionarConLopezReggaeAlado() {
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		Casillero casillero = new Casillero(new Posicion(1,1));
		ArticuloChala chala = new ArticuloChala();
		
		casillero.agregarObjeto(chala);
		assertTrue(chala.reaccionarCon(lopezReggaeAlado));
		assertTrue(chala.getCasillero() == null);
		assertTrue(lopezReggaeAlado.getVelocidad() == Constante.VELOCIDAD_CORRE);
	}

	@Test
	public void testReaccionarConBloqueCemento() {
		assertFalse(new ArticuloChala().reaccionarCon(new BloqueCemento()));
	}

	@Test
	public void testReaccionarConBloqueLadrillo() {
		assertFalse(new ArticuloChala().reaccionarCon(new BloqueLadrillo()));
	}
	
	@Test
	public void testReaccionarConBloqueAcero() {
		assertFalse(new ArticuloChala().reaccionarCon(new BloqueAcero()));
	}

	@Test
	public void testReaccionarConChala() {
		assertFalse(new ArticuloChala().reaccionarCon(new ArticuloChala()));
	}

	@Test
	public void testReaccionarConArticuloToleTole() {
		assertFalse(new ArticuloChala().reaccionarCon(new ArticuloToleTole()));
	}

	@Test
	public void testReaccionarConTimer() {
		assertFalse(new ArticuloChala().reaccionarCon(new ArticuloTimer()));
	}

	@Test
	public void testReaccionarConBombaMolotov() {
		assertFalse(new ArticuloChala().reaccionarCon(new Molotov()));
	}

	@Test
	public void testReaccionarConBombaToleTole() {
		assertFalse(new ArticuloChala().reaccionarCon(new ToleTole()));
	}

	@Test
	public void testReaccionarConProyectil() {
		assertFalse(new ArticuloChala().reaccionarCon(new Proyectil(Direccion.ARRIBA, new Posicion(1,1))));
	}

	@Test
	public void testReaccionarConExplosion() {
		Casillero casillero = new Casillero(new Posicion(1,1));
		ArticuloChala chala = new ArticuloChala();
		
		casillero.agregarObjeto(chala);
		assertTrue(chala.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.estaVacio());
	}
}
