package com.bombitarodriguez.dominio;

import java.io.File;
import java.util.Iterator;
import java.util.Map.Entry;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.controller.ControladorBombita;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.menues.MenuPrincipal;
import com.bombitarodriguez.persistencia.PersistenciaPartidaXML;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.PathFile;
import com.bombitarodriguez.vista.VentanaPrincipal;

/**
 * @author Mauro
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

	/**
	 * Metodo encargado de la creacion de un nivel.
	 */
	public void crearNivel(Integer nivel){
		
		/*Creamos el mapa*/
		this.crearMapa(nivel);
		
		/*Obtener Bombita*/
		bombita = this.obtenerBombita();	
				
		/*Agregamos el controlador de Bombita*/
		controlador.setControladorBombita(new ControladorBombita(bombita));
		
		/*Asignamos los objetos del mapa al controlador*/
		this.agregarObjetosDelMapa();
	}
	
	/**
	 * Similar al metodo anterior, pero primero debemos 
	 * eliminar todas las imagenes del mapa
	 */
	public void siguienteNivel(Integer nivel){
		this.borrarObjetosDelMapa();
		this.crearNivel(nivel);
	}
	
	/**
	 * Este metodo nos permite cargar una partida guardada
	 */
	public void cargarJuego(){
		this.cargarPartida();
		bombita = this.obtenerBombitaDePartidaGuardada();
		controlador.setControladorBombita(new ControladorBombita(bombita));
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
	 * Cuando se carga una nueva partida, bombita puede quedar guardado
	 * en cualquier parte del mapa. Por este motivo, se guarda la posicion de
	 * bombita cuando se persiste la partida, y se la recupera con este metodo
	 */
	private Bombita obtenerBombitaDePartidaGuardada() {
		Casillero casillero = Mapa.getMapa().getCasillero(Mapa.getMapa().getPosicionBombita());
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
            for(Objeto objeto : casillero.getObjetos())
            	Mapa.objetoParaAgregar(objeto);
		}
	}

	/**
	 * Con este metodo podemos borrar todos los objetos del mapa.
	 * Se llama cuando se crea un nuevo nivel.
	 */
	private void borrarObjetosDelMapa() {
		Iterator<Entry<Posicion, Casillero>> it = Mapa.getMapa().getEntryIterator();
        Casillero casillero;
        
	 	while (it.hasNext()) {
			Entry e = (Entry)it.next();
            casillero = (Casillero) e.getValue();
            for(Objeto objeto : casillero.getObjetos())
            	Mapa.objetoParaBorrar(objeto);
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
		Mapa.getMapa().setPosicionBombita(bombita.getPosicion());
		Mapa.getMapa().setNivelJuegoActual(ControladorBomberman.getNivelDelJuego());
		persistencia.persistirPartida();
	}
	
	private void cargarPartida() {
		PersistenciaPartidaXML persistencia = new PersistenciaPartidaXML(Constante.NOMBRE_ARCHIVO_PARTIDA);
		Mapa.setMapa(persistencia.cargarDominioDeXML());
		controlador.setNivelDelJuego(Mapa.getMapa().getNivelJuegoActual());
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

	public Bombita getBombita() {
		return bombita;
	}
	
}


