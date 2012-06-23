/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bombitarodriguez;

import javax.swing.JFrame;

/**
 *
 * @author JorG
 */
public class MainFrame extends JFrame {

    private StagePanel stagePanel = new StagePanel();

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 330);
        setLocationRelativeTo(null);
        add(stagePanel);
        addKeyListener(stagePanel);
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
