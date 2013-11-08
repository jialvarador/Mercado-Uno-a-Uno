package mx.MY.sistema.ado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.MY.sistema.beans.AnuncioTO;

public class CapturaADO {
	
	private AnuncioTO    anuncio;
	
	private List<AnuncioTO> listaAnuncio;
	private AnuncioTO      seleccion;
	

	public void inicializar(){
		System.out.println("inicializar en capturaADO");
		CapturaADO capturaADO = new CapturaADO();
		listaAnuncio=capturaADO.buscarAnuncios();
		
	}
	

	public List<AnuncioTO> buscarAnuncios() {
		Statement stmt = null;
		System.out.println("buscar todo");
		List<AnuncioTO> listado = new ArrayList<AnuncioTO>();
		try{
		try {
		Conecta conecta = new Conecta();
		Connection connection = conecta.getConexion();
		
		String sql = "SELECT idanuncio,titulo,descripcion,fecha,vigencia,descripcionCatego FROM `anuncios` inner join categorias on anuncios.categorias_idcategoria=idcategoria;";
		CallableStatement callableStatement = connection.prepareCall(sql);
	    callableStatement.execute();
	    
	    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	    ResultSet.CONCUR_UPDATABLE);
	    stmt.setQueryTimeout(30);
	    ResultSet resultSet = stmt.executeQuery(sql);
	    
	    
	    while (resultSet.next()) {
	    	
	    	AnuncioTO ms=new AnuncioTO();
	    	ms.setIdAnuncio(resultSet.getInt(1));
	    	ms.setTitulo(resultSet.getString(2));
	    	ms.setDescripcion(resultSet.getString(3));
	    	ms.setFecha(resultSet.getString(4));
	    	ms.setNombreCategoria(resultSet.getString(6));
	        listado.add(ms);
	    	System.out.println("LISTADO---"+ms.getImageA());
	    }
	    
	    
	} catch (Exception e) {
		e.printStackTrace();
		}
		}catch(Exception ex){
		System.out.println("Erro en.."+ex.getMessage());
		}
		return listado;
	}


	public AnuncioTO getAnuncio() {
		return anuncio;
	}


	public void setAnuncio(AnuncioTO anuncio) {
		this.anuncio = anuncio;
	}


	public List<AnuncioTO> getListaAnuncio() {
		return listaAnuncio;
	}


	public void setListaAnuncio(List<AnuncioTO> listaAnuncio) {
		this.listaAnuncio = listaAnuncio;
	}


	public AnuncioTO getSeleccion() {
		return seleccion;
	}


	public void setSeleccion(AnuncioTO seleccion) {
		this.seleccion = seleccion;
	}


	
	
	
	
	
	

	
	
	
}
