package SortOrderBasedOnValue;

import java.util.Comparator;

import casestudy.model.Order;

public class SortOrderBasedOnValue implements Comparator<Order> {

	@Override
	public int compare(Order a1, Order a2) {
		
		return a1.getOrderCost() - a2.getOrderCost();
	}

}
