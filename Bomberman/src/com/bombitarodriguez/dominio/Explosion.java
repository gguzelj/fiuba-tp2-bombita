package com.bombitarodriguez.dominio;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;

public class Explosion implements ObjetoReaccionable{

	protected Casillero casilleroContenedor;
	
	protected Integer destruccion;
	
	protected Integer ondaExpansiva;
	
	public Explosion(Integer destruccion, Integer ondaExpansiva){
		this.destruccion = destruccion;
		this.ondaExpansiva = ondaExpansiva;
	}
	public Integer getDestruccion(){
		return destruccion;
	}
	
	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.reaccionarCon(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		cecilio.reaccionarCon(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		losLopezReggae.reaccionarCon(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		losLopezReggaeAlado.reaccionarCon(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Bomba bomba) {
		bomba.reaccionarCon(bomba);
		return true;
	}
	
	@Override
	public Boolean reaccionarCon(Proyectil proyectil) {
		proyectil.reaccionarCon(proyectil);
		return true;
	}
	
	@Override
	public Boolean reaccionarCon(BloqueCemento bloqueCemento) {
		bloqueCemento.reaccionarCon(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(BloqueAcero bloqueAcero) {
		bloqueAcero.reaccionarCon(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(BloqueLadrillo bloqueLadrillo) {
		bloqueLadrillo.reaccionarCon(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Chala chala) {
		chala.reaccionarCon(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(ArticuloToleTole articuloBombaToleTole) {
		articuloBombaToleTole.reaccionarCon(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Timer timer) {
		timer.reaccionarCon(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		return true;
	}	
	
	@Override
	public Posicion getPosicion() {
		return casilleroContenedor.getPosicion();
	}

	@Override
	public void setCasillero(Casillero casillero) {
		casilleroContenedor = casillero;
	}
	
	public Casillero getCasillero() {
		return casilleroContenedor;
	}	
	
	public void causarEstragos() {
		
		Boolean puedoContinuar;
		Casillero casilleroActual = this.getCasillero();
		Integer ondaExpansivaDerecha = ondaExpansiva;
		Integer ondaExpansivaIzquierda = ondaExpansiva;
		Integer ondaExpansivaArriba = ondaExpansiva;
		Integer ondaExpansivaAbajo = ondaExpansiva;
		
		//Reaaciono con los objetos del casillero principal
		for( ObjetoReaccionable objeto : casilleroActual.getObjetos())
			objeto.reaccionarCon(this);
		
		//Reacciono hacia la derecha
		puedoContinuar = true;
		while(puedoContinuar){
			Casillero casilleroDerecha = Mapa.getMapa().getCasillero(Posicion.calcularPosicionDerecha(this, 1));
			puedoContinuar = reaccionarConTodos(casilleroDerecha);
			ondaExpansivaDerecha --;
			puedoContinuar = (ondaExpansivaDerecha == 0);
		}		

		//Reacciono hacia la izquierda
		puedoContinuar = true;
		while(puedoContinuar){
			Casillero casilleroIzquierda = Mapa.getMapa().getCasillero(Posicion.calcularPosicionIzquierda(this, 1));
			puedoContinuar = reaccionarConTodos(casilleroIzquierda);
			ondaExpansivaIzquierda --;
			puedoContinuar = (ondaExpansivaIzquierda == 0);
		}		
		
		//Reacciono hacia la arriba
		puedoContinuar = true;
		while(puedoContinuar){
			Casillero casilleroArriba = Mapa.getMapa().getCasillero(Posicion.calcularPosicionArriba(this, 1));
			puedoContinuar = reaccionarConTodos(casilleroArriba);
			ondaExpansivaArriba --;
			puedoContinuar = (ondaExpansivaArriba == 0);
		}		
		
		//Reacciono hacia la abajo
		puedoContinuar = true;
		while(puedoContinuar){
			Casillero casilleroAbajo = Mapa.getMapa().getCasillero(Posicion.calcularPosicionAbajo(this, 1));
			puedoContinuar = reaccionarConTodos(casilleroAbajo);
			ondaExpansivaAbajo --;
			puedoContinuar = (ondaExpansivaAbajo == 0);
		}				
	}	
	
	protected Boolean reaccionarConTodos(Casillero casillero) {
		Boolean puedoContinuar = true;
		
		for( ObjetoReaccionable objeto : casillero.getObjetos()){
			if(!objeto.reaccionarCon(this))
				puedoContinuar = false;
		}		
		
		return puedoContinuar;
	}

}
