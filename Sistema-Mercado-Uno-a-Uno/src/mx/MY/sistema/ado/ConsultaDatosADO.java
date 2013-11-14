package mx.MY.sistema.ado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import mx.MY.sistema.beans.AnuncioTO;
import mx.MY.sistema.beans.UsuarioTO;

public class ConsultaDatosADO {
	
    private AnuncioTO anuncioDato;
	private List<AnuncioTO>listaAnuncios;
    private UsuarioTO usuarioDato;
	private List<UsuarioTO> listaDatos;
    

	public void inicializar(){
		
		System.out.println("inicializar en capturaADO");
		ConsultaDatosADO consultaDatosADO = new ConsultaDatosADO();
		listaDatos=consultaDatosADO.buscarDatos();
	   
	}
	
	//**OTRO METODO PARA OBTENER EL OTROL VALOR EN SESION***/
	public Integer obtenerValorSesioIDn(String claveID){
		try{
			FacesContext context=FacesContext.getCurrentInstance();
			Integer bd=(Integer)context.getExternalContext().getSessionMap().get(claveID);
			return bd;
		}catch(Exception ex){
			return 0;
		}
	}
	
	

	
	
	
	
	public List<UsuarioTO> buscarDatos() {
		Statement stmt = null;
		System.out.println("buscar buscar datos");
		
		List<UsuarioTO> listado = new ArrayList<UsuarioTO>();
		
		try{
		try {
		Conecta conecta = new Conecta();
		Connection connection = conecta.getConexion();
		
		String sql = "SELECT * FROM `usuarios` where idusuario="+obtenerValorSesioIDn("identificador")+";";
		CallableStatement callableStatement = connection.prepareCall(sql);
	    callableStatement.execute();
	    
	    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	    ResultSet.CONCUR_UPDATABLE);
	    stmt.setQueryTimeout(30);
	    ResultSet resultSet = stmt.executeQuery(sql);
	    
	    
	    while (resultSet.next()) {
	    	UsuarioTO ms=new UsuarioTO();
	    	ms.setUsuario_id(resultSet.getInt(1));
	    	ms.setNombre(resultSet.getString(2));
	    	ms.setApe1(resultSet.getString(3));
	    	ms.setApe2(resultSet.getString(4));
	    	ms.setUser(resultSet.getString(5));
	    	ms.setPass(resultSet.getString(6));
	    	ms.setCorreo(resultSet.getString(7));
	    	ms.setTelefono(resultSet.getString(8));
	    	
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

	
	
	
	
	

	

	
	
	
	

	public UsuarioTO getUsuarioDato() {
		return usuarioDato;
	}


	public void setUsuarioDato(UsuarioTO usuarioDato) {
		this.usuarioDato = usuarioDato;
	}


	public List<UsuarioTO> getListaDatos() {
		return listaDatos;
	}


	public void setListaDatos(List<UsuarioTO> listaDatos) {
		this.listaDatos = listaDatos;
	}

	public AnuncioTO getAnuncioDato() {
		return anuncioDato;
	}

	public void setAnuncioDato(AnuncioTO anuncioDato) {
		this.anuncioDato = anuncioDato;
	}

	public List<AnuncioTO> getListaAnuncios() {
		return listaAnuncios;
	}

	public void setListaAnuncios(List<AnuncioTO> listaAnuncios) {
		this.listaAnuncios = listaAnuncios;
	}


	
	

	
	
	
}
