package hbm.xml;

import java.util.HashSet;
import java.util.Set;

public class Item {

	private Integer id;
	private Integer total;
	private Set<Cart> carts = new HashSet<>();
	
	public Item() {}

	public Item(Integer total) {
		super();
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carts == null) ? 0 : carts.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		Item other = (Item) obj;
		if (carts == null) {
			if (other.carts != null)
				return false;
		} else if (!carts.equals(other.carts))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", total=" + total + ", carts=" + carts + "]";
	}
}