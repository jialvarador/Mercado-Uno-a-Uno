package mx.MY.sistema.beans;

import java.util.Date;

public class PublicacionTO {
	
	   private Integer idPublicacion;
	   private String titulo;
	   private String fecha;
	   private Date vigencia;
	   
	   private Integer id_usuario;
	   private Integer id_categoria;
	   private String nombreCategoria;
	   
	   
	   
	   
	public Integer getIdPublicacion() {
		return idPublicacion;
	}
	public void setIdPublicacion(Integer idPublicacion) {
		this.idPublicacion = idPublicacion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Date getVigencia() {
		return vigencia;
	}
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Integer getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	   
	   
	   
}
