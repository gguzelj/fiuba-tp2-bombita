package com.test.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import ar.uba.fi.algo3.titiritero.Direccion;

import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;

public class ArticuloToleToleTest {

	@Test
	public void testReaccionarConBombita() {
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		FactoryArma factory;
		Casillero casillero = new Casillero(new Posicion(1,1));
		ArticuloToleTole articuloToleTole = new ArticuloToleTole();
		
		casillero.agregarObjeto(articuloToleTole);
		assertTrue(articuloToleTole.reaccionarCon(bombita));
		
		factory = bombita.getFactoryArma();
		assertTrue(factory instanceof FactoryToleTole);
		assertTrue(articuloToleTole.getCasillero() == null);
	}

	@Test
	public void testReaccionarConCecilio() {
		Cecilio cecilio = new Cecilio();
		FactoryArma factory;
		Casillero casillero = new Casillero(new Posicion(1,1));
		ArticuloToleTole articuloToleTole = new ArticuloToleTole();
		
		casillero.agregarObjeto(articuloToleTole);
		assertTrue(articuloToleTole.reaccionarCon(cecilio));
		
		factory = cecilio.getFactoryArma();
		assertTrue(factory instanceof FactoryToleTole);
		assertTrue(articuloToleTole.getCasillero() == null);
	}

	@Test
	public void testReaccionarConLopezReggae() {
		LopezReggae lopezReggae = new LopezReggae();
		Casillero casillero = new Casillero(new Posicion(1,1));
		ArticuloToleTole articuloToleTole = new ArticuloToleTole();
		
		casillero.agregarObjeto(articuloToleTole);
		assertTrue(articuloToleTole.reaccionarCon(lopezReggae));
		
		assertTrue(articuloToleTole.getCasillero() == null);
	}

	@Test
	public void testReaccionarConLopezReggaeAlado() {
		LopezReggaeAlado lopezReggaeAlado = new LopezReggaeAlado();
		FactoryArma factory;
		Casillero casillero = new Casillero(new Posicion(1,1));
		ArticuloToleTole articuloToleTole = new ArticuloToleTole();
		
		casillero.agregarObjeto(articuloToleTole);
		assertTrue(articuloToleTole.reaccionarCon(lopezReggaeAlado));
		
		factory = lopezReggaeAlado.getFactoryArma();
		assertTrue(factory instanceof FactoryToleTole);
		assertTrue(articuloToleTole.getCasillero() == null);
	}

	@Test
	public void testReaccionarConBloqueCemento() {
		assertFalse(new ArticuloToleTole().reaccionarCon(new BloqueCemento()));
	}

	@Test
	public void testReaccionarConBloqueLadrillo() {
		assertFalse(new ArticuloToleTole().reaccionarCon(new BloqueLadrillo()));
	}
	
	@Test
	public void testReaccionarConBloqueAcero() {
		assertFalse(new ArticuloToleTole().reaccionarCon(new BloqueAcero()));
	}
	
	@Test
	public void testReaccionarConChala() {
		assertFalse(new ArticuloToleTole().reaccionarCon(new ArticuloChala()));
	}

	@Test
	public void testReaccionarConArticuloToleTole() {
		assertFalse(new ArticuloToleTole().reaccionarCon(new ArticuloToleTole()));
	}

	@Test
	public void testReaccionarConTimer() {
		assertFalse(new ArticuloToleTole().reaccionarCon(new ArticuloTimer()));
	}

	@Test
	public void testReaccionarConBombaMolotov() {
		assertFalse(new ArticuloToleTole().reaccionarCon(new Molotov()));
	}

	@Test
	public void testReaccionarConBombaToleTole() {
		assertFalse(new ArticuloToleTole().reaccionarCon(new ToleTole()));
	}

	@Test
	public void testReaccionarConProyectil() {
		assertFalse(new ArticuloToleTole().reaccionarCon(new Proyectil(Direccion.ARRIBA, new Posicion(1,1))));
	}

	@Test
	public void testReaccionarConExplosion() {
		Casillero casillero = new Casillero(new Posicion(1,1));
		ArticuloToleTole articuloToleTole = new ArticuloToleTole();
		
		casillero.agregarObjeto(articuloToleTole);
		assertTrue(articuloToleTole.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.estaVacio());
		assertTrue(articuloToleTole.getCasillero() == null);
	}
}
