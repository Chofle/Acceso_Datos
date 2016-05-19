package servicios;

import java.util.List;

import comun.dominio.Partido;

public interface PartidoServicios {

	Partido buscarPartidoPorId(java.lang.Integer id);
	List<Partido> buscarPartidos();
	void insertarNuevoPartido(Partido partido);
	void borrarPartido(Partido partido);
	void editarPartido(Partido partido);
}