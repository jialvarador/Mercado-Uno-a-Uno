package mx.MY.sistema.ado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.MY.sistema.beans.DetallesPublicacionTO;

public class ConsultaDetallesPublicacion {
	
	
	private DetallesPublicacionTO todo;
	private List<DetallesPublicacionTO> listaTodo;
   
	
	public List<DetallesPublicacionTO> buscarDetallesPublicaciones(Integer iD) {
		Statement stmt = null;
		
		System.out.println("buscar buscar detalles de publicaciones");
		List<DetallesPublicacionTO> listado = new ArrayList<DetallesPublicacionTO>();
		
		try{
		try {
		Conecta conecta = new Conecta();
		Connection connection = conecta.getConexion();
		
		String sql = "SELECT id_articulo,nombre,descripcion,costo FROM `articulos` " +
				"inner join publicaciones on articulos.publicaciones_id_publicacion=id_publicacion " +
				"where `id_publicacion`="+iD+";";
		
		CallableStatement callableStatement = connection.prepareCall(sql);
	    callableStatement.execute();
	    
	    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	    ResultSet.CONCUR_UPDATABLE);
	    stmt.setQueryTimeout(30);
	    ResultSet resultSet = stmt.executeQuery(sql);
	    
	    
	    while (resultSet.next()) {
	    	
	    	DetallesPublicacionTO ms=new DetallesPublicacionTO();
	    	
	    	ms.setNombreArticulo(resultSet.getString(2));
	    	ms.setDescripcionArticulo(resultSet.getString(3));
	    	ms.setCosto(resultSet.getString(4));
	    	
	    	listado.add(ms);
	       }
	    
	    } catch (Exception e) {
		e.printStackTrace();
		}
		}catch(Exception ex){
		System.out.println("Erro en.."+ex.getMessage());
		}
		return listado;
	}

	
	
	public Integer buscarPublicaciones(Integer id) {
		Statement stmt = null;
		Integer Categoria = null;
		
		System.out.println("buscar buscar detalles de publicaciones");
		List<DetallesPublicacionTO> listado = new ArrayList<DetallesPublicacionTO>();
		
		try{
		try {
		Conecta conecta = new Conecta();
		Connection connection = conecta.getConexion();
		
		String sql = "SELECT  categorias_id_categoria FROM `publicaciones` where id_publicacion="+id+";";
		
		CallableStatement callableStatement = connection.prepareCall(sql);
	    callableStatement.execute();
	    
	    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	    ResultSet.CONCUR_UPDATABLE);
	    stmt.setQueryTimeout(30);
	    ResultSet resultSet = stmt.executeQuery(sql);
	    
	    
	    while (resultSet.next()) {
	    	Categoria=resultSet.getInt(1);
	       }
	    
	    
	    } catch (Exception e) {
		e.printStackTrace();
		}
		}catch(Exception ex){
		System.out.println("Erro en.."+ex.getMessage());
		}
		return Categoria;
	}
	
	
	

	
	public String CategoriaPublicacion(){
		Statement stmt = null;
		Integer resultado = 3;
	
		try{
			try {
				Conecta conecta = new Conecta();
				Connection connection = conecta.getConexion();
				
			    String sql="select * from publicaciones;";
				
				CallableStatement callableStatement = connection.prepareCall(sql);
			    callableStatement.execute();
			    
			    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			    ResultSet.CONCUR_UPDATABLE);
			    stmt.setQueryTimeout(30);
			    ResultSet resultSet = stmt.executeQuery(sql);
			    
			    
			    while (resultSet.next()) {
			      resultado=resultSet.getInt(1);		
			    }
			    
			    
				
				if(resultado==1){
				 	 
					 return resultado+"";
				 	
				}
				
				else{
				       
					  return resultado+" ";
			 	}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch(Exception ex){
			System.out.println("Erro en.."+ex.getMessage());
		}
		return "";
	}
	
	
	
	
	public DetallesPublicacionTO getTodo() {
		return todo;
	}

	public void setTodo(DetallesPublicacionTO todo) {
		this.todo = todo;
	}

	public List<DetallesPublicacionTO> getListaTodo() {
		return listaTodo;
	}

	public void setListaTodo(List<DetallesPublicacionTO> listaTodo) {
		this.listaTodo = listaTodo;
	}

	
	
	
}
