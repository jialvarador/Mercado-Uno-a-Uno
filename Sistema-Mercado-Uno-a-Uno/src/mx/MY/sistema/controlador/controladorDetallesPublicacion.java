package mx.MY.sistema.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.StreamedContent;

import mx.MY.sistema.ado.ConsultaDetallesPublicacion;
import mx.MY.sistema.beans.DetallesPublicacionTO;
import mx.MY.sistema.beans.PublicacionTO;


@ManagedBean(name="MostrarDetalles")
@SessionScoped
public class controladorDetallesPublicacion {
	private Integer ID=3;
	private StreamedContent imagen;

	private PublicacionTO seleccion;

	private DetallesPublicacionTO todo;
	private List<DetallesPublicacionTO> listaTodo;
    
    
    public controladorDetallesPublicacion(){
		inicializar();
	}
	
	
	public void inicializar(){
		System.out.println("inicializar EN CLIENTE TO mas....."+ID);
	    ConsultaDetallesPublicacion detallesPublicacion = new ConsultaDetallesPublicacion();
		detallesPublicacion.CategoriaPublicacion();
	    listaTodo=detallesPublicacion.buscarDetallesPublicaciones(ID);
		todo=new DetallesPublicacionTO();
	}
	
	
	public void acer(){
	     System.out.println(seleccion.getIdPublicacion());
		 ConsultaDetallesPublicacion detallesPublicacion = new ConsultaDetallesPublicacion();
		 ID=detallesPublicacion.buscarPublicaciones(seleccion.getIdPublicacion());
		 
		 System.out.println("CATEGORIA----"+ID);
		 inicializar();
		 redireccionar("verPublicacion.xhtml");
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
	
	
	
	/**
	 * Metodo que redirecciona a la pagina indicada
	 * @param ruta
	 */
	public void redireccionar(String ruta){
		
		 System.out.println("metodo redireccion de pagina");
		
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


	public PublicacionTO getSeleccion() {
		return seleccion;
	}


	public void setSeleccion(PublicacionTO seleccion) {
		this.seleccion = seleccion;
	}


	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}

	
	
   

	
	
	
	
	
	
	
	
	

	
}

