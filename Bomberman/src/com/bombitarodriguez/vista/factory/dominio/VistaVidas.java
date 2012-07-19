package com.bombitarodriguez.vista.factory.dominio;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.dominio.Juego;

public class VistaVidas extends Imagen {
	
	private Bombita bombita;
	
	public VistaVidas() {
		try {
			bombita = Juego.obtenerBombita();
		} catch (IndexOutOfBoundsException e) {
			bombita = Juego.obtenerBombitaDePartidaGuardada();
		}
		
		this.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/heart3.png");
	}
	
	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		switch (bombita.getVida()) {
		case 3:
			this.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/heart3.png");
			break;
		case 2:
			this.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/heart2.png");
			break;
		case 1:
			this.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/heart1.png");
			break;
		case 0:
			this.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/heart0.png");
			break;
		}
		
	super.dibujar(superficeDeDibujo);
	}
	
	public void setBombita(Bombita bombita) {
		this.bombita = bombita;
	}

}
