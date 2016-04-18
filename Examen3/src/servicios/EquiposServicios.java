package servicios;

import java.util.List;
import comun.dominio.Equipo;

public interface EquiposServicios {

	Equipo buscarEquipoPorId(java.lang.Integer id);
	List<Equipo> buscarEquipos();
	void insertarNuevoEquipo(Equipo equipo);
	void borrarEquipo(Equipo equipo);
}