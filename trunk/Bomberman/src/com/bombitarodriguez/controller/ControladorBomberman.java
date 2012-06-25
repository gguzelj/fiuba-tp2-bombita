package com.bombitarodriguez.controller;

import java.awt.image.BufferedImage;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.utils.Direccion;

public class ControladorBomberman extends ControladorJuego {

	private Boolean estaEnEjecucion;
	private Bombita bombita;
	private Integer paso = 0;
	private BufferedImage image;
	private int x;
	private int y;
	private int w;
	private int h;
	
	@Override
	public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
		super.setSuperficieDeDibujo(superficieDeDibujo);
	}
	
	
	public ControladorBomberman(boolean activarReproductor) {
		super(activarReproductor);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void comenzarJuego() {
		int contador = 0;
		estaEnEjecucion = true;
		try{
			while(estaEnEjecucion){
				simular();
				dibujar();
//				caminarBombita();
				Thread.sleep(100);
				contador++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void caminarBombita() {
		 if (bombita.getDireccionAMover() == Direccion.DERECHA) {
             switch (paso) {
                 case 0:
                     image = bombita.derecha1();
                     paso++;
                     break;
                 case 1:
                     image = bombita.derecha2();
                     paso++;
                     break;
                 case 2:
                     image = bombita.derecha3();
                     paso = 0;
                     break;
             }
             x += 5;
         }
      else if (bombita.getDireccionAMover() == Direccion.IZQUIERDA) {
             switch (paso) {
                 case 0:
                     image = bombita.izquierda1();
                     paso++;
                     break;
                 case 1:
                     image = bombita.izquierda2();
                     paso++;
                     break;
                 case 2:
                     image = bombita.izquierda3();
                     paso = 0;
                     break;
             }
             x += -5;
         }
      else if (bombita.getDireccionAMover() == Direccion.ARRIBA) {
             switch (paso) {
                 case 0:
                     image = bombita.arriba1();
                     paso++;
                     break;
                 case 1:
                     image = bombita.arriba2();
                     paso++;
                     break;
                 case 2:
                     image = bombita.arriba3();
                     paso++;
                     break;
                 case 3:
                     image = bombita.arriba4();
                     paso = 0;
                     break;
             }
         
         y += -5;
     } else if (bombita.getDireccionAMover() == Direccion.ABAJO) {
             switch (paso) {
                 case 0:
                     image = bombita.deFrente();
                     paso++;
                     break;
                 case 1:
                     image = bombita.abajo1();
                     paso++;
                     break;
                 case 2:
                     image = bombita.abajo2();
                     paso = 0;
                     break;                            
             }
         
         y += +5;
     }
 
     }
	
	public void setBombita(Bombita bombita2) {
		bombita = bombita2;
		
	}
}
