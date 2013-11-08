
package mx.MY.sistema.ado;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conecta {
	
	private static Connection connection=null;
	
	public Connection getConexion(){
	
		if(connection==null){
			try {
			
			Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/anuncios_clasificados";
            connection = DriverManager.getConnection(url, "root", "1111");
				
				System.out.println("Obteniendo conexion de mysql.....\n");
				System.out.println("Conectando a base de datos anuncios_clasficados....");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		}
		return connection;
	}

}