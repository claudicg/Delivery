package delivery.beans;

public class DeliveryPerson {

	private int deliveryPersonId;
	private static int deliveryPersonIdNext = 1;
	private String name;
	private boolean available = true;
	private DeliveryType deliveryType;
	
	public DeliveryPerson(String name, DeliveryType deliveryType) {
		super();
		this.deliveryPersonId = deliveryPersonIdNext;
		DeliveryPerson.deliveryPersonIdNext++;
		this.name = name;
		this.deliveryType = deliveryType;
	}
	

	public int getDeliveryPersonId() {
		return deliveryPersonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
	public DeliveryType getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}


	@Override
	public String toString() {
		return "DeliveryPerson [deliveryPersonId=" + deliveryPersonId + ", name=" + name 
				+ ", available=" + available + ", deliveryType=" + deliveryType + "]";
	}
}
