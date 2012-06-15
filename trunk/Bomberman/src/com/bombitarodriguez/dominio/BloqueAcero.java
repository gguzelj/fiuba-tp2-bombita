package com.bombitarodriguez.dominio;

/**
 * 
 * @author Mauro
 *
 */
public class BloqueAcero extends Obstaculo {

  
      @Override
  	  public Boolean reaccionarCon(Explosion explosion){
  	
  		if(explosion.getDestruccion()==0){ 
  			this.destruirse();
  			return true;
  		}			
  		return false;
  	}	
	
}