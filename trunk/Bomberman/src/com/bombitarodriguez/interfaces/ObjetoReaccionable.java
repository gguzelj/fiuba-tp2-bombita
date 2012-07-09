package com.bombitarodriguez.interfaces;

import com.bombitarodriguez.dominio.*;

/**
 * Interfaz para declarar de que manera reacciona un objeto ante
 * otro objeto de las clases aqui declaradas  
 */
public interface ObjetoReaccionable{

	public Boolean reaccionarCon(Bombita bombita);
	
	public Boolean reaccionarCon(Cecilio cecilio);
	
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae);
	
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado);
	
	public Boolean reaccionarCon(BloqueCemento bloqueCemento);
	
	public Boolean reaccionarCon(BloqueAcero bloqueAcero);
	
	public Boolean reaccionarCon(BloqueLadrillo bloqueLadrillo);
	
	public Boolean reaccionarCon(ArticuloChala chala);
	
	public Boolean reaccionarCon(ArticuloToleTole articuloBombaToleTole);
	
	public Boolean reaccionarCon(ArticuloTimer timer);
	
	public Boolean reaccionarCon(Bomba bomba);
	
	public Boolean reaccionarCon(Proyectil proyectil);
	
	public Boolean reaccionarCon(Explosion explosion);

//	public Posicion getPosicion();
	
	public void setCoordenadas(Integer x, Integer y);

}
