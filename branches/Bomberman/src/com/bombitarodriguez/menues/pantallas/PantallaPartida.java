package com.bombitarodriguez.menues.pantallas;

import ar.uba.fi.algo3.titiritero.Direccion;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.controller.menues.pantallas.ControladorPantallaPartida;
import com.bombitarodriguez.vista.VentanaPrincipal;
import com.bombitarodriguez.vista.factory.menues.VistaPantallaNuevaPartida;

public class PantallaPartida extends Pantalla {

	public PantallaPartida(int posX, int posY, VentanaPrincipal ventana) {

		super(posX, posY, ventana);

		/* Seteamos la posicion en la pantalla principal */
		this.setX(ventana.getHeight() / 2);
		this.setY(ventana.getWidth() / 2);

		this.vistaPantallaNuevaPartida = new VistaPantallaNuevaPartida();
		this.vistaPantallaNuevaPartida.setPosicionable(this);

		ventana.setPantallaPartida(this);
		
	}

	public void crearJuego() {
		this.getVentanaPrincipal().getJuego().crearNivel(ControladorBomberman.getNivelDelJuego());
	}

	public void cargarJuego() {
		this.getVentanaPrincipal().getJuego().cargarJuego();

	}

	@Override
	public void activarControl() {
		this.setControlador(new ControladorPantallaPartida(this));
		this.getVentanaPrincipal().setControladorActivo(this.getControlador());
	}

	public void mostrar() {
		this.getVentanaPrincipal().agregarDibujable(this.getVistaPantalla());
	}

	public void siguienteNivel(Integer nivelDelJuego) {
		this.getVentanaPrincipal().getJuego().siguienteNivel(nivelDelJuego);
	}

	@Override
	public Direccion getDireccion() {
		return null;
	}
}