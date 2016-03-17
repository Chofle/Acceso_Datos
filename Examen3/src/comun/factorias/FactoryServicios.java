package comun.factorias;


import servicios.EquiposServicios;
import servicios.PartidoServicios;
import servicios.EquipoServiciosImpl;
import servicios.PartidoServiciosImpl;

public class FactoryServicios {
	
	private static EquiposServicios equiposServicios;
	private static PartidoServicios partidoServicios;
	
	private FactoryServicios(){};
	
	public static EquiposServicios getEquipoServicios(){
		if(equiposServicios == null)
			equiposServicios = new EquipoServiciosImpl();
			return equiposServicios;
	}
	
	public static PartidoServicios getPartidoServicios(){
		if(partidoServicios == null)
			partidoServicios = new PartidoServiciosImpl();
			return partidoServicios;
	}
}
