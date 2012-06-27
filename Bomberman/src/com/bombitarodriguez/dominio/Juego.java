package com.bombitarodriguez.dominio;

import java.io.File;
import java.util.Iterator;
import java.util.Map.Entry;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.controller.ControladorBombita;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.menues.MenuPrincipal;
import com.bombitarodriguez.persistencia.PersistenciaPartidaXML;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.PathFile;
import com.bombitarodriguez.utils.Transformacion;
import com.bombitarodriguez.vista.VentanaPrincipal;


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
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(this, Constante.DIMENSION_VENTANA, Constante.DIMENSION_VENTANA);

		/*Creamos el menu principal del juego*/
		MenuPrincipal menuPrincipal = new MenuPrincipal(ventanaPrincipal);
		menuPrincipal.mostrar();

		controlador.setSuperficieDeDibujo(ventanaPrincipal);		
		controlador.setIntervaloSimulacion(10);
		controlador.comenzarJuego();
	}

	public void crearJuego(Integer nivel){
		
		/*Creamos el mapa*/
		this.crearMapa(nivel);
		
		/*Obtener Bombita*/
		bombita = this.obtenerBombita();	
				
		/*Agregamos el controlador de Bombita*/
		controlador.setControladorBombita(new ControladorBombita(bombita));
		controlador.agregarObjetoVivo(bombita);
		
		/*Asignamos los objetos del mapa al controlador*/
		this.agregarObjetosDelMapa();
	}
	
	public void cargarJuego(){
		this.cargarPartida();
		this.agregarObjetosDelMapa();
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

	
	/**
	 * Se recorre el mapa en busca de los objetos creados. Para cada objeto
	 * creado, se agrega en las listas de dibujables y de objetos vivos, del 
	 * controlador del juego. 
	 */
	private void agregarObjetosDelMapa() {
		Iterator<Entry<Posicion, Casillero>> it = Mapa.getMapa().getEntryIterator();
        Casillero casillero;
        
		while (it.hasNext()) {
			Entry e = (Entry)it.next();
            casillero = (Casillero) e.getValue();
           
            for(ObjetoReaccionable objeto : casillero.getObjetos()){
            	Imagen vistaObjeto = objeto.vistaDeObjeto();
            	vistaObjeto.setPosicionable((Posicionable) objeto);
            	this.controlador.agregarDibujable(vistaObjeto);
            	this.controlador.agregarObjetoVivo((ObjetoVivo) objeto);
           
            }   
		}
	}

	/**
	 * Llamamos al creador de mapas de la clase Mapa
	 */
	private void crearMapa(Integer nivelJuego) {
		StringBuilder nombreContenedorMapa = new StringBuilder();
		nombreContenedorMapa.append(nivelJuego.toString());
		nombreContenedorMapa.append(".mapa");
		
		String filePath = PathFile.getPathActual(Constante.DIRECTORIO_MAPAS, File.separatorChar + nombreContenedorMapa.toString(), 
                File.separatorChar + nivelJuego.toString() + ".xml");
		
		Mapa.getMapa().crearMapa(new File(filePath));
	}
	
	public void guardarPartida() {
		PersistenciaPartidaXML persistencia = new PersistenciaPartidaXML(Constante.NOMBRE_ARCHIVO_PARTIDA);
		persistencia.persistirPartida();
	}
	
	private void cargarPartida() {
		PersistenciaPartidaXML persistencia = new PersistenciaPartidaXML(Constante.NOMBRE_ARCHIVO_PARTIDA);
		Mapa.setMapa(persistencia.cargarDominioDeXML());
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


