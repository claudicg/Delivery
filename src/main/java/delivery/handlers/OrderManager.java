package delivery.handlers;

import java.util.ArrayList;
import java.util.List;

import delivery.beans.Customer;
import delivery.beans.DeliveryPerson;
import delivery.beans.DeliveryType;
import delivery.beans.Order;
import delivery.beans.Product;
import delivery.exceptions.DeliveryPersonException;
import delivery.utils.Constants;
import delivery.utils.Utils;


public class OrderManager {

	List<DeliveryPerson> availableForDeliveryPersons;
	List<DeliveryPerson> notAvailableForDeliveryPersons;
	
	List<Customer> customers;
	List<Order> orders;
	
	public OrderManager() {
		super();
		this.availableForDeliveryPersons = new ArrayList<>();
		this.notAvailableForDeliveryPersons = new ArrayList<>();
		this.orders = new ArrayList<>();
		this.customers = new ArrayList<>();
	}

	public List<DeliveryPerson> getAvailableForDeliveryPersons() {
		return availableForDeliveryPersons;
	}

	public void setAvailableForDeliveryPersons(List<DeliveryPerson> availableForDeliveryPersons) {
		this.availableForDeliveryPersons = availableForDeliveryPersons;
	}

	public List<DeliveryPerson> getNotAvailableForDeliveryPersons() {
		return notAvailableForDeliveryPersons;
	}

	public void setNotAvailableForDeliveryPersons(List<DeliveryPerson> notAvailableForDeliveryPersons) {
		this.notAvailableForDeliveryPersons = notAvailableForDeliveryPersons;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	//DeliveryPerson methods.
	private void validateAvailableForDeliveryList() throws DeliveryPersonException {
		if(availableForDeliveryPersons.isEmpty()) {
			throw new DeliveryPersonException(Constants.Exceptions.DELIVERY_PERSON);
		}
	}
	
	public DeliveryPerson chooseDeliveryPerson() {
		
		DeliveryPerson deliveryPerson= null;
		
		int randomNumber = Utils.generateRandom(availableForDeliveryPersons.size());

		try {
			validateAvailableForDeliveryList();
			deliveryPerson = availableForDeliveryPersons.get(randomNumber);
			
		}catch(DeliveryPersonException e) {
			System.out.println(e);
		}
		
		return deliveryPerson;
	}
	
	//Option 1 switch  methods.
	public Order createOrder(Customer customer, DeliveryPerson deliveryPerson ) {
		
		return new Order(customer, deliveryPerson);
	}
	
	
	public Customer findCustomer(int customerId) {
		
		 return customers.stream()
						 .filter(customer -> customerId == customer.getCustomerId())
						 .findFirst()
		                 .orElse(null);
		
	}
	
	public Product getProduct(String productOption) {
		
		 Product product = null;
		 
		 switch(productOption) {
		 	case "1" :
		 		product = Product.BURRITO;
		 		break;
		 	case "2" :
		 		product = Product.HAMBURGUER;
		 		break;
		 	case "3" :
		 		product = Product.KEBAB;
		 		break;
		 	case "4" :
		 		product = Product.PIZZA;
		 		break;
		 }
		return product;
	}
	
	
	public void addProduct(Order order, Product product) {
		
		order.getProducts().add(product);
	}
	
	public double getUnitAmount(Product product) {
		
		double amount = product.getPrice();
		
		
		return amount;
	}
	
	public void recalculateAmount(Order order, double productUnitAmount) {
		
		order.setTotalAmount(order.getTotalAmount() + productUnitAmount);
	}
	
	public String calculateDeliveryCharge(Order order) {
		
		DeliveryType deliveryType = order.getDeliveryPerson().getDeliveryType();
		int deliveryPercentage = getDeliveryPercentage(deliveryType);
		double deliveryAmount = (order.getTotalAmount() * deliveryPercentage) / 100;
		recalculateAmount(order, deliveryAmount);
		
		return getDeliveryMessage(deliveryType);
	}

	private String getDeliveryMessage(DeliveryType deliveryType) {
	
		String message = deliveryType.getMessage();

		return message;
	}
	
	private int getDeliveryPercentage(DeliveryType deliveryType) {
		
		int percentage = deliveryType.getPercentage();

		return percentage;
	}
	
	public String getGift(Product product) {
		
		String gift = product.getGift();
		
		
		return gift;
	}
	
	public Order findOrder(int orderId) {
	    return orders.stream()
	                 .filter(order -> orderId == order.getOrderId())
	                 .findFirst()
	                 .orElse(null);
	}
	
	public String flagOrderAsDelivered(Order order) {
		
		order.setDelivered(true);
		notAvailableForDeliveryPersons.remove(order.getDeliveryPerson());
		availableForDeliveryPersons.add(order.getDeliveryPerson());
		return TextMenuHandler.getFlaggedAsDeliveredMessage();
	}
	
	public void addOrder(Order order) {
		
		orders.add(order);
	}
	
	public void reassignDeliveryPerson(DeliveryPerson deliveryPerson) {
		
		availableForDeliveryPersons.remove(deliveryPerson);
		notAvailableForDeliveryPersons.add(deliveryPerson);
	}
	
	// Option 3 switch methods.
	public void printPendingOrders() {
		
		if(checkIfPendingOrders()) {
			orders.forEach(order -> {if (!order.isDelivered()) {System.out.println(order);}});
		}else {
			System.out.println(TextMenuHandler.getNoPendingOrdersMessage());
		}
	}

	private boolean checkIfPendingOrders() {
	
		boolean anyPending = orders.stream()
				 				   .anyMatch(order -> !order.isDelivered());
		return anyPending;
	}
	
	// Option 4 switch methods.
	public void printDeliveredOrders() {
		
		if(checkIfDeliveredOrders()) {
			orders.forEach(order -> {if (order.isDelivered()) {System.out.println(order);}});
		}else {
			System.out.println(TextMenuHandler.getNoDeliveredOrdersMesssage());
		}
	}
	
	private boolean checkIfDeliveredOrders() {
	
		boolean anyDelivered = orders.stream()
                					 .anyMatch(Order::isDelivered);

		return anyDelivered;
	}
}
