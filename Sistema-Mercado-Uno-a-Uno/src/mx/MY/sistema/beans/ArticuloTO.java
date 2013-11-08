package mx.MY.sistema.beans;

import org.primefaces.model.UploadedFile;

public class ArticuloTO {

	private Integer idArticulo;
	private String nombreArticulo;
	private String costo;
	private Integer estatus;
	
	private Integer id_anuncio;
	private Integer id_usuario;
	
	
	private UploadedFile imagen1;
	private UploadedFile imagen2;
	private UploadedFile imagen3;
	
	
	
	
	
	public UploadedFile getImagen1() {
		return imagen1;
	}
	public void setImagen1(UploadedFile imagen1) {
		this.imagen1 = imagen1;
	}
	public UploadedFile getImagen2() {
		return imagen2;
	}
	public void setImagen2(UploadedFile imagen2) {
		this.imagen2 = imagen2;
	}
	public UploadedFile getImagen3() {
		return imagen3;
	}
	public void setImagen3(UploadedFile imagen3) {
		this.imagen3 = imagen3;
	}
	public Integer getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}
	public String getNombreArticulo() {
		return nombreArticulo;
	}
	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	public Integer getId_anuncio() {
		return id_anuncio;
	}
	public void setId_anuncio(Integer id_anuncio) {
		this.id_anuncio = id_anuncio;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
	
	
}
