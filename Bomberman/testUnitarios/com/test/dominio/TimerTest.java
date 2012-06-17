package com.test.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import org.junit.Test;
import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;

public class TimerTest {
	@Test
	public void testReaccionarConBombita() {
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		Casillero casillero = new Casillero(new Posicion(1,1)); 
		Timer timer = new Timer();
		
		casillero.agregarObjeto(timer);
		
		assertTrue(timer.reaccionarCon(bombita));
		assertTrue(timer.getCasillero() == null);
		assertTrue(bombita.getFactoryArma().getRetardo() == (Constante.TIMER_MOLOTOV * 0.85));
	}

	@Test
	public void testReaccionarConCecilio() {
		Cecilio cecilio = new Cecilio();
		Casillero casillero = new Casillero(new Posicion(1,1)); 
		Timer timer = new Timer();
		
		casillero.agregarObjeto(timer);
		
		assertTrue(timer.reaccionarCon(cecilio));
		assertTrue(timer.getCasillero() == null);
		assertTrue(cecilio.getFactoryArma().getRetardo() == (Constante.TIMER_MOLOTOV * 0.85));
	}

	@Test
	public void testReaccionarConLopezReggae() {
		LosLopezReggae lopezReggae = new LosLopezReggae();
		Casillero casillero = new Casillero(new Posicion(1,1)); 
		Timer timer = new Timer();
		
		casillero.agregarObjeto(timer);
		
		assertTrue(timer.reaccionarCon(lopezReggae));
		assertTrue(timer.getCasillero() == null);
		assertTrue(lopezReggae.getFactoryArma().getRetardo() == (Constante.TIMER_PROYECTIL * 0.85));
	}

	@Test
	public void testReaccionarConLopezReggaeAlado() {
		LosLopezReggaeAlado lopezReggaeAlado = new LosLopezReggaeAlado();
		Casillero casillero = new Casillero(new Posicion(1,1)); 
		Timer timer = new Timer();
		
		casillero.agregarObjeto(timer);
		
		assertTrue(timer.reaccionarCon(lopezReggaeAlado));
		assertTrue(timer.getCasillero() == null);
		assertTrue(lopezReggaeAlado.getFactoryArma().getRetardo() == (Constante.TIMER_MOLOTOV * 0.85));
	}

	@Test
	public void testReaccionarConBloqueCemento() {
		assertFalse(new Timer().reaccionarCon(new BloqueCemento()));
	}

	@Test
	public void testReaccionarConBloqueLadrillo() {
		assertFalse(new Timer().reaccionarCon(new BloqueLadrillo()));
	}

	@Test
	public void testReaccionarConBloqueAcero() {
		assertFalse(new Timer().reaccionarCon(new BloqueAcero()));
	}
	
	@Test
	public void testReaccionarConChala() {
		assertFalse(new Timer().reaccionarCon(new Chala()));
	}

	@Test
	public void testReaccionarConArticuloToleTole() {
		assertFalse(new Timer().reaccionarCon(new ArticuloToleTole()));
	}

	@Test
	public void testReaccionarConTimer() {
		assertFalse(new Timer().reaccionarCon(new Timer()));
	}

	@Test
	public void testReaccionarConBombaMolotov() {
		assertFalse(new Timer().reaccionarCon(new Molotov()));
	}

	@Test
	public void testReaccionarConBombaToleTole() {
		assertFalse(new Timer().reaccionarCon(new ToleTole()));
	}

	@Test
	public void testReaccionarConProyectil() {
		assertFalse(new Timer().reaccionarCon(new Proyectil()));
	}

	@Test
	public void testReaccionarConExplosion() {
		Casillero casillero = new Casillero(new Posicion(1,1));
		Timer timer = new Timer();
		
		casillero.agregarObjeto(timer);
		assertTrue(timer.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.estaVacio());
	}
	
	@Test
	public void testAplicarRetardo() throws Exception{
		Double metodoResultado;
		Method metodoPrivado = null;
		
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);

		Timer timer = new Timer();
		
		metodoPrivado = timer.getClass().getDeclaredMethod("aplicarRetardo", new Class[]{Personaje.class});
		metodoPrivado.setAccessible(true);

		//Aplico el retardo
		metodoResultado = (Double) metodoPrivado.invoke(timer, bombita);
		assertTrue( metodoResultado == (Constante.TIMER_MOLOTOV * 0.85) );
	}
}
