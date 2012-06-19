package com.bombitarodriguez.vista;

import java.io.IOException;
import java.net.URL;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaBloqueLadrillo extends Imagen {

	public VistaBloqueLadrillo(ObjetoPosicionable posicionable)
			throws IOException {
		super(VistaBloqueLadrillo.class.getResource("casilleroLadrillo.png"), posicionable);
		// TODO Auto-generated constructor stub
	}


}
