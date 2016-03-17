package servicios;

import comun.dominio.Equipo;

public interface EquiposServicios {

	Equipo buscarEquipoPorId(java.lang.Integer id);
	void insertarEquipo(Equipo equipo);
}