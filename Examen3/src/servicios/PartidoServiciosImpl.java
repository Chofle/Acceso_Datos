package servicios;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
