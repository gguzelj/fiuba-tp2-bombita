package com.bombitarodriguez.dominio;

import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Identificaciones;

/**
 * @author Mauro 
 */
public class ArticuloChala extends Articulo {

	public ArticuloChala(){
		id = Identificaciones.articuloChala;
	}
	
	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.setVelocidad(Constante.VELOCIDAD_CORRE);
		casillero.quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		cecilio.setVelocidad(Constante.VELOCIDAD_CORRE);
		casillero.quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LopezReggae lopezReggae) {
		lopezReggae.setVelocidad(Constante.VELOCIDAD_CORRE);
		casillero.quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LopezReggaeAlado lopezReggaeAlado) {
		lopezReggaeAlado.setVelocidad(Constante.VELOCIDAD_CORRE);
		casillero.quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}
}
