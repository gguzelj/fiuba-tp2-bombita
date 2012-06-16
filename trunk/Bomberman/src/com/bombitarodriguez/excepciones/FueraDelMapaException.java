package com.bombitarodriguez.excepciones;

public class FueraDelMapaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FueraDelMapaException(String msgError) {
		super(msgError);
	}

}
