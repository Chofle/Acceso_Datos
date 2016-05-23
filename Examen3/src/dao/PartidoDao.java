package dao;

import java.util.List;

import comun.dominio.Equipo;
import comun.dominio.Partido;

public interface PartidoDao {

	void persist(Partido transientInstance);

	void attachDirty(Partido instance);

	void attachClean(Partido instance);

	void delete(Partido persistentInstance);

	Partido merge(Partido detachedInstance);

	Partido findById(java.lang.Integer id);

	List<Partido> findByPartido(Partido instance);

}