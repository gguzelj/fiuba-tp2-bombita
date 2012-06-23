/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bombitarodriguez;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

import com.bombitarodriguez.utils.ImageUtils;
import com.test.utils.PathFile;

/**
 *
 * @author jzavaleta
 */
public class Mario {

    private BufferedImage[] splitImage;

    public Mario() {

        BufferedImage imgFromUrl = null;
        BufferedImage imgFromResources = ImageUtils.loadImage(PathFile.getPathActual("/resources/caminarBombita.png"));

        try {
//            imgFromUrl = ImageIO.read(new URL("http://java-friki-tutorials.googlecode.com/svn/trunk/SpriteAnimation/src/resources/mario.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        splitImage = ImageUtils.splitImage(
                ImageUtils.makeColorTransparent(
                //Si esta ejecutando el codigo local puede usar imgFromResources
                //imgFromResources,
                //Si esta ejecutando el codigo desde web usar imgFromUrl aunque en local tambien funciona
                		imgFromResources,
                new Color(0, 115, 0)), 4, 4);
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
