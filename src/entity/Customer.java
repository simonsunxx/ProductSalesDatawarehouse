package entity;

public class Customer {
	int customer_id;
	int country_id;
	
	public Customer(int customer_id, int country_id) {
		super();
		this.customer_id = customer_id;
		this.country_id = country_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	

}
