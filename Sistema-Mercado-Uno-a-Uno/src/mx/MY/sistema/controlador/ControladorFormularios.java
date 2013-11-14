package mx.MY.sistema.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.MY.sistema.beans.AnuncioTO;

@ManagedBean(name="ControlarFormulario")
@SessionScoped


public class ControladorFormularios {
   AnuncioTO anuncio;
	/**
	 * Metodo que distribuye formularios
	 * @param rol
	 * @return
	 */
	
	public boolean muestra(){
	    Integer categoria=0;
	    
		if(categoria==1)
		return true;
		
		
		return false;

	}
	
	
}
