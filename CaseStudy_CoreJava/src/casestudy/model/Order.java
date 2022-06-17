package casestudy.model;

import java.time.LocalDate;

import java.util.Objects;



public class Order implements Comparable<Order> {

	String username;
	String category;
	int orderCost;
	LocalDate orderDate;
	boolean action;
	

	public Order() {

	}

	public Order(String username, String category, int orderCost, LocalDate orderDate, boolean action) {

		this.username = username;
		this.category = category;
		this.orderCost = orderCost;
		this.orderDate = orderDate;
		this.action = action;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public boolean isAction() {
		return action;
	}

	public void setAction(boolean action) {
		this.action = action;
	}

	@Override
	public int hashCode() {
		return Objects.hash(action, category, orderCost, orderDate, username);
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
		return action == other.action && Objects.equals(category, other.category) && orderCost == other.orderCost
				&& Objects.equals(orderDate, other.orderDate) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Order [username=" + username + ", category=" + category + ", orderCost=" + orderCost + ", orderDate="
				+ orderDate + ", action=" + action + "]";
	}

	public String showOrders() {
		return "Order -" + username + " , " + category + " , " + orderCost + " , " + orderDate + " , " + action;
	}

	public boolean contains(String string) {

		return false;
	}

	@Override
	public int compareTo(Order a) {
		
		return this.orderCost - a.orderCost;
	}

	

}// end of class
