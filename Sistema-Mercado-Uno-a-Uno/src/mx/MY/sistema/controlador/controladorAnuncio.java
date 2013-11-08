package mx.MY.sistema.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FlowEvent;
import mx.MY.sistema.ado.CapturaAnuncio;
import mx.MY.sistema.beans.AnuncioTO;
import mx.MY.sistema.beans.ArticuloTO;


@ManagedBean(name="Publicar")
@SessionScoped

public class controladorAnuncio {
	
	private AnuncioTO anuncio = new AnuncioTO();
	private ArticuloTO articulo;
	
	private boolean skip;
	
	private List<AnuncioTO> publicarAll = new ArrayList<AnuncioTO>();
    private static Logger logger= Logger.getLogger(controladorAnuncio.class.getName());
	
	 public controladorAnuncio(){
			inicializar();
		}

	   private void inicializar() {
		   System.out.println("inicializar");
		    anuncio = new AnuncioTO();
		    articulo=new ArticuloTO();
		  }
	   

public void save(ActionEvent actionEvent) {
    //Persist user
    publicarAll.add(anuncio);
    anuncio = new AnuncioTO();
    FacesMessage msg = new FacesMessage("Successful", "Welcome :" );
    FacesContext.getCurrentInstance().addMessage(null, msg);

}
	   

public boolean isSkip() {
    return skip;
}

public void setSkip(boolean skip) {
    this.skip = skip;
}


	   public void guardar(){
			
			System.out.println("guardar");
		    CapturaAnuncio capturaAnuncio = new CapturaAnuncio();
			String resultado="";
			
			if(anuncio.getIdAnuncio()==null){
				resultado=capturaAnuncio.guardaAnuncio(anuncio);
				resultado=capturaAnuncio.guardarArticulos(articulo);
			}
			
			else{
				
			}
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(resultado));
			inicializar();
		  
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

public List<AnuncioTO> getPublicarAll() {
	return publicarAll;
}

public void setPublicarAll(List<AnuncioTO> publicarAll) {
	this.publicarAll = publicarAll;
}



	
}
