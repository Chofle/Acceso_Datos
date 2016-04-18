package dao;

import java.util.List;

import comun.dominio.Equipo;

public interface EquipoDao {

	void persist(Equipo transientInstance);

	void attachDirty(Equipo instance);

	void attachClean(Equipo instance);

	void delete(Equipo persistentInstance);

	Equipo merge(Equipo detachedInstance);

	Equipo findById(java.lang.Integer id);

	List<Equipo> findByEquipo(Equipo instance);

}