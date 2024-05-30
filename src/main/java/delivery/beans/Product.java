package delivery.beans;

public enum Product {
	
	BURRITO("Burrito", "Pin", 6.5),
	HAMBURGUER("Hamburger", "Cap", 8.9),
	KEBAB("Kebab", "", 4.5),
	PIZZA("Pizza", "", 7.9);
	
	private String name;
	private String gift;
	private double price;

	private Product(String name, String gift, double price) {
		this.name = name;
		this.gift = gift;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	
	public String getGift()	{
		return gift;
	}
	
	public double getPrice() {
		return price;
	}
}
