package com.test.dominio;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.bombitarodriguez.dominio.*;
import ar.uba.fi.algo3.titiritero.Direccion;

public class FactoryProyectilTest {
	@Test
	public void testInstanciarArma(){
		FactoryProyectil factory = new FactoryProyectil();
		assertTrue(factory.instanciarArma(Direccion.ARRIBA,new Posicion(1,1)) instanceof Proyectil);
	}
}
