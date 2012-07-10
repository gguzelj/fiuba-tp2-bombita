package com.test.dominio;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;

public class FactoryToleToleTest {
	
	@Test
	public void testInstanciarArma(){
		FactoryArma factory = new FactoryToleTole();
		assertTrue(factory.instanciarArma() instanceof ToleTole);
	}	
	
}
