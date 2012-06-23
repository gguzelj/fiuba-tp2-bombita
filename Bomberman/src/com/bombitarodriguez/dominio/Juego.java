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
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Transformacion;
import com.bombitarodriguez.vista.VentanaPrincipal;
import com.bombitarodriguez.vista.factory.VistaBombita;

/**
 * 
 * @author Mauro
 * 
 */
public class Juego {
	
	private static ControladorBomberman controlador = new ControladorBomberman(false);
	private static Bombita bombita = null;

	public static void main(String[] args){
		
		/*Creamos el mapa*/
		Juego.crearMapa(Constante.DIRECTORIO_MAPAS, 1);
		
		/*Obtener Bombita*/
		bombita = Juego.obtenerBombita();	
		
		/*Ventana que encapsula al Juego*/
		Integer dimensionDelMapa =  Transformacion.transformarAPixeles(Mapa.getDimension() + 2);
		
		VentanaPrincipal ventanaPrincipal;
		ventanaPrincipal= new VentanaPrincipal(dimensionDelMapa,dimensionDelMapa);
		ventanaPrincipal.addKeyListener(new KeyPressedController(controlador));
		
		/*Controlador del jugador*/
		controlador.agregarKeyPressObservador(new ControladorBombita(bombita));
		controlador.setSuperficieDeDibujo(ventanaPrincipal.getSuperficieDeDibujo());
		
		/*Asignamos las vistas de cada objeto del mapa al controlador*/
		Juego.agregarDibujables();
		
		/* Vista del Jugador */
		VistaBombita vistaBombita = new VistaBombita();
		vistaBombita.setPosicionable(bombita);
		
		controlador.setBombita(bombita);
		controlador.agregarObjetoVivo(bombita);
		
		controlador.setIntervaloSimulacion(10);
		controlador.comenzarJuego();
	}

	
	/**
	 * Se asume que cada vez que se crea el mapa,
	 * bombita comienza el juego ubicado en el casillero (1,1)
	 * Para esto es necesario que el Mapa ya este creado.
	 */
	private static Bombita obtenerBombita() {
		Casillero casillero = Mapa.getMapa().getCasillero(new Posicion(1,1));
		return (Bombita) casillero.getObjetos().get(0);
	}

	private static void agregarDibujables() {
		
		java.util.Iterator<Entry<Posicion, Casillero>> it = Mapa.getMapa().getMapaCasillero().entrySet().iterator();
        Casillero casillero;
        
		while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            casillero = (Casillero) e.getValue();
            
            for(ObjetoReaccionable objeto : casillero.getObjetos()){

            	Imagen vistaObjeto = objeto.vistaDeObjeto();
            	vistaObjeto.setPosicionable((Posicionable) objeto);
            	controlador.agregarDibujable(vistaObjeto);
            	
            }   
		}
		
	}

	private static void crearMapa(File f, Integer nivelJuego) {
		StringBuilder nombreContenedorMapa = new StringBuilder();
		nombreContenedorMapa.append(nivelJuego.toString());
		nombreContenedorMapa.append(".mapa");
		File file = Constante.DIRECTORIO_MAPAS;
		file = new File(f.getPath() + File.separatorChar
	                + nombreContenedorMapa + File.separatorChar + nivelJuego.toString() + ".xml");
		
		Mapa.getMapa().crearMapa(file); 
		
		
	}
}


