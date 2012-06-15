package com.bombitarodriguez.interfaces;

import com.bombitarodriguez.dominio.*;

/**
 * 
 * @author Mauro
 *
 */
public interface ObjetoReaccionable {

	public Boolean reaccionarCon(Bombita bombita);
	
	public Boolean reaccionarCon(Cecilio cecilio);
	
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae);
	
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado);
	
	public Boolean reaccionarCon(BloqueCemento bloqueCemento);
	
	public Boolean reaccionarCon(BloqueAcero bloqueAcero);
	
	public Boolean reaccionarCon(BloqueLadrillo bloqueLadrillo);
	
	public Boolean reaccionarCon(Chala chala);
	
	public Boolean reaccionarCon(ArticuloToleTole articuloBombaToleTole);
	
	public Boolean reaccionarCon(Timer timer);
	
	public Boolean reaccionarCon(Bomba bomba);
	
	public Boolean reaccionarCon(Proyectil proyectil);
	
	public Boolean reaccionarCon(Explosion explosion);

	public Posicion getPosicion();
	
	public void setCasillero(Casillero casillero);

}
