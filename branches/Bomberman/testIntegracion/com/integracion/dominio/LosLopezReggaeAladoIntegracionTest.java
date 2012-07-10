package com.integracion.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bombitarodriguez.dominio.BloqueAcero;
import com.bombitarodriguez.dominio.Casillero;
import com.bombitarodriguez.dominio.LopezReggaeAlado;
import com.bombitarodriguez.dominio.Mapa;
import com.bombitarodriguez.dominio.Posicion;
import com.bombitarodriguez.utils.Direccion;

public class LosLopezReggaeAladoIntegracionTest {

	Posicion posicionInicial; 	
	Casillero casilleroInicial;
	LopezReggaeAlado lopezReggaeAlado;
	
	@Before
	public void setUp(){
		posicionInicial = new Posicion(1, 1);
		casilleroInicial = new Casillero(posicionInicial);
		lopezReggaeAlado = new LopezReggaeAlado();
		casilleroInicial.agregarObjeto(lopezReggaeAlado);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
	}	
	
	@Test
	public void testMoverArriba_CasilleroVacio() {
		Posicion posicionFinal = new Posicion(1,2);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		
		lopezReggaeAlado.moverseConEstrategia(Direccion.ARRIBA);
		assertEquals(lopezReggaeAlado.getPosicion(), posicionFinal);	
	}
	
	@Test
	public void testMover_CasilleroBloqueAcero(){
		Posicion posicionMedio = new Posicion(1,2);
		Posicion posicionDondeCae = new Posicion (1,3);
		Casillero casilleroMedio = new Casillero(posicionMedio);
		Casillero casilleroDondeCae = new Casillero (posicionDondeCae);
		
		casilleroMedio.agregarObjeto(new BloqueAcero());
		
		Mapa.getMapa().agregarCasillero(posicionMedio, casilleroMedio);
		Mapa.getMapa().agregarCasillero(posicionDondeCae, casilleroDondeCae);
		
		lopezReggaeAlado.moverseConEstrategia(Direccion.ARRIBA);
		assertEquals(lopezReggaeAlado.getPosicion(), posicionDondeCae);
		}
	
	@Test
	public void testMover_VariosBloquesDeAcero(){
		Posicion posicionIntermedia1 = new Posicion(1,2);
		Posicion posicionIntermedia2= new Posicion(1,3);
		Posicion posicionIntermedia3 = new Posicion(1,4);
		Posicion posicionDondeCae = new Posicion(1,5);
		Casillero casilleroIntermedio1 =new Casillero (posicionIntermedia1);
		Casillero casilleroIntermedio2 =new Casillero (posicionIntermedia1);
		Casillero casilleroIntermedio3 =new Casillero (posicionIntermedia1);
		Casillero DondeCae = new Casillero (posicionDondeCae);
		
		BloqueAcero bloque = new BloqueAcero();
		casilleroIntermedio1.agregarObjeto(bloque);
		casilleroIntermedio2.agregarObjeto(bloque);
		casilleroIntermedio3.agregarObjeto(bloque);
		Mapa.getMapa().agregarCasillero(posicionIntermedia1, casilleroIntermedio1);
		Mapa.getMapa().agregarCasillero(posicionIntermedia2, casilleroIntermedio2);
		Mapa.getMapa().agregarCasillero(posicionIntermedia3, casilleroIntermedio3);
		
		Mapa.getMapa().agregarCasillero(posicionDondeCae, DondeCae);
		
		lopezReggaeAlado.moverseConEstrategia(Direccion.ARRIBA);
		assertEquals(lopezReggaeAlado.getPosicion(), posicionDondeCae);
		}
}
