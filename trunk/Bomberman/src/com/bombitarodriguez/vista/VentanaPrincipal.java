package com.bombitarodriguez.vista;

import java.awt.Color;
import java.io.IOException;
import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.dominio.Juego;
import com.bombitarodriguez.menues.Menu;
import com.bombitarodriguez.menues.items.ItemMenu;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class VentanaPrincipal extends Ventana {

	private static final long serialVersionUID = 1L;
	private static int ancho;
	private static int alto;
	private ControladorBomberman controladorBomberman;
	private Juego juego;
	private KeyPressedObservador controladorActivo;

	public VentanaPrincipal(Juego juego, int alto, int ancho){
		super(alto,ancho,juego.getControlador());
		this.controladorBomberman = juego.getControlador();
		juego.setVentanaPrincipal(this);
		this.juego = juego;
		VentanaPrincipal.ancho = alto;
		VentanaPrincipal.alto = ancho;

		try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setVisible(true);
		this.setResizable(false);
		
	}

	private void initialize() throws IOException {

		this.setSize(VentanaPrincipal.ancho, VentanaPrincipal.alto);
		this.setBackground(new Color(0, 0, 0));
		this.setTitle("Bombita Rodriguez");
				
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.out.println("windowClosing()"); 
				System.exit(NORMAL);
			}
		});
	}

	public void agregarMenu(Menu menu) {

		/*agregamos los dibujables del menu*/
		this.controladorBomberman.agregarDibujable(menu.getVistaMenu());
		
		for(ItemMenu item : menu.getItems()){
			this.controladorBomberman.agregarDibujable(item.getVistaItem());
		}
		
		/*agregamos el controlador del menu*/
		this.quitarControlador(this.controladorActivo);
		this.controladorActivo = menu.getControlador();
		this.agregarControlador(this.controladorActivo);
		
	}

	public void quitarMenu(Menu menu){
		
		this.controladorBomberman.removerDibujable(menu.getVistaMenu());
		
		for(ItemMenu item : menu.getItems()){
			this.controladorBomberman.removerDibujable(item.getVistaItem());
		}
		
	}
	
	private void agregarControlador(KeyPressedObservador controlador) {
		this.controladorBomberman.agregarKeyPressObservador(controlador);
	}
	private void quitarControlador(KeyPressedObservador controlador){
		this.controladorBomberman.removerKeyPressObservador(controlador);
	}
	
	public void agregarDibujable(Dibujable dibujable){
		this.controladorBomberman.agregarDibujable(dibujable);		
	}
	
	public void quitarDibujable(Dibujable dibujable){
		this.controladorBomberman.removerDibujable(dibujable);		
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}


}