package crud;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/**
 * Die Klasse dient zur Herstellung der Datenbankverbindung.
 * 
 * @author Yunus Sari
 *
 */
public class HibernateConnection {
	private static SessionFactory sessionFactory;
	static{
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties());
		sessionFactory = config.buildSessionFactory(builder.build());
	}
	
	/**
	 * Die Vebindung wird zurückgegeben.
	 * 
	 * @return	Verbindung
	 */
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
