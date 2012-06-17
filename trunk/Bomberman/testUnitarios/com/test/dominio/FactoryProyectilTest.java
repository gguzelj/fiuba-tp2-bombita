package com.test.dominio;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.bombitarodriguez.dominio.*;

public class FactoryProyectilTest {
	@Test
	public void testInstanciarArma(){
		FactoryArma factory = new FactoryProyectil();
		assertTrue(factory.instanciarArma() instanceof Proyectil);
	}
}
