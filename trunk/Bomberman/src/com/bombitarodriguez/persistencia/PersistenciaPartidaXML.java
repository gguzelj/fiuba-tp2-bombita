package com.bombitarodriguez.persistencia;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.dominio.Mapa;
import com.bombitarodriguez.vista.factory.dominio.VistaBombita;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * 
 * @author Mauro
 *
 */
public class PersistenciaPartidaXML {
	
	private XStream xstream;
	private String pathXml;
	
	public PersistenciaPartidaXML(String pathFile) {
		this.pathXml = pathFile;
		xstream = new XStream(new DomDriver());
		xstream.omitField(Imagen.class, "imagen");
	}
	
	/**
	 * Persiste la clase mapa y los objetos dentro de este.
	 */
	public void persistirPartida() {        
        try {
			xstream.toXML(Mapa.getMapa(), new FileOutputStream(pathXml));
		} catch (FileNotFoundException e) {
			System.out.println("no se pudo crear el archivo pagar guardar la partida");
		}
      
	}
	
	/**
	 * 
	 * @return el mapa con el estado guardado.
	 */
	public Mapa cargarDominioDeXML() {
		FileReader xmlPartida = null;
		try {
			xmlPartida = new FileReader(pathXml);
		} catch (FileNotFoundException e) {
			System.out.println("no se encuentra el archivo para restaurar la partida");
		}
		 return (Mapa) xstream.fromXML(xmlPartida);
	
	}
	
}
