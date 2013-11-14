
package mx.MY.sistema.controlador;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import mx.MY.sistema.ado.CapturaLogin;;

	@ManagedBean(name="LoginControlador")
	@SessionScoped
	public class LoginControlador {
		

		private Integer idUsuario;
	    private String  usuario;
		private String  pwd;
		
		//**********************INICIO DE METODOS COMUNES ************** COPIARLOS EN CADA CLASE
		/**
		 * Metodo que cierra la sesion actual
		 */
		public void cerrarSesion(){
			try{
				FacesContext context=FacesContext.getCurrentInstance();
				context.getExternalContext().invalidateSession();//Se borrar valores en sesion
				redireccionar("bienvenido.xhtml");
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
		/**NUEVO METODO PARA SUBIR OTRO VALOR MAS A SESION **/
		
		public void subirValorSesionID(String claveID,Integer idUsuario){
			System.out.println("**SUBO VALOR **"+idUsuario);
			try {
				FacesContext context=FacesContext.getCurrentInstance();
				context.getExternalContext().getSessionMap().put(claveID, idUsuario);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		
		
		/**
		 * Metodo que muestra un mensaje en pantalla
		 * @param mensaje
		 */
		public void mostrarMensaje(String mensaje){
			System.out.println("mostrando mensaje...");
			
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
		
		public void ingresar(){
			System.out.println("***llamando metodo sesion***");
			try{
				FacesContext context=FacesContext.getCurrentInstance();
				context.getExternalContext().invalidateSession();
			}catch(Exception ex){
				
			}
			CapturaLogin c=new CapturaLogin();
			String resultado=c.validarIngreso(idUsuario,usuario,pwd);
			Integer idUsuario=c.encontrarId(usuario,pwd);
			System.out.println("BUSCO ID Y ENCUENTRO..."+idUsuario);
			
			String lista[]=resultado.split("@");
			if(lista[0].equals("1")){//SI ESTA LOGUEADO CARGAR LOS ROLES
				System.out.println("SI ESTOY....");
				//string clave y string valor
				subirValorSesion("administrador",usuario);
				//Se sube a sesion la clave del usuario para cualquier dato posterior
				subirValorSesionID("identificador",idUsuario);
				mostrarMensaje(lista[1]);
				redireccionar("index.xhtml");
				System.out.println("REDIRECCIONANDO....");
				return;
			}else{

				mostrarMensaje(lista[1]);
				redireccionar("bienvenido.xhtml");
				return;
			}
		}
		
		

		public Integer getNombre() {
			return idUsuario;
		}

		public void setNombre(Integer nombre) {
			this.idUsuario = nombre;
		}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		
		
	}