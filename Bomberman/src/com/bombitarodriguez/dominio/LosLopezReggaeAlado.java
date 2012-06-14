package com.bombitarodriguez.dominio;

import java.util.Iterator;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;


/**
 * 
 * @author Mauro
 *
 */
public class LosLopezReggaeAlado extends Personaje {

	@Override
	public Boolean reaccionarCon(Bombita bombita) {
		// TODO Acá se termina el juego
		return false;
	}

//	@Override
//	public Boolean reaccionarCon(Proyectil proyectil) {
//		// TODO Analizar caso
//		return null;
//	}

	@Override
	public void moverArriba(){
		Integer aumento = 1;
		Boolean encontrado = false;
		Casillero casilleroProximo = Mapa.getMapa().getCasillero(Posicion.calcularPosicionArriba(this, aumento));

		Iterator<ObjetoReaccionable> iterador; 
		while (!encontrado){
			iterador = casilleroProximo.getObjetos().iterator();
			if (reaccionarConTodos(iterador)) encontrado = true;
			else casilleroProximo = Mapa.getMapa().getCasillero(Posicion.calcularPosicionArriba(this, aumento++));
			}	
		
	 	Mapa.getMapa().reposicionar(this, casilleroProximo);
	}

	@Override
	public void moverAbajo(){
		Integer aumento = 1;
		Boolean encontrado = false;
		Casillero casilleroProximo = Mapa.getMapa().getCasillero(Posicion.calcularPosicionAbajo(this, aumento));

		Iterator<ObjetoReaccionable> iterador; 
		while (!encontrado){
			iterador = casilleroProximo.getObjetos().iterator();
			if (reaccionarConTodos(iterador)) encontrado = true;
			else casilleroProximo = Mapa.getMapa().getCasillero(Posicion.calcularPosicionAbajo(this, aumento++));
			}	
		
	 	Mapa.getMapa().reposicionar(this, casilleroProximo);
	}

	@Override
	public void moverDerecha(){
		Integer aumento = 1;
		Boolean encontrado = false;
		Casillero casilleroProximo = Mapa.getMapa().getCasillero(Posicion.calcularPosicionDerecha(this, aumento));

		Iterator<ObjetoReaccionable> iterador; 
		while (!encontrado){
			iterador = casilleroProximo.getObjetos().iterator();
			if (reaccionarConTodos(iterador)) encontrado = true;
			else casilleroProximo = Mapa.getMapa().getCasillero(Posicion.calcularPosicionDerecha(this, aumento++));
			}	
		
	 	Mapa.getMapa().reposicionar(this, casilleroProximo);
	}	
	
	@Override
	public void moverIzquierda(){
		Integer aumento = 1;
		Boolean encontrado = false;
		Casillero casilleroProximo = Mapa.getMapa().getCasillero(Posicion.calcularPosicionIzquierda(this, aumento));

		Iterator<ObjetoReaccionable> iterador; 
		while (!encontrado){
			iterador = casilleroProximo.getObjetos().iterator();
			if (reaccionarConTodos(iterador)) encontrado = true;
			else casilleroProximo = Mapa.getMapa().getCasillero(Posicion.calcularPosicionIzquierda(this, aumento++));
			}	
		
	 	Mapa.getMapa().reposicionar(this, casilleroProximo);
	}		
	
	@Override
	protected Boolean reaccionarConTodos(Iterator<ObjetoReaccionable> iterador) {
		Boolean permitePasar = true;
		while (iterador.hasNext() && (permitePasar)) {
			permitePasar = iterador.next().reaccionarCon(this);
		}
		return permitePasar;
	}
	
	@Override
	public void usarArma() {
		plantarBomba();
		
	}

	private void plantarBomba() {
		getCasillero().agregarObjeto(factoryArma.getArmaInstanciada());
		
	}


}
