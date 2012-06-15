package com.bombitarodriguez.dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bombitarodriguez.interfaces.Armado;
import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.interfaces.StrategyMovimiento;


/**
 * 
 * @author Mauro
 *
 */
public abstract class Personaje implements ObjetoReaccionable, Armado, StrategyMovimiento{
	
	protected Casillero casilleroContenedor;
	
	protected Integer resistencia;
	
	protected Integer velocidad;
	
	protected FactoryArma factoryArma;
		
	/**
	 * Permite reaccionar con todos los objetos de un casillero
	 * @param iterador
	 * @return true si se puede mover, false caso contrario
	 */
	protected abstract Boolean reaccionarConTodos(Iterator<ObjetoReaccionable> iterador);		
	
	public Integer getResistencia() {
		return resistencia;
	}

	public void setResistencia(Integer resistencia) {
		this.resistencia = resistencia;
	}

	public Integer getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}

	public Casillero getCasillero() {
		return casilleroContenedor;
	}
	
	@Override
	public Posicion getPosicion() {
		return casilleroContenedor.getPosicion();
	}

	@Override
	public void setCasillero(Casillero casillero) {
		casilleroContenedor = casillero;		
	}

	public FactoryArma getFactoryArma() {
		return factoryArma;
	}

	public void setFactoryArma(FactoryArma factoryArma) {
		this.factoryArma = factoryArma;
	}

	@Override
	public Boolean reaccionarCon(Bombita bombita){
		bombita.quitarVida();
		return false;
	}
	@Override
	public Boolean reaccionarCon(Cecilio cecilio){
		return false;
	}
	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae){
		return false;
	}
	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado){
		return false;
	}
	
	@Override
	public Boolean reaccionarCon(Bomba bomba) {
		return false;
	}

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		return true;
	}	
	
	@Override
	public Boolean reaccionarCon(BloqueCemento bloqueCemento){
		return false;
	}
	
	@Override
	public Boolean reaccionarCon(BloqueAcero bloqueAcero){
		return false;
	}
	
	@Override
	public Boolean reaccionarCon(BloqueLadrillo bloqueLadrillo){
		return false;
	}
	
	@Override
	public Boolean reaccionarCon(Chala chala){
		return false;
	}
	
	@Override
	public Boolean reaccionarCon(ArticuloToleTole articuloBombaToleTole){
		return false;
	}
	
	@Override
	public Boolean reaccionarCon(Timer timer){
		return false;
	}	
	
	@Override
	public Boolean reaccionarCon(Proyectil proyectil) {
		return false;
	}
}
