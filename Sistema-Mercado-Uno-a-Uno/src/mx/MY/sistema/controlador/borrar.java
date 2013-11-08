package mx.MY.sistema.controlador;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import mx.MY.sistema.ado.Conecta;

@ManagedBean(name="borrar")
@SessionScoped
public class borrar {
	
	private StreamedContent hola;
	
	
    public borrar() {
    	
    	cargar();
    	
	}
	
    
   
	
    
    
    public void cargar(){
		System.out.println("cargando......");
		 try {
			  
	            Conecta conecta = new Conecta();
	    		Connection connection = conecta.getConexion();
	    		
	            String sql = "SELECT nombre, imagen1 FROM anuncios;";
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            ResultSet resultSet = stmt.executeQuery();
	            
	            while (resultSet.next()) {
	            	
	                InputStream is = resultSet.getBinaryStream(2);
	                hola = new DefaultStreamedContent(is, "image/jpg");
	                System.out.println("Sale..."+hola);
	                		
	                }
	           

	        } catch (Exception e) {
	        }

	}


	public StreamedContent getHola() {
		return hola;
	}


	public void setHola(StreamedContent hola) {
		this.hola = hola;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
