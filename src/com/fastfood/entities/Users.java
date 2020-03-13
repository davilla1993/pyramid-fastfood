package com.fastfood.entities;
// Generated 13 janv. 2020 13:37:28 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "users", catalog = "fastfood_db")
@NamedQueries({
	@NamedQuery(name = "Users.findAll" , query = "SELECT u FROM Users u ORDER BY u.fullname"),
	@NamedQuery(name = "Users.countAll" , query = "SELECT COUNT(*) FROM Users u "),
	@NamedQuery(name = "Users.checkLogin" , query = "SELECT u FROM Users u WHERE u.email = :email AND password = :password"),
	@NamedQuery(name = "Users.findByEmail" , query = "SELECT u FROM Users u WHERE u.email = :email")
})
public class Users implements java.io.Serializable {

	private static final long serialVersionUID = 2325416990067099846L;
	private Integer iduser;
	private String email;
	private String password;
	private String fullname;

	public Users() {
	}
	
	public Users(Integer iduser, String email, String password, String fullname) {
		this.iduser = iduser;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
	}

	public Users(String email, String password, String fullname) {
		this.email = email;
		this.password = password;
		this.fullname = fullname;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "iduser", unique = true, nullable = false)
	public Integer getIduser() {
		return this.iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	@Column(name = "email", nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "fullname", nullable = false, length = 100)
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
}
