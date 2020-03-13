package com.fastfood.entities;
// Generated 13 janv. 2020 13:37:28 by Hibernate Tools 5.2.12.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "items", catalog = "fastfood_db", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@NamedQueries({
	@NamedQuery(name ="Items.findAll" , query="SELECT i FROM Items i ORDER BY i.iditem"),
	@NamedQuery(name ="Items.countAll" , query ="SELECT COUNT(*) FROM Items i "),
	@NamedQuery(name ="Items.findByName", query="SELECT i FROM Items i WHERE i.name = :name"),
	@NamedQuery(name ="Items.findByCategory", query="SELECT i FROM Items i JOIN Category c ON i.category.idcategory = c.idcategory AND c.idcategory = :idcategory"),
	@NamedQuery(name ="Items.countByCategory", query="SELECT COUNT(i) FROM Items i WHERE i.category.idcategory = :idcategory")
})
public class Items implements java.io.Serializable {

	private static final long serialVersionUID = 2411169427408067808L;
	private int iditem;
	private Category category;
	private String name;
	private String description;
	private float price;
	private byte[] image;
	private String base64Image;
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);
	private Set<Review> reviews = new HashSet<Review>(0);

	public Items() {
	}
	
	
	public Items(int iditem) {
		super();
		this.iditem = iditem;
	}


	public Items(Category category, String name, String description, float price, byte[] image) {
		this.category = category;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
	}

	public Items(Category category, String name, String description, float price, byte[] image, Set<OrderDetail> orderDetails, Set<Review> reviews) {
		this.category = category;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.orderDetails = orderDetails;
		this.reviews = reviews;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "iditem", unique = true, nullable = false)
	public int getIditem() {
		return this.iditem;
	}

	public void setIditem(int iditem) {
		this.iditem = iditem;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcategory", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name", unique = true, nullable = false, length = 60)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false, length = 16777215)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "price", nullable = false, precision = 12, scale = 0)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "image", nullable = false)
	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "items")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "items")
	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
	@Transient
	public String getBase64Image() {
		this.base64Image = Base64.getEncoder().encodeToString(this.image);
		return this.base64Image;
	}

	@Transient
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iditem;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		if (iditem != other.iditem)
			return false;
		return true;
	}
	
	

}
