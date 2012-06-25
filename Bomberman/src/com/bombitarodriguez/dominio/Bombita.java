package com.bombitarodriguez.dominio;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

import com.bombitarodriguez.interfaces.ObjetoReaccionable;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;
import com.bombitarodriguez.utils.ImageUtils;
import com.bombitarodriguez.vista.factory.dominio.VistaBombita;
import com.test.utils.PathFile;



/**
 * 
 * @author Mauro
 *
 */
public class Bombita extends Personaje{
	
	private Integer vida;
	//TODO ver si se puede subir a personaje
	private Direccion direccionAMover = null;
	private Boolean atacar = false;
	 private BufferedImage[] splitImage;
	    private BufferedImage image;
	    private int x;
	    private int y;
	    private int w;
	    private int h;
	    private int paso = 0;
	
	public Bombita(Integer vida) {
		this.vida = vida;
		this.resistencia = 0;
		this.velocidad = Constante.VELOCIDAD_CAMINA;
		this.factoryArma = new FactoryMolotov();
		BufferedImage imgFromResources = ImageUtils.loadImage(PathFile.getPathActual() + "/resources/caminarBombita.png");

	        try {
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        splitImage = ImageUtils.splitImage(
	                ImageUtils.makeColorTransparent(imgFromResources, new Color(0, 115, 0)), 4, 4);
	    
	}
	
	@Override
	public Boolean reaccionarCon(Cecilio cecilio) {
		this.quitarVida();
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggae losLopezReggae) {
		this.quitarVida();
		return true;
	}

	@Override
	public Boolean reaccionarCon(LosLopezReggaeAlado losLopezReggaeAlado) {
		this.quitarVida();
		return true;
	}

	@Override
	public Boolean reaccionarCon(Explosion explosion) {
		this.quitarVida();
		return true;
	}
	
	public void quitarVida() {
		vida -= 1;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	@Override
	public void usarArma() {
		plantarBomba();
	}

	private void plantarBomba() {
		getCasillero().agregarObjeto(factoryArma.getArmaInstanciada());
	}
	
	@Override
	protected Boolean reaccionarConTodos(Iterator<ObjetoReaccionable> iterador) {
		Boolean permitePasar = true;
		while (iterador.hasNext() && (permitePasar)) {
			permitePasar = iterador.next().reaccionarCon(this);
		}
		return permitePasar;
	}

	
	/**
	 * Guardo la direccion a la que tengo que moverme.
	 * Cuando el juego ejecute el metodo vivir(), se ejecuta la accion de 
	 * moverConEstrategia() 
	 */
	public void setDireccionAMover(Direccion direccionAMover){
		this.direccionAMover  = direccionAMover;
	}
	
	/**
	 * Guardo la sentencia de atacar. Cuando el juego ejecute vivir(),
	 * se llama al metodo usarArma()
	 */
	public void atacar(){
		this.atacar = true;
	}
	
	@Override
	public void vivir() {
		
		if(this.direccionAMover != null){
			this.moverseConEstrategia(direccionAMover);
			direccionAMover = null;
		}
		
		 if (this.getDireccionAMover() == Direccion.DERECHA) {
             switch (paso) {
                 case 0:
                     image = this.derecha1();
                     paso++;
                     break;
                 case 1:
                     image = this.derecha2();
                     paso++;
                     break;
                 case 2:
                     image = this.derecha3();
                     paso = 0;
                     break;
             }
             x += 5;
         }
      else if (this.getDireccionAMover() == Direccion.IZQUIERDA) {
             switch (paso) {
                 case 0:
                     image = this.izquierda1();
                     paso++;
                     break;
                 case 1:
                     image = this.izquierda2();
                     paso++;
                     break;
                 case 2:
                     image = this.izquierda3();
                     paso = 0;
                     break;
             }
             x += -5;
         }
      else if (this.getDireccionAMover() == Direccion.ARRIBA) {
             switch (paso) {
                 case 0:
                     image = this.arriba1();
                     paso++;
                     break;
                 case 1:
                     image = this.arriba2();
                     paso++;
                     break;
                 case 2:
                     image = this.arriba3();
                     paso++;
                     break;
                 case 3:
                     image = this.arriba4();
                     paso = 0;
                     break;
             }
         
         y += -5;
     } else if (this.getDireccionAMover() == Direccion.ABAJO) {
             switch (paso) {
                 case 0:
                     image = this.deFrente();
                     paso++;
                     break;
                 case 1:
                     image = this.abajo1();
                     paso++;
                     break;
                 case 2:
                     image = this.abajo2();
                     paso = 0;
                     break;                            
             }
         
         y += +5;
     }
 
		
		if(this.atacar == true){
			this.usarArma();
			this.atacar = false;
			
		}
		
	}
	
	
	public boolean bombaPlantada(){
		return atacar;
	}
	

	@Override
	public Imagen vistaDeObjeto() {
		return new VistaBombita();
	}

	public Direccion getDireccionAMover() {
		return direccionAMover;
	}
	
	 /**
     * frente
     */
    public BufferedImage deFrente() {
        return splitImage[0];
    }

    /**
     * derecha
     */
    public BufferedImage derecha1() {
        return splitImage[1];
    }

    public BufferedImage derecha2() {
        return splitImage[2];
    }

   
    public BufferedImage derecha3() {
        return splitImage[3];
    }
    
    
    /**
     * arriba
     */
    public BufferedImage arriba1() {
        return splitImage[4];
    }

    public BufferedImage arriba2() {
        return splitImage[5];
    }

    public BufferedImage arriba3() {
        return splitImage[6];
    }

    public BufferedImage arriba4() {
        return splitImage[7];
    }
    
    /**
     * Izquierda
     */
    public BufferedImage izquierda1() {
        return splitImage[8];
    }

    public BufferedImage izquierda2() {
        return splitImage[9];
    }

    public BufferedImage izquierda3() {
        return splitImage[10];
    }

    
    /**
     * Abajo
     */
    public BufferedImage abajo1() {
        return splitImage[11];
    }

    public BufferedImage abajo2() {
        return splitImage[12];
    }


	
}
