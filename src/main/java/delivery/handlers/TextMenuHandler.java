package delivery.handlers;

import delivery.enums.ProductEnum;
import delivery.utils.Constants;

public class TextMenuHandler {

	public static String getMainMenu() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("1: Create an order.\n");
		sb.append("2: Flag an order as delivered.\n");
		sb.append("3: Print pending orders.\n");
		sb.append("4: Print delivered orders.\n");
		sb.append("0: Exit.\n\n");
		return sb.toString();
	}
	
	public static String getAddProductsMenu() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("1: ").append(ProductEnum.BURRITO.getName()).append("\n");
		sb.append("2: ").append(ProductEnum.HAMBURGUER.getName()).append("\n");
		sb.append("3: ").append(ProductEnum.KEBAB.getName()).append("\n");
		sb.append("4: ").append(ProductEnum.PIZZA.getName()).append("\n");
		sb.append("0: Exit.\n\n");
		return sb.toString();
	}
	
	
	
	public static String getChooseAnOption() {
		
		return Constants.Messages.CHOOSE;
	}
	
	public static String getExitMessage() {
		
		return Constants.Messages.EXIT;
	}
	
	public static String getFlaggedAsDeliveredMessage() {
		
		return Constants.Messages.DELIVERED;
	}
	
	public static String getCustomerIdMessage() {
		
		return Constants.Messages.ID_CUSTOMER;
	}
	
	public static String getOrderIdMessage() {
		
		return Constants.Messages.ID_ORDER;
	}
	
	public static String getIdNotFoundMessage() {
		
		return Constants.Messages.ID_NOT_FOUND;
	}
	
	public static String getNoPendingOrdersMessage() {
		
		return Constants.Messages.NO_PENDING;
	}
	
	public static String getNoDeliveredOrdersMesssage() {
		
		return Constants.Messages.NO_DELIVERED;
	}
	
	
	public static String getAddProductsMessage() {
		
		return Constants.Messages.EMPTY_PRODUCTS;
	}
}
	