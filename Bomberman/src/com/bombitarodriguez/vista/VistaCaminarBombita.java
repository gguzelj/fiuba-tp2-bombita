package com.bombitarodriguez.vista;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.bombitarodriguez.utils.Direccion;
import com.bombitarodriguez.utils.ImageUtils;
import com.bombitarodriguez.utils.PathFile;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class VistaCaminarBombita extends Imagen implements Posicionable, ObjetoVivo{
	
	 private BufferedImage[] splitImage;
	    private BufferedImage image;
	    private int w;
	    private int h;
	    private int paso = 0;
		private Direccion direccionAMover = null;
		
		
	public VistaCaminarBombita(){
		
		BufferedImage imgFromResources = ImageUtils.loadImage(PathFile.getPathActual() + "/resources/caminarBombita.png");

        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

        splitImage = ImageUtils.splitImage(
                ImageUtils.makeColorTransparent(imgFromResources, new Color(0, 115, 0)), 4, 4);

		
	}
	
	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
	
	public void setCoordenadas(Integer x, Integer y) {
		this.x = x;
		this.y = y;
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


	@Override
	public void vivir() {
		// TODO Auto-generated method stub
		
	}

	public Direccion getDireccionAMover() {
		return direccionAMover;
	}

	public void setDireccionAMover(Direccion direccionAMover) {
		this.direccionAMover = direccionAMover;
	}

}
