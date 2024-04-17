package delivery.handlers;

import java.util.ArrayList;
import java.util.List;

import delivery.beans.Customer;
import delivery.beans.DeliveryPerson;
import delivery.beans.Order;
import delivery.enums.DeliveryTypeEnum;
import delivery.enums.ProductEnum;
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
	
	@SuppressWarnings("static-access")
	public Customer findCustomer(int customerId) {
		
		Customer customer = null;
		for(int i = 0; i < customers.size(); i++) {
			if(customerId == customers.get(i).getCustomerId()) {
				customer = customers.get(i);
				break;
			}
		}
		return customer;
	}
	
	public String getProductName(String productOption) {
		
		 String productName = "";
		 
		 switch(productOption) {
		 	case "1" :
		 		productName = ProductEnum.BURRITO.getName();
		 		break;
		 	case "2" :
		 		productName = ProductEnum.HAMBURGUER.getName();
		 		break;
		 	case "3" :
		 		productName = ProductEnum.KEBAB.getName();
		 		break;
		 	case "4" :
		 		productName = ProductEnum.PIZZA.getName();
		 		break;
		 	default:
		 		break;
		 }
		return productName;
	}
	
	
	public void addProductName(Order order, String productName) {
		
		order.getProductNames().add(productName);
	}
	
	public double getUnitAmount(String productName) {
		
		double amount = 0;
		
		if(productName.equalsIgnoreCase(ProductEnum.BURRITO.getName())){
			amount = ProductEnum.BURRITO.getPrice();
		}else if(productName.equalsIgnoreCase(ProductEnum.HAMBURGUER.getName())) {
			amount = ProductEnum.HAMBURGUER.getPrice();
		}else if(productName.equalsIgnoreCase(ProductEnum.KEBAB.getName())) {
			amount = ProductEnum.KEBAB.getPrice();
		}else if(productName.equalsIgnoreCase(ProductEnum.PIZZA.getName())) {
			amount = ProductEnum.PIZZA.getPrice();
		}
		
		return amount;
	}
	
	public void recalculateAmount(Order order, double productUnitAmount) {
		
		order.setTotalAmount(order.getTotalAmount() + productUnitAmount);
	}
	
	public String calculateDeliveryCharge(Order order) {
		
		String deliveryType = order.getDeliveryPerson().getDeliveryType();
		int deliveryPercentage = getDeliveryPercentage(deliveryType);
		double deliveryAmount = (order.getTotalAmount() * deliveryPercentage) / 100;
		recalculateAmount(order, deliveryAmount);
		
		return getDeliveryMessage(deliveryType);
	}

	private String getDeliveryMessage(String deliveryType) {
	
	String message = "";
	if(deliveryType.equalsIgnoreCase(DeliveryTypeEnum.ON_FOOT.getDeliveryType())){
		message = Constants.DeliveryType.ON_FOOT;
	}else if(deliveryType.equalsIgnoreCase(DeliveryTypeEnum.BICYCLE.getDeliveryType())) {
		message = Constants.DeliveryType.BICYCLE;
	}else if(deliveryType.equalsIgnoreCase(DeliveryTypeEnum.MOTORCYCLE.getDeliveryType())) {
		message = Constants.DeliveryType.MOTORCYCLE;
	}
	return message;
	}
	
	private int getDeliveryPercentage(String deliveryType) {
		
		int percentage = 0;
		if(deliveryType.equalsIgnoreCase(DeliveryTypeEnum.ON_FOOT.getDeliveryType())){
			percentage = DeliveryTypeEnum.ON_FOOT.getPercentage();
		}else if(deliveryType.equalsIgnoreCase(DeliveryTypeEnum.BICYCLE.getDeliveryType())) {
			percentage = DeliveryTypeEnum.BICYCLE.getPercentage();
		}else if(deliveryType.equalsIgnoreCase(DeliveryTypeEnum.MOTORCYCLE.getDeliveryType())) {
			percentage = DeliveryTypeEnum.MOTORCYCLE.getPercentage();
		}
		return percentage;
	}
	
	public String getGift(String productName) {
		
		String gift = "";
		
		if(productName.equalsIgnoreCase(ProductEnum.BURRITO.getName())){
			gift = ProductEnum.BURRITO.getGift();
		}else if(productName.equalsIgnoreCase(ProductEnum.HAMBURGUER.getName())) {
			gift = ProductEnum.HAMBURGUER.getGift();
		}else if(productName.equalsIgnoreCase(ProductEnum.KEBAB.getName())) {
			gift = ProductEnum.KEBAB.getGift();
		}else if(productName.equalsIgnoreCase(ProductEnum.PIZZA.getName())) {
			gift = ProductEnum.PIZZA.getGift();
		}
		
		return gift;
	}
	
	
	
	// Option 2 switch methods.
	@SuppressWarnings("static-access")
	public Order findOrder(int orderId) {
		
		Order order = null;
		for(int i = 0; i < orders.size(); i++) {
			if(orderId == orders.get(i).getOrderId()) {
				order = orders.get(i);
				break;
			}
		}
		return order;
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
	
	for(int i = 0; i < orders.size(); i++) {
		if(!orders.get(i).isDelivered()) {
			return true;
		}
	}
	return false;
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
		
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).isDelivered()) {
				return true;
			}
		}
		return false;
	}
}
