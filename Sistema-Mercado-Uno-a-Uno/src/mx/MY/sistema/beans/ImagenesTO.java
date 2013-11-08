package mx.MY.sistema.beans;

import org.primefaces.model.StreamedContent;

public class ImagenesTO {
	
	
	private StreamedContent imagen;
    private Integer idImagen;
	private String nombreIM ;
	
	
	
	
	public StreamedContent getImagen() {
		return imagen;
	}
	public void setImagen(StreamedContent imagen) {
		this.imagen = imagen;
	}
	public Integer getIdImagen() {
		return idImagen;
	}
	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
	}
	public String getNombreIM() {
		return nombreIM;
	}
	public void setNombreIM(String nombreIM) {
		this.nombreIM = nombreIM;
	}
	
	
	
		
}
