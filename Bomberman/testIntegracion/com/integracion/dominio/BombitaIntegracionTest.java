package com.integracion.dominio;

	import static org.junit.Assert.*;

import java.util.List;

	import org.junit.Test;
	import com.bombitarodriguez.dominio.Arma;
import com.bombitarodriguez.dominio.ArticuloToleTole;
	import com.bombitarodriguez.dominio.BloqueAcero;
import com.bombitarodriguez.dominio.BloqueLadrillo;
	import com.bombitarodriguez.dominio.Bombita;
	import com.bombitarodriguez.dominio.Casillero;
	import com.bombitarodriguez.dominio.Cecilio;
	import com.bombitarodriguez.dominio.Juego;
	import com.bombitarodriguez.dominio.LosLopezReggae;
	import com.bombitarodriguez.dominio.Mapa;
	import com.bombitarodriguez.dominio.Molotov;
import com.bombitarodriguez.dominio.Posicion;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;

	public class BombitaIntegracionTest {
		

		@Test
		public void testEnemigoEstaFueraDelAlcanceYNoPierdeResistencia() {
			Integer vida = new Integer(4);
			//Creo a Bombita y lo agrego a un casillero
			Juego juego = new Juego();
			juego.crearCasillerosVacios(10);
			
			Posicion posicionInicial = new Posicion(5, 5);
			Casillero casilleroInicial = new Casillero(posicionInicial);
			Bombita bombita = new Bombita(vida);
			casilleroInicial.agregarObjeto(bombita);

			Posicion posicionEnemigo = new Posicion(1,1);
			Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
			Cecilio ceci = new Cecilio();
			casilleroEnemigo.agregarObjeto(ceci);
			
			Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
			Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);
			
			bombita.usarArma();
			Arma arma = (Molotov)bombita.getCasillero().getObjetos().get(1);
			arma.explotar();
			ceci = (Cecilio) Mapa.getMapa().getCasillero(posicionEnemigo).getObjetos().get(0);
			assertEquals (ceci.getResistencia(),new Integer(5));
			//assertTrue(bombita.getCasillero().getObjetos().get(1) instanceof null);
				
		}
		
		
		@Test
		public void testEnemigoEstaEnElAlcanceYSIPierdeResistencia() {
			Integer vida = new Integer(4);
			//Creo a Bombita y lo agrego a un casillero
			Juego juego = new Juego();
			juego.crearCasillerosVacios(10);
			
			Posicion posicionInicial = new Posicion(5, 5);
			Casillero casilleroInicial = new Casillero(posicionInicial);
			Bombita bombita = new Bombita(vida);
			casilleroInicial.agregarObjeto(bombita);

			Posicion posicionEnemigo = new Posicion(5,4);
			Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
			Cecilio ceci = new Cecilio();
			casilleroEnemigo.agregarObjeto(ceci);
			
			Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
			Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);
			
			bombita.usarArma();
			Arma arma = (Molotov)bombita.getCasillero().getObjetos().get(1);
			arma.explotar();
			
			Integer tamaño = Mapa.getMapa().getCasillero(posicionEnemigo).getObjetos().size();
			assertEquals(tamaño, new Integer(0));
						
		}
		
		
		@Test
		public void testEnemigoEstaEnElAlcancePeroLoCubreUnBloqueAcero() {
			Integer vida = new Integer(4);
			//Creo a Bombita y lo agrego a un casillero
			Juego juego = new Juego();
			juego.crearCasillerosVacios(10);
			
			Posicion posicionInicial = new Posicion(5, 5);
			Casillero casilleroInicial = new Casillero(posicionInicial);
			Bombita bombita = new Bombita(vida);
			casilleroInicial.agregarObjeto(bombita);

			Posicion posicionEnemigo = new Posicion(5,3);
			Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
			Cecilio ceci = new Cecilio();
			casilleroEnemigo.agregarObjeto(ceci);
			
			Posicion posicionBloque = new Posicion(5,4);
			Casillero casilleroBloque = new Casillero(posicionEnemigo);
			BloqueAcero bloque = new BloqueAcero();
			casilleroEnemigo.agregarObjeto(bloque);
			
			Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
			Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);
			Mapa.getMapa().agregarCasillero(posicionBloque, casilleroBloque);
			bombita.usarArma();
			
			Arma arma = (Molotov)bombita.getCasillero().getObjetos().get(1);
			
			arma.explotar();
			ceci = (Cecilio) Mapa.getMapa().getCasillero(posicionEnemigo).getObjetos().get(0);
			assertEquals (ceci.getResistencia(),new Integer(5));
					
		}
		
		
		@Test
		public void BombitaMataADosEnemigosUnoDetrasDelOtroConMolotov(){
			
			Integer vida = new Integer(4);
			//Creo a Bombita y lo agrego a un casillero
			Juego juego = new Juego();
			juego.crearCasillerosVacios(20);
			
			Posicion posicionInicial = new Posicion(10, 10);
			Casillero casilleroInicial = new Casillero(posicionInicial);
			Bombita bombita = new Bombita(vida);
			casilleroInicial.agregarObjeto(bombita);

			Posicion posicionEnemigo = new Posicion(10,9);
			Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
			Cecilio ceci = new Cecilio();
			casilleroEnemigo.agregarObjeto(ceci);
			

			Posicion posicionEnemigo2 = new Posicion(10,8);
			Casillero casilleroEnemigo2 = new Casillero(posicionEnemigo);
			Cecilio ceci2 = new Cecilio();
			casilleroEnemigo.agregarObjeto(ceci2);
			
			Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
			Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);
			Mapa.getMapa().agregarCasillero(posicionEnemigo2, casilleroEnemigo2);
			bombita.usarArma();
			
			Arma arma = (Molotov)bombita.getCasillero().getObjetos().get(1);
			
			arma.explotar();
			
			Integer tamaño = Mapa.getMapa().getCasillero(posicionEnemigo).getObjetos().size();
			assertEquals(tamaño, new Integer(0));
			
			Integer tamaño2 = Mapa.getMapa().getCasillero(posicionEnemigo2).getObjetos().size();
			assertEquals(tamaño2, new Integer(0));
			
			
		}
	
		
	

		@Test
		public void BombitaMataADosEnemigosEnDiferentesDireccionesYDostanciasConMolotov(){
			
			Integer vida = new Integer(4);
			//Creo a Bombita y lo agrego a un casillero
			Juego juego = new Juego();
			juego.crearCasillerosVacios(20);
			
			Posicion posicionInicial = new Posicion(10, 10);
			Casillero casilleroInicial = new Casillero(posicionInicial);
			Bombita bombita = new Bombita(vida);
			casilleroInicial.agregarObjeto(bombita);

			Posicion posicionEnemigo = new Posicion(11, 10);
			Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
			Cecilio ceci = new Cecilio();
			casilleroEnemigo.agregarObjeto(ceci);
			

			Posicion posicionEnemigo2 = new Posicion(10,8);
			Casillero casilleroEnemigo2 = new Casillero(posicionEnemigo);
			Cecilio ceci2 = new Cecilio();
			casilleroEnemigo.agregarObjeto(ceci2);
			
			Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
			Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);
			Mapa.getMapa().agregarCasillero(posicionEnemigo2, casilleroEnemigo2);
			bombita.usarArma();
			
			Arma arma = (Molotov)bombita.getCasillero().getObjetos().get(1);
			
			arma.explotar();
			
			Integer tamaño = Mapa.getMapa().getCasillero(posicionEnemigo).getObjetos().size();
			assertEquals(tamaño, new Integer(0));
			
			Integer tamaño2 = Mapa.getMapa().getCasillero(posicionEnemigo2).getObjetos().size();
			assertEquals(tamaño2, new Integer(0));
				
		}
	
		
		@Test
		public void BombitaMataACecilioYLopezPierdeVida(){
			
			Integer vida = new Integer(4);
			//Creo a Bombita y lo agrego a un casillero
			Juego juego = new Juego();
			juego.crearCasillerosVacios(20);
			
			Posicion posicionInicial = new Posicion(10, 10);
			Casillero casilleroInicial = new Casillero(posicionInicial);
			Bombita bombita = new Bombita(vida);
			casilleroInicial.agregarObjeto(bombita);

			Posicion posicionEnemigo = new Posicion(11, 10);
			Casillero casilleroEnemigo = new Casillero(posicionEnemigo);
			LosLopezReggae lopez = new LosLopezReggae();
			casilleroEnemigo.agregarObjeto(lopez);
			

			Posicion posicionEnemigo2 = new Posicion(10,8);
			Casillero casilleroEnemigo2 = new Casillero(posicionEnemigo);
			Cecilio lopez2 = new Cecilio();
			casilleroEnemigo.agregarObjeto(lopez2);
			
			Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
			Mapa.getMapa().agregarCasillero(posicionEnemigo, casilleroEnemigo);
			Mapa.getMapa().agregarCasillero(posicionEnemigo2, casilleroEnemigo2);
			bombita.usarArma();
			
			Arma arma = (Molotov)bombita.getCasillero().getObjetos().get(1);
			
			arma.explotar();
			
			LosLopezReggae enemigo = (LosLopezReggae) Mapa.getMapa().getCasillero(posicionEnemigo).getObjetos().get(0);
			Integer tamaño = Mapa.getMapa().getCasillero(posicionEnemigo).getObjetos().size();
			assertEquals(tamaño, new Integer(1));
			assertEquals (enemigo.getResistencia(), new Integer(5));
			
			Integer tamaño2 = Mapa.getMapa().getCasillero(posicionEnemigo2).getObjetos().size();
			assertEquals(tamaño2, new Integer(0));
				
		}
		
		@Test
		public void BombitaRompeUnLadrilloYQuedaAtributoToletoleEnElPiso(){
		

			Integer vida = new Integer(4);
			//Creo a Bombita y lo agrego a un casillero
			Juego juego = new Juego();
			juego.crearCasillerosVacios(20);
			
			Posicion posicionInicial = new Posicion(7, 4);
			Casillero casilleroInicial = new Casillero(posicionInicial);
			Bombita bombita = new Bombita(vida);
			casilleroInicial.agregarObjeto(bombita);
			
			Posicion posicionBloque = new Posicion(5,4);
			Casillero casilleroBloque = new Casillero(posicionBloque);
			BloqueLadrillo bloque = new BloqueLadrillo();
			ArticuloToleTole articulo = new ArticuloToleTole();
			bloque.setObjeto(articulo);
			casilleroBloque.agregarObjeto(bloque);
			
			Mapa.getMapa().agregarCasillero(posicionBloque, casilleroBloque);
			Mapa.getMapa().agregarCasillero(posicionInicial, casilleroInicial);
			
			bombita.usarArma();
			assertTrue (Mapa.getMapa().getCasillero(posicionBloque).getObjetos().get(0) instanceof BloqueLadrillo);
         }
		
	
		
}		
		
		
		


