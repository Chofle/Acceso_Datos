package servicios;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import comun.dominio.Equipo;
import comun.dominio.Partido;
import comun.factorias.FactoryDao;
import comun.factorias.FactorySessionUtil2;

public class PartidoServiciosImpl implements PartidoServicios {
	
	private static final Log log = LogFactory.getLog(PartidoServiciosImpl.class);
	
	/* (non-Javadoc)
	 * @see servicios.PartidoServicios#buscarPartidoPorId(java.lang.Integer)
	 */
	@Override
	public Partido buscarPartidoPorId(java.lang.Integer id){
		Transaction tx = null;
		Partido partidoEncontrado = null;
		try{
			tx = FactorySessionUtil2.getSessionFactory().getCurrentSession().beginTransaction();	
			
			partidoEncontrado = FactoryDao.getPartidoDaoHibernate().findById(id);
			tx.commit();
			return partidoEncontrado;
		}catch(RuntimeException re){
			log.error("Fallo al realizar la transaccion", re);
			if(tx != null)
				tx.rollback();
			throw re;	
		}
		
	
	} 
	
	@Override
	public void borrarPartido (Partido partido){
		Transaction tx = null;
		try{
			tx = FactorySessionUtil2.getSessionFactory().getCurrentSession().beginTransaction();
			FactoryDao.getPartidoDaoHibernate().delete(partido);
			tx.commit();
		} catch (RuntimeException ex){
			log.error("Fallo al ejecutar la transacción", ex);
			if(tx!= null)
				tx.rollback();
			throw ex;
		}
	}
	/* (non-Javadoc)
	 * @see servicios.EquiposServicios#insertarEquipo(Equipo equipo)
	 */
	@Override
	public void insertarNuevoPartido(Partido partido){
		
		Transaction tx = null;

		try{
			tx = FactorySessionUtil2.getSessionFactory().getCurrentSession().beginTransaction();	
			FactoryDao.getPartidoDaoHibernate().persist(partido);
			tx.commit();
		}catch(RuntimeException ex){
			log.error("Fallo al realizar la transaccion", ex);
			if(tx != null)
				tx.rollback();
			throw ex;
		}
		
	} 
	
	@Override
	public List<Partido> buscarPartidos(){
		
		List<Partido> partidos = null;
		Partido partido = new Partido();
		Transaction tx = null;
		try{
			tx = FactorySessionUtil2.getSessionFactory().getCurrentSession().beginTransaction();
			partidos= FactoryDao.getPartidoDaoHibernate().findByPartido(partido);
			tx.commit();
			return partidos;
		} catch (RuntimeException ex){
			log.error("Fallo al ejecutar la transacción", ex);
			if(tx!= null)
				tx.rollback();
			throw ex;
		}
	}
	
	@Override
	public void editarPartido (Partido p){
		Transaction tx = null;
		try{
			tx = FactorySessionUtil2.getSessionFactory().getCurrentSession().beginTransaction();
			FactoryDao.getPartidoDaoHibernate().attachDirty(p);;
			tx.commit();
		} catch (RuntimeException ex){
			log.error("Fallo al ejecutar la transacción", ex);
			if(tx!= null)
				tx.rollback();
			throw ex;
		}
	}
	

}
