package com.bombitarodriguez.vista;

import java.awt.Color;
import java.awt.Graphics;
import ar.uba.fi.algo3.titiritero.vista.Imagen;
import java.awt.image.BufferedImage;

import com.bombitarodriguez.utils.ImageUtils;
import com.bombitarodriguez.utils.PathFile;

import ar.uba.fi.algo3.titiritero.Direccion;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaCaminarBombita extends Imagen {

	private BufferedImage[] splitImage;
	private BufferedImage image;
	private int paso = 0;
	private Direccion direccionAMover = null;
	private Posicionable posicionable;

	public VistaCaminarBombita() {
		BufferedImage imgFromResources = ImageUtils.loadImage(PathFile.getPathActual() + "/resources/caminarBombita.png");
		// TODO Esta bien que la vista conozca a bombita?
		splitImage = ImageUtils.splitImage(ImageUtils.makeColorTransparent(imgFromResources, new Color(0, 115, 0)), 4, 4);
	}

	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {

		Graphics grafico = (Graphics) superficeDeDibujo.getBuffer();

		if (this.posicionable.getDireccion() != null) {

			switch (this.posicionable.getDireccion()) {
			case ARRIBA:
				setImagenArriba(paso);
				break;

			case ABAJO:
				setImagenAbajo(paso);
				break;

			case DERECHA:
				setImagenDerecha(paso);
				break;
			case IZQUIERDA:
				setImagenIzquierda(paso);
				break;
			default:
				setImagen(deFrente());
			}

		}
		else {
			setImagen(deFrente());
		}

		grafico.drawImage(image, this.posicionable.getX(), this.posicionable.getY(), null);
	}

	private void setImagenIzquierda(int paso2) {
		switch (paso) {
		case 0:
			setImagen(izquierda1());
			paso = 1;
			break;
		case 1:
			setImagen(izquierda2());
			paso = 2;
			break;
		case 2:
			setImagen(izquierda3());
			paso = 0;
			break;
		}
	}

	private void setImagenDerecha(int paso2) {
		switch (paso) {
		case 0:
			setImagen(derecha1());
			paso = 1;
			break;
		case 1:
			setImagen(derecha2());
			paso = 2;
			break;
		case 2:
			setImagen(derecha3());
			paso = 0;
			break;
		}
	}

	private void setImagenAbajo(int paso2) {
		switch (paso) {
		case 0:
			setImagen(arriba1());
			paso = 1;
			break;
		case 1:
			setImagen(arriba2());
			paso = 2;
			break;
		case 2:
			setImagen(arriba3());
			paso = 0;
			break;
		}
	}

	private void setImagenArriba(int paso2) {
		switch (paso) {
		case 0:
			setImagen(abajo1());
			paso = 1;
			break;
		case 1:
			setImagen(abajo2());
			paso = 0;
			break;
		}
	}

	@Override
	public Posicionable getPosicionable() {
		return posicionable;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;
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

	/**
	 * derecha
	 */
	public BufferedImage derecha1() {
		return splitImage[1];
	}

	public BufferedImage derecha2() {
		return splitImage[2];
	}

	public BufferedImage derecha3() {
		return splitImage[3];
	}

	/**
	 * arriba
	 */
	public BufferedImage arriba1() {
		return splitImage[4];
	}

	public BufferedImage arriba2() {
		return splitImage[5];
	}

	public BufferedImage arriba3() {
		return splitImage[6];
	}

	public BufferedImage arriba4() {
		return splitImage[7];
	}

	/**
	 * Izquierda
	 */
	public BufferedImage izquierda1() {
		return splitImage[8];
	}

	public BufferedImage izquierda2() {
		return splitImage[9];
	}

	public BufferedImage izquierda3() {
		return splitImage[10];
	}

	/**
	 * Abajo
	 */
	public BufferedImage abajo1() {
		return splitImage[11];
	}

	public BufferedImage abajo2() {
		return splitImage[12];
	}

	public Direccion getDireccionAMover() {
		return direccionAMover;
	}
}
