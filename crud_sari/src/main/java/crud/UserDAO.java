package crud;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 * Die Klasse stellt die Verbindung zur Datenbank her.
 * 
 * @author Yunus Sari
 */
public class UserDAO {
	Session session = HibernateConnection.getSessionFactory().openSession();
	
	/**
	 * Benutzer wird in der Datenbank gespeichert.
	 * 
	 * @param user wird zum speichern verwendet.
	 */
	public void save(User user){
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
	
	/**
	 * Eine neue ID wird definiert
	 * 
	 * @return definierte ID
	 */
	public Integer getId() {
		String select = "select max(user.id) from User user";
		List<Integer> resultSet = session.createQuery(select).list();
		Integer uID = 1;
		if(resultSet.get(0) != null){
			uID = resultSet.get(0) + 1;
		}
		return uID;
	}
	
	/**
	 * Eine neue Connection wird erstellt und die Benutzer eingelesen.
	 * 
	 * @return Liste mit den Benutzern
	 */
	public static List<User> read(){
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(User.class);
		List<User> uList = cr.list();
		session.getTransaction().commit();
		session.close();
		return uList;
	}

	/**
	 * Benutzer wird von der Datenbank gelöscht
	 * 
	 * @param u Gelöschte Benutzer
	 */
	public void delete(User u) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(u);
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * Benutzer wird aktualisiert.
	 * 
	 * @param updateUser aktualisierter Benutzer
	 */
	public void update(User updateUser) {
		Session session = HibernateConnection.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(updateUser);
		session.getTransaction().commit();
		session.close();
	}	
}