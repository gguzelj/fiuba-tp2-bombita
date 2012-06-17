package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.ArticuloToleTole;
import com.bombitarodriguez.dominio.BloqueAcero;
import com.bombitarodriguez.dominio.BloqueCemento;
import com.bombitarodriguez.dominio.BloqueLadrillo;
import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.dominio.Casillero;
import com.bombitarodriguez.dominio.Cecilio;
import com.bombitarodriguez.dominio.Chala;
import com.bombitarodriguez.dominio.Explosion;
import com.bombitarodriguez.dominio.LosLopezReggae;
import com.bombitarodriguez.dominio.LosLopezReggaeAlado;
import com.bombitarodriguez.dominio.Molotov;
import com.bombitarodriguez.dominio.Posicion;
import com.bombitarodriguez.dominio.Proyectil;
import com.bombitarodriguez.dominio.Timer;
import com.bombitarodriguez.dominio.ToleTole;
import com.bombitarodriguez.utils.Constante;

public class BloqueAceroTest {
	
	@Test
	public void testReaccionarConBombita() {
		Integer vida = new Integer(3);
		assertFalse(new BloqueAcero().reaccionarCon(new Bombita(vida)));
	}

	@Test
	public void testReaccionarConCecilio() {
		assertFalse(new BloqueAcero().reaccionarCon(new Cecilio()));
	}

	@Test
	public void testReaccionarConLopezReggae() {
		assertFalse(new BloqueAcero().reaccionarCon(new LosLopezReggae()));
	}

	@Test
	public void testReaccionarConLopezReggaeAlado() {
		assertFalse(new BloqueAcero().reaccionarCon(new LosLopezReggaeAlado()));
	}

	@Test
	public void testReaccionarConBloqueCemento() {
		assertFalse(new BloqueAcero().reaccionarCon(new BloqueCemento()));
	}

	@Test
	public void testReaccionarConBloqueLadrillo() {
		assertFalse(new BloqueAcero().reaccionarCon(new BloqueLadrillo()));
	}

	@Test
	public void testReaccionarConChala() {
		assertFalse(new BloqueAcero().reaccionarCon(new Chala()));
	}

	@Test
	public void testReaccionarConArticuloToleTole() {
		assertFalse(new BloqueAcero().reaccionarCon(new ArticuloToleTole()));
	}

	@Test
	public void testReaccionarConTimer() {
		assertFalse(new BloqueAcero().reaccionarCon(new Timer()));
	}

	@Test
	public void testReaccionarConBombaMolotov() {
		assertFalse(new BloqueAcero().reaccionarCon(new Molotov()));
	}

	@Test
	public void testReaccionarConBombaToleTole() {
		assertFalse(new BloqueAcero().reaccionarCon(new ToleTole()));
	}

	@Test
	public void testReaccionarConProyectil() {
		assertFalse(new BloqueAcero().reaccionarCon(new Proyectil()));
	}

	@Test
	public void testReaccionarConExplosion() {
		Casillero casillero = new Casillero(new Posicion(1,2));
		BloqueAcero bloqueAcero = new BloqueAcero();
		
		casillero.agregarObjeto(bloqueAcero);

		assertFalse(bloqueAcero.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(bloqueAcero.reaccionarCon(new Explosion(Constante.DESTRUCCION_TOLETOLE, Constante.ONDA_EXPANSIVA_TOLETOLE)));
	}	
	
	@Test
	public void testDestruirse() {
		Casillero casillero = new Casillero(new Posicion(1,2));
		BloqueAcero bloqueAcero = new BloqueAcero();
		casillero.agregarObjeto(bloqueAcero);
		
		bloqueAcero.destruirse();
		assertTrue(casillero.getObjetos().size() == 0);
	}	
}


