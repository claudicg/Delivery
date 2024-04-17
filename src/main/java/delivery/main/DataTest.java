package delivery.main;

import java.util.List;

import delivery.beans.Customer;
import delivery.beans.DeliveryPerson;
import delivery.enums.DeliveryTypeEnum;

public class DataTest {
	
public void addDeliveryPersons(List<DeliveryPerson> availableForDeliveryPersons) {
		
		DeliveryPerson person1 = new DeliveryPerson("Joan Garrido", DeliveryTypeEnum.ON_FOOT.getDeliveryType());
		availableForDeliveryPersons.add(person1);
		DeliveryPerson person2 = new DeliveryPerson("Carmen Salcedo", DeliveryTypeEnum.BICYCLE.getDeliveryType());
		availableForDeliveryPersons.add(person2);
		DeliveryPerson person3 = new DeliveryPerson("José Pizarro", DeliveryTypeEnum.MOTORCYCLE.getDeliveryType());
		availableForDeliveryPersons.add(person3);
	}
	
	public void addCustomers(List<Customer> customers) {
		
		Customer customer1 = new Customer("Sandra", "Carrer Mallorca 234");
		customers.add(customer1);
		Customer customer2 = new Customer("Jordi", "Carrer Provenza 357");
		customers.add(customer2);
		Customer customer3 = new Customer("Pedro", "Carrer Casanova 296");
		customers.add(customer3);
	}
}
