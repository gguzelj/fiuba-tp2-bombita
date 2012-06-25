package com.bombitarodriguez.controller;


import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class ControladorBomberman extends ControladorJuego {

	private ControladorBombita controladorBombita;
	private Boolean estaEnEjecucion;
	
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
				simular();
				dibujar();
				Thread.sleep(100);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public ControladorBombita getControladorBombita() {
		return controladorBombita;
	}


	public void setControladorBombita(ControladorBombita controladorBombita) {
		this.controladorBombita = controladorBombita;
	}

}
