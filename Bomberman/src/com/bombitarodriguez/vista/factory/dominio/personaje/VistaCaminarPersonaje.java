package com.bombitarodriguez.vista.factory.dominio.personaje;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.utils.ImageUtils;

public class VistaCaminarPersonaje extends Imagen{

	private BufferedImage[] splitImage;
	private BufferedImage[] imagenesDerecha = new BufferedImage[4];
	private BufferedImage[] imagenesIzquierda = new BufferedImage[4];
	private BufferedImage[] imagenesArriba = new BufferedImage[4];
	private BufferedImage[] imagenesAbajo = new BufferedImage[4];
	private BufferedImage image;
	private int paso = 0;

	public VistaCaminarPersonaje() {}
	
	public VistaCaminarPersonaje(String pathName) {
		BufferedImage imgFromResources = ImageUtils.loadImage(pathName);
		splitImage = ImageUtils.splitImage(imgFromResources, 8, 8);
		setImagenesDerecha();
		setImagenesIzquierda();
		setImagenesArriba();
		setImagenesAbajo();
	}

	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {

		Graphics grafico = (Graphics) superficeDeDibujo.getBuffer();

		if (this.getPosicionable().getDireccion() != null) {

			switch (this.getPosicionable().getDireccion()) {
			case ARRIBA:
				determinarImagen(imagenesArriba);
				break;

			case ABAJO:
				determinarImagen(imagenesAbajo);
				break;

			case DERECHA:
				determinarImagen(imagenesDerecha);
				break;
				
			case IZQUIERDA:
				determinarImagen(imagenesIzquierda);
				break;
				
			default:
				setImagen(deFrente());
			}

		} else {
			setImagen(deFrente());
		}

		grafico.drawImage(image, this.getPosicionable().getX(), this.getPosicionable().getY(), null);
	}

	private void determinarImagen(BufferedImage[] imagenes) {
		setImagen(imagenes[paso]);
		nextPaso();
	}
	
	private void nextPaso() {
		paso++;
		if(paso == 3)
			paso = 0;
	}

	public void setImagen(BufferedImage imagen) {
		this.image = imagen;
	}

	/**
	 * frente
	 */
	public BufferedImage deFrente() {
		return splitImage[0];
	}

	private void setImagenesDerecha() {
		imagenesDerecha[0] = splitImage[24];
		imagenesDerecha[1] = splitImage[25];
		imagenesDerecha[2] = splitImage[26];
		imagenesDerecha[3] = splitImage[27];
	}
	
	private void setImagenesIzquierda() {
		imagenesIzquierda[0] = splitImage[8];
		imagenesIzquierda[1] = splitImage[9];
		imagenesIzquierda[2] = splitImage[10];
		imagenesIzquierda[3] = splitImage[11];
	}

	private void setImagenesArriba() {
		imagenesArriba[0] = splitImage[0];
		imagenesArriba[1] = splitImage[1];
		imagenesArriba[2] = splitImage[2];
		imagenesArriba[3] = splitImage[3];
	}
	
	private void setImagenesAbajo() {
		imagenesAbajo[0] = splitImage[16];
		imagenesAbajo[1] = splitImage[17];
		imagenesAbajo[2] = splitImage[18];
		imagenesAbajo[3] = splitImage[19];
	}
	
}

