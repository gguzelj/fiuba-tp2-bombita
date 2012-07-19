package com.bombitarodriguez.controller;

import java.util.HashMap;
import java.util.List;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.dominio.Mapa;
import com.bombitarodriguez.dominio.Objeto;
import com.bombitarodriguez.excepciones.IdInexistente;
import com.bombitarodriguez.menues.MenuPrincipal;
import com.bombitarodriguez.menues.pantallas.PantallaPartida;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.vista.VentanaPrincipal;
import com.bombitarodriguez.vista.factory.dominio.FactoryVistas;

public class ControladorBomberman extends ControladorJuego {

	private HashMap<Objeto, Imagen> vistas = new HashMap<Objeto, Imagen>();
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
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo encargado de copiar los objetos que se crearon mientras se
	 * simulaba la partida.
	 */
	private void copiarObjetos() throws IdInexistente {

		List<Objeto> objetosParaAgregar = Mapa.getObjetosParaAgregar();
		List<Objeto> objetosParaBorrar = Mapa.getObjetosParaBorrar();

		Imagen imagen;
		for (Objeto objeto : objetosParaAgregar) {

			this.agregarObjetoVivo((ObjetoVivo) objeto);

			/*
			 * Obtenemos una nueva vista de la factory, y guardamos su
			 * referencia
			 */
			imagen = FactoryVistas.getVistaPorId(objeto.getId());
			imagen.setPosicionable((Posicionable) objeto);

			this.agregarDibujable(imagen);
			this.vistas.put(objeto, imagen);
		}

		for (Objeto objeto : objetosParaBorrar) {

			this.removerObjetoVivo((ObjetoVivo) objeto);

			/* Obtenemos la referencia ya guardada del objeto */
			this.removerDibujable(this.vistas.get(objeto));
			this.vistas.remove(objeto);
		}

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

		if (ganoElNivel) {
			if (!juegoGanado()) {
				VentanaPrincipal ventanaPrincipal = (VentanaPrincipal) this.getSuperficieDeDibujo();
				PantallaPartida pantalla = ventanaPrincipal.getPantallaPartida();
				pantalla.siguienteNivel(++nivelDelJuego);
				pantalla.getControlador().setControladorBombita(controladorBombita);
				ganoElNivel = false;
			}

			else {
				/* Creamos el menu principal del juego */
				MenuPrincipal menuPrincipal = new MenuPrincipal(
						(VentanaPrincipal) this.getSuperficieDeDibujo());
				menuPrincipal.mostrar();
			}
		}
	}

	private boolean juegoGanado() {
		return nivelDelJuego.equals(Constante.CANTIDAD_DE_NIVELES);
	}
}
