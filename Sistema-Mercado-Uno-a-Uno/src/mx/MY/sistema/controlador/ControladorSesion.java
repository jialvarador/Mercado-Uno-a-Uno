
package mx.MY.sistema.controlador;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

	@ManagedBean(name="ControladorSesion")
	@SessionScoped
	public class ControladorSesion {

		
	/** obtener fecha en la vista **/
		
		public String obtenerFecha(){

			  String dia = "";
			  String MES="";
			  
			  
		        Calendar cal = Calendar.getInstance();
		        cal.setTime(new Date());
               		      
		        int diaInt = cal.get(Calendar.DAY_OF_WEEK);
		        int diaLt= cal.get(Calendar.DAY_OF_MONTH);
		        int me=cal.get(Calendar.MONTH);	
		        int anio=cal.get(Calendar.YEAR);
		        int mes=me+1;	
		        	
		        	
		        switch (diaInt) {
		            case 1:
		                dia = "Domingo";
		                break;
		            case 2:
		                dia = "Lunes";
		                break;
		            case 3:
		                dia = "Martes";
		                break;
		            case 4:
		                dia = "Miercoles";
		                break;
		            case 5:
		                dia = "Jueves";
		                break;
		            case 6:
		                dia = "Viernes";
		                break;
		            case 7:
		                dia = "Sabado";
		                break;

		        }
		        
		        
		    	
		        switch (mes) {
		            case 1:
		            	MES= "Enero";
		                break;
		            case 2:
		            	MES = "Febrero";
		                break;
		            case 3:
		            	MES = "Marzo";
		                break;
		            case 4:
		            	MES = "Abril";
		                break;
		            case 5:
		            	MES = "Mayo";
		                break;
		            case 6:
		            	MES = "Junio";
		                break;
		            case 7:
		            	MES = "Julio";
		                break;
		            case 8:
		            	MES = "Agosto";
		                break;
		            case 9:
		            	MES = "Septiembre";
		                break;
		            case 10:
		            	MES = "Octubre";
		                break;
		            case 11:
		            	MES = "Noviembre";
		                break;
		            case 12:
		            	MES = "Diciembre";
		                break;

		                

		        }
		        
		        
		        return " "+dia +" "+diaLt+" de "+MES+" de "+anio;

		}
	
		
		
		
		//**********************INICIO DE METODOS COMUNES ************** COPIARLOS EN CADA CLASE
				
				/**
				 * Metodo que cierra la sesion actual
				 */
				public void cerrarSesion(){
					try{
						FacesContext context=FacesContext.getCurrentInstance();
						context.getExternalContext().invalidateSession();//Se borrar valores en sesion
						redireccionar("index.xhtml");
					}catch(Exception ex){
						
					}
				}
		
				/**
				 * Metodo que indica si tiene una sesion activa
				 * @param rol
				 * @return
				 */
				public boolean tieneSesion(String activo){
					String valor=obtenerValorSesion(activo);

					if(valor==null)
						return false;
					if(!valor.equals("")){
						return true;
					}else{
						return false;
					}
				}
				
				/**
				 * Metodo que indica si tiene una sesion activa
				 * @param activa
				 * @return
				 */
				public boolean ocultarEnSesion(String oculta){
					String valor=obtenerValorSesion(oculta);
					
					if(valor==null)
						return true;
					
					if(!valor.equals("")){
					   return false;
					}
					
					else{
						return true;
					}
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
				 * Metodo para subir un valor a sesion
				 * @param clave
				 * @param valor
				 */
				public void subirValorSesion(String clave,String valor){
					try {
						FacesContext context=FacesContext.getCurrentInstance();
						context.getExternalContext().getSessionMap().put(clave, valor);
					} catch (Exception e) {
						e.printStackTrace();
						
					}
				}
				
				/**
				 * Metodo que muestra un mensaje en pantalla
				 * @param mensaje
				 */
				public void mostrarMensaje(String mensaje){
					System.out.println("Metodo Mostrar Mensaje..");
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage(mensaje));
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
				
				//**********************FIN DE METODOS COMUNES ************** COPIARLOS EN CADA CLASE
				
		
		
		
	}