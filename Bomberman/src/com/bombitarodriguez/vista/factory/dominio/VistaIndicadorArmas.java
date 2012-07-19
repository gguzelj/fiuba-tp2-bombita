package com.bombitarodriguez.vista.factory.dominio;

import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.dominio.FactoryArma;
import com.bombitarodriguez.dominio.Juego;
import com.bombitarodriguez.utils.Constante;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaIndicadorArmas extends Imagen {
	
	Bombita bombita;
	
	public VistaIndicadorArmas() {
		setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/IndicadorMolotov.png");
		try {
			bombita = Juego.obtenerBombita();
		} catch (IndexOutOfBoundsException e) {
			bombita = Juego.obtenerBombitaDePartidaGuardada();
		}
	}

	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		
		FactoryArma factory = bombita.getFactoryArma();
		
		if(factory.getArmaInstanciada().getDestruccion() == Constante.DESTRUCCION_TOLETOLE)
			setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/IndicadorToleTole.png");
				
		super.dibujar(superficeDeDibujo);
	}
	
}
