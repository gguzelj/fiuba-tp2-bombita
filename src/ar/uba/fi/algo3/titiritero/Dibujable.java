package ar.uba.fi.algo3.titiritero;

/*
 * Esta abstraccion representa a todos los objetos Vista de la aplicacion
 * Cada objeto vista esta relacionado con un objeto del modelo que implementa
 * la interface Posicionable
 */
public interface Dibujable{

	public abstract Posicionable getPosicionable();
	public abstract void setPosicionable(Posicionable posicionable);
	public abstract void dibujar(SuperficieDeDibujo superficieDeDibujo);

}   
