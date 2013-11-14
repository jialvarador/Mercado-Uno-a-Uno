package mx.MY.sistema.ado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.MY.sistema.beans.AnuncioTO;
import mx.MY.sistema.beans.ArticuloTO;

public class ConsultaBusqueda {


	private ArticuloTO publicacion;
	private List<ArticuloTO> listaPublicacion;
	
	
	

	public List<ArticuloTO> buscarArticulosPorCategoria(Integer categoria) {
		
		Statement stmt = null;
		String sql = null ;
		
		System.out.println("buscar todo");
		List<ArticuloTO> listado = new ArrayList<ArticuloTO>();
		try{
		try {
		Conecta conecta = new Conecta();
		Connection connection = conecta.getConexion();
		   sql = "SELECT id_articulo,nombre,descripcion,costo FROM `articulos` " +
		   		"inner join publicaciones on articulos.publicaciones_id_publicacion=id_publicacion " +
		   		"inner join categorias on categorias.id_categoria=publicaciones.categorias_id_categoria " +
		   		"where categorias_id_categoria="+categoria+" and disponibilidad=1;;";
		
		
		CallableStatement callableStatement = connection.prepareCall(sql);
	    callableStatement.execute();
	    
	    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	    ResultSet.CONCUR_UPDATABLE);
	    stmt.setQueryTimeout(30);
	    ResultSet resultSet = stmt.executeQuery(sql);
	    
	    
	    while (resultSet.next()) {
	    	ArticuloTO ms=new ArticuloTO();
	    	ms.setIdArticulo(resultSet.getInt(1));
	    	ms.setNombreArticulo(resultSet.getString(2));
	    	ms.setDescripcion(resultSet.getString(3));
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
	
	


	public List<AnuncioTO> buscarAnuncios(Integer categoria) {
		
		Statement stmt = null;
		String sql = null ;
		
		System.out.println("buscar todo");
		List<AnuncioTO> listado = new ArrayList<AnuncioTO>();
		try{
		try {
		Conecta conecta = new Conecta();
		Connection connection = conecta.getConexion();
		   sql = "SELECT id_anuncio,nombre,descripcion FROM `anuncios` " +
		   		"inner join publicaciones on anuncios.publicaciones_id_publicacion=id_publicacion " +
		   		"inner join categorias on categorias.id_categoria=publicaciones.categorias_id_categoria " +
		   		"where categorias_id_categoria="+categoria+";";
		
		
		CallableStatement callableStatement = connection.prepareCall(sql);
	    callableStatement.execute();
	    
	    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	    ResultSet.CONCUR_UPDATABLE);
	    stmt.setQueryTimeout(30);
	    ResultSet resultSet = stmt.executeQuery(sql);
	    
	    
	    while (resultSet.next()) {
	    	AnuncioTO ms=new AnuncioTO();
	    	
	    	ms.setIdAnuncio(resultSet.getInt(1));
	    	ms.setNombreAnuncio(resultSet.getString(2));
	    	ms.setDescripcion(resultSet.getString(3));
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




	public ArticuloTO getPublicacion() {
		return publicacion;
	}




	public void setPublicacion(ArticuloTO publicacion) {
		this.publicacion = publicacion;
	}




	public List<ArticuloTO> getListaPublicacion() {
		return listaPublicacion;
	}




	public void setListaPublicacion(List<ArticuloTO> listaPublicacion) {
		this.listaPublicacion = listaPublicacion;
	}

	
	
	
	
	
	
}
