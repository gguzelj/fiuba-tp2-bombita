package com.bombitarodriguez.excepciones;

public class IdInexistente extends Exception{

	private static final long serialVersionUID = 1L;

	public IdInexistente(String msgError) {
		super(msgError);
	}
	
}