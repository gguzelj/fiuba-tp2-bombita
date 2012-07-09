package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;

public class BloqueLadrilloTest {
	
	@Test
	public void testReaccionarConBombita() {
		Integer vida = new Integer(3);
		assertFalse(new BloqueLadrillo().reaccionarCon(new Bombita(vida)));
	}

	@Test
	public void testReaccionarConCecilio() {
		assertFalse(new BloqueLadrillo().reaccionarCon(new Cecilio()));
	}

	@Test
	public void testReaccionarConLopezReggae() {
		assertFalse(new BloqueLadrillo().reaccionarCon(new LosLopezReggae()));
	}

	@Test
	public void testReaccionarConLopezReggaeAlado() {
		assertFalse(new BloqueLadrillo().reaccionarCon(new LosLopezReggaeAlado()));
	}

	@Test
	public void testReaccionarConBloqueCemento() {
		assertFalse(new BloqueLadrillo().reaccionarCon(new BloqueCemento()));
	}

	@Test
	public void testReaccionarConBloqueLadrillo() {
		assertFalse(new BloqueLadrillo().reaccionarCon(new BloqueLadrillo()));
	}

	@Test
	public void testReaccionarConChala() {
		assertFalse(new BloqueLadrillo().reaccionarCon(new ArticuloChala()));
	}

	@Test
	public void testReaccionarConArticuloToleTole() {
		assertFalse(new BloqueLadrillo().reaccionarCon(new ArticuloToleTole()));
	}

	@Test
	public void testReaccionarConTimer() {
		assertFalse(new BloqueLadrillo().reaccionarCon(new ArticuloTimer()));
	}

	@Test
	public void testReaccionarConBombaMolotov() {
		assertFalse(new BloqueLadrillo().reaccionarCon(new Molotov()));
	}

	@Test
	public void testReaccionarConBombaToleTole() {
		assertFalse(new BloqueLadrillo().reaccionarCon(new ToleTole()));
	}

	@Test
	public void testReaccionarConProyectil() {
		assertFalse(new BloqueLadrillo().reaccionarCon(new Proyectil(Direccion.ARRIBA, new Posicion(1,1))));
	}

	@Test
	public void testReaccionarConExplosion() {
		Casillero casillero = new Casillero(new Posicion(1,2));
		BloqueLadrillo bloqueLadrillo = new BloqueLadrillo();
		
		casillero.agregarObjeto(bloqueLadrillo);

		assertTrue(bloqueLadrillo.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.getObjetos().isEmpty());
	}	
	
	@Test
	public void testDestruirse() {
		//El primer caso es que el bloque este vacio
		Casillero casillero = new Casillero(new Posicion(1,2));
		BloqueLadrillo bloqueLadrillo = new BloqueLadrillo();
		casillero.agregarObjeto(bloqueLadrillo);
		
		bloqueLadrillo.destruirse();
		assertTrue(casillero.getObjetos().isEmpty());
		
		//El segundo es que el bloque si contenga un objeto,
		//en este caso, se destruye el bloque y se agrega el objeto al casillero
		bloqueLadrillo.setObjeto(new ArticuloChala());
		casillero.agregarObjeto(bloqueLadrillo);
		
		bloqueLadrillo.destruirse();
		assertTrue(casillero.getObjetos().size() == 1);
	}	
}
