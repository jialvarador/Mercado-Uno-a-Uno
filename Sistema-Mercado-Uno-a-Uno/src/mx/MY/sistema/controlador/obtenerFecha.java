package mx.MY.sistema.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="Hoy")
@SessionScoped

public class obtenerFecha {
	
	String hoy = new SimpleDateFormat("yyyy-dd-MM").format(new Date());

	public String getHoy() {
		return hoy;
	}

	public void setHoy(String hoy) {
		this.hoy = hoy;
	}
    
}
