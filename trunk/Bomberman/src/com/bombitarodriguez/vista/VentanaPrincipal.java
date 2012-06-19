package com.bombitarodriguez.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

import com.bombitarodriguez.controller.ControladorBomberman;
import com.bombitarodriguez.dominio.BloqueLadrillo;
import com.bombitarodriguez.dominio.Bombita;
import com.bombitarodriguez.dominio.Mapa;
import com.bombitarodriguez.dominio.Personaje;
import com.bombitarodriguez.dominio.Posicion;
import com.bombitarodriguez.utils.Constante;
import com.bombitarodriguez.utils.Direccion;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;


public class VentanaPrincipal implements KeyPressedObservador{

	private JFrame frame;
	private GameLoop gameLoop;
	private ControladorBomberman controlador;
	private Personaje modelo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Integer nivelJuego = 1;
					StringBuilder nombreContenedorMapa = new StringBuilder();
					nombreContenedorMapa.append(nivelJuego.toString());
					nombreContenedorMapa.append(".mapa");
					File f = new File(Constante.DIRECTORIO_MAPAS.getPath() + File.separatorChar
				                + nombreContenedorMapa + File.separatorChar + nivelJuego.toString() + ".xml");
					Mapa.getMapa().crearCasillerosVacios(10);
					Mapa.getMapa().crearMapa(f); 
					final Personaje modelo = (Personaje) Mapa.getMapa().getCasillero(new Posicion(1, 1)).getObjetos().get(0);
					VentanaPrincipal window = new VentanaPrincipal(new ControladorBomberman(true, modelo));
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public VentanaPrincipal(ControladorBomberman controladorBomberman) {
		controlador = controladorBomberman;
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameLoop.iniciarEjecucion();
			}
		});
		btnIniciar.setBounds(42, 16, 77, 25);
		frame.getContentPane().add(btnIniciar);
		
		JButton btnDetener = new JButton("Detener");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameLoop.detenerEjecucion();
			}
		});
		btnDetener.setBounds(325, 16, 92, 25);
		frame.getContentPane().add(btnDetener);
		
		JPanel panel = new SuperficiePanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 450, 450);
		frame.getContentPane().add(panel);
		

		
		this.gameLoop = new GameLoop((SuperficieDeDibujo) panel);
		modelo = (Personaje) Mapa.getMapa().getCasillero(new Posicion(1, 1)).getObjetos().get(0);
		BloqueLadrillo modelo2 = (BloqueLadrillo) Mapa.getMapa().getCasillero(new Posicion(7, 1)).getObjetos().get(0);
		this.gameLoop.agregar(modelo);
		this.gameLoop.agregar(modelo2);
		Imagen vistaBombita = new VistaBombita(modelo);
//		Imagen vistaLadrillo = new VistaBloqueLadrillo(modelo2);
		this.gameLoop.agregar(vistaBombita);
//		this.gameLoop.agregar(vistaLadrillo);
		panel.addMouseListener(new MouseAdapter() {
					
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controlador.requestMover(modelo, Direccion.DERECHA);
					
			}});
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		controlador.requestMover(modelo, Direccion.DERECHA);
		
	}

	@Override
	public void keyRelease(KeyEvent arg0) {
		controlador.requestMover(modelo, Direccion.DERECHA);
		
	}
}