package delivery.main;

import delivery.handlers.CRMHandler;

public class DeliveryMain {

	public static void main(String[] args) {
		
		CRMHandler delivery = new CRMHandler();
		delivery.runDelivery();
	}
}
