package servicios;

import java.sql.*;

public class Conexion {
	
	private Connection conexion=null;
    //private String servidor="";
    //private String database="";
    //private String usuario="";
    //private String password="";
    //private String url="";
 
    public Conexion(String url){
        try {
        	
        	//Cargar el driver
        	
            //this.servidor = servidor;
            //this.database = database;
 
            try {
				Class.forName("org.sqlite.JDBC").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            url="jdbc:sqlite:" + url;
            
          //Establecemos la conexion con la BD
            this.conexion=DriverManager.getConnection(url);
            System.out.println("Conexion a Base de Datos "+url+" . . . . .Ok");
            
            
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
 
    public Connection getConexion(){
        return this.conexion;
    }
 
    //Metodo que cierra la conexion
    public Connection cerrarConexion(){
        try {
            conexion.close();
             System.out.println("Cerrando conexion a  . . . . . Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conexion=null;
        return conexion;
    }

}
