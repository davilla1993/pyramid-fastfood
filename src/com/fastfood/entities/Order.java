package com.fastfood.entities;
// Generated 13 janv. 2020 13:37:28 by Hibernate Tools 5.2.12.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name = "order", catalog = "fastfood_db")
@NamedQueries({
	@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o ORDER BY o.orderDate DESC"),
	@NamedQuery(name = "Order.countAll", query = "SELECT COUNT(*) FROM Order"),
	@NamedQuery(name = "Order.findByCustomer", query = "SELECT o FROM Order o WHERE o.customer.idcustomer =:idcustomer ORDER BY o.orderDate DESC"),
	@NamedQuery(name = "Order.findByIdAndCustomer", query = "SELECT o FROM Order o WHERE o.idorder =:idorder AND o.customer.idcustomer =:idcustomer")
})
public class Order implements java.io.Serializable {

	private static final long serialVersionUID = 8188306915993124446L;
	private int idorder;
	private Customer customer;
	private Date orderDate;
	private String shippingAddress;
	private String recipientName;
	private String recipientPhone;
	private float total;
	private String status;
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

	public Order() {
	}

	public Order(Customer customer, Date orderDate, String shippingAddress, String recipientName,
			String recipientPhone, float total, String status) {
		this.customer = customer;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.total = total;
		this.status = status;
	}

	public Order(Customer customer, Date orderDate, String shippingAddress, String recipientName,
			String recipientPhone, float total, String status, Set<OrderDetail> orderDetails) {
		this.customer = customer;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.total = total;
		this.status = status;
		this.orderDetails = orderDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idorder", unique = true, nullable = false)
	public int getIdorder() {
		return this.idorder;
	}

	public void setIdorder(int idorder) {
		this.idorder = idorder;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcustomer", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date", nullable = false, length = 19)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "shipping_address", nullable = false, length = 256)
	public String getShippingAddress() {
		return this.shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Column(name = "recipient_name", nullable = false, length = 45)
	public String getRecipientName() {
		return this.recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	@Column(name = "recipient_phone", nullable = false, length = 45)
	public String getRecipientPhone() {
		return this.recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	@Column(name = "total", nullable = false, precision = 12, scale = 0)
	public float getTotal() {
		return this.total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Column(name = "status", nullable = false, length = 20)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	@Transient
	public int getItemCopies() {
		int total = 0;
		for(OrderDetail orderDetail : orderDetails) {
			total += orderDetail.getQuantity();
		}
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idorder;
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
		Order other = (Order) obj;
		if (idorder != other.idorder)
			return false;
		return true;
	}

}
