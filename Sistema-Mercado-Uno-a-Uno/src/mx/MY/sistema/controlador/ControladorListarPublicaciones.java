package mx.MY.sistema.controlador;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import mx.MY.sistema.ado.ConsultaPublicaciones;
import mx.MY.sistema.beans.PublicacionTO;


@ManagedBean(name="MostrarPublicacion")
@SessionScoped



public class ControladorListarPublicaciones {

	private String imagen;
	private PublicacionTO publicacion;
	private List<PublicacionTO> listaPublicacion;
	private PublicacionTO		seleccion;

	
public ControladorListarPublicaciones(){
	    inicializar();
	  	
	  
	}
	
	
public void inicializar(){
	
	     
	    seleccion= new PublicacionTO();
	    publicacion= new PublicacionTO();
	    System.out.println("Metodo inicializar en ControladorPublicacion....");
	    ConsultaPublicaciones consultaPublicacion = new ConsultaPublicaciones();
	    listaPublicacion=consultaPublicacion.buscarPublicaciones();
	    
	}
	

public void eliminar(){
     System.out.println("Eliminar");
     System.out.println(seleccion+" \n  id de la publicacion seleccionada es: "+seleccion.getIdPublicacion()+" \n fecha de la seleccion"+seleccion.getFecha());
    
	//CapturaADO c = new CapturaADO();
	//String resultado = c.eliminar(seleccion);
	
	FacesContext context = FacesContext.getCurrentInstance();
	context.addMessage(null, new FacesMessage("selecciono "+seleccion.getIdPublicacion()));

	inicializar();
}
	


	public String getImagen() {
	return imagen;
}


public void setImagen(String imagen) {
	this.imagen = imagen;
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



	public PublicacionTO getSeleccion() {
		return seleccion;
	}



	public void setSeleccion(PublicacionTO seleccion) {
		this.seleccion = seleccion;
	}
	
	
	


	
}

