package delivery.utils;

import delivery.beans.Customer;
import delivery.beans.Order;

public class Validations {

	//Valida que sea opción de 0 a 4.
	public static boolean validateMenuOption(String option) {
		
		return option.matches("^[0-4]{1}$");
	}
	
	//Valida que sea un número natural, mayor que 0.
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
