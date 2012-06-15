package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.BloqueAcero;
import com.bombitarodriguez.dominio.Casillero;
import com.bombitarodriguez.dominio.Explosion;
import com.bombitarodriguez.dominio.Posicion;

public class BloqueAceroTest {

	@Test
	public void testBloqueNoSeVeAfectadoPorMolotov() {
		BloqueAcero bloque = new BloqueAcero();
		Posicion posicionInicial = new Posicion(1,2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Explosion explo = new Explosion(new Integer(5), new Integer (6));
		casilleroInicial.agregarObjeto(bloque);

		assertEquals (casilleroInicial.getObjetos().size(),1);
		assertFalse (bloque.reaccionarCon(explo));
		assertEquals (casilleroInicial.getObjetos().size(),1);
		}

	
	@Test
	public void testBloqueNoSeVeAfectadoPorToleTole() {
		BloqueAcero bloque = new BloqueAcero();
		Posicion posicionInicial = new Posicion(1,2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Explosion explo = new Explosion(new Integer(0), new Integer (6));
		casilleroInicial.agregarObjeto(bloque);

		assertEquals (casilleroInicial.getObjetos().size(),1);
		assertTrue (bloque.reaccionarCon(explo));
		assertEquals (casilleroInicial.getObjetos().size(),0);

	}


}


