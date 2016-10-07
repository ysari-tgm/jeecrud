package crud;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Die Daten werden mithilfe von Beans verwaltet und organisiert.
 * 
 * @author Yunus Sari
 */
@ManagedBean(name = "userBean", eager = true)
@RequestScoped
public class UserBean {
	private String nname;
	private String vname;
	public int age;
	public List<User> users = UserDAO.read();
	public User updateUser;
	public List<User> selectedUsers;

	/**
	 * Create-Funktionalit�t
	 * Diese Methode dient zur Erstelllung eines Users.
	 * 
	 * @return index f�r die Navigation
	 */
	public String saveUser() {
		UserDAO uDao = new UserDAO();
		Integer uid = uDao.getId();
		User user = new User(uid, vname, nname, age);
		uDao.save(user);
		return "index";
	}

	/**
	 * Delete-Funktionalit�t
	 * Diese Methode dient zum L�schen eines Users.
	 * 
	 * @return index f�r die Navigation
	 */
	public String deleteUser() {
		UserDAO uDao = new UserDAO();
		for (User u : selectedUsers) {
			uDao.delete(u);
		}
		return "index";
	}

	/**
	 * Update-Funktionalit�t
	 * Diese Methode dient zur Aktualisierung eines Users.
	 * 
	 * @return index f�r die Navigation
	 */
	public String update() {
		UserDAO uDao = new UserDAO();
		if (updateUser != null) {
			if (vname == null || vname.equals("")) {
				vname = updateUser.getVname();
			}
			if (nname == null || nname.equals("")) {
				nname = updateUser.getNname();
			}
			if (age == 0) {
				age = updateUser.getAge();
			}
			User user = new User(updateUser.getId(), vname, nname, age);
			uDao.update(user);
		}
		return "index";
	}
	
	/**
	 * Getter-Methode f�r das aktualisieren von Benutzer.
	 * @return
	 */
	public User getUpdateUser() {
		return updateUser;
	}
	
	/**
	 * Setter-Methode f�r das aktualisieren von Benutzer.
	 * @param updateUser
	 */
	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}
	
	/**
	 * Getter-Methode f�r den Nachnamen
	 * @return
	 */
	public String getNname() {
		return nname;
	}

	/**
	 * Setter-Methode f�r den Nachnamen 
	 * @param nname
	 */
	public void setNname(String nname) {
		this.nname = nname;
	}

	/**
	 * Getter-Methode f�r den Vornamen
	 * @return 
	 */
	public String getVname() {
		return vname;
	}

	/**
	 * Setter-Methode f�r den Vornamen
	 * @param vname
	 */
	public void setVname(String vname) {
		this.vname = vname;
	}

	/**
	 * Getter-Methode f�r den Alter
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Setter-Methode f�r den Alter
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Getter-Methode f�r die User
	 * @return
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * Setter-Methode f�r die User
	 * @param users
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * Getter-Methode f�r die ausgewaehlten User
	 * @return
	 */
	public List<User> getSelectedUsers() {
		return selectedUsers;
	}

	/**
	 * Setter-Methode f�r die ausgewaehlten User
	 * @param selectedUsers
	 */
	public void setSelectedUsers(List<User> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}
}