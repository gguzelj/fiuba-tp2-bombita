package com.bombitarodriguez.vista.factory.dominio;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;


public class VistaAbstracta extends Imagen{
	
	protected ObjetoReaccionable ejecutor;
	protected ControladorBomberman controlador;
	
	public VistaAbstracta (ControladorBomberman controladorBomberman){

		controlador = controladorBomberman;
		
	}
	
	public void mostrar(ObjetoReaccionable ejecutor){
		Imagen vistaObjeto = ejecutor.vistaDeObjeto();
		vistaObjeto.setPosicionable((Posicionable) ejecutor);
	  	
		controlador.agregarObjetoVivo((ObjetoVivo) ejecutor);
		controlador.agregarDibujable(vistaObjeto);
	}
	
	public void quitar(ObjetoReaccionable ejecutor){
		//controlador.removerDibujable(ejecutor.vistaDeObjeto());
		ejecutor = null;
		controlador = null;
	}


}	
	