package mx.MY.sistema.controlador;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import mx.MY.sistema.ado.ConsultaDatosADO;
import mx.MY.sistema.ado.Conecta;
import mx.MY.sistema.beans.AnuncioTO;
import mx.MY.sistema.beans.UsuarioTO;


@ManagedBean(name="MostrarDatos")
@SessionScoped
public class controladorCuentaUsuario {
	
	private StreamedContent imagen;
	
	private AnuncioTO anuncioDato;
	private UsuarioTO usuarioDato;
    
	private List<UsuarioTO> listaDatos;
    private List<AnuncioTO> listaAnuncios;
    
    public controladorCuentaUsuario(){
		inicializar();
		cargar();
	}
	
	
	public void inicializar(){
		cargar();
		System.out.println("inicializar EN CLIENTE TO");
		
		ConsultaDatosADO consultaDatosADO=new ConsultaDatosADO();
		listaDatos=consultaDatosADO.buscarDatos();
		usuarioDato=new UsuarioTO();
		
		 cargar();
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
	
	
	
	public void cargar(){
		
		 try {
			  
	            Conecta conecta = new Conecta();
	    		Connection connection = conecta.getConexion();
	    		
	            String sql = "SELECT nombre, imagen FROM imagenes where='"+obtenerValorSesioIDn("identificador")+"';";
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            ResultSet resultSet = stmt.executeQuery();
	            while (resultSet.next()) {
	                InputStream is = resultSet.getBinaryStream(2);
	                imagen = new DefaultStreamedContent(is, "image/jpg");
	                		
	                		System.out.println("Sale en cuenta.."+imagen);
	                		
	                		
	                    }
	           

	        } catch (Exception e) {
	        }

	}


	

	

	public StreamedContent getImagen() {
		return imagen;
	}


	public void setImagen(StreamedContent imagen) {
		this.imagen = imagen;
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

