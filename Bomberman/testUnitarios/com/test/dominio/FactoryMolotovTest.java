package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;
import com.bombitarodriguez.dominio.*;

public class FactoryMolotovTest {

	@Test
	public void testInstanciarArma(){
		FactoryArma factory = new FactoryMolotov();
		assertTrue(factory.instanciarArma() instanceof Molotov);
	}	
}