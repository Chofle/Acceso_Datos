import java.util.List;
import java.util.Scanner;

import comun.dominio.Equipo;
import comun.dominio.Partido;
import comun.factorias.FactoryServicios;

public class Main {
	
	static Scanner Teclado;
	static List<Equipo> equipos;
	static List<Partido> partidos;
	public static void main(String[] args) {
		
		//Equipo equipo = FactoryServicios.getEquipoServicios().buscarEquipoPorId(1);
		//System.out.println(equipo.toString());		
		
		//Partido partido = FactoryServicios.getPartidoServicios().buscarPartidoPorId(1);
		//System.out.println(partido.toString());
		
		
		Teclado = new Scanner(System.in);
		Menu();
		
	}
	
	private static void Menu() {

		int OP = -1;

		while (OP != 0) {
			System.out.println("1. Alta Equipo");
			System.out.println("2. Baja Equipo");
			System.out.println("3. Editar Equipo");
			System.out.println("4. Listado de Equipos");
			System.out.println("5. Alta Partido");
			System.out.println("6. Baja Equipo");
			System.out.println("7. Editar Equipo");
			System.out.println("8. Listado de Equipos");
			
			OP = Integer.parseInt(Teclado.nextLine());

			switch (OP) {
			case 1:
				addEquipo();
				break;
			case 2:
				deleteEquipo();
				break;
			case 3:
				editarEquipo();
				break;
			case 4:
				listEquipos();
				break;
			case 5:
				addPartido();
				break;
			case 6:
				deletePartido();
				break;
			case 7:
				editarPartido();
				break;
			case 8:
				listPartidos();
				break;
			default:
				if (OP != 0)
					System.out.println("Opción no válida.");
				break;
			}

		}

	}
	
	private static void addEquipo() {
		String nombre, localidad;
		
		System.out.println("Nombre: ");
		nombre = Teclado.nextLine();
		System.out.println("Localidad: ");
		localidad = Teclado.nextLine();
		
		Equipo equipo = new Equipo(nombre, localidad);
		FactoryServicios.getEquipoServicios().insertarNuevoEquipo(equipo);
		
		System.out.println("");

	}
	
	private static void addPartido() {
		int  idEquipoLocal, idEquipoVisitante, golesLocal, golesVisitante, jornada;
		
		System.out.println("Id Equipo Local: ");
		idEquipoLocal = Integer.valueOf(Teclado.nextLine());
		
		System.out.println("Id Equipo Visitante: ");
		idEquipoVisitante = Integer.valueOf(Teclado.nextLine());
		
		System.out.println("Goles Equipo Local: ");
		golesLocal = Integer.valueOf(Teclado.nextLine());
		
		System.out.println("Goles Equipo Visitante: ");
		golesVisitante = Integer.valueOf(Teclado.nextLine());
		
		System.out.println("Jornada: ");
		jornada = Integer.valueOf(Teclado.nextLine());
		
		Partido partido = new Partido(idEquipoLocal, idEquipoVisitante, golesLocal, golesVisitante, jornada);
		
		FactoryServicios.getPartidoServicios().insertarNuevoPartido(partido);
		
		System.out.println("");

	}
	
	private static void editarEquipo(){
		
		System.out.println("Id del equipo que se quiere editar: ");
		int id = Integer.parseInt(Teclado.nextLine());
		
		Equipo equipo = FactoryServicios.getEquipoServicios().buscarEquipoPorId(id);
		
		System.out.println("Nombre: " + equipo.getNombre());
		
		String nombre = Teclado.nextLine();
		
		if(!nombre.equals("")){
			equipo.setNombre(nombre);
		}
				
		System.out.println("Localidad: " + equipo.getLocalidad());
		
		String localidad = Teclado.nextLine();
		
		if(!localidad.equals("")){
			equipo.setLocalidad(localidad);
		}
		
		System.out.println("¿Seguro que quieres actualizar este equipo? S/N");
		String confirmacion = Teclado.nextLine();
		
		if(confirmacion.equalsIgnoreCase("S")){
		
			FactoryServicios.getEquipoServicios().editarEquipo(equipo);
		}
	}
	
	private static void editarPartido(){
		
		System.out.println("Id del partido que se quiere editar: ");
		int id = Integer.parseInt(Teclado.nextLine());
		
		Partido partido = FactoryServicios.getPartidoServicios().buscarPartidoPorId(id);	
		
		System.out.println("Id Equipo Local: " + partido.getEquipo_local());
		
		if(!Teclado.nextLine().equals("")){
		
			int idEquipoLocal = Integer.valueOf(Teclado.nextLine());
			partido.setEquipo_local(idEquipoLocal);
		}
		
		System.out.println("Id Equipo Visitante: " + partido.getEquipo_visitante());
		
		if(!Teclado.nextLine().equals("")){
			
			int idEquipoVisitante = Integer.valueOf(Teclado.nextLine());
			partido.setEquipo_visitante(idEquipoVisitante);
		}
				
		System.out.println("Goles Equipo Local: " + partido.getGoles_local());
		
		if(!Teclado.nextLine().equals("")){
			
			int golesLocal = Integer.valueOf(Teclado.nextLine());
			partido.setGoles_local(golesLocal);
		}
		
		System.out.println("Goles Equipo Visitante: " + partido.getGoles_visitante());
		
		if(!Teclado.nextLine().equals("")){
			
			int golesVisitante = Integer.valueOf(Teclado.nextLine());
			partido.setGoles_visitante(golesVisitante);
		}
		
		System.out.println("Jornada: " + partido.getJornada());
		
		if(!Teclado.nextLine().equals("")){
			
			int jornada = Integer.valueOf(Teclado.nextLine());
			partido.setJornada(jornada);
		}
		
		
		
		System.out.println("¿Seguro que quieres actualizar este partido? S/N");
		String confirmacion = Teclado.nextLine();
		
		if(confirmacion.equalsIgnoreCase("S")){
		
			FactoryServicios.getPartidoServicios().editarPartido(partido);
		}
	}
	
	private static void deleteEquipo() {
		int id;
		System.out.println("Id del equipo para borrar: ");
		id = Integer.parseInt(Teclado.nextLine());
		
		System.out.println("¿Seguro que quieres borrar este equipo? S/N");
		String confirmacion = Teclado.nextLine();
		
		if(confirmacion.equalsIgnoreCase("S")){
		
			Equipo equipo = FactoryServicios.getEquipoServicios().buscarEquipoPorId(id);
			FactoryServicios.getEquipoServicios().borrarEquipo(equipo);
			
			System.out.println("");
		}
		
	}
	
	private static void deletePartido() {
		int id;
		System.out.println("Id del partido para borrar: ");
		id = Integer.parseInt(Teclado.nextLine());
		
		System.out.println("¿Seguro que quieres borrar este partido? S/N");
		String confirmacion = Teclado.nextLine();
		
		if(confirmacion.equalsIgnoreCase("S")){
		
			Partido partido = FactoryServicios.getPartidoServicios().buscarPartidoPorId(id);
			FactoryServicios.getPartidoServicios().borrarPartido(partido);
			
			System.out.println("");
		}
		
	}
	
	private static void listEquipos() {
		
		equipos = FactoryServicios.getEquipoServicios().buscarEquipos();
		
		System.out.println("Id  --  Equipos  --  Localidades");
				
		for (int i = 0; i < equipos.size(); i++) {
			System.out.println(equipos.get(i).toString());
			System.out.println("----------------------------------");
		}
		
		System.out.println("");
	}
	
	private static void listPartidos() {
		
		partidos = FactoryServicios.getPartidoServicios().buscarPartidos();
		
		System.out.println("Id  --  Equipos Local --  Equipo Visitante --");
				
		for (int i = 0; i < partidos.size(); i++) {
			System.out.println(partidos.get(i).toString());
			System.out.println("----------------------------------");
		}
		
		System.out.println("");
	}
	
}
