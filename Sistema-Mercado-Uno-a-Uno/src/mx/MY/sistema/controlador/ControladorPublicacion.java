package mx.MY.sistema.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import mx.MY.sistema.beans.AnuncioTO;
import mx.MY.sistema.beans.ArticuloTO;
import mx.MY.sistema.beans.ImagenesTO;
import mx.MY.sistema.beans.PublicacionTO;
import mx.MY.sistema.ado.CapturaPublicacion;


@ManagedBean(name="Publicar")
@SessionScoped

public class ControladorPublicacion {
	
	private AnuncioTO anuncio = new AnuncioTO();
	private ArticuloTO articulo=new ArticuloTO();
	private PublicacionTO publicacion = new PublicacionTO();
    private ImagenesTO imagenes=new ImagenesTO();
    
    
    
	private boolean skip;
	
	private List<PublicacionTO> publicarAll = new ArrayList<PublicacionTO>();
    private static Logger logger= Logger.getLogger(ControladorPublicacion.class.getName());
	
	 public ControladorPublicacion(){
			inicializar();
		}

	   private void inicializar() {
		   System.out.println("inicializar");
		    anuncio = new AnuncioTO();
		    articulo=new ArticuloTO();
		  }
	   
	   

public boolean isSkip() {
    return skip;
}

public void setSkip(boolean skip) {
    this.skip = skip;
}


	public void guardar(){
		
		
		System.out.println("ControladorPublicacion Guardar...");
		System.out.println("-------------BEANS PUBLICACION-----------------------");
	    System.out.println("Valores-----"+publicacion.getTitulo());
		System.out.println("Valores-----"+publicacion.getId_categoria());
		System.out.println("Valores-----"+publicacion.getVigencia());
		System.out.println("Valores-----"+publicacion.getFecha());
		System.out.println("-------------BEANS ANUNCIOS---------------------------");
        System.out.println("Valores-----"+anuncio.getNombreAnuncio());
        System.out.println("Valores-----"+anuncio.getDescripcion());
        System.out.println("-------------BEANS ARTICULOS---------------------------");
        System.out.println("Valores-----"+articulo.getNombreArticulo());
		System.out.println("Valores-----"+articulo.getDescripcion());
		System.out.println("Valores-----"+articulo.getCosto());
		
		
		CapturaPublicacion capturaPublicacion = new CapturaPublicacion();
			
	    if(publicacion.getId_categoria()==1 || publicacion.getId_categoria()==2 || publicacion.getId_categoria()==3){
				System.out.println("SI es vender, rentar, articulos perdios");
			    capturaPublicacion.guardaPublicacion(publicacion);
			
				//    resultado=capturaPublicacion.guardarArticulos(articulo);	
			    
				//FacesContext context = FacesContext.getCurrentInstance();
				//context.addMessage(null, new FacesMessage("Hecho..."));
			//	redireccionar("index.xhtml");
				
				//inicializar();

		  }
			
		   	if(publicacion.getId_categoria()==4){
				System.out.println("SI es anunciar");
		        capturaPublicacion.guardaPublicacion(publicacion);
		//		resultado=capturaPublicacion.guardarAnuncios(anuncio);
				
		//		FacesContext context = FacesContext.getCurrentInstance();
		///		context.addMessage(null, new FacesMessage("Hecho..."));
		//		redireccionar("");
				
			//	inicializar();

		  }
			
			
	}
	   
	   public String onFlowProcess(FlowEvent event) {
		    logger.info("Current wizard step:" + event.getOldStep());
		    logger.info("Siguiente paso:" + event.getNewStep());
		   if (skip) {
		        skip = false;   //reset in case user goes back
		        return "confirm";
		    } else {

		        return event.getNewStep();
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
	
	   
	   
	   
	   
	   
	   
	   
	   
	public AnuncioTO getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(AnuncioTO anuncio) {
		this.anuncio = anuncio;
	}
    
	
	

public ArticuloTO getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloTO articulo) {
		this.articulo = articulo;
	}

public AnuncioTO getPublicar() {
	return anuncio;
}

public void setPublicar(AnuncioTO publicar) {
	this.anuncio = publicar;
}

public List<PublicacionTO> getPublicarAll() {
	return publicarAll;
}

public void setPublicarAll(List<PublicacionTO> publicarAll) {
	this.publicarAll = publicarAll;
}

public PublicacionTO getPublicacion() {
	return publicacion;
}

public void setPublicacion(PublicacionTO publicacion) {
	this.publicacion = publicacion;
}

public ImagenesTO getImagenes() {
	return imagenes;
}

public void setImagenes(ImagenesTO imagenes) {
	this.imagenes = imagenes;
}



	
}
