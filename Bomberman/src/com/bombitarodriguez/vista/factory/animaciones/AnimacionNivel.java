package com.bombitarodriguez.vista.factory.animaciones;

import java.io.File;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.dominio.ArticuloToleTole;
import com.bombitarodriguez.dominio.BloqueAcero;
import com.bombitarodriguez.dominio.BloqueCemento;
import com.bombitarodriguez.dominio.BloqueLadrillo;
import com.bombitarodriguez.dominio.Bomba;
import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.dominio.Casillero;
import com.bombitarodriguez.dominio.Cecilio;
import com.bombitarodriguez.dominio.ArticuloChala;
import com.bombitarodriguez.dominio.Explosion;
import com.bombitarodriguez.dominio.LosLopezReggae;
import com.bombitarodriguez.dominio.LosLopezReggaeAlado;
import com.bombitarodriguez.dominio.Posicion;
import com.bombitarodriguez.dominio.Proyectil;
import com.bombitarodriguez.dominio.ArticuloTimer;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.PathFile;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class AnimacionNivel implements ObjetoVivo, Posicionable, ObjetoReaccionable {

	Imagen imagen;
	Integer posicionX = -100;
	Integer posicionY = 300;

	public AnimacionNivel(Integer nivel) {
		
//		String nombreImagen = PathFile.getPathActual(Constante.DIRECTORIO_IMAGENES, "/Niveles/" + nivel.toString() + ".png");
		imagen = new Imagen();
		imagen.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/Niveles/"+nivel.toString()+".png");
		imagen.setPosicionable(this);
//		ControladorBomberman.agregarObjeto(this);
	}

	@Override
	public int getX() {
		return posicionX;
	}

	@Override
	public int getY() {
		return posicionY;
	}

	@Override
	public void vivir() {

		if (posicionX == 700) {
//			ControladorBomberman.borrarObjeto((ObjetoReaccionable) this);
			return;
		}

		posicionX += 20;

	}

	public Imagen vistaDeObjeto() {
		return imagen;
	}

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(BloqueCemento bloqueCemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(BloqueAcero bloqueAcero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(BloqueLadrillo bloqueLadrillo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(ArticuloChala chala) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(ArticuloToleTole articuloBombaToleTole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(ArticuloTimer timer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(Bomba bomba) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(Proyectil proyectil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		// TODO Auto-generated method stub
		return null;
	}
}