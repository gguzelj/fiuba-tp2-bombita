package com.bombitarodriguez.vista;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.bombitarodriguez.AndarDeBombita;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Panel;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static int ancho;
	private static int alto;
	private JPanel jContentPanel = null;
	private Panel panel = null;

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public VentanaPrincipal(int alto, int ancho){
		super();
		VentanaPrincipal.ancho = alto;
		VentanaPrincipal.alto = ancho;
		
		
		try {
			initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setVisible(true);
		this.setResizable(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {
		
		this.setSize(VentanaPrincipal.ancho, VentanaPrincipal.alto);
		this.setBackground(new Color(0, 0, 0));
		this.setContentPane(getSuperficieDeDibujo());
		this.setTitle("Bombita Rodriguez");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.out.println("windowClosing()"); // TODO Auto-generated
														// Event stub
														// windowClosing()
				System.exit(NORMAL);
			}
		});
	}

	private JPanel getJContentPanel(){
		if (jContentPanel == null)
		{
		
			jContentPanel.setLayout(null);
			jContentPanel.add(getSuperficieDeDibujo(), null);
			
		}
		return jContentPanel;
	}
	
	public Panel getSuperficieDeDibujo(){
		if (panel == null) 
		{
			panel = new Panel(800, 800);
			panel.setLayout(new GridBagLayout());
			panel.setBounds(new Rectangle(20, 20, VentanaPrincipal.ancho, VentanaPrincipal.alto));
			panel.setBackground(new Color(0, 0, 0));
			panel.setForeground(new Color(0,255,0));
		}
		return panel;
	}
	
	
}