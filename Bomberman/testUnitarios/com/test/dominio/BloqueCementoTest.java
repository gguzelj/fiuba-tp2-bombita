package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;

public class BloqueCementoTest {

	@Test
	public void testReaccionarConBombita() {
		Integer vida = new Integer(3);
		assertFalse(new BloqueCemento().reaccionarCon(new Bombita(vida)));
	}

	@Test
	public void testReaccionarConCecilio() {
		assertFalse(new BloqueCemento().reaccionarCon(new Cecilio()));
	}

	@Test
	public void testReaccionarConLopezReggae() {
		assertFalse(new BloqueCemento().reaccionarCon(new LosLopezReggae()));
	}

	@Test
	public void testReaccionarConLopezReggaeAlado() {
		assertFalse(new BloqueCemento().reaccionarCon(new LosLopezReggaeAlado()));
	}

	@Test
	public void testReaccionarConBloqueLadrillo() {
		assertFalse(new BloqueCemento().reaccionarCon(new BloqueLadrillo()));
	}

	@Test
	public void testReaccionarConBloqueCemento() {
		assertFalse(new BloqueCemento().reaccionarCon(new BloqueCemento()));
	}

	@Test
	public void testReaccionarConChala() {
		assertFalse(new BloqueCemento().reaccionarCon(new ArticuloChala()));
	}

	@Test
	public void testReaccionarConArticuloToleTole() {
		assertFalse(new BloqueCemento().reaccionarCon(new ArticuloToleTole()));
	}

	@Test
	public void testReaccionarConTimer() {
		assertFalse(new BloqueCemento().reaccionarCon(new ArticuloTimer()));
	}

	@Test
	public void testReaccionarConBombaMolotov() {
		assertFalse(new BloqueCemento().reaccionarCon(new Molotov()));
	}

	@Test
	public void testReaccionarConBombaToleTole() {
		assertFalse(new BloqueCemento().reaccionarCon(new ToleTole()));
	}

	@Test
	public void testReaccionarConProyectil() {
		assertFalse(new BloqueCemento().reaccionarCon(new Proyectil()));
	}

	@Test
	public void testReaccionarConExplosion() {
		Casillero casillero = new Casillero(new Posicion(1,2));
		BloqueCemento bloqueCemento = new BloqueCemento();
		
		casillero.agregarObjeto(bloqueCemento);

		//La resistencia del bloque es mayor a la destruccion de la explosion
		assertFalse(bloqueCemento.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertFalse(casillero.getObjetos().isEmpty());

		//Con una segunda explosion, el bloque se destruye
		assertTrue(bloqueCemento.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.getObjetos().isEmpty());
	}	
	
	@Test
	public void testDestruirse() {
		//El primer caso es que el bloque este vacio
		Casillero casillero = new Casillero(new Posicion(1,2));
		BloqueCemento bloqueCemento = new BloqueCemento();
		casillero.agregarObjeto(bloqueCemento);
		
		bloqueCemento.destruirse();
		assertTrue(casillero.getObjetos().isEmpty());
		
		//El segundo es que el bloque si contenga un objeto,
		//en este caso, se destruye el bloque y se agrega el objeto al casillero
		bloqueCemento.setObjeto(new ArticuloChala());
		casillero.agregarObjeto(bloqueCemento);
		
		bloqueCemento.destruirse();
		assertTrue(casillero.getObjetos().size() == 1);
	}	
}
