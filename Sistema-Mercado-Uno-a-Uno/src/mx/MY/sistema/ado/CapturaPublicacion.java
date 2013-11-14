package mx.MY.sistema.ado;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.CallableStatement;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.MY.sistema.ado.Conecta;
import mx.MY.sistema.beans.AnuncioTO;
import mx.MY.sistema.beans.ArticuloTO;
import mx.MY.sistema.beans.PublicacionTO;

public class CapturaPublicacion {
	
private AnuncioTO anuncio;
private ArticuloTO articulo;
private PublicacionTO publicacion;


                     


public String guardaPublicacion(PublicacionTO publica) {
	
	System.out.println("Metodo guardaPublicacion en base de datos...");
	System.out.println("---"+publica.getTitulo());
    System.out.println("---"+publica.getId_categoria());
    System.out.println("---"+publica.getVigencia());
    
     
    String hoy = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    String convercion=new SimpleDateFormat("yyyy-MM-dd").format(publica.getVigencia());

    System.out.println(convercion+"---"+hoy);
    
    
    
    try{
		
		try {
			Conecta conecta = new Conecta();
			Connection connection = conecta.getConexion();
		
        
	   // String sql = "insert into usuarios(idusuario,nombre,apellidoA,apellidoM,usuario,contrasenia,correo,telefono) values ('0','"+to.getNombre()+"','"+to.getApe1()+"','"+to.getApe2()+"','"+to.getUser()+"','"+to.getPass()+"','"+to.getCorreo()+"','"+to.getTelefono()+"'); ";
		
	    String sql=("INSERT INTO `anuncios_clasificados`.`publicaciones` (`id_publicacion`, `titulo`, `fecha`, `vigencia`, `categorias_id_categoria`, `usuarios_idusuario`) VALUES (NULL, '"+publica.getTitulo()+"','"+hoy+"', '"+convercion+"', '"+publica.getId_categoria()+"', '"+obtenerValorSesioIDn("identificador")+"');"); 
	   
	  	CallableStatement callableStatement = connection.prepareCall(sql);
	    callableStatement.execute();
	    
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Ok se ha Publicado..."));
		
	    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}catch(Exception ex){
		System.out.println("Erro en.."+ex.getMessage());
	}

    
    redireccionar("   ");
    
   
    return "";
}
















			                 /**
							 * Metodo para obtener un valor
							 * @param clave
							 * @return
							 */
							public String obtenerValorSesion(String clave){
								try{
									FacesContext context=FacesContext.getCurrentInstance();
									String bd=(String)context.getExternalContext().getSessionMap().get(clave);
									return bd;
								}catch(Exception ex){
									return "";
								}
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

	public PublicacionTO getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(PublicacionTO publicacion) {
		this.publicacion = publicacion;
	}


	
	   
	   
	   
}

