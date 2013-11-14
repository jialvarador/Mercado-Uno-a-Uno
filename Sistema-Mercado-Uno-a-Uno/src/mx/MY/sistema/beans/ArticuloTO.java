package mx.MY.sistema.beans;

public class ArticuloTO {

	private Integer idArticulo;
	private String nombreArticulo;
	private String descripcion;
	private String costo;
	private Integer disponibilidad;
	private Integer id_publicacion;
	
	
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public Integer getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(Integer disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public Integer getId_publicacion() {
		return id_publicacion;
	}
	public void setId_publicacion(Integer id_publicacion) {
		this.id_publicacion = id_publicacion;
	}
	
	
	
}
