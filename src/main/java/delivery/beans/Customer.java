package delivery.beans;

public class Customer {
	
	private int customerId;
	private static int customerIdNext = 1;
	private String name;
	private String address;
	
	public Customer(String name, String address) {
		super();
		this.customerId = customerIdNext;
		Customer.customerIdNext++;
		this.name = name;
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + "]";
	}
	
}
