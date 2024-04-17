package delivery.beans;

import java.util.ArrayList;
import java.util.List;

import delivery.handlers.OrderManager;

public class Order {
		
	private int orderId;
	private static int orderIdNext = 1;
	private Customer customer;
	private List<String> productNames;
	private DeliveryPerson deliveryPerson;
	private double totalAmount;
	private boolean delivered;
	
	public Order(Customer customer, DeliveryPerson deliveryPerson) {
		super();
		this.orderId = orderIdNext;
		Order.orderIdNext++;
		this.customer = customer;
		this.productNames = new ArrayList<>();
		this.deliveryPerson = deliveryPerson;
	}

	public int getOrderId() {
		return orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<String> getProductNames() {
		return productNames;
	}

	public void setProductNames(List<String> productNames) {
		this.productNames = productNames;
	}


	public DeliveryPerson getDeliveryPerson() {
		return deliveryPerson;
	}

	public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
		this.deliveryPerson = deliveryPerson;
	}
	
	
	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public boolean isDelivered() {
		return delivered;
	}


	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	
	@Override
	public String toString() {
		
		OrderManager orderManager = new OrderManager();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("=== Order Id: ").append(orderId).append(" ===\n\n");
		for(String product: productNames) {
			sb.append("- ").append(product).append("\n");
			sb.append("gift: " + orderManager.getGift(product)).append("\n");
		}
		sb.append("\nAmount: ").append(totalAmount).append("€\n");
		sb.append("\nCustomer: ").append(customer.getName()).append("\n");
		sb.append("Delivery Person: ").append(deliveryPerson.getName()).append("\n");
		sb.append("Delivery Address: ").append(customer.getAddress()).append("\n");
		sb.append("Delivered: ").append(delivered ? "Yes" : "No").append("\n\n");
		
		return sb.toString();
	}
	
}
