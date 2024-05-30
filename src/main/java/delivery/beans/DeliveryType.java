package delivery.beans;

public enum DeliveryType {
	
	ON_FOOT("On foot", 0, "Delivery on foot is free.\n"),
	BICYCLE("Bicycle", 1, "It includes a one percent total amount charge for bicycle delivery.\n"),
	MOTORCYCLE("Motorcycle", 2, "It includes a two percent total amount charge for motorcycle delivery.\n");
		
	private String deliveryType;
	private int percentage;
	private String message;
	
	private DeliveryType(String deliveryType, int percentage, String message) {
		this.deliveryType = deliveryType;
		this.percentage = percentage;
		this.message = message;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public int getPercentage() {
		return percentage;
	}


	public String getMessage() {
		return message;
	}

}
