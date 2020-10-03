package com.fastfood.entities;
// Generated 13 janv. 2020 13:37:28 by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail", catalog = "heroku_4cf8e2888dd4dea")
public class OrderDetail implements java.io.Serializable {

	private static final long serialVersionUID = -1537621937007979898L;
	private OrderDetailId id = new OrderDetailId();
	private Items items;
	private Order order;
	private int quantity;
	private float subtotal;

	public OrderDetail() {
	}

	public OrderDetail(OrderDetailId id) {
		this.id = id;
	}

	public OrderDetail(OrderDetailId id, Items items, Order order) {
		this.id = id;
		this.items = items;
		this.order = order;
	}
	
	

	public OrderDetail(OrderDetailId id, Items items, Order order, int quantity, float subtotal) {
		super();
		this.id = id;
		this.items = items;
		this.order = order;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "idorder", column = @Column(name = "idorder")),
			@AttributeOverride(name = "iditem", column = @Column(name = "iditem")),
	})
	public OrderDetailId getId() {
		return this.id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "iditem", insertable = false, updatable = false)
	public Items getItems() {
		return this.items;
	}

	public void setItems(Items items) {
		this.items = items;
		this.id.setItems(items);
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idorder", insertable = false, updatable = false)
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
		this.id.setOrder(order);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	
	

}
