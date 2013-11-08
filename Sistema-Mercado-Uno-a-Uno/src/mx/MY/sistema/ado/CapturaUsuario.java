package mx.MY.sistema.ado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import mx.MY.sistema.beans.UsuarioTO;
import mx.MY.sistema.ado.Conecta;

public class CapturaUsuario {
         
	private UsuarioTO     usuario;
	
	@SuppressWarnings("unused")
	
private void inicializar() {
		
	    System.out.println("inicializar EN CAPTURA");
	    CapturaUsuario capturaUsuario = new CapturaUsuario();
	    usuario = new UsuarioTO();
	}

   public String guardaUsuario(UsuarioTO to){
		System.out.println("OK ENTRADO A SENTENCIAS....");
		try{
			
			try {
				Conecta conecta = new Conecta();
				Connection connection = conecta.getConexion();
			
            
		    String sql = "insert into usuarios(idusuario,nombre,apellidoA,apellidoM,usuario,contrasenia,correo,telefono) values ('0','"+to.getNombre()+"','"+to.getApe1()+"','"+to.getApe2()+"','"+to.getUser()+"','"+to.getPass()+"','"+to.getCorreo()+"','"+to.getTelefono()+"'); ";
				
		  	CallableStatement callableStatement = connection.prepareCall(sql);
		    callableStatement.execute();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("hola "+to.getNombre()+" "+to.getApe1()+" "+ to.getApe2()));
			return "Nombre almacenado ! ";
		
		    
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch(Exception ex){
			System.out.println("Erro en.."+ex.getMessage());
		}
		return "";
		
	}
   
   
   
   
   

	
	public Integer VerificaRegistroUsuario(String nombre,String apellidoA ,String apellidoM,String Alias){
		Statement stmt = null;
		Integer resultado1 = 0;
	    Integer resultado2 = 0;
		try{
			try {
				Conecta conecta = new Conecta();
				Connection connection = conecta.getConexion();
				 
			    String sql1="SELECT COUNT(*) FROM `usuarios` WHERE `nombre`='"+nombre+"' and `apellidoA`='"+apellidoA+"' and `apellidoM`='"+apellidoM+"';";
				
				CallableStatement callableStatement1 = connection.prepareCall(sql1);
			    callableStatement1.execute();
			    
			    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			    ResultSet.CONCUR_UPDATABLE);
			    stmt.setQueryTimeout(30);
			    ResultSet resultSet1 = stmt.executeQuery(sql1);
			    
			    
			    while (resultSet1.next()) {
			      resultado1=resultSet1.getInt(1);		
			    }
			    
			    
                String sql2="SELECT COUNT(*) FROM `usuarios` WHERE `nombre`='"+Alias+"';";
				
				CallableStatement callableStatement2 = connection.prepareCall(sql2);
			    callableStatement2.execute();
			    
			    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			    ResultSet.CONCUR_UPDATABLE);
			    stmt.setQueryTimeout(30);
			    ResultSet resultSet2 = stmt.executeQuery(sql2);
			    
			    
			    while (resultSet2.next()) {
			      resultado2=resultSet2.getInt(1);		
			    }
			    
			    
			  if(resultado1>=1 && resultado2>=1 || resultado1>=1 || resultado2>=1){
				      if(resultado1>=1){
				    	  FacesContext context = FacesContext.getCurrentInstance();
							context.addMessage(null, new FacesMessage("Nombre y apellidos ya existen"));
					    }
				    
				      if(resultado2>=1){
				    	  FacesContext context = FacesContext.getCurrentInstance();
						  context.addMessage(null, new FacesMessage("El nombre de usuario esta ocupado"));
					
				    	}
				      
				     
				    return 1;
				}
			  
			  else{
				      return 0;
			       }
			
			   
			  
			  

			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch(Exception ex){
			System.out.println("Erro en.."+ex.getMessage());
		}
		return 3;
	}

   
   
   
   
   
				
				public UsuarioTO getUsuario() {
					return usuario;
				}
				
				public void setUsuario(UsuarioTO usuario) {
					this.usuario = usuario;
				}
				   
   
   
   
}
