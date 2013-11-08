package mx.MY.sistema.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import mx.MY.sistema.ado.Conecta;

import org.primefaces.event.FileUploadEvent;

@ManagedBean(name="SubirImagen")

public class SubirImagenes {
	
	
	    public void upload(FileUploadEvent event) throws ClassNotFoundException, SQLException, IOException {  
	    	Conecta conecta = new Conecta();
	    	Connection connection = conecta.getConexion();
	    		
	    
	        FacesMessage msg = new FacesMessage("Success---base de datos! ", event.getFile().getFileName() + " is uploaded.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        // Do what you want with the file   
	        
	         //Class.forName("org.gjt.mm.mysql.Driver");
		 	
		 	//Connection  = DriverManager.getConnection("jdbc:mysql://localhost/sistema", "root","1111");
		 	
		 	PreparedStatement ps = connection.prepareStatement("insert into imagenes(id_imagen, nombre, imagen) values (000, ?, ?)");
		 	
		 	try {
		 		
		    connection .setAutoCommit(false);
		 	event.getFile();
             
		 	ps.setString(1,event.getFile().getFileName());
		  	ps.setBinaryStream(2, event.getFile().getInputstream(), (int) event.getFile().getSize());
		  	
		 	ps.executeUpdate();
		 	connection .commit();
		 	
		 	} finally {
		 	ps.close();
		 	
		 	}

	    }  

	  
       
}
