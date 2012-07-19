package com.test.persistencia;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import com.bombitarodriguez.dominio.BloqueAcero;
import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.dominio.Casillero;
import com.bombitarodriguez.dominio.Mapa;
import com.bombitarodriguez.dominio.Posicion;
import com.bombitarodriguez.excepciones.ArchivoSaveNoEncontrado;
import com.bombitarodriguez.persistencia.PersistenciaPartidaXML;

public class PersistenciaTest {
	
	Posicion posicionInicial;
	Posicion posicionFinal;
	Casillero casilleroInicial;
	Casillero casilleroFinal;
	Bombita bombita;
	Integer vida;

	@Before
	public void setUp() throws Exception {
		Mapa.getMapa().getMapaCasillero().clear();
		vida = new Integer(1);		
		posicionInicial = new Posicion(1, 1);
		posicionFinal = new Posicion(1, 2);
		casilleroInicial = new Casillero(posicionInicial);
		casilleroFinal = new Casillero(posicionFinal);
		bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new BloqueAcero());
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
	}
	
	@Test
	public void testPersistencia_1() throws ArchivoSaveNoEncontrado {
		PersistenciaPartidaXML persistencia = new PersistenciaPartidaXML("persistencia-test.xml");
		persistencia.persistirPartida();
		Mapa.setMapa(persistencia.cargarDominioDeXML());
		bombita = (Bombita) Mapa.getMapa().getCasillero(new Posicion(1, 1)).getObjetos().get(0);
		
		assertTrue(Mapa.getMapa().getMapaCasillero().size() == 2);
		assertTrue(bombita.getVida() == 1);
		
	}
	
	@Test
	/**
	 * Se cambia el estado a bombita y se lo recupera con este ultimo.
	 */
	public void testPersistencia_2() throws ArchivoSaveNoEncontrado {
		PersistenciaPartidaXML persistencia = new PersistenciaPartidaXML("persistencia-test.xml");
		Bombita bombita = (Bombita) Mapa.getMapa().getCasillero(new Posicion(1, 1)).getObjetos().get(0);
		bombita.setVida(8);
		persistencia.persistirPartida();
		Mapa.setMapa(persistencia.cargarDominioDeXML());
		
		bombita = (Bombita) Mapa.getMapa().getCasillero(new Posicion(1, 1)).getObjetos().get(0);
		
		assertTrue(Mapa.getMapa().getMapaCasillero().size() == 2);
		assertTrue(bombita.getVida() == 8);
		
	}

}
