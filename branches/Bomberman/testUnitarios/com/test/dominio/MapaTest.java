package com.test.dominio;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Direccion;

public class MapaTest {

	@Test
	public void testGetCasillero() {
		Posicion  posicion = new Posicion(1,1);
		Casillero casillero1 = new Casillero(posicion);
		Mapa.getMapa().agregarCasillero(posicion, casillero1);
		Casillero casillero2 = Mapa.getMapa().getCasillero(posicion);
		
		assertEquals(casillero1 , casillero2);		
		
	}
	
	@Test
	public void testReposicionar() {
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(1,2);
		
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		
		Bombita bombitaPosicionInicial = new Bombita(1);
		casilleroInicial.agregarObjeto(bombitaPosicionInicial);
		
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		
		bombitaPosicionInicial.moverseConEstrategia(Direccion.ARRIBA);
		
		casilleroFinal = Mapa.getMapa().getCasillero(posicionFinal);
		Bombita bombitaPosicionFinal = (Bombita) casilleroFinal.getObjetos().get(0);
		
		assertEquals(bombitaPosicionInicial, bombitaPosicionFinal);
		
	}
	
	@Test
	public void testCrearCasillerosVacios(){
		new Juego();
		Mapa.getMapa().crearCasillerosVacios(3);
	
		for (int x = 1; x <= 3; x++){
			Posicion pos = new Posicion (x,1);
			assertEquals(Mapa.getMapa().getCasillero(pos).getObjetos().size(), 0);
		}
	
		for (int x = 1; x <= 3; x++){
			Posicion pos = new Posicion (x,2);
			assertEquals(Mapa.getMapa().getCasillero(pos).getObjetos().size(), 0);
		}
		
		for (int x = 1; x <= 3; x++){
			Posicion pos = new Posicion (x,3);
			assertEquals(Mapa.getMapa().getCasillero(pos).getObjetos().size(), 0);
		}
		
	}
	
	@Test
	public void testCrearObjetosEnElMapa() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String[] codigos = {"1", "2", "-1", "-2", "-3", "0", "21", "31", "34", "22"};
        Method crearObjetosEnElMapa = Mapa.getMapa().getClass().getDeclaredMethod("crearObjetosEnElMapa", new Class[]{String[].class, Integer.class});
        crearObjetosEnElMapa.setAccessible(true);
        Mapa.getMapa().crearCasillerosVacios(10);
      
        crearObjetosEnElMapa.invoke(Mapa.getMapa(), new Object[]{codigos, 1});
        
        Casillero casillero = Mapa.getMapa().getCasillero(new Posicion(1,1));
        assertTrue(casillero.getObjetos().size() == 1);
        assertTrue(casillero.getObjetos().get(0) instanceof Bombita);
        
        casillero = Mapa.getMapa().getCasillero(new Posicion(2,1));
        assertTrue(casillero.getObjetos().size() == 1);
        assertTrue(casillero.getObjetos().get(0) instanceof BloqueLadrillo);
        
        casillero = Mapa.getMapa().getCasillero(new Posicion(3,1));
        assertTrue(casillero.getObjetos().size() == 1);
        assertTrue(casillero.getObjetos().get(0) instanceof Cecilio);
        
        casillero = Mapa.getMapa().getCasillero(new Posicion(4,1));
        assertTrue(casillero.getObjetos().size() == 1);
        assertTrue(casillero.getObjetos().get(0) instanceof LopezReggae);
        
        casillero = Mapa.getMapa().getCasillero(new Posicion(5,1));
        assertTrue(casillero.getObjetos().size() == 1);
        assertTrue(casillero.getObjetos().get(0) instanceof LopezReggaeAlado);
        
        casillero = Mapa.getMapa().getCasillero(new Posicion(6,1));
        assertTrue(casillero.getObjetos().size() == 0);
        
        casillero = Mapa.getMapa().getCasillero(new Posicion(7,1));
        assertTrue(casillero.getObjetos().size() == 1);
        assertTrue(casillero.getObjetos().get(0) instanceof BloqueLadrillo);
        BloqueLadrillo bl = (BloqueLadrillo) casillero.getObjetos().get(0);
        assertTrue(bl.getObjeto() instanceof ArticuloChala);
        
        casillero = Mapa.getMapa().getCasillero(new Posicion(8,1));
        assertTrue(casillero.getObjetos().size() == 1);
        assertTrue(casillero.getObjetos().get(0) instanceof BloqueCemento);
        BloqueCemento bc = (BloqueCemento) casillero.getObjetos().get(0);
        assertTrue(bc.getObjeto() instanceof ArticuloChala);
        
        casillero = Mapa.getMapa().getCasillero(new Posicion(9,1));
        assertTrue(casillero.getObjetos().size() == 1);
        assertTrue(casillero.getObjetos().get(0) instanceof BloqueCemento);
        bc = (BloqueCemento) casillero.getObjetos().get(0);
        assertTrue(bc.getObjeto() instanceof Salida);
        
        casillero = Mapa.getMapa().getCasillero(new Posicion(10,1));
        assertTrue(casillero.getObjetos().size() == 1);
        assertTrue(casillero.getObjetos().get(0) instanceof BloqueLadrillo);
        bl = (BloqueLadrillo) casillero.getObjetos().get(0);
        assertTrue(bl.getObjeto() instanceof ArticuloTimer);
      
	}

	@Test
	public void testCrearMapa() {
		
	}
	
}
