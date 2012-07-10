package com.test.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;

public class ProyectilTest {

	@Test
	public void testReaccionarConBombita(){
		Integer vida = new Integer(3);
		Proyectil proyectil = new Proyectil(Direccion.ARRIBA, new Posicion(1,1));
		Casillero casillero = new Casillero(new Posicion(1,2));
		
		casillero.agregarObjeto(proyectil);
		
		assertFalse(proyectil.reaccionarCon(new Bombita(vida)));
		assertFalse(casillero.getObjetos().isEmpty());
	}

	@Test
	public void testReaccionarConCecilio(){
		Proyectil proyectil = new Proyectil(Direccion.ARRIBA, new Posicion(1,1));
		Casillero casillero = new Casillero(new Posicion(1,2));
		
		casillero.agregarObjeto(proyectil);
		
		assertFalse(proyectil.reaccionarCon(new Cecilio()));
		assertFalse(casillero.getObjetos().isEmpty());
	}
	
	@Test
	public void testReaccionarConLopezReggae(){
		Proyectil proyectil = new Proyectil(Direccion.ARRIBA, new Posicion(1,1));
		Casillero casillero = new Casillero(new Posicion(1,2));
		
		casillero.agregarObjeto(proyectil);
		
		assertFalse(proyectil.reaccionarCon(new LopezReggae()));
		assertFalse(casillero.getObjetos().isEmpty());
	}
	
	@Test
	public void testReaccionarConLopezReggaeAlado(){
		Proyectil proyectil = new Proyectil(Direccion.ARRIBA, new Posicion(1,1));
		Casillero casillero = new Casillero(new Posicion(1,2));
		
		casillero.agregarObjeto(proyectil);
		
		assertFalse(proyectil.reaccionarCon(new LopezReggaeAlado()));
		assertFalse(casillero.getObjetos().isEmpty());
	}
	
	@Test
	public void testReaccionarConBloqueCemento(){
		assertFalse(new Proyectil(Direccion.ARRIBA, new Posicion(1,1)).reaccionarCon(new BloqueCemento()));
	}
	
	@Test
	public void testReaccionarConBloqueLadrillo(){
		assertFalse(new Proyectil(Direccion.ARRIBA, new Posicion(1,1)).reaccionarCon(new BloqueLadrillo()));
	}
	
	@Test
	public void testReaccionarConBloqueAcero() {
		assertFalse(new Proyectil(Direccion.ARRIBA, new Posicion(1,1)).reaccionarCon(new BloqueAcero()));
	}
	
	@Test
	public void testReaccionarConChala(){
		assertFalse(new Proyectil(Direccion.ARRIBA, new Posicion(1,1)).reaccionarCon(new ArticuloChala()));
	}
	
	@Test
	public void testReaccionarConArticuloToleTole(){
		assertFalse(new Proyectil(Direccion.ARRIBA, new Posicion(1,1)).reaccionarCon(new ArticuloToleTole()));
	}
	
	@Test
	public void testReaccionarConTimer(){
		assertFalse(new Proyectil(Direccion.ARRIBA, new Posicion(1,1)).reaccionarCon(new ArticuloTimer()));
	}
	
	@Test
	public void testReaccionarConBombaMolotov(){
		assertFalse(new Proyectil(Direccion.ARRIBA, new Posicion(1,1)).reaccionarCon(new Molotov()));
	}
	
	@Test
	public void testReaccionarConBombaToleTole(){
		assertFalse(new Proyectil(Direccion.ARRIBA, new Posicion(1,1)).reaccionarCon(new ToleTole()));
	}
	
	@Test
	public void testReaccionarConProyectil(){
		assertFalse(new Proyectil(Direccion.ARRIBA, new Posicion(1,1)).reaccionarCon(new Proyectil(Direccion.ARRIBA, new Posicion(1,1))));	
	}
	
	@Test
	public void testReaccionarConExplosion(){
		Proyectil proyectil = new Proyectil(Direccion.ARRIBA, new Posicion(1,1));
		Casillero casillero = new Casillero(new Posicion(1,1));
		
		casillero.agregarObjeto(proyectil);
				
		assertTrue(proyectil.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(casillero.getObjetos().isEmpty());
	}
	
	@Test
	public void testExplotar(){
		Proyectil proyectil = new Proyectil(Direccion.ARRIBA, new Posicion(1,1));
		Casillero casillero = new Casillero(new Posicion(1,1));
		
		casillero.agregarObjeto(proyectil);
				
		proyectil.explotar();
		
		assertFalse(casillero.getObjetos().isEmpty());
	}
}
