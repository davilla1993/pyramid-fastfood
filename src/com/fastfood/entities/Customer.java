package com.fastfood.entities;
// Generated 13 janv. 2020 13:37:28 by Hibernate Tools 5.2.12.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "customer", catalog = "heroku_4cf8e2888dd4dea", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@NamedQueries({
	@NamedQuery(name = "Customer.findAll" , query = "SELECT c FROM Customer c ORDER BY c.registerDate DESC"),
	@NamedQuery(name = "Customer.countAll" , query = "SELECT COUNT(c.email) FROM Customer c "),
	@NamedQuery(name = "Customer.findByEmail" , query = "SELECT c FROM Customer c WHERE c.email =:email"),
	@NamedQuery(name = "Customer.checkLogin" , query = "SELECT c  FROM Customer c WHERE c.email = :email AND c.password = :password")
})
public class Customer implements java.io.Serializable {
	
	private static final long serialVersionUID = 580932091813716004L;
	private int idcustomer;
	private String email;
	private String fullname;
	private String address;
	private String city;
	private String phone;
	private String password;
	private Date registerDate;
	private Set<Order> orders = new HashSet<Order>(0);
	private Set<Review> reviews = new HashSet<Review>(0);

	public Customer() {
	}

	public Customer(String email, String fullname, String address, String city, String phone,
			String password, Date registerDate) {
		this.email = email;
		this.fullname = fullname;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.password = password;
		this.registerDate = registerDate;
	}

	public Customer(String email, String fullname, String address, String city, String phone,
			String password, Date registerDate, Set<Order> orders, Set<Review> reviews) {
		this.email = email;
		this.fullname = fullname;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.password = password;
		this.registerDate = registerDate;
		this.orders = orders;
		this.reviews = reviews;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcustomer", unique = true, nullable = false)
	public int getIdcustomer() {
		return this.idcustomer;
	}

	public void setIdcustomer(int idcustomer) {
		this.idcustomer = idcustomer;
	}

	@Column(name = "email", unique = true, nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "fullname", nullable = false, length = 100)
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "address", nullable = false, length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "city", nullable = false, length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "phone", nullable = false, length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "register_date", nullable = false, length = 19)
	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

}
