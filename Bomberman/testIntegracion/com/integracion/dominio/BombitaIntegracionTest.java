package com.integracion.dominio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.uba.fi.algo3.titiritero.Direccion;

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
	 * Se testea que Bombita pueda moverse para arriba En la prueba, el
	 * casillero final no contiene ningun objeto
	 */
	@Test
	public void testMoverArriba() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 2);
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
	 * Se testea que Bombita pueda moverse para abajo En la prueba, el casillero
	 * final no contiene ningun objeto
	 */
	@Test
	public void testMoverAbajo() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 0);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);

		casilleroInicial.agregarObjeto(bombita);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.ABAJO);

		assertEquals(bombita.getPosicion(), posicionFinal);
		assertTrue(casilleroInicial.getObjetos().isEmpty());
	}

	/**
	 * Se testea que Bombita pueda moverse a la Izquierda En la prueba, el
	 * casillero final no contiene ningun objeto
	 */
	@Test
	public void testMoverIzquierda() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(0, 1);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);

		casilleroInicial.agregarObjeto(bombita);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.IZQUIERDA);

		assertEquals(bombita.getPosicion(), posicionFinal);
		assertTrue(casilleroInicial.getObjetos().isEmpty());
	}

	/**
	 * Se testea que Bombita pueda moverse a la Derecha En la prueba, el
	 * casillero final no contiene ningun objeto
	 */
	@Test
	public void testMoverDerecha() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(2, 1);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);

		casilleroInicial.agregarObjeto(bombita);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.DERECHA);

		assertEquals(bombita.getPosicion(), posicionFinal);
		assertTrue(casilleroInicial.getObjetos().isEmpty());
	}

	/**
	 * Se testea que bombita la interaccion entre bombita y un bloqueAcero En
	 * este caso, bombita no deberia poder cambiar de casillero
	 */
	@Test
	public void testInteraccionCaso1() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 2);
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
	 * Se testea que bombita pueda no moverse a un casillero ocupado por un
	 * bloque de Ladrillos
	 */
	@Test
	public void testInteraccionCaso2() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 2);
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
	 * Se testea que bombita pueda no moverse a un casillero ocupado por un
	 * bloque de Cemento
	 */
	@Test
	public void testInteraccionCaso3() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 2);
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
	 * Se testea que bombita pueda moverse a un casillero ocupado por una bomba
	 * Molotov
	 */
	@Test
	public void testInteraccionCaso4() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);

		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new Molotov());
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.ARRIBA);

		assertEquals(bombita.getPosicion(), posicionInicial);
		assertFalse(casilleroInicial.getObjetos().isEmpty());
	}

	/**
	 * Se testea que bombita pueda moverse a un casillero ocupado por una bomba
	 * ToleTole
	 */
	@Test
	public void testInteraccionCaso5() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);

		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new ToleTole());
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.ARRIBA);

		assertEquals(bombita.getPosicion(), posicionInicial);
		assertFalse(casilleroInicial.getObjetos().isEmpty());
	}

	/**
	 * Se testea que bombita no pueda moverse a un casillero ocupado por una
	 * proyectil. Este caso es poco probable que suceda, pero en caso de que
	 * pase, bombita no podra morverse, y el proyectil se detonara
	 */
	@Test
	public void testInteraccionCaso6() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);

		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new Proyectil(Direccion.ARRIBA, new Posicion(1,1)));
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.ARRIBA);

		assertTrue(bombita.getVida() == 2);
		assertFalse(casilleroFinal.getObjetos().isEmpty());
	}

	/**
	 * Se testea que Bombita pueda moverse a un casillero ocupado por un
	 * Cecilio, y al hacerlo, pierda una vida
	 */
	@Test
	public void testInteraccionCaso7() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);

		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new Cecilio());

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.ARRIBA);

		assertTrue(bombita.getVida() == 2);
		assertEquals(bombita.getPosicion(), posicionFinal);
	}

	/**
	 * Se testea que Bombita pueda moverse a un casillero ocupado por un
	 * LopezReggae, y al hacerlo, pierda una vida
	 */
	@Test
	public void testInteraccionCaso8() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);

		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new LopezReggae());

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.ARRIBA);

		assertTrue(bombita.getVida() == 2);
		assertEquals(bombita.getPosicion(), posicionFinal);
	}

	/**
	 * Se testea que Bombita pueda moverse a un casillero ocupado por un
	 * LopezReggaeAlado, y al hacerlo, pierda una vida
	 */
	@Test
	public void testInteraccionCaso9() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);

		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new LopezReggaeAlado());

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.ARRIBA);

		assertTrue(bombita.getVida() == 2);
		assertEquals(bombita.getPosicion(), posicionFinal);
	}

	/**
	 * Se testea que Bombita pueda moverse a un casillero ocupado por una
	 * explosion, y al hacerlo, pierda una vida
	 */
	@Test
	public void testInteraccionCaso10() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);

		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal
				.agregarObjeto(new Explosion(Constante.DESTRUCCION_MOLOTOV,
						Constante.ONDA_EXPANSIVA_MOLOTOV));

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.ARRIBA);

		assertTrue(bombita.getVida() == 2);
	}

	/**
	 * Se testea que Bombita pueda moverse a un casillero ocupado por una Chala,
	 * y al hacerlo, modifique su velocidad
	 */
	@Test
	public void testInteraccionCaso11() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);

		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new ArticuloChala());

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.ARRIBA);

		assertTrue(bombita.getVelocidad() == Constante.VELOCIDAD_CORRE);
		assertEquals(bombita.getPosicion(), posicionFinal);
	}

	/**
	 * Se testea que Bombita pueda moverse a un casillero ocupado por un Timer,
	 * y al hacerlo, modifique su velocidad
	 */
	@Test
	public void testInteraccionCaso12() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);

		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new ArticuloTimer());

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.ARRIBA);

		assertTrue(bombita.getFactoryArma().getRetardo() == (Constante.TIMER_MOLOTOV * 0.85));
		assertEquals(bombita.getPosicion(), posicionFinal);
	}

	/**
	 * Se testea que Bombita pueda moverse a un casillero ocupado por un
	 * ArticuloToleTole, y al hacerlo, cambie su factory de armas
	 */
	@Test
	public void testInteraccionCaso13() {
		Integer vida = new Integer(3);
		Posicion posicionInicial = new Posicion(1, 1);
		Posicion posicionFinal = new Posicion(1, 2);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Bombita bombita = new Bombita(vida);

		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new ArticuloToleTole());

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.ARRIBA);

		assertTrue(bombita.getFactoryArma().getArmaInstanciada() instanceof ToleTole);
		assertEquals(bombita.getPosicion(), posicionFinal);
	}

	@Test
	public void testPorDefaultColocaMolotov() {
		bombita.usarArma();
		assertTrue(bombita.getCasillero().getObjetos().get(1) instanceof Molotov);
	}

	@Test
	public void testAtributoChala() {
		casilleroFinal.agregarObjeto(new ArticuloChala());
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		bombita.moverseConEstrategia(Direccion.ARRIBA);

		assertEquals(bombita.getVelocidad(), new Integer(2));
	}

	@Test
	public void testMoverHastaUnCecilio() {
		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
		Posicion posicionInicial = new Posicion(1, 1);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);

		// Creo al enemigo y lo agrego al casillero de arriba del que est�
		// bombita
		Posicion posicionFinal = new Posicion(1, 2);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		Cecilio ceci = new Cecilio();
		casilleroFinal.agregarObjeto(ceci);

		// Agrego ambos Casilleros
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);

		bombita.moverseConEstrategia(Direccion.ARRIBA);
		assertEquals(bombita.getVida(), new Integer(3));

	}

	@Test
	public void testMoverHastaUnLopezReggae() {
		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
		Posicion posicionInicial = new Posicion(1, 1);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);

		// Creo al enemigo y lo agrego al casillero de arriba del que est�
		// bombita
		Posicion posicionFinal = new Posicion(1, 2);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		LopezReggae lope = new LopezReggae();
		casilleroFinal.agregarObjeto(lope);

		// Agrego ambos Casilleros
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);

		bombita.moverseConEstrategia(Direccion.ARRIBA);
		assertEquals(bombita.getVida(), new Integer(3));

	}

	@Test
	public void testMoverHastaUnLopezReggaeAlado() {
		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
		Posicion posicionInicial = new Posicion(1, 1);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);

		// Creo al enemigo y lo agrego al casillero de arriba del que est�
		// bombita
		Posicion posicionFinal = new Posicion(1, 2);
		Casillero casilleroFinal = new Casillero(posicionFinal);
		LopezReggaeAlado lopeAlado = new LopezReggaeAlado();
		casilleroFinal.agregarObjeto(lopeAlado);

		// Agrego ambos Casilleros
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);

		bombita.moverseConEstrategia(Direccion.ARRIBA);
		assertEquals(bombita.getVida(), new Integer(3));

	}

	@Test
	public void testRecogerArticuloToleTole() {
		casilleroFinal.agregarObjeto(new ArticuloToleTole());
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		bombita.moverseConEstrategia(Direccion.ARRIBA);

		FactoryArma arma = bombita.getFactoryArma();

		assertTrue(arma.getArmaInstanciada() instanceof ToleTole);
	}

	/**
	 * Bombita planta bomba y se mueve
	 */

	@Test
	public void testBombitaPlantarBombaCaso1() {

		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);
		bombita.usarArma();
		bombita.moverseConEstrategia(Direccion.ARRIBA);
		Integer cantidadDeObjetos = casilleroInicial.getObjetos().size();
		assertEquals(cantidadDeObjetos, new Integer(1));

	}

	/**
	 * Bombita planta Molotov pero no afecta a Cecilio dada su lejania.
	 */

	@Test
	public void testBombitaPlantarBombaCaso2() {
		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
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

	}

	/**
	 * Bombita planta Molotov, y el enemigo pierde vida.
	 */
	@Test
	public void testBombitaPlantarBombaCaso3() {
		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
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

		Arma arma = bombita.usarArma();
		arma.explotar();

		// El unico objeto en el casillero es la explosion
		Integer tamanio = Mapa.getMapa().getCasillero(posicionEnemigo)
				.getObjetos().size();
		assertEquals(tamanio, new Integer(1));

	}

	/**
	 * Bombita planta Molotov. Cecilio no muere porque entre el y la bomba hay
	 * un BloqueAcero
	 */

	@Test
	public void testBombitaPlantarBombaCaso4() {
		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
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

		Arma arma = bombita.usarArma();

		arma.explotar();
		ceci = (Cecilio) Mapa.getMapa().getCasillero(posicionEnemigo)
				.getObjetos().get(0);
		assertEquals(ceci.getResistencia(), new Integer(5));

	}

	@Test
	/**
	 * Bombita planta molotov y con eso mata a dos enemigos alineados
	 */
	public void testBombitaPlantarBombaCaso5() {

		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
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

		Arma arma = bombita.usarArma();

		arma.explotar();

		// El unico objeto en el casillero es la explosion
		Integer tamanio = Mapa.getMapa().getCasillero(posicionEnemigo)
				.getObjetos().size();
		assertEquals(tamanio, new Integer(1));

		Integer tamanio2 = Mapa.getMapa().getCasillero(posicionEnemigo2)
				.getObjetos().size();
		assertEquals(tamanio2, new Integer(0));

	}

	/**
	 * Bombita mata a dos enemigos que estan situados a distancia y direcciones
	 * distintas.
	 */
	@Test
	public void testBombitaPlantarBombaCaso6() {

		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
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

		Arma arma = bombita.usarArma();
		arma.explotar();

		Integer tamanio = Mapa.getMapa().getCasillero(posicionEnemigo)
				.getObjetos().size();
		assertEquals(tamanio, new Integer(1));

		Integer tamanio2 = Mapa.getMapa().getCasillero(posicionEnemigo2)
				.getObjetos().size();
		assertEquals(tamanio2, new Integer(0));

	}

	/**
	 * Bombita planta bomba Molotov. Mata a un cecilio y le saca vida a un
	 * LopezReggae
	 */
	@Test
	public void testBombitaPlantarBombaCaso7() {

		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
		Mapa.getMapa().crearCasillerosVacios(10);

		Posicion posicionInicial = new Posicion(10, 10);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);

		Posicion posicionEnemigo = new Posicion(11, 10);
		Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
		LopezReggae lopez = new LopezReggae();
		casilleroEnemigo.agregarObjeto(lopez);

		Posicion posicionEnemigo2 = new Posicion(10, 8);
		Casillero casilleroEnemigo2 = new Casillero(posicionEnemigo);
		Cecilio lopez2 = new Cecilio();
		casilleroEnemigo.agregarObjeto(lopez2);

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);
		Mapa.getMapa().agregarCasillero(posicionEnemigo2, casilleroEnemigo2);

		Arma arma = bombita.usarArma();

		arma.explotar();

		LopezReggae enemigo = (LopezReggae) Mapa.getMapa()
				.getCasillero(posicionEnemigo).getObjetos().get(0);
		Integer tamanio = Mapa.getMapa().getCasillero(posicionEnemigo)
				.getObjetos().size();

		assertEquals(tamanio, new Integer(2));
		assertEquals(enemigo.getResistencia(), new Integer(5));

		Integer tamanio2 = Mapa.getMapa().getCasillero(posicionEnemigo2)
				.getObjetos().size();
		assertEquals(tamanio2, new Integer(0));

	}

	/**
	 * Bombita planta la bomba Molotov, rompo un ladrillo y el atributo queda en
	 * el piso
	 */
	@Test
	public void testBombitaPlantarBombaCaso8() {

		Integer vida = new Integer(4);
		// Creo a Bombita y lo agrego a un casillero
		new Juego();
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

	/**
	 * BOMBITA Planta la bomba, se mueve un casillero y muere por la
	 * explosion.
	 */
	@Test
	public void testBombitaPlantarBombaCaso9() {

		Integer vida = new Integer(5);
		// Creo a Bombita y lo agrego a un casillero

		Mapa.getMapa().crearCasillerosVacios(20);

		Posicion posicionFinal = new Posicion(6, 4);
		Posicion posicionInicial = new Posicion(7, 4);
		Casillero casilleroInicial = new Casillero(posicionInicial);
		Bombita bombita = new Bombita(vida);
		casilleroInicial.agregarObjeto(bombita);
		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);

		Arma arma = bombita.usarArma();
		bombita.moverseConEstrategia(Direccion.IZQUIERDA);

		assertTrue(Mapa.getMapa().getCasillero(posicionInicial).getObjetos().get(0) instanceof Molotov);
		arma.explotar();

		assertTrue(Mapa.getMapa().getCasillero(posicionFinal).getObjetos().get(0) instanceof Explosion);
	}

	/**
	 * BOMBITA planta una TOLETOLE, se mueve. Muere el, y barre a un Cecilio
	 */
	@Test
	public void testBombitaPlantarBombaCaso10() {
		Integer vida = new Integer(5);
		// Creo a Bombita y lo agrego a un casillero

		Mapa.getMapa().crearCasillerosVacios(20);

		Posicion posicionFinal = new Posicion(6, 4);
		Posicion posicionInicial = new Posicion(7, 4);

		Casillero casilleroInicial = new Casillero(posicionInicial);
		Casillero casilleroFinal = new Casillero(posicionFinal);

		Bombita bombita = new Bombita(vida);
		bombita.setFactoryArma(new FactoryToleTole(new Double(5)));
		casilleroInicial.agregarObjeto(bombita);
		casilleroFinal.agregarObjeto(new Cecilio());

		Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
		Mapa.getMapa().agregarCasillero(posicionFinal, casilleroFinal);

		ToleTole arma = (ToleTole) bombita.usarArma();
		bombita.moverseConEstrategia(Direccion.ABAJO);

		arma.explotar();
		assertEquals(bombita.getVida(), new Integer(4));

		Integer cantidadDeObjetosReaccionables = Mapa.getMapa().getCasillero(posicionFinal).getObjetos().size();
		assertEquals(cantidadDeObjetosReaccionables, new Integer(1));

	}
}