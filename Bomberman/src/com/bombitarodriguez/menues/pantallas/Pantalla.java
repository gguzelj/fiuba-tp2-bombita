package com.bombitarodriguez.menues.pantallas;

import com.bombitarodriguez.vista.VentanaPrincipal;

import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class Pantalla implements Posicionable{

	private VentanaPrincipal ventanaPrincipal;
	private int posX;
	private int posY;
	private Imagen vistaPantallaNuevaPartida;
	
	public Pantalla(int posX, int posY, VentanaPrincipal ventana){
		
		this.posX = posX;
		this.posY = posY;
		this.ventanaPrincipal = ventana;
		
	}
	
	@Override
	public int getX() {				
		return posX;
	}

	@Override
	public int getY() {
		return posY;
	}

	protected void setX(int x){
		this.posX = x;
	}
	
	protected void setY(int y){
		this.posY = y;
	}
	
	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}	

	public Imagen getVistaPantalla() {
		return this.vistaPantallaNuevaPartida;
	}


	public void setVistaPantalla(Imagen vistaPantallaNuevaPartida) {
		this.vistaPantallaNuevaPartida = vistaPantallaNuevaPartida;
	}

}
