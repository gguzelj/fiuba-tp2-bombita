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
import javax.swing.JPanel;

/**
 *
 * @author jzavaleta
 */
public class StagePanel extends JPanel implements KeyListener {

    private Mario mario = new Mario();
    private BufferedImage image;
    private int x;
    private int y;
    private int w;
    private int h;
    private int step = 0;
    private int air = 0;
    private boolean stand = true;
    private boolean walkRight = false;
    private boolean walkLeft = false;
    private boolean walkUp = false;
    private boolean walkDown = false;
    private boolean jump = false;
    /* Define de walk thread */
    private Thread walk;

    public StagePanel() {
        image = mario.deFrente();
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
                    if (walkRight) {
                            switch (step) {
                                case 0:
                                    image = mario.derecha1();
                                    step++;
                                    break;
                                case 1:
                                    image = mario.derecha2();
                                    step++;
                                    break;
                                case 2:
                                    image = mario.derecha3();
                                    step = 0;
                                    break;
                            }
                            x += 5;
                        }
                     else if (walkLeft) {
                            switch (step) {
                                case 0:
                                    image = mario.izquierda1();
                                    step++;
                                    break;
                                case 1:
                                    image = mario.izquierda2();
                                    step++;
                                    break;
                                case 2:
                                    image = mario.izquierda3();
                                    step = 0;
                                    break;
                            }
                            x += -5;
                        }
                     else if (walkUp) {
                            switch (step) {
                                case 0:
                                    image = mario.arriba1();
                                    step++;
                                    break;
                                case 1:
                                    image = mario.arriba2();
                                    step++;
                                    break;
                                case 2:
                                    image = mario.arriba3();
                                    step++;
                                    break;
                                case 3:
                                    image = mario.arriba4();
                                    step = 0;
                                    break;
                            }
                        
                        y += -5;
                    } else if (walkDown) {
                            switch (step) {
                                case 0:
                                    image = mario.deFrente();
                                    step++;
                                    break;
                                case 1:
                                    image = mario.abajo1();
                                    step++;
                                    break;
                                case 2:
                                    image = mario.abajo2();
                                    step = 0;
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
                walkUp = true;
                break;
            case KeyEvent.VK_DOWN:
                stand = false;
                walkDown = true;
                break;
            case KeyEvent.VK_LEFT:
                stand = false;
                walkLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
                stand = false;
                walkRight = true;
                break;
            case KeyEvent.VK_SPACE:
                jump = true;
                break;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                walkUp = false;
                stand = true;
                break;
            case KeyEvent.VK_DOWN:
                walkDown = false;
                stand = true;
                break;
            case KeyEvent.VK_LEFT:
                walkLeft = false;
                stand = true;
                break;
            case KeyEvent.VK_RIGHT:
                walkRight = false;
                stand = true;
                break;
        }
        repaint();
    }
}
