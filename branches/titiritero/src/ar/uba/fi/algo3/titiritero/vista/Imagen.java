package ar.uba.fi.algo3.titiritero.vista;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

/*
 * Esta clase representa una imagen JPG abstrayendo al usuario de los detalles de Java2D
 * Simplemente requiere de una referencia al nombre del archivo JPG
 */
public class Imagen implements Dibujable{
	
	private String nombreArchivoImagen;
    private Image imagen;
    private Posicionable posicionable;
	
	public Imagen(){}
	
	/** Constructor que le permite al objeto tomar los valores y forma de otro del mismo tipo. */
	public Imagen(Imagen imagen){
		this.nombreArchivoImagen = imagen.getNombreArchivoImagen();
		this.imagen = imagen.getImagen();
		this.posicionable = imagen.getPosicionable();
	}

	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		grafico.drawImage(this.imagen, this.posicionable.getX() - this.imagen.getWidth(null) / 2, this.posicionable.getY() - this.getImagen().getHeight(null) / 2, null);
	}
	    
	/**
	 * Establece la imagen con la que se dibujará el objeto.
	 * @param nombreArchivoImagen es el nombre del archivo que contiene l a imagen. Se espera que dicho 
	 * archivo sea .jpg o .png y esté ubicado en el directorio raiz donde se encuentra la clase o en
	 * un subdirectorio de esta.
	 */
	public void setNombreArchivoImagen(String nombreArchivoImagen) {
		this.nombreArchivoImagen = nombreArchivoImagen;
		try{
			URL u = this.getClass().getResource(this.nombreArchivoImagen);
			this.imagen = ImageIO.read(u);
		}catch(Exception ex){
			System.out.println("La imagen no cargo.");
		}
	}
	
	public String getNombreArchivoImagen() {
		return nombreArchivoImagen;
	}
	
	public Image getImagen() {
		return this.imagen;
	}
	
	public void setImagen(Image imagen) {
		this.imagen = imagen;	
	}
		
	public Posicionable getPosicionable() {
		return this.posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;
	}
	
	/** Convierte la imagen actual en una clonación de otra imagen externa pasada parametro. */
	public void setImagenDiferente(Imagen imagen) {
		this.nombreArchivoImagen = imagen.getNombreArchivoImagen();
		this.imagen = imagen.getImagen();
	}
}
