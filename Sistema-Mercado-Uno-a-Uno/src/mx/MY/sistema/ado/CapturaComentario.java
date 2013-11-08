package mx.MY.sistema.ado;

import java.sql.CallableStatement;
import java.sql.Connection;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import mx.MY.sistema.beans.ComentariosTO;
import mx.MY.sistema.ado.Conecta;

public class CapturaComentario {
	
    private ComentariosTO comentario;     
	
	@SuppressWarnings("unused")
	
private void inicializar() {
	    System.out.println("inicializar EN CAPTURA");
	    CapturaComentario capturaComentario = new CapturaComentario();
	    comentario= new ComentariosTO();
	  }

   public String guardaComentario(ComentariosTO to){
		System.out.println("***Ok entrando a sentencias comentarios....***");
		try{
			
			try {
				Conecta conecta = new Conecta();
				Connection connection = conecta.getConexion();
			
		    String sql="INSERT INTO `sistema`.`comentarios` (`idcomentario`, `mensaje`, `fecha`, `anuncios_idanuncio`) VALUES (NULL, '"+to.getMensaje()+"', '2013-10-12', '1');";
		  		
		  	CallableStatement callableStatement = connection.prepareCall(sql);
		    callableStatement.execute();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("comento"));
			
			return "se hizo un comentario ! ";
		
		    
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch(Exception ex){
			System.out.println("Erro en.."+ex.getMessage());
		}
		return "";
		
	}

   
   			
			public ComentariosTO getComentario() {
				return comentario;
			}
			
			public void setComentario(ComentariosTO comentario) {
				this.comentario = comentario;
			}
			   
			   
   


}
