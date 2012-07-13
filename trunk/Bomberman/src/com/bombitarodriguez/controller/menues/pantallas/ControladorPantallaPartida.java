package com.bombitarodriguez.controller.menues.pantallas;

import java.awt.event.KeyEvent;

import com.bombitarodriguez.controller.ControladorBombita;
import com.bombitarodriguez.menues.MenuPausa;
import com.bombitarodriguez.menues.pantallas.PantallaPartida;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControladorPantallaPartida implements KeyPressedObservador {

        private PantallaPartida pantalla;
        private ControladorBombita controladorBombita;

        public ControladorPantallaPartida(PantallaPartida pantalla) {
                this.pantalla = pantalla;
                this.controladorBombita = pantalla.getVentanaPrincipal().getJuego().getControlador().getControladorBombita();
        }

        @Override
        public void keyPressed(KeyEvent event) {

                /* Le pasamos el evento al controlador de Bombita */
                controladorBombita.keyPressed(event);

                switch (event.getKeyCode()) {

                case KeyEvent.VK_P:
                        this.pantalla.getVentanaPrincipal().getJuego().getControlador().setEstaPausado(true);
                        MenuPausa menuPausa = new MenuPausa(this.pantalla.getVentanaPrincipal(), this.pantalla);
                        menuPausa.mostrar();
                        break;
                        
                }
        }

        public void setControladorBombita(ControladorBombita controladorBombita) {
			this.controladorBombita = controladorBombita;
		}
}