package com.bombitarodriguez.dominio;


import com.bombitarodriguez.utils.Identificaciones;

public class Vida extends Objeto {
	
	private int id;
	private int posX;
	private int posY;
	
	public Vida() {
		id = Identificaciones.vidas;
		posX = 80;
		posY = 25;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return posX;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return posY;
	}

}
