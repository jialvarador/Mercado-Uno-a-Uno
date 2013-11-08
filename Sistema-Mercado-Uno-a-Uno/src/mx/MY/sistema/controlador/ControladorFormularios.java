package mx.MY.sistema.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="ControlarFormulario")
@SessionScoped


public class ControladorFormularios {

	
	
	public boolean Formulario(String categoria){
		
		//String valor=obtenerValorSesion(rol);
		
		if(categoria==null)
			return false;
		if(!categoria.equals("")){
			return true;
		}
		else{
			return false;
		}
	}
}
