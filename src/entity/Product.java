package entity;

public class Product {
	int product_id;
	String product_name;
	String product_description;
	int category_id;
	String category_name;
	int list_price;
	int min_price;
	public Product(int product_id, String product_name,String product_description,int list_price,int min_price) 
	{
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description=product_description;
		this.list_price = list_price;
		this.min_price=min_price;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public int getList_price() {
		return list_price;
	}
	public void setList_price(int list_price) {
		this.list_price = list_price;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public int getMin_price() {
		return min_price;
	}
	public void setMin_price(int min_price) {
		this.min_price = min_price;
	}
	
	

}
