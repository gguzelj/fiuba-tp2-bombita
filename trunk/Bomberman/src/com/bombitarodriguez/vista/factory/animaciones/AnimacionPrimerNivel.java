package com.bombitarodriguez.vista.factory.animaciones;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.dominio.ArticuloToleTole;
import com.bombitarodriguez.dominio.BloqueAcero;
import com.bombitarodriguez.dominio.BloqueCemento;
import com.bombitarodriguez.dominio.BloqueLadrillo;
import com.bombitarodriguez.dominio.Bomba;
import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.dominio.Casillero;
import com.bombitarodriguez.dominio.Cecilio;
import com.bombitarodriguez.dominio.Chala;
import com.bombitarodriguez.dominio.Explosion;
import com.bombitarodriguez.dominio.LosLopezReggae;
import com.bombitarodriguez.dominio.LosLopezReggaeAlado;
import com.bombitarodriguez.dominio.Posicion;
import com.bombitarodriguez.dominio.Proyectil;
import com.bombitarodriguez.dominio.Timer;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class AnimacionPrimerNivel implements ObjetoVivo, Posicionable, ObjetoReaccionable {

	Imagen imagen;
	Integer posicionX = -100;
	Integer posicionY = 300;

	public AnimacionPrimerNivel() {
		imagen = new Imagen();
		imagen.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/Niveles/PrimerNivel.png");
		imagen.setPosicionable(this);
		ControladorBomberman.agregarObjeto(this);
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
			ControladorBomberman.borrarObjeto((ObjetoReaccionable) this);
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
	public Boolean reaccionarCon(Chala chala) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(ArticuloToleTole articuloBombaToleTole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean reaccionarCon(Timer timer) {
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

	@Override
	public Posicion getPosicion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCasillero(Casillero casillero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCoordenadas(Integer x, Integer y) {
		// TODO Auto-generated method stub
		
	}

}