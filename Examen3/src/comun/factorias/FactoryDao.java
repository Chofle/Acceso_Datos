package comun.factorias;

import dao.EquipoDao;
import dao.EquipoHome;
import dao.PartidoDao;
import dao.PartidoHome;

public class FactoryDao {
	
	private static EquipoDao equipoDao;
	private static PartidoDao partidoDao;
	
	private FactoryDao(){};
	
	public static EquipoDao getEquipoDaoHibernate(){
		if(equipoDao == null)
		    equipoDao = new EquipoHome();
			return equipoDao;
	}
	
	public static PartidoDao getPartidoDaoHibernate(){
		if(partidoDao == null)
			partidoDao = new PartidoHome();
			return partidoDao;
	}
	
}
