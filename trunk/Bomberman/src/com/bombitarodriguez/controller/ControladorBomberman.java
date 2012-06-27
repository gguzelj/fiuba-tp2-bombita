package com.bombitarodriguez.controller;


import java.util.ArrayList;
import java.util.List;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class ControladorBomberman extends ControladorJuego {

	private ControladorBombita controladorBombita;
	private Boolean estaEnEjecucion;
	private static List<ObjetoReaccionable> objetosParaAgregar = new ArrayList<ObjetoReaccionable>();
	private static List<ObjetoReaccionable> objetosParaBorrar = new ArrayList<ObjetoReaccionable>();
	
	public static void agregarObjeto(ObjetoReaccionable objeto){
		objetosParaAgregar.add(objeto);
	}
	
	public static void borrarObjeto(ObjetoReaccionable objeto){
		objetosParaBorrar.add(objeto);
	}
	
	
	@Override
	public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
		super.setSuperficieDeDibujo(superficieDeDibujo);
	}
	
	
	public ControladorBomberman(boolean activarReproductor) {
		super(activarReproductor);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void comenzarJuego() {
		estaEnEjecucion = true;
		try{
			while(estaEnEjecucion){
				copiarObjetos();
				simular();
				dibujar();

				Thread.sleep(150);
			}
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private void copiarObjetos() {

		Dibujable dibujable;
		
		for(ObjetoReaccionable objeto : objetosParaAgregar){

			dibujable = objeto.vistaDeObjeto();
			dibujable.setPosicionable((Posicionable) objeto);
	
			this.agregarObjetoVivo((ObjetoVivo) objeto);
			this.agregarDibujable(dibujable);

		}
		
		for(ObjetoReaccionable objeto : objetosParaBorrar){
			
			dibujable = objeto.vistaDeObjeto();
			dibujable.setPosicionable((Posicionable) objeto);
			
			this.removerObjetoVivo((ObjetoVivo) objeto);
			this.removerDibujable(dibujable);
			
		}
		
		objetosParaAgregar.clear();
		objetosParaBorrar.clear();

	}

	public ControladorBombita getControladorBombita() {
		return controladorBombita;
	}


	public void setControladorBombita(ControladorBombita controladorBombita) {
		this.controladorBombita = controladorBombita;
	}

}
