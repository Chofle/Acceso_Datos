import java.util.List;
import java.util.Scanner;
import comun.dominio.Equipo;
import comun.dominio.Partido;
import comun.factorias.FactoryServicios;

public class Main {
	
	static Scanner Teclado;
	static List<Equipo> equipos;
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
			
			OP = Integer.parseInt(Teclado.nextLine());

			switch (OP) {
			case 1:
				add();
				break;
			case 2:
				delete();
				break;
			case 3:
				break;
			case 4:
				listEquipos();
				break;
			default:
				if (OP != 0)
					System.out.println("Opción no válida.");
				break;
			}

		}

	}
	
	private static void add() {
		
		String nombre, localidad;
		
		System.out.println("Nombre: ");
		nombre = Teclado.nextLine();
		System.out.println("Localidad: ");
		localidad = Teclado.nextLine();
		
		Equipo equipo = new Equipo(nombre, localidad);
		FactoryServicios.getEquipoServicios().insertarNuevoEquipo(equipo);

	}
	
	private static void delete() {
		String nombre;
		System.out.println("Nombre del equipo para borrar: ");
		nombre = Teclado.nextLine();
	}
	
	private static void listEquipos() {
		
		equipos = FactoryServicios.getEquipoServicios().buscarEquipos();
		
		System.out.println("Equipos, Localidades");
				
		for (int i = 0; i < equipos.size(); i++) {
			System.out.println(equipos.get(i).toString());
		}
		
		System.out.println("\n\r");
	}
	
}
