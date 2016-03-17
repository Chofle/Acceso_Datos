package comun.factorias;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FactorySessionUtil2 {

	private static final Log log = LogFactory.getLog(FactorySessionUtil2.class);
	private static  SessionFactory sessionFactory=null ;
	
	private FactorySessionUtil2(){}
	public static SessionFactory getSessionFactory(){
		if (sessionFactory == null)
			sessionFactory=cargarSessionFactory();
		return sessionFactory;		
		
	}
	
	private static    SessionFactory cargarSessionFactory() {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		SessionFactory sessionFactory=null ;
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
			throw e;
		}
		
		return sessionFactory;
		
	}
}
	
	
	
	

