package mx.MY.sistema.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import mx.MY.sistema.ado.CapturaUsuario;
import mx.MY.sistema.beans.UsuarioTO;


@ManagedBean(name="RegistroUsuario")
@SessionScoped



public class RegistroUsuario {

	private UsuarioTO  usuario;
	
	  public RegistroUsuario(){
			inicializar();
		}
	    
	    
    
	   private void inicializar() {
		   System.out.println("inicializar");
		    usuario = new UsuarioTO();
		   
		}
	   
	   
	   

	   public void guardar(){
			
			System.out.println("guardar");
		
			CapturaUsuario capturaUsuario = new CapturaUsuario();
			@SuppressWarnings("unused")
			String resultado=" ";
			Integer verifica=0;
			
			verifica=capturaUsuario.VerificaRegistroUsuario(usuario.getNombre(), usuario.getApe1(),usuario.getApe2(),usuario.getUser());
		
			System.out.println(verifica+"----");
			
			if(verifica==0){
				resultado=capturaUsuario.guardaUsuario(usuario);
				inicializar();
			  }
			
			else{
				
				inicializar();
				  
			}
			
		  
		}




	public UsuarioTO getUsuario() {
		return usuario;
	}




	public void setUsuario(UsuarioTO usuario) {
		this.usuario = usuario;
	}
		




}
