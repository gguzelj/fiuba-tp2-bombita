package com.test.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;

public class ExplosionTest {
	
	@Test
	public void testReaccionarConTodos(){
		
		Posicion posicion = new Posicion(1,1);
		Casillero casillero = new Casillero(posicion);
		Explosion explosion = new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV);
		
		//En este caso, la onda destruccion de la explosion es mayor a la resistencia del bloque,
		//y deberia devolver true
		casillero.agregarObjeto(new BloqueLadrillo());
		assertTrue(explosion.reaccionarConTodos(casillero));

		//En este caso, la onda destruccion de la explosion es menor a la resistencia del bloque,
		//y deberia devolver false
		casillero.agregarObjeto(new BloqueAcero());
		assertFalse(explosion.reaccionarConTodos(casillero));
			
	}
	
	@Test
	public void testRecorrerCasilleros(){
		
		Casillero primerCasillero = new Casillero(new Posicion(1,1));
		Casillero segundoCasillero = new Casillero(new Posicion(1,2));
		Casillero tercerCasillero = new Casillero(new Posicion(1,3));
		Casillero cuartoCasillero = new Casillero(new Posicion(1,4));
		Casillero quintoCasillero = new Casillero(new Posicion(1,5));
		Explosion explosion = new Explosion(Constante.DESTRUCCION_MOLOTOV, Constante.ONDA_EXPANSIVA_MOLOTOV);
		
		primerCasillero.agregarObjeto(explosion);
		segundoCasillero.agregarObjeto(new BloqueLadrillo());
		tercerCasillero.agregarObjeto(new BloqueLadrillo());
		cuartoCasillero.agregarObjeto(new BloqueLadrillo());
		quintoCasillero.agregarObjeto(new BloqueLadrillo());
		
		Mapa.getMapa().agregarCasillero(new Posicion(1,1), primerCasillero);
		Mapa.getMapa().agregarCasillero(new Posicion(1,2), segundoCasillero);
		Mapa.getMapa().agregarCasillero(new Posicion(1,3), tercerCasillero);
		Mapa.getMapa().agregarCasillero(new Posicion(1,4), cuartoCasillero);
		Mapa.getMapa().agregarCasillero(new Posicion(1,5), quintoCasillero);
		
		//La explosion deberia reaccionar con todos los objetos de todos los casilleros(hasta el cuarto)
		explosion.recorrerCasilleros(Constante.ONDA_EXPANSIVA_MOLOTOV, Direccion.ARRIBA);
	
		assertTrue(segundoCasillero.getObjetos().size() == 0);
		assertTrue(tercerCasillero.getObjetos().size() == 0);
		assertTrue(cuartoCasillero.getObjetos().size() == 0);
		assertTrue(quintoCasillero.getObjetos().size() == 1);
	}
}