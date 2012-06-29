package com.bombitarodriguez.controller;

import java.util.ArrayList;
import java.util.List;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.menues.MenuPrincipal;
import com.bombitarodriguez.menues.pantallas.PantallaPartida;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.vista.VentanaPrincipal;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ControladorBomberman extends ControladorJuego {

	private static List<ObjetoReaccionable> objetosParaAgregar = new ArrayList<ObjetoReaccionable>();
	private static List<ObjetoReaccionable> objetosParaBorrar = new ArrayList<ObjetoReaccionable>();
	private ControladorBombita controladorBombita;
	private static Boolean estaEnEjecucion;
	private Boolean estaPausado = false;
	private static Boolean ganoElNivel = false;
	private static Integer nivelDelJuego = 1;
	
		
	public ControladorBomberman(boolean activarReproductor) {
		super(activarReproductor);
		this.estaPausado = false;
	}
		
	@Override
	public void comenzarJuego() {
		estaEnEjecucion = true;
		try {
			while (estaEnEjecucion) {

				if (!estaPausado) {
					copiarObjetos();
					simular();
				}

				dibujar();
				controlarPartida();

				Thread.sleep(150);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void copiarObjetos() {

		Dibujable dibujable;
		String nombreArchivoImagen;
		for (ObjetoReaccionable objeto : objetosParaAgregar) {

			dibujable = objeto.vistaDeObjeto();
			nombreArchivoImagen = ((Imagen) dibujable).getNombreArchivoImagen();
			((Imagen) dibujable).setNombreArchivoImagen(nombreArchivoImagen);
			dibujable.setPosicionable((Posicionable) objeto);

			this.agregarObjetoVivo((ObjetoVivo) objeto);
			this.agregarDibujable(dibujable);

		}

		for (ObjetoReaccionable objeto : objetosParaBorrar) {

			dibujable = objeto.vistaDeObjeto();
			dibujable.setPosicionable((Posicionable) objeto);

			this.removerObjetoVivo((ObjetoVivo) objeto);
			this.removerDibujable(dibujable);

		}

		objetosParaAgregar.clear();
		objetosParaBorrar.clear();

	}

	public ControladorBombita getControladorBombita() {
		return controladorBombita;
	}

	public void setControladorBombita(ControladorBombita controladorBombita) {
		this.controladorBombita = controladorBombita;
	}

	public void setEstaPausado(Boolean estaPausado) {
		synchronized (this) {
			this.estaPausado = estaPausado;
		}
	}

	public static void setGanoElNivel(Boolean ganoElNivel) {
			ControladorBomberman.ganoElNivel = ganoElNivel;
	}

	public static void agregarObjeto(ObjetoReaccionable objeto) {
		objetosParaAgregar.add(objeto);
	}

	public static void borrarObjeto(ObjetoReaccionable objeto) {
		objetosParaBorrar.add(objeto);
	}

	@Override
	public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
		super.setSuperficieDeDibujo(superficieDeDibujo);
	}

	public static Integer getNivelDelJuego() {
		return nivelDelJuego;
	}

	public static void setNivelDelJuego(Integer nivelDelJuego) {
		ControladorBomberman.nivelDelJuego = nivelDelJuego;
	}	
	
	/**
	 * Nos encargamos de hacer chequeos sobre la partida, como si bombita paso
	 * el nivel, o perdio una vida.
	 */
	private void controlarPartida() {

		if(ganoElNivel){
			if (!juegoGanado()) {
			VentanaPrincipal ventanaPrincipal = (VentanaPrincipal) this.getSuperficieDeDibujo();
			PantallaPartida pantalla = ventanaPrincipal.getPantallaPartida();			
			pantalla.siguienteNivel(++nivelDelJuego);			
			pantalla.getControlador().setControladorBombita(controladorBombita);		
			ganoElNivel = false;
//			new AnimacionNivel();
			}
			
			else {
				/*Creamos el menu principal del juego*/
				
				MenuPrincipal menuPrincipal = new MenuPrincipal((VentanaPrincipal) this.getSuperficieDeDibujo());
				menuPrincipal.mostrar();

			}
			
			
		}
		
		
	}

	private boolean juegoGanado() {
		return nivelDelJuego.equals(Constante.CANTIDAD_DE_NIVELES);
	}
}
