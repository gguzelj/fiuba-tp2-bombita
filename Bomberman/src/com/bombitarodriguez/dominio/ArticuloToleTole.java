package com.bombitarodriguez.dominio;

import com.bombitarodriguez.excepciones.IdInexistente;
import com.bombitarodriguez.utils.Identificaciones;
import com.bombitarodriguez.vista.factory.dominio.FactoryVistas;
import com.bombitarodriguez.vista.factory.dominio.VistaIndicadorArmas;
import com.bombitarodriguez.vista.factory.dominio.VistaVidas;

/**
 * @author Mauro
 */
public class ArticuloToleTole extends Articulo {
	
	private VistaIndicadorArmas vistaArmas;
	
	public ArticuloToleTole(){
		this.id = Identificaciones.articuloToleTole;
		try {
			vistaArmas = (VistaIndicadorArmas) FactoryVistas.getVistaPorId(Identificaciones.armas);
		} catch (IdInexistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		bombita.setFactoryArma(new FactoryToleTole());
		vistaArmas.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/IndicadorToleTole.png");
		this.getCasillero().quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		cecilio.setFactoryArma(new FactoryToleTole());
		this.getCasillero().quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LopezReggae lopezReggae) {
		lopezReggae.setFactoryArma(new FactoryToleTole());
		this.getCasillero().quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}

	@Override
	public Boolean reaccionarCon(LopezReggaeAlado lopezReggaeAlado) {
		lopezReggaeAlado.setFactoryArma(new FactoryToleTole());
		this.getCasillero().quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}
}
