package com.fastfood.entities;
// Generated 13 janv. 2020 13:37:28 by Hibernate Tools 5.2.12.Final

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderDetailId implements java.io.Serializable {

	private static final long serialVersionUID = -7945200718189416946L;
	private Items items;
	private Order order;

	public OrderDetailId() {
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iditem", insertable = false, updatable = false , nullable = false)
	public Items getItems() {
		return this.items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idorder", insertable = false, updatable = false , nullable = false)
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		OrderDetailId other = (OrderDetailId) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}
	
	

	
}
