package delivery.utils;

import delivery.beans.Customer;
import delivery.beans.Order;

public class Validations {

	public static boolean validateMenuOption(String option) {
		
		return option.matches("^[0-4]{1}$");
	}
	

	public static boolean validateId(String id) {
		
		return id.matches("^[1-9]{1}[0-9]*$");
	}
	
	public static boolean checkOrderNull(Order order) {
		
		return order == null;
	}
	
	public static boolean checkCustomerNull(Customer customer) {
		
		return customer == null;
	}

}
