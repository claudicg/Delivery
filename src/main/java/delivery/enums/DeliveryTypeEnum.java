package delivery.enums;

public enum DeliveryTypeEnum {
	
	ON_FOOT("On foot", 0),
	BICYCLE("Bicycle", 1),
	MOTORCYCLE("Motorcycle", 2);
	
	private String deliveryType;
	private int percentage;
	
	private DeliveryTypeEnum(String deliveryType, int percentage) {
		this.deliveryType = deliveryType;
		this.percentage = percentage;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
}
