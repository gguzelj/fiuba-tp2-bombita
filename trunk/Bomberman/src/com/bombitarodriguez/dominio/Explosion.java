package com.bombitarodriguez.dominio;

import java.util.ArrayList;
import java.util.List;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.excepciones.FueraDelMapaException;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Direccion;
import com.bombitarodriguez.utils.Transformacion;
import com.bombitarodriguez.vista.factory.dominio.VistaExplosion;

public class Explosion implements ObjetoReaccionable , Posicionable, ObjetoVivo{

	protected Casillero casilleroContenedor;
	protected Integer destruccion;
	protected Integer ondaExpansiva;
	protected Integer posX;
	protected Integer posY;
	protected Imagen vistaExplosion;
	protected Integer tiempoDeVisualizacion;
	
	public Explosion(Integer destruccion, Integer ondaExpansiva){
		this.destruccion = destruccion;
		this.ondaExpansiva = ondaExpansiva;
		this.mostrar();
	}
	
	private void mostrar() {
		this.vistaExplosion = new VistaExplosion();
		this.tiempoDeVisualizacion = 3;
		ControladorBomberman.agregarObjeto(this);
	}
	
	public Integer getDestruccion(){
		return destruccion;
	}
	
	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.reaccionarCon(this);
		return false;
	}
	
	@Override
	public Boolean reaccionarCon(Bomba bomba) {
		return false;
	}
	
	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		cecilio.reaccionarCon(this);
		return false;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		losLopezReggae.reaccionarCon(this);
		return false;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		losLopezReggaeAlado.reaccionarCon(this);
		return false;
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
		
		List<ObjetoReaccionable> copiaDeObjetos = new ArrayList<ObjetoReaccionable>();
		copiaDeObjetos.addAll(this.getCasillero().getObjetos());
		
		//Reaaciono con los objetos del casillero principal
		for( ObjetoReaccionable objeto : copiaDeObjetos)
			objeto.reaccionarCon(this);
		
		//Reacciono hacia la derecha
		this.recorrerCasilleros(ondaExpansiva, Direccion.DERECHA);		

		//Reacciono hacia la izquierda
		this.recorrerCasilleros(ondaExpansiva, Direccion.IZQUIERDA);
		
		//Reacciono hacia la arriba
		this.recorrerCasilleros(ondaExpansiva, Direccion.ARRIBA);
		
		//Reacciono hacia la abajo
		this.recorrerCasilleros(ondaExpansiva, Direccion.ABAJO);
		
	}	
	
	//Metodo public solamente para poder ser testeado
	//Recorre todos los casilleros en la direccion indicada, hasta la onda expansiva recibida,
	//o hasta que algun objeto no nos permita pasar
	public void recorrerCasilleros(Integer ondaExpansiva, Direccion direccion){
		Boolean puedoContinuar = true;
		Posicion posicionActual = this.getPosicion();
		
		while((puedoContinuar) && (ondaExpansiva > 0)){
			try {
				posicionActual = Mapa.getMapa().getNuevaPosicion(posicionActual, direccion);
			} catch (FueraDelMapaException e) {
				return;
			}
			Casillero casilleroActual = Mapa.getMapa().getCasillero(posicionActual);
			//Agrego la vista de la explosion al controlador para que se visualice
			casilleroActual.agregarObjeto(new Explosion(0, 0));
			puedoContinuar = reaccionarConTodos(casilleroActual);
			ondaExpansiva --;
		}
	}
	
	//Reaaciona con todos los objetos del casillero
	private Boolean reaccionarConTodos(Casillero casillero) {
		
		Boolean puedoContinuar = true;
		// Creo una copia de la lista sobre la cual voy a iterar, ya que se puede modificar
		List<ObjetoReaccionable> copiaObjetosCasillero = new ArrayList<ObjetoReaccionable>();
		copiaObjetosCasillero.addAll(casillero.getObjetos());
		
		for( ObjetoReaccionable objeto : copiaObjetosCasillero){
			if(!objeto.reaccionarCon(this))
				puedoContinuar = false;
		}		
		
		return puedoContinuar;
	}

	public void destruirse(ObjetoReaccionable objeto){
		
	}
	
	@Override
	public Imagen vistaDeObjeto() {
		return this.vistaExplosion;
	}

	@Override
	public int getX() {
		return Transformacion.transformarAPixeles(getPosX());
	}

	@Override
	public int getY() {	
		return Transformacion.transformarAPixeles(getPosY());
	}
	
	@Override
	public void setCoordenadas(Integer x, Integer y) {
		posX = x;
		posY = y;
	}
	
	public Integer getPosX() {
		return posX;
	}
	
	public Integer getPosY() {
		return posY;
	}
	
	@Override
	public void vivir() {
		this.tiempoDeVisualizacion--;
		if(this.tiempoDeVisualizacion == 0){
			ControladorBomberman.borrarObjeto(this);
			this.casilleroContenedor.quitarObjeto(this);
		}
	}

	
}
