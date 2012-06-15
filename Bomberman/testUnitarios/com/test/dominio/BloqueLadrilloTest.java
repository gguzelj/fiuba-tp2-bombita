package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;

public class BloqueLadrilloTest {
	
	@Test 
	public void testAgregarObjeto() {
		Casillero casillero = new Casillero(new Posicion(1, 1));
		BloqueLadrillo bloqueLadrillo = new BloqueLadrillo(null);
		casillero.agregarObjeto(bloqueLadrillo);
		ObjetoReaccionable salida = new Salida();
		
		bloqueLadrillo.agregarObjeto(salida);
		
		assertEquals(bloqueLadrillo.getObjeto(), salida);
		
	}
	
	@Test 
	public void testQuitarObjeto() {
		Casillero casillero = new Casillero(new Posicion(1, 1));
		BloqueLadrillo bloqueLadrillo = new BloqueLadrillo(null);
		casillero.agregarObjeto(bloqueLadrillo);
		ObjetoReaccionable salida = new Salida();
		bloqueLadrillo.setObjeto(salida);
		
		bloqueLadrillo.quitarObjeto();
		
		assertNull(bloqueLadrillo.getObjeto());
	}
	
	
	
	@Test
	public void testDestruirse() {
		Casillero casillero = new Casillero(new Posicion(1, 1));
		BloqueLadrillo bloqueLadrillo = new BloqueLadrillo(null);
		casillero.agregarObjeto(bloqueLadrillo);
		ObjetoReaccionable salida = new Salida();
		bloqueLadrillo.setObjeto(salida);
		
		bloqueLadrillo.destruirse();
		
		assertEquals(casillero.getObjetos().size(), 1);
	}

}
