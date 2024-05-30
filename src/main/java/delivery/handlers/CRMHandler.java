package delivery.handlers;

import java.util.Scanner;

import delivery.beans.Customer;
import delivery.beans.DeliveryPerson;
import delivery.beans.Order;
import delivery.beans.Product;
import delivery.main.DataTest;
import delivery.utils.Validations;

public class CRMHandler {
	
	private static Scanner scanner;
	private OrderManager orderManager;
	
	public CRMHandler() {
		super();
		CRMHandler.scanner = new Scanner(System.in);
		this.orderManager = new OrderManager();
	}
	

	public void runDelivery() {
		
		try {
			loadTestData();
			
			String menuOption = "";
			do {
				showMainMenu();
				
				do {
					printText(TextMenuHandler.getChooseAnOption());
					menuOption = readInput().trim();
				}while(!Validations.validateMenuOption(menuOption));
				
				processOption(menuOption);
				
			}while(!menuOption.equals("0"));
			
		}catch(Exception e) {
			printText("" + e);
		}finally {
			closeScanner();
		}
	}
	 
	
	private void showMainMenu() {
		
		String menuText = TextMenuHandler.getMainMenu();
		 printText(menuText);
	}
	
	private void processOption(String menuOption) {

		switch (menuOption) {
			case "1": 
				runOrderCreation();
				break;
			case "2":
				Order order = getOrder();
				
				if(!Validations.checkOrderNull(order)) {
					printText(orderManager.flagOrderAsDelivered(order));
				}else {
					printText(TextMenuHandler.getIdNotFoundMessage());
				}
				break;
			case "3":
				orderManager.printPendingOrders();
				break;
			case "4":
				orderManager.printDeliveredOrders();
				break;
			case "0":
				printText(TextMenuHandler.getExitMessage());
				break;
		}
			
	}
	
	// switch case 1 runOrderCreation methods.
	private void runOrderCreation() {
		
		Order newOrder = null;
		
		DeliveryPerson deliveryPerson = orderManager.chooseDeliveryPerson();
		if(deliveryPerson != null) {
			orderManager.reassignDeliveryPerson(deliveryPerson);
			
			Customer customer = getCustomer();
			if(!Validations.checkCustomerNull(customer)) {
				newOrder = orderManager.createOrder(customer, deliveryPerson);
				addProductsToOrder(newOrder);
				System.out.println(newOrder.toString());
			}else {
				printText(TextMenuHandler.getIdNotFoundMessage());
			}
			
			printText(orderManager.calculateDeliveryCharge(newOrder));
			System.out.println(newOrder.toString());
			
			orderManager.addOrder(newOrder);
		}
		
		
	}
	private void showAddProductsMenu() {
		
		 String menuText = TextMenuHandler.getAddProductsMenu();
		 printText(menuText);
	}
	
	private void addProductsToOrder(Order order) {
		
		String productOption = "";
		
		do {
			showAddProductsMenu();
			
			do {
				printText(TextMenuHandler.getChooseAnOption());
				productOption = readInput().trim();
			}while(!Validations.validateMenuOption(productOption));
			
			if(productOption.equals("0") && order.getProducts().isEmpty()) {
				printText(TextMenuHandler.getAddProductsMessage());
				productOption = "";
			}else {
				Product product = orderManager.getProduct(productOption);
				
				if(product != null) {
					orderManager.addProduct(order, product);
					
					double productUnitAmount = orderManager.getUnitAmount(product);
					orderManager.recalculateAmount(order, productUnitAmount);
					System.out.println(order.toString());
				}

			}
			
		}while(!productOption.equals("0"));
	}
	
	private Customer getCustomer() {
		
		String customerId = "";
		do {
			printText(TextMenuHandler.getCustomerIdMessage());
			customerId = readInput().trim();
		}while(!Validations.validateId(customerId));
		
		Customer customer = orderManager.findCustomer(Integer.parseInt(customerId));
		
		return customer;
	}
	
	// switch case 2 methods.
	private Order getOrder() {
		
		String orderId = "";
		do {
			printText(TextMenuHandler.getOrderIdMessage());
			orderId = readInput().trim();
		}while(!Validations.validateId(orderId));
		
		Order order = orderManager.findOrder(Integer.parseInt(orderId));
		
		return order;
	}
	
	
	// Print and Input methods.
	private void printText(String text) {
		
		System.out.println(text);
	}
	
	private String readInput() {
		return scanner.nextLine();
	}
	
	private void closeScanner() {
		scanner.close();
	}
	
	// Data test methods.
	private void loadTestData() {
		
		DataTest dtg = new DataTest();
		dtg.addCustomers(orderManager.getCustomers());
		dtg.addDeliveryPersons(orderManager.getAvailableForDeliveryPersons());
	}
}
