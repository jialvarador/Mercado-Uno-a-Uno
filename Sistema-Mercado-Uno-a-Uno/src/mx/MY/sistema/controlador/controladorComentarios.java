package mx.MY.sistema.controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.MY.sistema.ado.CapturaComentario;
import mx.MY.sistema.beans.ComentariosTO;


@ManagedBean(name="GuardaComentario")
@SessionScoped



public class controladorComentarios {
    
	private ComentariosTO comentario;
    
	
	  public controladorComentarios(){
			inicializar();
		}
	    
	    
    
	   private void inicializar() {
		   System.out.println("inicializar");
		   comentario=new ComentariosTO();
		   
		}
	   
	   
	   

	   @SuppressWarnings("unused")
	   public void guardar(){
			String resultado =" ";
			System.out.println("***Guarda el comentario***");
		    CapturaComentario capturaComentario= new CapturaComentario();
		    resultado = capturaComentario.guardaComentario(comentario);
		    inicializar();
		}



	public ComentariosTO getComentario() {
		return comentario;
	}



	public void setComentario(ComentariosTO comentario) {
		this.comentario = comentario;
	}







}
