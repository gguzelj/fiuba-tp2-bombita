package com.bombitarodriguez.acciones;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Direccion;

/**
 * Todo request de la vista se va a transformar en una Accion
 * @author Mauro
 *
 */
public abstract class AccionAbstracta {
	
	ObjetoReaccionable ejecutor;
	
	Direccion direccion;
	
	public AccionAbstracta(ObjetoReaccionable objeto, Direccion direccion) {
		this.ejecutor = objeto;
		this.direccion = direccion;
	}
	
	public abstract void ejectuarAccion();
	
	public ObjetoReaccionable getEjecutor() {
		return ejecutor;
	}
	public void setEjecutor(ObjetoReaccionable ejecutor) {
		this.ejecutor = ejecutor;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	

}
