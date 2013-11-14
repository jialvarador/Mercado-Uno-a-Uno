package mx.MY.sistema.ado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.MY.sistema.beans.PublicacionTO;

public class ConsultaPublicaciones {
	
	
	private PublicacionTO publicacion;
	private List<PublicacionTO> listaPublicacion;
	
	
	public List<PublicacionTO> buscarPublicaciones() {
		Statement stmt = null;
		System.out.println("buscar todo");
		List<PublicacionTO> listado = new ArrayList<PublicacionTO>();
		try{
		try {
		Conecta conecta = new Conecta();
		Connection connection = conecta.getConexion();
		
		String sql = "SELECT id_publicacion,titulo,fecha,vigencia,descripcionCategoria FROM `publicaciones` inner join categorias on publicaciones.categorias_id_categoria=id_categoria ORDER BY `id_publicacion` DESC;";
		CallableStatement callableStatement = connection.prepareCall(sql);
	    callableStatement.execute();
	    
	    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	    ResultSet.CONCUR_UPDATABLE);
	    stmt.setQueryTimeout(30);
	    ResultSet resultSet = stmt.executeQuery(sql);
	    
	    
	    while (resultSet.next()) {
	    	
	    	PublicacionTO ms=new PublicacionTO();
	    	
	    	ms.setIdPublicacion(resultSet.getInt(1));
	    	ms.setTitulo(resultSet.getString(2));
	    	ms.setFecha(resultSet.getString(3));
	    	ms.setVigencia(resultSet.getDate(4));
	    	ms.setNombreCategoria(resultSet.getString(5));
	    	
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

    
	
	
	
	
	
	
	

	public List<PublicacionTO> buscarPorCategoria() {
		Statement stmt = null;
		System.out.println("buscar todo");
		List<PublicacionTO> listado = new ArrayList<PublicacionTO>();
		try{
		try {
		Conecta conecta = new Conecta();
		Connection connection = conecta.getConexion();
		
		String sql = "SELECT id_publicacion,titulo,fecha,vigencia,descripcionCategoria FROM `publicaciones` inner join categorias on publicaciones.categorias_id_categoria=id_categoria ORDER BY `id_publicacion` DESC;";
		CallableStatement callableStatement = connection.prepareCall(sql);
	    callableStatement.execute();
	    
	    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	    ResultSet.CONCUR_UPDATABLE);
	    stmt.setQueryTimeout(30);
	    ResultSet resultSet = stmt.executeQuery(sql);
	    
	    
	    while (resultSet.next()) {
	    	
	    	PublicacionTO ms=new PublicacionTO();
	    	
	    	ms.setIdPublicacion(resultSet.getInt(1));
	    	ms.setTitulo(resultSet.getString(2));
	    	ms.setFecha(resultSet.getString(3));
	    	ms.setVigencia(resultSet.getDate(4));
	    	ms.setNombreCategoria(resultSet.getString(5));
	    	
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


	
	
	
	
	
	public PublicacionTO getPublicacion() {
		return publicacion;
	}


	public void setPublicacion(PublicacionTO publicacion) {
		this.publicacion = publicacion;
	}


	public List<PublicacionTO> getListaPublicacion() {
		return listaPublicacion;
	}


	public void setListaPublicacion(List<PublicacionTO> listaPublicacion) {
		this.listaPublicacion = listaPublicacion;
	}



	
	
	

	
	
	
}
