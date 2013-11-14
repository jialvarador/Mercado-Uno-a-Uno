package mx.MY.sistema.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
		    System.out.println("inicializar usuario");
		    usuario = new UsuarioTO();
		   
		}
	   
	   
	   

	   public void guardar(){
			
			System.out.println("guardar");
		
			CapturaUsuario capturaUsuario = new CapturaUsuario();
		    Integer verifica=0;
			verifica=capturaUsuario.VerificaRegistroUsuario(usuario.getNombre(), usuario.getApe1(),usuario.getApe2(),usuario.getUser());
		    System.out.println(verifica+"----");
			
			if(verifica==0){
				
				capturaUsuario.guardaUsuario(usuario);
				redireccionar("bienvenido.xhtml");
			  }
			
			else{
				
				inicializar();
				  
			}
			
		  
		}
	   
	   

	   /**
		 * Metodo que redirecciona a la pagina indicada
		 * @param ruta
		 */
		public void redireccionar(String ruta){
			try{
				
				
				FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
				FacesContext context=FacesContext.getCurrentInstance();  
				
				context.getExternalContext().redirect(ruta);
			
			
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		

		

	public UsuarioTO getUsuario() {
		return usuario;
	}




	public void setUsuario(UsuarioTO usuario) {
		this.usuario = usuario;
	}
		




}
