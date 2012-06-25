package com.bombitarodriguez.dominio;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.vista.factory.dominio.VistaSalida;


/**
 * 
 * @author Mauro
 *
 */
public class Salida implements ObjetoReaccionable {

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
	public Boolean reaccionarCon(Bombita bombita){
		// TODO Fin del juego. Como se implementa?
		return true;
	}
	@Override
	public Boolean reaccionarCon(Cecilio cecilio){
		return true;
	}
	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae){
		return true;
	}
	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado){
		return true;
	}

	@Override
	public Boolean reaccionarCon(BloqueCemento bloqueCemento){
		return false;
	}
	@Override
	public Boolean reaccionarCon(BloqueAcero bloqueAcero){
		return false;
	}
	@Override
	public Boolean reaccionarCon(BloqueLadrillo bloqueLadrillo){
		return false;
	}
	@Override
	public Boolean reaccionarCon(Chala chala){
		return false;
	}
	@Override
	public Boolean reaccionarCon(ArticuloToleTole articuloBombaToleTole){
		return false;
	}
	@Override
	public Boolean reaccionarCon(Timer timer){
		return false;
	}

	@Override
	public Boolean reaccionarCon(Bomba bomba) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(Proyectil proyectil) {
		return false;
	}	

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		return true;
	}
	
	public void destruirse(ObjetoReaccionable objeto){
		
	}

	@Override
	public Imagen vistaDeObjeto() {
		return new VistaSalida();
	}
}
