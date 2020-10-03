package com.fastfood.entities;
// Generated 13 janv. 2020 13:37:28 by Hibernate Tools 5.2.12.Final

import static javax.persistence.GenerationType.IDENTITY;

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

@Entity
@Table(name = "category", catalog = "heroku_4cf8e2888dd4dea")
@NamedQueries({
	@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c ORDER BY c.idcategory"),
	@NamedQuery(name = "Category.countAll" , query = "SELECT COUNT(*) FROM Category c"),
	@NamedQuery(name ="Category.findByName", query = "SELECT c FROM Category c WHERE c.name = :name")
})
public class Category implements java.io.Serializable {

	private static final long serialVersionUID = -824687293027942338L;
	private int idcategory;
	private String name;
	private Set<Items> itemses = new HashSet<Items>(0);

	public Category() {
	}
	
	
	public Category(String name) {
		super();
		this.name = name;
	}


	public Category(int idcategory, String name) {
		this.idcategory = idcategory;
		this.name = name;
	}

	public Category(int idcategory, String name, Set<Items> itemses) {
		this.idcategory = idcategory;
		this.name = name;
		this.itemses = itemses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcategory", unique = true, nullable = false)
	public int getIdcategory() {
		return this.idcategory;
	}

	public void setIdcategory(int idcategory) {
		this.idcategory = idcategory;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Items> getItemses() {
		return this.itemses;
	}

	public void setItemses(Set<Items> itemses) {
		this.itemses = itemses;
	}

}
