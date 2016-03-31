package dao;
// Generated 11-feb-2016 10:32:41 by Hibernate Tools 4.0.0

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import comun.dominio.Equipo;
import comun.factorias.FactorySessionUtil2;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Cliente.
 * @see comun.dominio.Cliente
 * @author Hibernate Tools
 */
public class EquipoHome implements EquipoDao {

	private static final Log log = LogFactory.getLog(EquipoHome.class);
	
	//Usar esto cuando lo tenga en autoincrementado, poniendo null el ID 
		/* (non-Javadoc)
		 * @see dao.EquipoDao#persist(comun.dominio.Equipo)
		 */
		@Override
		public void persist(Equipo transientInstance) {
			log.debug("persisting Equipo instance");
			try {
				FactorySessionUtil2.getSessionFactory().getCurrentSession().persist(transientInstance);
				log.debug("persist successful");
			} catch (RuntimeException re) {
				log.error("persist failed", re);
				throw re;
			}
		}
	

	/* (non-Javadoc)
	 * @see dao.EquipoDao#attachDirty(comun.dominio.Cliente)
	 */
	@Override
	public void attachDirty(Equipo instance) {
		log.debug("attaching dirty Equipo instance");
		try {
			FactorySessionUtil2.getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.EquipoDao#attachClean(comun.dominio.Equipo)
	 */
	@Override
	public void attachClean(Equipo instance) {
		log.debug("attaching clean Equipo instance");
		try {
			FactorySessionUtil2.getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.EquipoDao#delete(comun.dominio.Equipo)
	 */
	@Override
	public void delete(Equipo persistentInstance) {
		log.debug("deleting Equipo instance");
		try {
			FactorySessionUtil2.getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.EquipoDao#merge(comun.dominio.Equipo)
	 */
	@Override
	public Equipo merge(Equipo detachedInstance) {
		log.debug("merging Cliente instance");
		try {
			Equipo result = (Equipo) FactorySessionUtil2.getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.EquipoDao#findById(java.lang.Integer)
	 */
	@Override
	public Equipo findById(java.lang.Integer id) {
		log.debug("getting Cliente instance with id: " + id);
		try {
			Equipo instance = (Equipo) FactorySessionUtil2.getSessionFactory().getCurrentSession().get("comun.dominio.Equipo", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.EquipoDao#findByExample(comun.dominio.Equipo)
	 */
	@Override
	public List<Equipo> findByExample(Equipo instance) {
		log.debug("finding Equipo instance by example");
		try {
			List<Equipo> results = (List<Equipo>) FactorySessionUtil2.getSessionFactory().getCurrentSession().createCriteria("comun.dominio.Equipo")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
