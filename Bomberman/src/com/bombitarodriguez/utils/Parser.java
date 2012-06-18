package com.bombitarodriguez.utils;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parser {
	
	public static List<String> parsearMapXML(File file) {
		List<String> rows = new ArrayList<String>();
		 try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			Integer dimension = Integer.parseInt(doc.getDocumentElement().getAttribute("dimension"));
			NodeList nList = doc.getElementsByTagName("casillero");
				
			Node nNode = nList.item(0);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {		 
				Element eElement = (Element) nNode;
				for (Integer x = 1; x <= dimension; x++) {    
				  rows.add(getTagValue("row" + x, eElement));
				    }
			}

		 	} catch (Exception e) {
				e.printStackTrace();
		}
		 return rows;
	}
	
		 
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);		 
		return nValue.getNodeValue();
		  }


	public static String[] parsearLista(String string) {
		String[] subObjetos = string.split(" ");
		return subObjetos;
	}
}
