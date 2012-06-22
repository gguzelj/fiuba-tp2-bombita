package com.bombitarodriguez.dominio;

import java.io.File;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.KeyPressedController;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.vista.VentanaPrincipal;
import com.bombitarodriguez.vista.factory.VistaBloqueLadrillo;
import com.bombitarodriguez.vista.factory.VistaBombita;
import com.bombitarodriguez.vista.factory.VistaNivel;

/**
 * 
 * @author Mauro
 * 
 */
public class Juego {
	
	private static ControladorJuego controlador = new ControladorJuego(false);
	private static Bombita bombita = new Bombita(new Integer(1));

	public static void main(String[] args){
		
		/*Ventana que encapsula al Juego*/
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setVisible(true);
		ventanaPrincipal.setResizable(false);
		ventanaPrincipal.addKeyListener(new KeyPressedController(controlador));

		
		/*Controlador del jugador*/
		controlador.agregarKeyPressObservador(new ControladorBomberman(bombita));
		controlador.setSuperficieDeDibujo(ventanaPrincipal.getSuperficieDeDibujo());
		
		
		/* Vista del Jugador */
		VistaBombita vistaBombita = new VistaBombita();
		vistaBombita.setPosicionable(bombita);
		
		/* Vista del Nivel */
		Nivel nivel = new Nivel(800,600);
		VistaNivel vistaNivel = new VistaNivel();
		vistaNivel.setPosicionable(nivel);
		
		/*Vista un bloque de Ladrillo*/
		BloqueLadrillo bloqueLadrillo = new BloqueLadrillo();
		VistaBloqueLadrillo vistaBloqueLadrillo = new VistaBloqueLadrillo();
		vistaBloqueLadrillo.setPosicionable(bloqueLadrillo);
		
		Casillero casilleroBombita = new Casillero(new Posicion(1,1));
		casilleroBombita.agregarObjeto(bombita);
		
		Casillero casilleroBloqueLadrillo = new Casillero(new Posicion(40,29));
		casilleroBloqueLadrillo.agregarObjeto(bloqueLadrillo);
		
		controlador.agregarDibujable(vistaNivel);
		controlador.agregarDibujable(vistaBombita);
		controlador.agregarDibujable(vistaBloqueLadrillo);
		
		
//		Juego.crearMapa(Constante.DIRECTORIO_MAPAS, 1);
		controlador.setIntervaloSimulacion(10);
		controlador.comenzarJuego();
	}

	private static void crearMapa(File f, Integer nivelJuego) {
		StringBuilder nombreContenedorMapa = new StringBuilder();
		nombreContenedorMapa.append(nivelJuego.toString());
		nombreContenedorMapa.append(".mapa");
		File file = Constante.DIRECTORIO_MAPAS;
		file = new File(f.getPath() + File.separatorChar
	                + nombreContenedorMapa + File.separatorChar + nivelJuego.toString() + ".xml");
		
		Mapa.getMapa().crearMapa(f); 
		
		
	}

//	public void crearCasillerosVacios(Integer numColumnas) {
//		Casillero casillero = null;
//		Posicion posicion = null;
//		
//		for (int x = 1; x <= numColumnas; x++) {
//
//			for (int y = 1; y <= numColumnas; y++) {
//				posicion = new Posicion(x, y);
//				casillero = new Casillero(posicion);
//				Mapa.getMapa().agregarCasillero(posicion, casillero);
//			}
//		}
//
//	}

	
}


