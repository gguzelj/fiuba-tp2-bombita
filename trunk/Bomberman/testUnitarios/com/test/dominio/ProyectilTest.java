package com.test.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;

public class ProyectilTest {

	@Test
	public void testReaccionarConBombita(){
		Integer vida = new Integer(3);
		Proyectil proyectil = new Proyectil();
		Casillero casillero = new Casillero(new Posicion(1,2));
		
		casillero.agregarObjeto(proyectil);
		
		assertFalse(proyectil.reaccionarCon(new Bombita(vida)));
		assertTrue(casillero.getObjetos().isEmpty());
	}

	@Test
	public void testReaccionarConCecilio(){
		Proyectil proyectil = new Proyectil();
		Casillero casillero = new Casillero(new Posicion(1,2));
		
		casillero.agregarObjeto(proyectil);
		
		assertFalse(proyectil.reaccionarCon(new Cecilio()));
		assertTrue(casillero.getObjetos().isEmpty());
	}
	
	@Test
	public void testReaccionarConLopezReggae(){
		Proyectil proyectil = new Proyectil();
		Casillero casillero = new Casillero(new Posicion(1,2));
		
		casillero.agregarObjeto(proyectil);
		
		assertFalse(proyectil.reaccionarCon(new LosLopezReggae()));
		assertTrue(casillero.getObjetos().isEmpty());
	}
	
	@Test
	public void testReaccionarConLopezReggaeAlado(){
		Proyectil proyectil = new Proyectil();
		Casillero casillero = new Casillero(new Posicion(1,2));
		
		casillero.agregarObjeto(proyectil);
		
		assertFalse(proyectil.reaccionarCon(new LosLopezReggaeAlado()));
		assertTrue(casillero.getObjetos().isEmpty());
	}
	
	@Test
	public void testReaccionarConBloqueCemento(){
		assertFalse(new Proyectil().reaccionarCon(new BloqueCemento()));
	}
	
	@Test
	public void testReaccionarConBloqueLadrillo(){
		assertFalse(new Proyectil().reaccionarCon(new BloqueLadrillo()));
	}
	
	@Test
	public void testReaccionarConBloqueAcero() {
		assertFalse(new Proyectil().reaccionarCon(new BloqueAcero()));
	}
	
	@Test
	public void testReaccionarConChala(){
		assertFalse(new Proyectil().reaccionarCon(new Chala()));
	}
	
	@Test
	public void testReaccionarConArticuloToleTole(){
		assertFalse(new Proyectil().reaccionarCon(new ArticuloToleTole()));
	}
	
	@Test
	public void testReaccionarConTimer(){
		assertFalse(new Proyectil().reaccionarCon(new Timer()));
	}
	
	@Test
	public void testReaccionarConBombaMolotov(){
		assertFalse(new Proyectil().reaccionarCon(new Molotov()));
	}
	
	@Test
	public void testReaccionarConBombaToleTole(){
		assertFalse(new Proyectil().reaccionarCon(new ToleTole()));
	}
	
	@Test
	public void testReaccionarConProyectil(){
		assertFalse(new Proyectil().reaccionarCon(new Proyectil()));	
	}
	
	@Test
	public void testReaccionarConExplosion(){
		Proyectil proyectil = new Proyectil();
		Casillero casillero = new Casillero(new Posicion(1,1));
		
		casillero.agregarObjeto(proyectil);
				
		assertTrue(proyectil.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.getObjetos().isEmpty());
	}
}
