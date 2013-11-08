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

import mx.MY.sistema.ado.CapturaADO;
import mx.MY.sistema.ado.Conecta;
import mx.MY.sistema.beans.AnuncioTO;


@ManagedBean(name="MostrarAnuncio")
@SessionScoped
public class ControladorClienteTO {
	
	
	private StreamedContent imagen;
	
	private AnuncioTO  anuncio;
	private List<AnuncioTO> listaAnuncio;
	private AnuncioTO      seleccion;
	
	public ControladorClienteTO(){
		inicializar();
		
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
	
	public void inicializar(){
		System.out.println("inicializar EN CLIENTE TO");
		CapturaADO capturaADO = new CapturaADO();
		listaAnuncio=capturaADO.buscarAnuncios();
		anuncio = new AnuncioTO();
	    seleccion= new AnuncioTO();
        
	 }
	
	
	
	public void cargar(){
		System.out.println("**metodo cargar imagenes");
		 try {
			  
	            Conecta conecta = new Conecta();
	    		Connection connection = conecta.getConexion();
	    		
	            String sql = "SELECT imagen1 FROM articulos where idarticulo=4;";
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            ResultSet resultSet = stmt.executeQuery();
	            
	            while (resultSet.next()) {
	            	
	                InputStream is = resultSet.getBinaryStream(1);
	                imagen = new DefaultStreamedContent(is, "image/jpg");
	                		
	                		System.out.println("Sale..."+imagen);
	                		
	                }
	           

	        } catch (Exception e) {
	        }

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


	public StreamedContent getImagen() {
		return imagen;
	}


	public void setImagen(StreamedContent imagen) {
		this.imagen = imagen;
	}
	
	
	


	
	
	
	
	
	
	
	
	

	
}

