package dao;
// Generated 11-feb-2016 10:32:41 by Hibernate Tools 4.0.0

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import comun.dominio.Partido;
import comun.factorias.FactorySessionUtil2;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Producto.
 * @see comun.dominio.Producto
 * @author Hibernate Tools
 */
public class PartidoHome implements PartidoDao {

	private static final Log log = LogFactory.getLog(PartidoHome.class);

	/* (non-Javadoc)
	 * @see dao.PartidoDao#persist(comun.dominio.Partido)
	 */
	@Override
	public void persist(Partido transientInstance) {
		log.debug("persisting Partido instance");
		try {
			FactorySessionUtil2.getSessionFactory().getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.PartidoDao#attachDirty(comun.dominio.Partido)
	 */
	@Override
	public void attachDirty(Partido instance) {
		log.debug("attaching dirty Producto instance");
		try {
			FactorySessionUtil2.getSessionFactory().getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.PartidoDao#attachClean(comun.dominio.Partido)
	 */
	@Override
	public void attachClean(Partido instance) {
		log.debug("attaching clean Partido instance");
		try {
			FactorySessionUtil2.getSessionFactory().getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.PartidoDao#delete(comun.dominio.Partido)
	 */
	@Override
	public void delete(Partido persistentInstance) {
		log.debug("deleting Partido instance");
		try {
			FactorySessionUtil2.getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.PartidoDao#merge(comun.dominio.Partido)
	 */
	@Override
	public Partido merge(Partido detachedInstance) {
		log.debug("merging Producto instance");
		try {
			Partido result = (Partido) FactorySessionUtil2.getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see dao.PartidoDao#findById(java.lang.Integer)
	 */
	@Override
	public Partido findById(java.lang.Integer id) {
		log.debug("getting Producto instance with id: " + id);
		try {
			Partido instance = (Partido) FactorySessionUtil2.getSessionFactory().getCurrentSession().get("comun.dominio.Partido", id);
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
	 * @see dao.PartidoDao#findByExample(comun.dominio.Partido)
	 */
	@Override
	public List<Partido> findByExample(Partido instance) {
		log.debug("finding Producto instance by example");
		try {
			List<Partido> results = (List<Partido>) FactorySessionUtil2.getSessionFactory().getCurrentSession().createCriteria("comun.dominio.Partido")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
