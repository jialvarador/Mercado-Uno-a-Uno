
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
		        Calendar cal = Calendar.getInstance();
		        cal.setTime(new Date());
		        int diaInt = cal.get(Calendar.DAY_OF_WEEK);
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
		        return "Hoy es: "+dia;

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
				 * Metodo que indica si tiene un rol
				 * @param rol
				 * @return
				 */
				public boolean tieneRol(String rol){
					String valor=obtenerValorSesion(rol);


					if(valor==null)
						return false;
					if(!valor.equals("")){
						return true;
					}else{
						return false;
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