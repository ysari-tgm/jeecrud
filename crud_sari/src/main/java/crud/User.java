package crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * In dieser Klasse werden die Daten in der Datenbank (SQLite) gespeichert.
 * Es wird eine Tabelle User mit den Attributen Id, Vorname, Nachname und Alter erstellt.
 * 
 * @author Yunus Sari
 *
 */
@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="id")
		private Integer id;
	@Column (name="vname")
	private String vname;
	@Column (name="nname")
		private String nname;
	@Column (name="age")
		private Integer age;
	
	/**
	 * Hier werden die angegebenen Variablen intialisiert.
	 * 
	 * @param id
	 * @param vname
	 * @param nname
	 * @param age
	 */
	public User(Integer id, String vname, String nname, Integer age){
		this.id = id;
		this.vname = vname;
		this.nname = nname;
		this.age = age;
	}
	
	/**
	 * defaultconstructor
	 */
	public User(){
	}
	
	/**
	 * ID - Gettermethode
	 * 
	 * @return	ID des Eintrags
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * ID - Settermethode
	 * 
	 * @param id	ID des Eintrags
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Vorname - Getttermethode
	 * 
	 * @return	Vorname
	 */
	public String getVname() {
		return vname;
	}
	
	/**
	 * Vorname - Settermethode
	 * 
	 * @param vname	Vorname
	 */
	public void setVname(String vname) {
		this.vname = vname;
	}
	
	/**
	 * Nachname  - Gettermethode
	 * 
	 * @return Nachname
	 */
	public String getNname() {
		return nname;
	}
	
	/**
	 * Nachname - Settermethode
	 * 
	 * @param nname	Nachname
	 */
	public void setNname(String nname) {
		this.nname = nname;
	}
	
	/**
	 * Alter - Gettermethode
	 * 
	 * @return	Alter
	 */
	public Integer getAge() {
		return age;
	}
	
	/**
	 * Alter - Settermethode
	 * 
	 * @param age	Alter
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
}