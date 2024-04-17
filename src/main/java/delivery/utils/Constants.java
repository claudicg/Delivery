package delivery.utils;

public class Constants {
	
	public class DeliveryType	{
		public static final String ON_FOOT = "Delivery on foot is free.\n";
		public static final String BICYCLE = "It includes a one percent total amount charge for bicycle delivery.\n";
		public static final String MOTORCYCLE = "It includes a two percent total amount charge for motorcycle delivery.\n";
	}
	
	public class Exceptions	{
		public static final String DELIVERY_PERSON = " There aren't any delivery persons available.\n"
				+ "It's not possible to place a new order.\n\n";
	}
	
	public class Messages {
		public static final String EXIT = "Closing down.";
		public static final String CHOOSE = "Choose a valid option:\n";
		public static final String DELIVERED = "The order has been delivered.\n";
		public static final String ID_CUSTOMER = "Enter a customer valid id: \n";
		public static final String ID_ORDER = "Enter a valid order id: ";
		public static final String ID_NOT_FOUND = "Id not found.\n";
		public static final String NO_PENDING = "There are no pending orders.\n";
		public static final String NO_DELIVERED = "There are no delivered orders.\n";
		public static final String EMPTY_PRODUCTS = "There are no products in the order. Add one.\n";
	}
}
