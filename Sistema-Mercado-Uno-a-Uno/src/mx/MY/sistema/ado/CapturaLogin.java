package mx.MY.sistema.ado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import mx.MY.sistema.ado.Conecta;

public class CapturaLogin {
	
	
	
	
	public String validarIngreso(Integer usu,String nom ,String pass){
		Statement stmt = null;
		Integer resultado = 3;
	
		try{
			try {
				Conecta conecta = new Conecta();
				Connection connection = conecta.getConexion();
				
			    String sql="SELECT COUNT(*) FROM `usuarios` WHERE `usuario`='"+nom+"' and contrasenia='"+pass+"' ;";
				
				CallableStatement callableStatement = connection.prepareCall(sql);
			    callableStatement.execute();
			    
			    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			    ResultSet.CONCUR_UPDATABLE);
			    stmt.setQueryTimeout(30);
			    ResultSet resultSet = stmt.executeQuery(sql);
			    
			    
			    while (resultSet.next()) {
			      resultado=resultSet.getInt(1);		
			    }
			    
			    
			
				System.out.println(" EL usuario "+nom+" lo "+pass+"existe solo"+resultado);
				
				if(resultado==1){
				 	return resultado+"@Bienvenido! "+nom;
				 	
				}else{
				   return resultado+"@El usuario no esta registrado en la bse de datos.";
			 	}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch(Exception ex){
			System.out.println("Erro en.."+ex.getMessage());
		}
		return "";
	}

	
	
	public Integer encontrarId(String usuario, String pwd) {
		Statement stmt = null;
		Integer resultado = 3;
	
		try{
			try {
				Conecta conecta = new Conecta();
				Connection connection = conecta.getConexion();
				
			    String sql="SELECT `idusuario` FROM `usuarios` WHERE `usuario`='"+usuario+"' and `contrasenia`='"+pwd+"' ;";
				
				CallableStatement callableStatement = connection.prepareCall(sql);
			    callableStatement.execute();
			    
			    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			    ResultSet.CONCUR_UPDATABLE);
			    stmt.setQueryTimeout(30);
			    ResultSet resultSet = stmt.executeQuery(sql);
			    
			    
			    while (resultSet.next()) {
			      resultado=resultSet.getInt(1);		
			    }
			    System.out.println("****BUSQUE ID Y ENCONTRE...*** "+resultado);
			    
				
				
				 	return resultado;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch(Exception ex){
			System.out.println("Erro en.."+ex.getMessage());
		}
		return null;
	}

	
}
