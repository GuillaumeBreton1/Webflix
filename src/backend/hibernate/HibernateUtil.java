package backend.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new Configuration().configure("backend/hibernate/hibernate.cfg.xml")
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null || sessionFactory.isClosed()){
			sessionFactory = new Configuration().configure("backend/hibernate/hibernate.cfg.xml")
					.buildSessionFactory();
		}
		return sessionFactory;
	}
}