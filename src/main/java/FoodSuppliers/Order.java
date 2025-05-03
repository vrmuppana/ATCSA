package FoodSuppliers;

import java.util.HashMap;
import java.util.Map;

public class Order{

	private String restaurantName;
	private Map<String, Integer> product;
	
	public Order(String restaurantName, HashMap<String, Integer> map) {
		this.restaurantName=restaurantName;
		this.product=map;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public Map<String, Integer> getProduct() {
		return product;
	}
	
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	public String toString() {
		return restaurantName+" :"+product+"";
	}


//	public void setProduct(int product) {
//		this.product = product;
//	}
	
	
	
}
