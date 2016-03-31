package servicios;

import comun.dominio.Equipo;

public interface EquiposServicios {

	Equipo buscarEquipoPorId(java.lang.Integer id);
	void insertarNuevoEquipo(Equipo equipo);
}