package com.test.dominio;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;

public class BombitaTest {

	@Test
	public void testReaccionarConBombita(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new Bombita(vida)));
	}
	
	@Test
	public void testReaccionarConCecilio(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertTrue(bombita.reaccionarCon(new Cecilio()));
		assertTrue(bombita.getVida() == 2);
	}
	
	@Test
	public void testReaccionarConLopezReggae(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertTrue(bombita.reaccionarCon(new LosLopezReggae()));
		assertTrue(bombita.getVida() == 2);
	}
	
	@Test
	public void testReaccionarConLopezReggaeAlado(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertTrue(bombita.reaccionarCon(new LosLopezReggaeAlado()));
		assertTrue(bombita.getVida() == 2);
	}
	
	@Test
	public void testReaccionarConBloqueCemento(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new BloqueCemento()));
	}
	
	@Test
	public void testReaccionarConBloqueLadrillo(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new BloqueLadrillo()));
	}
	
	@Test
	public void testReaccionarConBloqueAcero() {
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new BloqueAcero()));
	}
	
	@Test
	public void testReaccionarConChala(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new ArticuloChala()));
	}
	
	@Test
	public void testReaccionarConArticuloToleTole(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new ArticuloToleTole()));
	}
	
	@Test
	public void testReaccionarConTimer(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new ArticuloTimer()));
	}
	
	@Test
	public void testReaccionarConBombaMolotov(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new Molotov()));
	}
	
	@Test
	public void testReaccionarConBombaToleTole(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new ToleTole()));
	}
	
	@Test
	public void testReaccionarConProyectil(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		assertFalse(bombita.reaccionarCon(new Proyectil()));		
	}
	
	@Test
	public void testReaccionarConExplosion(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		Casillero casillero = new Casillero(new Posicion(1, 1));
		casillero.agregarObjeto(bombita);
		assertTrue(bombita.reaccionarCon(new Explosion(Constante.DESTRUCCION_MOLOTOV,
				Constante.ONDA_EXPANSIVA_MOLOTOV)));
		assertTrue(bombita.getVida() == 2);
	}
	
	@Test
	public void testGetPosicion(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		
		casillero.agregarObjeto(bombita);
		assertEquals(bombita.getPosicion(),posicion);	
	}
	
	@Test
	public void testUsarArma(){
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		
		casillero.agregarObjeto(bombita);
		assertTrue(casillero.getObjetos().size() == 1);
		
		bombita.usarArma();
		assertTrue(casillero.getObjetos().size() == 2);
	}
	
	@Test
	public void testQuitarVida() {		
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);

		bombita.quitarVida();
		assertEquals(bombita.getVida(), new Integer(vida - 1));		
	}
	
	@Test
	public void testReaccionarConTodos() throws Exception{
		Boolean metodoResultado;
		Method metodoPrivado = null;
		
		Integer vida = new Integer(3);
		Bombita bombita = new Bombita(vida);
		List<ObjetoReaccionable> listaObjetos = new ArrayList<ObjetoReaccionable>();

		metodoPrivado = bombita.getClass().getDeclaredMethod("reaccionarConTodos", 
				new Class[]{java.util.Iterator.class});
		metodoPrivado.setAccessible(true);

		//Reaccionar con la molotov deberia devolvernos false
		listaObjetos.add(new Molotov());
		metodoResultado = (Boolean) metodoPrivado.invoke(bombita, listaObjetos.iterator());
		assertFalse(metodoResultado);
		
		//Reaccionar con el bloqueAcero deberia devolvernos false
		listaObjetos.add(new BloqueAcero());
		metodoResultado = (Boolean) metodoPrivado.invoke(bombita, listaObjetos.iterator());
		assertFalse(metodoResultado);
	}
}
