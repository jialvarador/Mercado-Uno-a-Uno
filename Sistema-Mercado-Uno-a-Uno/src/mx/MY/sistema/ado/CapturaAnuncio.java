package mx.MY.sistema.ado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import mx.MY.sistema.beans.AnuncioTO;
import mx.MY.sistema.beans.ArticuloTO;

public class CapturaAnuncio {
	
private AnuncioTO anuncio;
private ArticuloTO articulo;
   
       
@SuppressWarnings("unused")

private void inicializar() {
	   System.out.println("inicializar EN CAPTURA");
	    CapturaUsuario capturaUsuario = new CapturaUsuario(); 
	    anuncio = new AnuncioTO();
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

       @SuppressWarnings("unused")
	public String guardaAnuncio(AnuncioTO to){
    	   Statement stmt = null;
    	   Integer id = null;
    	   List<AnuncioTO> listado = new ArrayList<AnuncioTO>();
    		
    	   
    	    /**1-Ventas:
    		   2-Rentas: 	
    		   3-Artículos perdidos:
    		   4-Anuncios:**/
    	   
    	   
    	 if(to.getId_categoria()==1){
    		   System.out.println("ESTA CATEGORIA ES VENTA..");
    		
				String nombre = "administrador";
				String resul=" ";
				System.out.println("***insertando a mysql el anuncio...."+obtenerValorSesion(nombre));
				System.out.println("BEANS..."+to.getTitulo()+" "+to.getDescripcion()+" "+to.getFecha()+" "+to.getId_categoria());
				resul=obtenerValorSesion(nombre);
				
		try{
				
				try {
		  
		   Conecta conecta = new Conecta();
	       Connection connection = conecta.getConexion();
		   String hoy = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	       String convercion=new SimpleDateFormat("yyyy-MM-dd").format(to.getVigencia());

	        String sql1="INSERT INTO `anuncios_clasificados`.`anuncios` (`idanuncio`, `titulo`, `descripcion`, `fecha`, `vigencia`,`usuarios_idusuario`, `categorias_idcategoria`) " +
		   "VALUES (NULL, '"+to.getTitulo()+"','"+to.getDescripcion()+"', '"+hoy+"', '"+convercion+"','"+obtenerValorSesioIDn("identificador")+"', '"+to.getId_categoria()+"');"; 
	      	CallableStatement callableStatement1 = connection.prepareCall(sql1);
		    callableStatement1.execute();
		    
		    /*****************************************************/
		    
		    String sql2 = "SELECT max(anuncios.idanuncio) as id FROM anuncios;";
			CallableStatement callableStatement2 = connection.prepareCall(sql2);
		    callableStatement2.execute();
		    
		    stmt=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		    ResultSet.CONCUR_UPDATABLE);
		    stmt.setQueryTimeout(30);
		    ResultSet resultSet = stmt.executeQuery(sql2);
		    
		    
		    while (resultSet.next()) {
		    	
		    	AnuncioTO ms=new AnuncioTO();
		    	id=resultSet.getInt(1);
		    	
		        
		    	listado.add(ms);
		    	System.out.println("Ultimo anuncio id "+id);
		    }
		  
		    FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(to.getTitulo()));
			
			return "Se ha publicado ! ";
				
				    
					} catch (Exception e) {
						e.printStackTrace();
					}
				}catch(Exception ex){
					System.out.println("Erro en.."+ex.getMessage());
				}
		
				return "error";
			
    	   }

    	   if(to.getId_categoria()==2){
    		   System.out.println("ESTA CATEGORIA ES RENTAS..");
    		   FacesContext context = FacesContext.getCurrentInstance();
			   context.addMessage(null, new FacesMessage("SE PUBLICO..."));
			   
    	   }
    	   if(to.getId_categoria()==3){
    		   System.out.println("ESTA CATEGORIA ES ARTICULOS PERDIDOS..");
    		   FacesContext context = FacesContext.getCurrentInstance();
			   context.addMessage(null, new FacesMessage("SE PUBLICO..."));
		
    	   }
    	   if(to.getId_categoria()==4){
    		   System.out.println("ESTA CATEGORIA ES ANUNCIOS..");
               FacesContext context = FacesContext.getCurrentInstance();
			   context.addMessage(null, new FacesMessage("SE PUBLICO..."));
			   redireccionar("index.xhtml");
	           
		
    	   }
		return null;
    	   
			
		}
       
       
       
       public String guardarArticulos(ArticuloTO articulo) {
   		
   		
   		
   		
   		// Create connection
   		try {
   			// Load driver
   			Conecta conecta = new Conecta();
   			Connection connection = conecta.getConexion();
   			// Connect to the database
   			// Set autocommit to false to manage it by hand
   			connection.setAutoCommit(false);
   			
   			// Create the statement object
   			PreparedStatement statement = connection.prepareStatement("INSERT INTO `anuncios_clasificados`.`articulos`(`idarticulos`, `nombre`, `costo`, `estatus`, `imagen1`, `usuarios_idusuario`, `anuncios_idanuncio`) VALUES (null,'coche','500 pesos','1',?,'1','1')");
   			// Set file data
   			statement.setBinaryStream(1, articulo.getImagen1().getInputstream());
   			System.out.println("iniciando conexion....");
   			// Insert data to the database
   			statement.executeUpdate();
   			
   			// Commit & closeS
   			connection.commit();	// when autocommit=false
   			
   		 redireccionar("index.xhtml");
			
   		} catch (Exception e) {
   			e.printStackTrace();
   			
   			// Add error message
   		}
   		
   		
   		
   		return null;

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

	
	   
	   
	   
}

