package com.integracion.dominio;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.bombitarodriguez.dominio.*;
import com.bombitarodriguez.utils.*;

public class BombitaIntegracionTest {

	Posicion posicionInicial;
	Posicion posicionFinal;
	Casillero casilleroInicial;
	Casillero casilleroFinal;
	Bombita bombita;
	Integer vida;

	@Before
	public void setUp() {
		vida = new Integer(1);
		posicionInicial = new Posicion(1, 1);
		posicionFinal = new Posicion(1, 2);
		casilleroInicial = new Casillero(posicionInicial);
		casilleroFinal = new Casillero(posicionFinal);
		bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
	}

	
	/**
	 * Se testea que bombita pueda moverse a un casillero vacio
	 */
	@Test
	public void testMoverCaso1() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(1,2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);
		
		casilleroInicial.agregarObjeto(bombita);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		
		bombita.moverseConEstrategia(Direccion.ARRIBA);
		
		assertEquals(bombita.getPosicion(), posicionFinal);
		assertTrue(casilleroInicial.getObjetos().isEmpty());
	}

	/**
	 * Se testea que bombita pueda no moverse a un casillero ocupado 
	 * por un bloque de acero
	 */
	@Test
	public void testMoverCaso2() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(1,2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);
		
		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new BloqueAcero());
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		
		bombita.moverseConEstrategia(Direccion.ARRIBA);
		
		assertEquals(bombita.getPosicion(), posicionInicial);
	}
	
	/**
	 * Se testea que bombita pueda no moverse a un casillero ocupado 
	 * por un bloque de Ladrillos
	 */
	@Test
	public void testMoverCaso3() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(1,2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);
		
		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new BloqueLadrillo());
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		
		bombita.moverseConEstrategia(Direccion.ARRIBA);
		
		assertEquals(bombita.getPosicion(), posicionInicial);
	}
	
	/**
	 * Se testea que bombita pueda no moverse a un casillero ocupado 
	 * por un bloque de Cemento
	 */
	@Test
	public void testMoverCaso4() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(1,2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);
		
		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new BloqueCemento());
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		
		bombita.moverseConEstrategia(Direccion.ARRIBA);
		
		assertEquals(bombita.getPosicion(), posicionInicial);
	}

	/**
	 * Se testea que bombita pueda moverse a un casillero ocupado 
	 * por una bomba Molotov
	 */
	@Test
	public void testMoverCaso5() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(1,2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);
		
		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new Molotov());
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		
		bombita.moverseConEstrategia(Direccion.ARRIBA);
		
		assertEquals(bombita.getPosicion(), posicionFinal);
		assertTrue(casilleroInicial.getObjetos().isEmpty());
	}
	
	/**
	 * Se testea que bombita pueda moverse a un casillero ocupado 
	 * por una bomba ToleTole
	 */
	@Test
	public void testMoverCaso6() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(1,2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);
		
		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new ToleTole());
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		
		bombita.moverseConEstrategia(Direccion.ARRIBA);
		
		assertEquals(bombita.getPosicion(), posicionFinal);
		assertTrue(casilleroInicial.getObjetos().isEmpty());
	}
	
	/**
	 * Se testea que bombita no pueda moverse a un casillero ocupado 
	 * por una proyectil. Este caso es poco probable que suceda, 
	 * pero en caso de que pase, bombita no podra morverse, y el
	 * proyectil se detonara
	 */
	@Test
	public void testMoverCaso7() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1,1);
		Posicion posicionFinal = new Posicion(1,2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);
		
		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new Proyectil());
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		
		bombita.moverseConEstrategia(Direccion.ARRIBA);
		
		assertTrue(casilleroInicial.getObjetos().isEmpty());
		assertTrue(casilleroFinal.getObjetos().isEmpty());
	}
	@Test
	public void testMover_CasilleroBombaMolotov() {
		casilleroFinal.agregarObjeto(new Molotov(new Double(1)));
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		bombita.moverseConEstrategia(Direccion.ARRIBA);
		assertEquals(bombita.getPosicion(), posicionFinal);
	}

	@Test
	public void testMover_CasilleroCecilio() {
		casilleroFinal.agregarObjeto(new Cecilio());
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		bombita.moverseConEstrategia(Direccion.ARRIBA);
		assertEquals(bombita.getVida(), new Integer(0));

	}

	@Test
	public void testPorDefaultColocaMolotov() {
		bombita.usarArma();
		assertTrue(bombita.getCasillero().getObjetos().get(1) instanceof Molotov);
	}

	@Test
	public void testAtributoChala() {
		casilleroFinal.agregarObjeto(new Chala());
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		bombita.moverseConEstrategia(Direccion.ARRIBA);

		assertEquals(bombita.getVelocidad(), new Integer(2));
	}

	@Test
	public void testRecogerArticuloToleTole() {
		casilleroFinal.agregarObjeto(new ArticuloToleTole());
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.ARRIBA);

		FactoryArma arma = bombita.getFactoryArma();

		assertTrue(arma.getArmaInstanciada() instanceof ToleTole);
	}

	@Test
	public void testBombitaColocaBombaYSeMueve() {

		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		bombita.usarArma();
		bombita.moverseConEstrategia(Direccion.ARRIBA);
		Integer cantidadDeObjetos = casilleroInicial.getObjetos().size();
		assertEquals(cantidadDeObjetos, new Integer(1));

	}

	@Test
	public void testEnemigoEstaFueraDelAlcanceYNoPierdeResistencia() {
		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
		Juego juego = new Juego();
		Mapa.getMapa().crearCasillerosVacios(10);

		Posicion posicionInicial = new Posicion(5, 5);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);

		Posicion posicionEnemigo = new Posicion(1, 1);
		Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
		Cecilio ceci = new Cecilio();
		casilleroEnemigo.agregarObjeto(ceci);

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);

		bombita.usarArma();
		Arma arma = (Molotov) bombita.getCasillero().getObjetos().get(1);
		arma.explotar();
		ceci = (Cecilio) Mapa.getMapa().getCasillero(posicionEnemigo)
				.getObjetos().get(0);
		assertEquals(ceci.getResistencia(), new Integer(5));
		// assertTrue(bombita.getCasillero().getObjetos().get(1) instanceof
		// null);

	}

	@Test
	public void testEnemigoEstaEnElAlcanceYSIPierdeResistencia() {
		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
		Juego juego = new Juego();
		Mapa.getMapa().crearCasillerosVacios(10);

		Posicion posicionInicial = new Posicion(5, 5);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);

		Posicion posicionEnemigo = new Posicion(5, 4);
		Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
		Cecilio ceci = new Cecilio();
		casilleroEnemigo.agregarObjeto(ceci);

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);

		bombita.usarArma();
		Arma arma = (Molotov) bombita.getCasillero().getObjetos().get(1);
		arma.explotar();

		Integer tamaño = Mapa.getMapa().getCasillero(posicionEnemigo)
				.getObjetos().size();
		assertEquals(tamaño, new Integer(0));

	}

	@Test
	public void testEnemigoEstaEnElAlcancePeroLoCubreUnBloqueAcero() {
		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
		Juego juego = new Juego();
		Mapa.getMapa().crearCasillerosVacios(10);

		Posicion posicionInicial = new Posicion(5, 5);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);

		Posicion posicionEnemigo = new Posicion(5, 3);
		Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
		Cecilio ceci = new Cecilio();
		casilleroEnemigo.agregarObjeto(ceci);

		Posicion posicionBloque = new Posicion(5, 4);
		Casillero casilleroBloque = new Casillero(posicionBloque);
		BloqueAcero bloque = new BloqueAcero();
		casilleroBloque.agregarObjeto(bloque);

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);
		Mapa.getMapa().agregarCasillero(posicionBloque, casilleroBloque);
		bombita.usarArma();

		Arma arma = (Molotov) bombita.getCasillero().getObjetos().get(1);

		arma.explotar();
		ceci = (Cecilio) Mapa.getMapa().getCasillero(posicionEnemigo).getObjetos().get(0);
		assertEquals(ceci.getResistencia(), new Integer(5));

	}

	@Test
	/**
	 * 
	 */
	public void BombitaMataADosEnemigosUnoDetrasDelOtroConMolotov() {

		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
		Juego juego = new Juego();
		Mapa.getMapa().crearCasillerosVacios(10);

		Posicion posicionInicial = new Posicion(10, 10);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);

		Posicion posicionEnemigo = new Posicion(10, 9);
		Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
		Cecilio ceci = new Cecilio();
		casilleroEnemigo.agregarObjeto(ceci);

		Posicion posicionEnemigo2 = new Posicion(10, 8);
		Casillero casilleroEnemigo2 = new Casillero(posicionEnemigo);
		Cecilio ceci2 = new Cecilio();
		casilleroEnemigo.agregarObjeto(ceci2);

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);
		Mapa.getMapa().agregarCasillero(posicionEnemigo2, casilleroEnemigo2);
		bombita.usarArma();

		Arma arma = (Molotov) bombita.getCasillero().getObjetos().get(1);

		arma.explotar();

		Integer tamaño = Mapa.getMapa().getCasillero(posicionEnemigo)
				.getObjetos().size();
		assertEquals(tamaño, new Integer(0));

		Integer tamaño2 = Mapa.getMapa().getCasillero(posicionEnemigo2)
				.getObjetos().size();
		assertEquals(tamaño2, new Integer(0));

	}

	@Test
	public void BombitaMataADosEnemigosEnDiferentesDireccionesYDostanciasConMolotov() {

		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
		Juego juego = new Juego();
		Mapa.getMapa().crearCasillerosVacios(10);

		Posicion posicionInicial = new Posicion(10, 10);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);

		Posicion posicionEnemigo = new Posicion(11, 10);
		Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
		Cecilio ceci = new Cecilio();
		casilleroEnemigo.agregarObjeto(ceci);

		Posicion posicionEnemigo2 = new Posicion(10, 8);
		Casillero casilleroEnemigo2 = new Casillero(posicionEnemigo);
		Cecilio ceci2 = new Cecilio();
		casilleroEnemigo.agregarObjeto(ceci2);

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);
		Mapa.getMapa().agregarCasillero(posicionEnemigo2, casilleroEnemigo2);
		bombita.usarArma();

		Arma arma = (Molotov) bombita.getCasillero().getObjetos().get(1);

		arma.explotar();

		Integer tamaño = Mapa.getMapa().getCasillero(posicionEnemigo)
				.getObjetos().size();
		assertEquals(tamaño, new Integer(0));

		Integer tamaño2 = Mapa.getMapa().getCasillero(posicionEnemigo2)
				.getObjetos().size();
		assertEquals(tamaño2, new Integer(0));

	}

	@Test
	public void BombitaMataACecilioYLopezPierdeVida() {

		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
		Juego juego = new Juego();
		Mapa.getMapa().crearCasillerosVacios(10);

		Posicion posicionInicial = new Posicion(10, 10);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);

		Posicion posicionEnemigo = new Posicion(11, 10);
		Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
		LosLopezReggae lopez = new LosLopezReggae();
		casilleroEnemigo.agregarObjeto(lopez);

		Posicion posicionEnemigo2 = new Posicion(10, 8);
		Casillero casilleroEnemigo2 = new Casillero(posicionEnemigo);
		Cecilio lopez2 = new Cecilio();
		casilleroEnemigo.agregarObjeto(lopez2);

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);
		Mapa.getMapa().agregarCasillero(posicionEnemigo2, casilleroEnemigo2);
		bombita.usarArma();

		Arma arma = (Molotov) bombita.getCasillero().getObjetos().get(1);

		arma.explotar();

		LosLopezReggae enemigo = (LosLopezReggae) Mapa.getMapa()
				.getCasillero(posicionEnemigo).getObjetos().get(0);
		Integer tamaño = Mapa.getMapa().getCasillero(posicionEnemigo)
				.getObjetos().size();
		assertEquals(tamaño, new Integer(1));
		assertEquals(enemigo.getResistencia(), new Integer(5));

		Integer tamaño2 = Mapa.getMapa().getCasillero(posicionEnemigo2)
				.getObjetos().size();
		assertEquals(tamaño2, new Integer(0));

	}

	@Test
	public void BombitaRompeUnLadrilloYQuedaAtributoToletoleEnElPiso() {

		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
		Juego juego = new Juego();
		Mapa.getMapa().crearCasillerosVacios(10);

		Posicion posicionInicial = new Posicion(7, 4);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);

		Posicion posicionBloque = new Posicion(5, 4);
		Casillero casilleroBloque = new Casillero(posicionBloque);
		BloqueLadrillo bloque = new BloqueLadrillo();
		ArticuloToleTole articulo = new ArticuloToleTole();
		bloque.setObjeto(articulo);
		casilleroBloque.agregarObjeto(bloque);

		Mapa.getMapa().agregarCasillero(posicionBloque, casilleroBloque);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);

		bombita.usarArma();
		assertTrue(Mapa.getMapa().getCasillero(posicionBloque).getObjetos()
				.get(0) instanceof BloqueLadrillo);
	}

}
