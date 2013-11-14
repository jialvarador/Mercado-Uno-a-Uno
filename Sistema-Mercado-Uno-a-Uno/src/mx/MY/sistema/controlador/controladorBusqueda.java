package mx.MY.sistema.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.StreamedContent;

import mx.MY.sistema.ado.ConsultaBusqueda;
import mx.MY.sistema.beans.AnuncioTO;
import mx.MY.sistema.beans.ArticuloTO;


@ManagedBean(name="BuscarCategoria")
@SessionScoped
public class controladorBusqueda {
	
	private StreamedContent imagen;
	
	private List<ArticuloTO> listaArticulos;
	private List<AnuncioTO>listaAnuncio;
	private AnuncioTO anuncio;
	private ArticuloTO articulo;
    private Integer categoriaID;
    
	
    public controladorBusqueda(){
		
	
    }
	
	
	
	public void buscarPorCategoria(){
		System.out.println("buscar por categoria "+categoriaID);
		if(categoriaID==0){System.out.println("ninguna");
			redireccionar(" ");
			categoriaID=0;
		}
       
		if(categoriaID==1 || categoriaID==2 ||  categoriaID==3){
			articulo= new ArticuloTO();
		    ConsultaBusqueda consultaBusqueda = new ConsultaBusqueda();
		    listaArticulos=consultaBusqueda.buscarArticulosPorCategoria(categoriaID);
			System.out.println("es venta");
			redireccionar("busqueda.xhtml");
			categoriaID=0;
		}
    
		
		if(categoriaID==4){
        	System.out.println("es anuncio");
        	anuncio= new AnuncioTO();
		    ConsultaBusqueda consultaBusqueda = new ConsultaBusqueda();
		    listaAnuncio=consultaBusqueda.buscarAnuncios(categoriaID);
		    redireccionar("busqueda.xhtml");
		}
	
	
	}
	
	
	/**
	 * Metodo que redirecciona a la pagina indicada
	 * @param ruta
	 */
	public void redireccionar(String ruta){
		try{
			
			
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			FacesContext context=FacesContext.getCurrentInstance();  
			
			context.getExternalContext().redirect(ruta);
		
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}


	public StreamedContent getImagen() {
		return imagen;
	}


	public void setImagen(StreamedContent imagen) {
		this.imagen = imagen;
	}


	public List<ArticuloTO> getListaArticulos() {
		return listaArticulos;
	}


	public void setListaArticulos(List<ArticuloTO> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}


	public List<AnuncioTO> getListaAnuncio() {
		return listaAnuncio;
	}


	public void setListaAnuncio(List<AnuncioTO> listaAnuncio) {
		this.listaAnuncio = listaAnuncio;
	}



	public ArticuloTO getArticulo() {
		return articulo;
	}


	public void setArticulo(ArticuloTO articulo) {
		this.articulo = articulo;
	}


	public Integer getCategoriaID() {
		return categoriaID;
	}


	public void setCategoriaID(Integer categoriaID) {
		this.categoriaID = categoriaID;
	}



	public AnuncioTO getAnuncio() {
		return anuncio;
	}



	public void setAnuncio(AnuncioTO anuncio) {
		this.anuncio = anuncio;
	}






	
	
	
	
	
	
	

	
}

