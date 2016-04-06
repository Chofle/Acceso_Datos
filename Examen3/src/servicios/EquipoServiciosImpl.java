package servicios;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import comun.dominio.Equipo;
import comun.factorias.FactoryDao;
import comun.factorias.FactorySessionUtil2;
import dao.EquipoDao;

public class EquipoServiciosImpl implements EquiposServicios {
	
	private static final Log log = LogFactory.getLog(EquipoServiciosImpl.class);
	
	/* (non-Javadoc)
	 * @see servicios.EquiposServicios#buscarEquipoPorId(java.lang.Integer)
	 */
	@Override
	public Equipo buscarEquipoPorId(java.lang.Integer id){
		Transaction tx = null;
		Equipo equipoEncontrado = null;
		try{
			tx = FactorySessionUtil2.getSessionFactory().getCurrentSession().beginTransaction();	
			
			equipoEncontrado = FactoryDao.getEquipoDaoHibernate().findById(id);
			tx.commit();
			return equipoEncontrado;
		}catch(RuntimeException re){
			log.error("Fallo al realizar la transaccion", re);
			if(tx != null)
				tx.rollback();
			throw re;	
		}
		
	
	} 
	
	/* (non-Javadoc)
	 * @see servicios.EquiposServicios#insertarEquipo(Equipo equipo)
	 */
	@Override
	public void insertarNuevoEquipo(Equipo equipo){
		
		Transaction tx = null;

		try{
			tx = FactorySessionUtil2.getSessionFactory().getCurrentSession().beginTransaction();	
			FactoryDao.getEquipoDaoHibernate().persist(equipo);
			tx.commit();
		}catch(RuntimeException ex){
			log.error("Fallo al realizar la transaccion", ex);
			if(tx != null)
				tx.rollback();
			throw ex;
		}
		
	} 
	
	@Override
	public List<Equipo> buscarEquipos(){
		
		List<Equipo> equipos = null;
		Equipo equipo = new Equipo();
		Transaction tx = null;
		try{
			tx = FactorySessionUtil2.getSessionFactory().getCurrentSession().beginTransaction();
			equipos= FactoryDao.getEquipoDaoHibernate().findByExample(equipo);
			tx.commit();
			return equipos;
		} catch (RuntimeException ex){
			log.error("Fallo al ejecutar la transacción", ex);
			if(tx!= null)
				tx.rollback();
			throw ex;
		}
	}
	
}
