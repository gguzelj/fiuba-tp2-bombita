package com.bombitarodriguez.vista.factory.dominio;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaProyectil extends Imagen{
	int paso = 1;
	
	public VistaProyectil(){
		super.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/AnimacionProyectil/Imagen1.png");
	}
	
	@Override
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		this.cambiarImagen();
		super.dibujar(superficeDeDibujo);
	}

	private void cambiarImagen() {
		
		switch(paso){
		case 1:
			super.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/AnimacionProyectil/Imagen1.png");
			paso++;
			break;
		case 2:
			super.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/AnimacionProyectil/Imagen2.png");
			paso++;
			break;
		case 3:
			super.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/AnimacionProyectil/Imagen3.png");
			paso++;
			break;
		case 4:
			super.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/AnimacionProyectil/Imagen4.png");
			paso++;
			break;
		case 5:
			super.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/AnimacionProyectil/Imagen5.png");
			paso++;
			break;
		case 6:
			super.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/AnimacionProyectil/Imagen6.png");
			paso++;
			break;
		case 7:
			super.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/AnimacionProyectil/Imagen7.png");
			paso++;
			break;
		case 8:
			super.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/AnimacionProyectil/Imagen8.png");
			paso++;
			break;
		case 9:
			super.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/AnimacionProyectil/Imagen9.png");
			paso++;
			break;
		case 10:
			super.setNombreArchivoImagen("/com/bombitarodriguez/vista/imagenes/AnimacionProyectil/Imagen10.png");
			paso = 1;
			break;
			
		}
		
	}
}
