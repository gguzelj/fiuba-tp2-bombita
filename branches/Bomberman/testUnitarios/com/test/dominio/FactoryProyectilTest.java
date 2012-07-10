package com.test.dominio;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Direccion;

public class FactoryProyectilTest {
	@Test
	public void testInstanciarArma(){
		FactoryProyectil factory = new FactoryProyectil();
		assertTrue(factory.instanciarArma(Direccion.ARRIBA,new Posicion(1,1)) instanceof Proyectil);
	}
}
