package com.bombitarodriguez.acciones;

import com.bombitarodriguez.dominio.Personaje;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Direccion;

public class AccionMovimiento extends AccionAbstracta {

	public AccionMovimiento(Personaje personaje, Direccion direccion) {
		super(personaje, direccion);
	}

	@Override
	public void ejectuarAccion() {
		Personaje personaje = (Personaje) ejecutor;
		personaje.moverseConEstrategia(direccion);
	}

}
