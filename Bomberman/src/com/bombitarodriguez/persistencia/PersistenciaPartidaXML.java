package com.bombitarodriguez.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import com.bombitarodriguez.dominio.BloqueAcero;
import com.bombitarodriguez.dominio.BloqueCemento;
import com.bombitarodriguez.dominio.BloqueLadrillo;
import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.dominio.Casillero;
import com.bombitarodriguez.dominio.Cecilio;
import com.bombitarodriguez.dominio.Chala;
import com.bombitarodriguez.dominio.LosLopezReggae;
import com.bombitarodriguez.dominio.LosLopezReggaeAlado;
import com.bombitarodriguez.dominio.Mapa;
import com.bombitarodriguez.dominio.Posicion;
import com.bombitarodriguez.dominio.Salida;
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
