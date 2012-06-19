package com.bombitarodriguez.vista;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaBombita extends Imagen {

	public VistaBombita(ObjetoPosicionable posicionable)
			throws IOException {
		
		super(VentanaPrincipal.class.getResource("imagen.png"), posicionable);
		// TODO Auto-generated constructor stub
	}

	
}
