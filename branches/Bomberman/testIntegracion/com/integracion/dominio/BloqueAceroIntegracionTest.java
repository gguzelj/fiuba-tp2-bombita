package com.integracion.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;

public class BloqueAceroIntegracionTest {

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
