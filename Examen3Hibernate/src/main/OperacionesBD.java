package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Equipo;
import dominio.Partido;

public class OperacionesBD {

	public Connection getConnection() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/jguerrero", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexion;
	}

	public ArrayList<Equipo> listaEquipos() {
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		try {
			Connection conexion = getConnection();
			Statement sentencia = conexion.createStatement();
			String sql = "Select * from equipo";
			ResultSet resul = sentencia.executeQuery(sql);
			while (resul.next()) {

				Equipo e = new Equipo(resul.getInt("id"), resul.getString("nombre"),
						resul.getString("localidad"));
				equipos.add(e);

			}
			conexion.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (equipos);

	}	
	
	public ArrayList<Partido> listaPartidos() {
		ArrayList<Partido> partidos = new ArrayList<Partido>();
		try {
			Connection conexion = getConnection();
			Statement sentencia = conexion.createStatement();
			String sql = "Select * from partido";
			ResultSet resul = sentencia.executeQuery(sql);
			while (resul.next()) {

				Partido p = new Partido(resul.getInt("id"), resul.getInt("equipo_local"),
						resul.getInt("equipo_visitante"), resul.getInt("goles_local"),
						resul.getInt("goles_visitante"), resul.getInt("jornada"));
				partidos.add(p);

			}
			conexion.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (partidos);

	}	
	

}
