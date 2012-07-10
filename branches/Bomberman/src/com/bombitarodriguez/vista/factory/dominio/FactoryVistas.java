package com.bombitarodriguez.vista.factory.dominio;

import com.bombitarodriguez.excepciones.IdInexistente;
import com.bombitarodriguez.utils.Identificaciones;
import com.bombitarodriguez.vista.VistaCaminarBombita;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class FactoryVistas {

	public static Imagen getVistaPorId(int ID) throws IdInexistente{
		
		switch (ID) {
		case Identificaciones.bombita:
			return new VistaCaminarBombita();
		
		case Identificaciones.cecilio:
			return new VistaCecilio();

		case Identificaciones.lopezReggae:
			return new VistaLopezReggae();
			
		case Identificaciones.lopezReggaeAlado:
			return new VistaLopezReggaeAlado();
			
		case Identificaciones.articuloChala:
			return new VistaArticuloChala();
		
		case Identificaciones.articuloTimer:
			return new VistaArticuloTimer();
			
		case Identificaciones.articuloToleTole:
			return new VistaArticuloToleTole();
			
		case Identificaciones.bloqueLadrillo:
			return new VistaBloqueLadrillo();
			
		case Identificaciones.bloqueCemento:
			return new VistaBloqueCemento();

		case Identificaciones.bloqueAcero:
			return new VistaBloqueAcero();

		case Identificaciones.molotov:
			return new VistaMolotov();

		case Identificaciones.proyectil:
			return new VistaProyectil();

		case Identificaciones.toleTole:
			return new VistaToleTole();

		case Identificaciones.salida:
			return new VistaSalida();
			
		case Identificaciones.explosion:
			return new VistaExplosion();
			
		default:
			System.out.println(ID);
			throw new IdInexistente("ID Inexistente");
		}
	}
}
