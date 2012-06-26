package com.bombitarodriguez.vista.factory.dominio;

import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;


public class VistaAbstracta extends Imagen{
	
	protected ObjetoReaccionable ejecutor;
	protected ControladorBomberman controlador;
	
	public VistaAbstracta (ObjetoReaccionable objeto, ControladorBomberman controladorBomberman){
		
		ejecutor = objeto;
		controlador = controladorBomberman;
		
	}
	
	public void mostrar(){
		Imagen vistaObjeto = ejecutor.vistaDeObjeto();
		vistaObjeto.setPosicionable((Posicionable) ejecutor);
    	controlador.agregarDibujable(vistaObjeto);
	}
	
	public void quitar(){
		ejecutor = null;
		controlador = null;
		controlador.removerDibujable(ejecutor.vistaDeObjeto());
	}


}	
	