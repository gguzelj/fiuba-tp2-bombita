package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;
import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;

public class CecilioTest {

	@Test
	public void testReaccionarConBombita(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		Cecilio cecilio = new Cecilio();
		assertTrue(cecilio.reaccionarCon(bombita));
		assertTrue(bombita.getVida() == 2);
	}
	
	@Test
	public void testReaccionarConCecilio(){
		Cecilio cecilio = new Cecilio();
		assertFalse(cecilio.reaccionarCon(new Cecilio()));
	}
	
	@Test
	public void testReaccionarConLopezReggae(){
		Cecilio cecilio = new Cecilio();
		assertFalse(cecilio.reaccionarCon(new LosLopezReggae()));
	}
	
	@Test
	public void testReaccionarConLopezReggaeAlado(){
		Cecilio cecilio = new Cecilio();
		assertFalse(cecilio.reaccionarCon(new LosLopezReggaeAlado()));
	}
	
	@Test
	public void testReaccionarConBloqueCemento(){
		Cecilio cecilio = new Cecilio();
		assertFalse(cecilio.reaccionarCon(new BloqueCemento()));
	}
	
	@Test
	public void testReaccionarConBloqueLadrillo(){
		Cecilio cecilio = new Cecilio();
		assertFalse(cecilio.reaccionarCon(new BloqueLadrillo()));
	}
	
	@Test
	public void testReaccionarConBloqueAcero() {
		assertFalse(new Cecilio().reaccionarCon(new BloqueAcero()));
	}
	
	@Test
	public void testReaccionarConChala(){
		Cecilio cecilio = new Cecilio();
		assertFalse(cecilio.reaccionarCon(new ArticuloChala()));
	}
	
	@Test
	public void testReaccionarConArticuloToleTole(){
		Cecilio cecilio = new Cecilio();
		assertFalse(cecilio.reaccionarCon(new ArticuloToleTole()));
	}
	
	@Test
	public void testReaccionarConTimer(){
		Cecilio cecilio = new Cecilio();
		assertFalse(cecilio.reaccionarCon(new ArticuloTimer()));
	}
	
	@Test
	public void testReaccionarConBombaMolotov(){
		Cecilio cecilio = new Cecilio();
		assertFalse(cecilio.reaccionarCon(new Molotov()));
	}
	
	@Test
	public void testReaccionarConBombaToleTole(){
		Cecilio cecilio = new Cecilio();
		assertFalse(cecilio.reaccionarCon(new ToleTole()));
	}
	
	@Test
	public void testReaccionarConProyectil(){
		Cecilio cecilio = new Cecilio();
		assertFalse(cecilio.reaccionarCon(new Proyectil(Direccion.ARRIBA, new Posicion(1,1))));		
	}
	
	@Test
	public void testReaccionarConExplosion(){
		Cecilio cecilio = new Cecilio();
		Casillero casillero = new Casillero(new Posicion(1,1));
		casillero.agregarObjeto(cecilio);
		
		assertTrue(cecilio.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.getObjetos().size() == 0);
	}
	
	@Test
	public void testGetPosicion(){
		Cecilio cecilio = new Cecilio();
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		
		casillero.agregarObjeto(cecilio);
		assertEquals(cecilio.getPosicion(),posicion);	
	}
	
	@Test
	public void testUsarArma(){
		Cecilio cecilio = new Cecilio();
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		
		casillero.agregarObjeto(cecilio);
		assertTrue(casillero.getObjetos().size() == 1);
		
		cecilio.usarArma();
		assertTrue(casillero.getObjetos().size() == 2);
	}
}
