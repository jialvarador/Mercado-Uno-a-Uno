package mx.MY.sistema.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

public class AnuncioTO {
	
  String hoy = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
 	
   private Integer idAnuncio;
   private String titulo;
   private String descripcion;
   private String fecha;
   private Date vigencia;
   
   private UploadedFile image1;
   private UploadedFile image2;
   private UploadedFile image3;
   
   private StreamedContent imageA;
   private StreamedContent imageB;
   private StreamedContent imageC;
   
   private Integer id_usuario;
   private Integer id_categoria;
   private String nombreCategoria;
   
   
   
   
   
   
public String getNombreCategoria() {
	return nombreCategoria;
}
public void setNombreCategoria(String nombreCategoria) {
	this.nombreCategoria = nombreCategoria;
}
public String getHoy() {
	return hoy;
}
public void setHoy(String hoy) {
	this.hoy = hoy;
}
public Integer getIdAnuncio() {
	return idAnuncio;
}
public void setIdAnuncio(Integer idAnuncio) {
	this.idAnuncio = idAnuncio;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
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
public UploadedFile getImage1() {
	return image1;
}
public void setImage1(UploadedFile image1) {
	this.image1 = image1;
}
public UploadedFile getImage2() {
	return image2;
}
public void setImage2(UploadedFile image2) {
	this.image2 = image2;
}
public UploadedFile getImage3() {
	return image3;
}
public void setImage3(UploadedFile image3) {
	this.image3 = image3;
}
public StreamedContent getImageA() {
	return imageA;
}
public void setImageA(StreamedContent imageA) {
	this.imageA = imageA;
}
public StreamedContent getImageB() {
	return imageB;
}
public void setImageB(StreamedContent imageB) {
	this.imageB = imageB;
}
public StreamedContent getImageC() {
	return imageC;
}
public void setImageC(StreamedContent imageC) {
	this.imageC = imageC;
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

   

   
   
}
