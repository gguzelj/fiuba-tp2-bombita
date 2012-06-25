package com.bombitarodriguez.vista.factory.menues.items;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class FabricaImagenesItems extends Imagen{

	public static Imagen vistaNuevaPartidaOut(){
		Imagen imagen = new Imagen();
		imagen.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/menues/items/NuevaPartida/NuevaPartidaOut.png");
		return imagen;
	}
	
	public static Imagen vistaNuevaPartidaOver(){
		Imagen imagen = new Imagen();
		imagen.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/menues/items/NuevaPartida/NuevaPartidaOver.png");
		return imagen;
	}
	
	public static Imagen vistaCargarPartidaOut(){
		Imagen imagen = new Imagen();
		imagen.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/menues/items/CargarPartida/CargarPartidaOut.png");
		return imagen;
	}
	
	public static Imagen vistaCargarPartidaOver(){
		Imagen imagen = new Imagen();
		imagen.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/menues/items/CargarPartida/CargarPartidaOver.png");
		return imagen;
	}
	
	public static Imagen vistaSalirDelJuegoOut(){
		Imagen imagen = new Imagen();
		imagen.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/menues/items/SalirDelJuego/SalirDelJuegoOut.png");
		return imagen;
	}
	
	public static Imagen vistaSalirDelJuegoOver(){
		Imagen imagen = new Imagen();
		imagen.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/menues/items/SalirDelJuego/SalirDelJuegoOver.png");
		return imagen;
	}
}
