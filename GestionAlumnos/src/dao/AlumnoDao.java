package dao;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import servicios.Conexion;
import utilidades.Alumno;
import utilidades.DaoException;


public class AlumnoDao {

	private List<Alumno> listaAlumnos = new ArrayList<Alumno>();
	
	private String url = "basededatos/jguerrero.db";
	
    private int numMatricula;
    List<Alumno> listaAlumnosEncontradosApellido1 = new ArrayList<Alumno>();
    List<Alumno> listaAlumnosEncontradosApellido2 = new ArrayList<Alumno>();
    
  //Realizamos la conexion al principio del programa.
  	Conexion conexion = new Conexion(url);
  	
  	
  	
	public AlumnoDao() {
		
	}
	
	public void insertar(int numMatricular, String nombre, String apellido1, String apellido2, String horaAlta, String horaModificacion, String dni) throws DaoException{
		//Preparamos la consulta
		try {
			
			Statement sentencia = this.conexion.getConexion().createStatement();
			sentencia.execute("insert into Alumno values('"+numMatricular+"','"+nombre+"','"+apellido1+"','" + apellido2+"','"+horaAlta+"','"+horaModificacion+"','"+dni+"')");
            sentencia.close();
			
		} catch (SQLException e) {
			throw new DaoException("No se ha podido almacenar el alumno", e);
		}
	}
	
	public void update(int numMatricular, String nombre, String apellido1, String apellido2, String horaAlta, String horaModificacion, String dni,String dniAlumnoEdit) throws DaoException{
		//Preparamos la consulta
		try {
			
			Statement sentencia = this.conexion.getConexion().createStatement();
			sentencia.execute("UPDATE Alumno SET numMatricular="+numMatricular+",nombre='"+nombre+"',apellido1='"+apellido1+"',apellido2='" + apellido2+"',horaAlta='"+horaAlta+"',horaModificacion='"+horaModificacion+"',dni='"+dni+"' WHERE dni='"+dniAlumnoEdit+"'");
            sentencia.close();
			
		} catch (SQLException e) {
			throw new DaoException("No se ha podido actualizar los datos del alumno", e);
		}
	}
	
	public int getNumMatricula(){
		//Preparamos la consulta
		try {
			
			Statement sentencia = this.conexion.getConexion().createStatement();
			ResultSet rs = sentencia.executeQuery("select numMatricular from Alumno order by numMatricular desc limit 1");
	        
			while (rs.next()) 
			{ 
				numMatricula = rs.getInt ("numMatricular") + 1;
			}
			rs.close();
          
            sentencia.close();
			
		} catch (SQLException e) {
			try {
				throw new DaoException("No se ha podido obtener el número de la matrícula", e);
			} catch (DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return numMatricula;
	}


	/*
	 * Añadimos el alumno nuevo a la lista que tenemos en memoria y almacenamos
	 * en disco (non-Javadoc)
	 * 
	 */

	public String crear(Alumno alumnoNuevo) throws DaoException {
		String dniAlumno = añadirAlumno(alumnoNuevo);
		//almacenar(listaAlumnos);
		return dniAlumno;
	}

	private String añadirAlumno(Alumno nuevoObjeto) throws DaoException {
		listaAlumnos.add(nuevoObjeto);
		return nuevoObjeto.getDni();
	}


	public void borrar(String dni) throws DaoException {
		//Preparamos la consulta
				try {
					
					Statement sentencia = this.conexion.getConexion().createStatement();
					sentencia.execute("DELETE FROM Alumno WHERE dni='"+dni+"'");
		            sentencia.close();
					
				} catch (SQLException e) {
					throw new DaoException("No se ha podido eliminar el alumno", e);
				}
	}

	private void borrarAlumno(Alumno nuevoObjeto) throws DaoException {
		listaAlumnos.remove(nuevoObjeto);

	}

	/**
	 * Buscamos un alumno si existe en la lista de memoria de alumnos
	 * 
	 * @param alumnoABuscar
	 * @return Si se ha encontrado el alumno o no
	 */
	public boolean existe(Alumno alumnoABuscar) {

		return listaAlumnos.contains(alumnoABuscar);

	}

	
	/**
	 * Buscamos un alumno por dni.
	 * 
	 * @param dni
	 *            El dni del alumno a buscar
	 * @return El alumno encontrado por dni
	 */
	public Alumno buscarAlumnoPorDni(String dni) {

		for (Alumno alumno : listaAlumnos) {
			if (dni.compareToIgnoreCase(alumno.getDni()) == 0)
				return alumno;
		}
		return null;
	}
	
	/**
	 * Buscamos un alumno por nombre.
	 * 
	 * @param nombre
	 *            El nombre del alumno a buscar
	 * @return El alumno encontrado por nombre
	 */
	public Alumno buscarAlumnoPorNombre(String nombre) {

		for (Alumno alumno : listaAlumnos) {
			if (nombre.compareToIgnoreCase(alumno.getNombre().trim()) == 0)
				return alumno;
		}
		return null;
	}
	
	/**
	 * Buscamos un alumno por número de matrícula.
	 * 
	 * @param numMatricula
	 *            El numMatricula del alumno a buscar
	 * @return El alumno encontrado por numMatricula
	 */
	public Alumno buscarAlumnoPorNumMatricula(int numMatricula) {

		for (Alumno alumno : listaAlumnos) {
			if (numMatricula == alumno.getNumMatricular())
				return alumno;
		}
		return null;
	}
	
	/**
	 * Buscamos un alumno por el primer apellido.
	 * 
	 * @param apellido1
	 *            El primer apellido del alumno a buscar
	 * @return El alumno encontrado por apellido1
	 */
	public List<Alumno> buscarAlumnoPorApellido1(String apellido1) {
		listaAlumnosEncontradosApellido1.clear();
		
		for (Alumno alumno : listaAlumnos) {
			if (apellido1.compareToIgnoreCase(alumno.getApellido1().trim()) == 0)
				listaAlumnosEncontradosApellido1.add(alumno);
		}
		return listaAlumnosEncontradosApellido1;
	}
	
	/**
	 * Buscamos lista alumnos por el segundo apellido.
	 * 
	 * @param apellido2
	 *            El segundo apellido del alumno a buscar
	 * @return lista de alumnos encontrados por apellido2
	 */
	public List<Alumno> buscarAlumnoPorApellido2(String apellido2) {
		listaAlumnosEncontradosApellido2.clear();
		for (Alumno alumno : listaAlumnos) {
			if (apellido2.compareToIgnoreCase(alumno.getApellido2().trim()) == 0)
				listaAlumnosEncontradosApellido2.add(alumno);
		}
		return listaAlumnosEncontradosApellido2;
	}
	
	/**
	 * Agregamos los datos de un cliente a una JTable.
	 * 
	 * @param tablaAlumno
	 *            
	 */
	public void agregarDatos(JTable tablaAlumnos, List<Alumno> listaAlumnos){
		
		tablaAlumnos.setModel(new DefaultTableModel());
		DefaultTableModel tableModel = (DefaultTableModel) tablaAlumnos.getModel();
		
		String datos[] = new String[3];
		//tableModel.setColumnIdentifiers(columnNames);
		tableModel.addColumn("Número Alumno");
		tableModel.addColumn("DNI");
		tableModel.addColumn("Nombre");
		
		for (int i = 0; i < listaAlumnos.size(); i++) {
	
			datos[0] = String.valueOf(listaAlumnos.get(i).getNumMatricular());
			datos[1] = listaAlumnos.get(i).getDni();
			datos[2] = listaAlumnos.get(i).getNombre() +" " + listaAlumnos.get(i).getApellido1() +" " + listaAlumnos.get(i).getApellido2() ;
			tableModel.addRow(datos);
		}

	}
	
	/**
	 * Retornamos la lista de alumnos.
	 * 
	 *return listaAlumnos
	 *            
	 */
	
	public List<Alumno> getListaAlumnos() {
		try {
			
			Statement sentencia = this.conexion.getConexion().createStatement();
			ResultSet rs = sentencia.executeQuery("select * from Alumno");
	        
			while (rs.next()) 
			{ 
				Alumno alumno = new Alumno();
				alumno.setNumMatricular(rs.getInt("numMatricular"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellido1(rs.getString("apellido1"));
				alumno.setApellido2(rs.getString("apellido2"));
				alumno.setHoraAlta(rs.getString("horaAlta"));
				alumno.setHoraModificacion(rs.getString("horaModificacion"));
				alumno.setDni(rs.getString("dni"));
	            listaAlumnos.add(alumno);
			}
			rs.close();
          
            sentencia.close();
			
		} catch (SQLException e) {
			try {
				throw new DaoException("No se ha podido obtener la lista de alumnos", e);
			} catch (DaoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
}
