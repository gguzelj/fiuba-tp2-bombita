package com.bombitarodriguez.dominio;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;
import ar.uba.fi.algo3.titiritero.vista.KeyPressedController;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.controller.ControladorBombita;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.menues.MenuPrincipal;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Transformacion;
import com.bombitarodriguez.vista.VentanaPrincipal;
import com.test.utils.PathFile;

/**
 * 
 * @author Mauro
 * 
 */
public class Juego {
	
	private ControladorBomberman controlador = new ControladorBomberman(false);
	private Bombita bombita = null;
	private VentanaPrincipal ventanaPrincipal;


	public void iniciarJuego() {
		
		/*Creamos la ventana principal del juego*/
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(this, 1000,1000);
		ventanaPrincipal.addKeyListener(new KeyPressedController(controlador));

		
		/*Creamos el menu principal del juego*/
		MenuPrincipal menuPrincipal = new MenuPrincipal(ventanaPrincipal);
		
		/*Agregamos el menu a la pantalla principal*/
		ventanaPrincipal.agregarMenu(menuPrincipal);

		controlador.setSuperficieDeDibujo(ventanaPrincipal);		
		controlador.setIntervaloSimulacion(10);
		controlador.comenzarJuego();
		
	}

	public void crearJuego(Integer nivel){
		
		/*Creamos el mapa*/
		this.crearMapa(nivel);
		
		/*Obtenemos las dimensiones del mapa que creamos*/
		Integer dimensionDelMapa = Transformacion.transformarAPixeles(Mapa.getDimension() + 2);
		this.ventanaPrincipal.setSize(dimensionDelMapa, dimensionDelMapa);
		
		/*Obtener Bombita*/
		bombita = this.obtenerBombita();	
				
		/*Agregamos el controlador de Bombita*/
		controlador.agregarKeyPressObservador(new ControladorBombita(bombita));
		
		/*Asignamos las vistas de cada objeto del mapa al controlador*/
		this.agregarDibujables();
		
//		controlador.setBombita(bombita);
		controlador.agregarObjetoVivo(bombita);
	}
	/**
	 * Se asume que cada vez que se crea el mapa,
	 * bombita comienza el juego ubicado en el casillero (1,1)
	 * Para esto es necesario que el Mapa ya este creado.
	 */
	private Bombita obtenerBombita() {
		Casillero casillero = Mapa.getMapa().getCasillero(new Posicion(1,1));
		return (Bombita) casillero.getObjetos().get(0);
	}

	private void agregarDibujables() {
		
		java.util.Iterator<Entry<Posicion, Casillero>> it = Mapa.getMapa().getMapaCasillero().entrySet().iterator();
        Casillero casillero;
        
		while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            casillero = (Casillero) e.getValue();
            
            for(ObjetoReaccionable objeto : casillero.getObjetos()){

            	Imagen vistaObjeto = objeto.vistaDeObjeto();
            	vistaObjeto.setPosicionable((Posicionable) objeto);
            	this.controlador.agregarDibujable(vistaObjeto);
            	
            }   
		}
		
	}

	private void crearMapa(Integer nivelJuego) {
		StringBuilder nombreContenedorMapa = new StringBuilder();
		nombreContenedorMapa.append(nivelJuego.toString());
		nombreContenedorMapa.append(".mapa");
		
		String filePath = PathFile.getPathActual(Constante.DIRECTORIO_MAPAS, File.separatorChar + nombreContenedorMapa.toString(), 
                File.separatorChar + nivelJuego.toString() + ".xml");

		Mapa.getMapa().crearMapa(new File(filePath));
			
	}

	public VentanaPrincipal getVentanaPrincipal() {
		return this.ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public ControladorBomberman getControlador() {
		return controlador;
	}

	public void setControlador(ControladorBomberman controlador) {
		this.controlador = controlador;
	}

}


