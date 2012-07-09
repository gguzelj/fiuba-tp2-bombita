package com.bombitarodriguez.dominio;

/**
 * @author Mauro
 */
public abstract class Arma extends Objeto{
	
	protected Integer destruccion;
	protected Double retardo;
	protected Integer ondaExpansiva;

	public void explotar(){
		Explosion explosion = new Explosion(getDestruccion(),getOndaExpansiva());
		
		this.getCasillero().agregarObjeto(explosion);
		this.getCasillero().quitarObjeto(this);
		
		explosion.causarEstragos();

		Mapa.objetoParaBorrar(this);
	}
	
	@Override
	public Boolean reaccionarCon(Explosion explosion){
		this.getCasillero().quitarObjeto(this);
		Mapa.objetoParaBorrar(this);
		return true;
	}
	
	public Integer getDestruccion() {
		return destruccion;
	}

	public void setDestruccion(Integer destruccion) {
		this.destruccion = destruccion;
	}

	public Double getRetardo() {
		return retardo;
	}

	public void setRetardo(Double retardo) {
		this.retardo = retardo;
	}

	public Integer getOndaExpansiva() {
		return ondaExpansiva;
	}

	public void setOndaExpansiva(Integer ondaExpansiva) {
		this.ondaExpansiva = ondaExpansiva;
	}
}
