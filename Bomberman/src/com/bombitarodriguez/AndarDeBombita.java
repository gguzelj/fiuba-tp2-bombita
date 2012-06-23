/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bombitarodriguez;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

import com.bombitarodriguez.dominio.Bombita;

/**
 *
 * @author jzavaleta
 */
public class AndarDeBombita extends JPanel {

	private Bombita bombita = new Bombita(1);
    private BufferedImage image;
    private int x;
    private int y;
    private int w;
    private int h;
    private int paso = 0;
    private boolean stand = true;
    private boolean caminarDerecha = false;
    private boolean caminarIzquirda = false;
    private boolean caminarArriba = false;
    private boolean caminarAbajo = false;
    private SuperficieDeDibujo superficieDeDibujo;
    /* Define de walk thread */
    private Thread walk;

    public AndarDeBombita(SuperficieDeDibujo superficieDeDibujo) {
        image = bombita.deFrente();
        x = (300 - image.getWidth()) / 2;
        y = (300 - image.getHeight()) / 2;
        w = image.getWidth();
        h = image.getHeight();
        startWalkThread();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawImage(image, x, y, w, h, null);
        }
    }

    private void startWalkThread() {
        walk = new Thread(new Runnable() {

            public void run() {
                while (true) {
//                    if (stand) {
//                        image = mario.deFrente();
//                    }
                    if (caminarDerecha) {
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
                     else if (caminarIzquirda) {
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
                     else if (caminarArriba) {
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
                    } else if (caminarAbajo) {
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
                        sleep();
                    }
                
            }
            });
     
        walk.start();
    }

    private void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            repaint();
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                stand = false;
                caminarArriba = true;
                break;
            case KeyEvent.VK_DOWN:
                stand = false;
                caminarAbajo = true;
                break;
            case KeyEvent.VK_LEFT:
                stand = false;
                caminarIzquirda = true;
                break;
            case KeyEvent.VK_RIGHT:
                stand = false;
                caminarDerecha = true;
                break;
            case KeyEvent.VK_SPACE:
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                caminarArriba = false;
                stand = true;
                break;
            case KeyEvent.VK_DOWN:
                caminarAbajo = false;
                stand = true;
                break;
            case KeyEvent.VK_LEFT:
                caminarIzquirda = false;
                stand = true;
                break;
            case KeyEvent.VK_RIGHT:
                caminarDerecha = false;
                stand = true;
                break;
        }
        repaint();
    }
}
