package FoodSuppliers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FoodSupplier {

	HashMap<Date, LinkedList<Order>> database;

	public FoodSupplier() {
		database = new HashMap<Date, LinkedList<Order>>();
	}

	public void add(String line) throws ParseException {
		String[] arr = line.split(" ");
		if (arr.length > 1) {
			String pattern = "MM-dd-yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			Date d = simpleDateFormat.parse(arr[0]);
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("burgers", 0);
			map.put("buns", 0);
			map.put("cups", 0);
			map.put("straws", 0);
			map.put("fries", 0);
			map.put("napkins", 0);
			map.put("cokesyrup", 0);
			for (int i = 2; i < arr.length; i++) {
				String[] arr2 = arr[i].split("-");
				map.put(arr2[0], Integer.parseInt(arr2[1]));
			}
			Order or = new Order(arr[1], map);
			database.putIfAbsent(d, new LinkedList<Order>());
			database.get(d).add(or);
//			System.out.println(arr[1]);
		}
	}

	public void print() {
		for (Date date : database.keySet()) {
			String pattern = "MM-dd-yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			System.out.print(simpleDateFormat.format(date) + "\t");
			System.out.println(database.get(date));
		}
	}

	public Date dateWithMostItems() {
		int longest = 0;
		Date result = new Date();
		for (Date date : database.keySet()) {
			if (database.get(date).size() > longest) {
				result = date;
				longest = database.get(date).size();
			}
		}
		return result;
	}

	public String orderedMostProduct(String product) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int highest = 0;
		String result = "";
		for (Date date : database.keySet()) {
			for (Order or : database.get(date)) {
//				System.out.println(or.getRestaurantName());
				String restaurant = or.getRestaurantName().substring(0, or.getRestaurantName().indexOf('#'));
//				System.out.print(restaurant);
				map.putIfAbsent(restaurant, 0);
				map.put(restaurant, map.get(restaurant) + or.getProduct().get(product));
				if (map.get(restaurant) > highest) {
					result = restaurant;
				}
			}
		}
		return result;
	}

	public String longestBetweenOrders() {
		String result = "";
		HashMap<String, Object[]> map = new HashMap<String, Object[]>();
		for (Date date : database.keySet()) {
			for (Order or : database.get(date)) {
				String restaurant = or.getRestaurantName();
				if (!map.containsKey(restaurant)) {
					map.put(restaurant, new Object[] { 0, date }); // if new restaurant add into map
				} else {
					int diffInDays = (int) ((date.getTime() - ((Date) map.get(restaurant)[1]).getTime()) / 100 / 60
							/ 24);
					if ((int) map.get(restaurant)[0] < diffInDays) {
						map.put(restaurant, new Object[] { diffInDays, date });
					} else {
						map.put(restaurant, new Object[] { map.get(restaurant)[0], date });
					}
				}
			}
		}
		String highest = "";
		for (String st : map.keySet()) {
			if (highest.isEmpty()) {
				highest = st;
			}
			if ((int) map.get(highest)[0] < (int) map.get(st)[0]) {
				highest = st;
			}
		}
		return highest;

	}

	public String orderedMostProduct(String product, int year) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int highest = 0;
		String result = "";
		for (Date date : database.keySet()) {
			if (1900 + date.getYear() == year) {
				for (Order or : database.get(date)) {
//					System.out.println(or.getRestaurantName());
					String restaurant = or.getRestaurantName().substring(0, or.getRestaurantName().indexOf('#'));
//					System.out.print(restaurant);
					map.putIfAbsent(restaurant, 0);
					map.put(restaurant, map.get(restaurant) + or.getProduct().get(product));
					if (map.get(restaurant) > highest) {
						result = restaurant;
					}
				}
			}
		}
		return result;
	}

	public Set<Order> ordersInDay(Date day) {
        Set<Order> set = new HashSet<Order>(database.get(day));
		return set;
	}

	public Set<Order> ordersInMonth(String month) {
		String[] arr = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		Set<Order> set = new HashSet<Order>();
		for (Date date : database.keySet()) {
			if (month.equalsIgnoreCase(arr[date.getMonth()])) {
				set.addAll(database.get(date));
			}
		}
		return set;
	}
	
//	return a set of duplicate orders of a given day - (use 1-9-2010 to test)
	public Set<Object[]> duplicateOrdersInDay(Date day) {
		Set<Object[]> set = new HashSet<Object[]>();
		Scanner sc = new Scanner(System.in);
		if (database.get(day) == null ) {
			throw new NullPointerException("There are no orders on this day");
		}
		for (Order or : database.get(day)) {
			System.out.println(or + "\n");
		}
		System.out.println("Pick a number from 1 to " + database.get(day).size());
		int input = sc.nextInt();
		Order or = database.get(day).get(input-1);
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		System.out.println(simpleDateFormat.format(day) + " - " + or);
		System.out.println("---------");
		for (Date date : database.keySet()) {
			for (Order order : database.get(date)) {
				if (order.getRestaurantName().equals(or.getRestaurantName()) && order.getProduct().equals(or.getProduct())) {
					set.add(new Object[]{date, order});
				}
			}
		}

		for (Object[] arr : set) {
			for (Order order : database.get((Date) arr[0])) {
				if (order.getRestaurantName().equals(or.getRestaurantName()) && (Date) arr[0] != day) {
					System.out.println(simpleDateFormat.format((Date) arr[0]) + " - " + (Order) arr[1]);
				}
			}
		}

		return set;
	}

	/*return a set of the companies that ordered at least a (given number) of (burgers)
in a (given year) (3 parameters)*/

	public Set<String> minimumAmountProductInYear(int num, String product, Date year) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (Date date : database.keySet()) {
			for (Order or : database.get(date)) {
				if (date.getYear()==year.getYear()) {
					String company = or.getRestaurantName().substring(0, or.getRestaurantName().indexOf("#"));
					map.putIfAbsent(company, 0);
					map.put(company, map.get(company)+or.getProduct().get(product));
				}
			}
		}
		Set<String> set = new HashSet<>();
		for (String st : map.keySet()) {
			if (map.get(st)>=num) {
				set.add(st);
			}
		}
		return set;
	}

	/*
	return a set of all of the orders for a given (company) in a given Date interval (3 parameters)
	 */

	public Set<Order> ordersForCompanyRange(String company, Date date2, Date date1) {
		if (date1.after(date2)) {
			Date d1 = date2;
			Date d2 = date1;
		}
		Date d1 = date1;
		Date d2 = date2;

		Set<Order> set = new HashSet<Order>();

		for (Date date : database.keySet()) {
			for (Order or : database.get(date)) {
				if (date.after(d2))
					return set;
				if (or.getRestaurantName().substring(0, or.getRestaurantName().indexOf("#")).equalsIgnoreCase(company) && date.compareTo(d1) >= 0)
					set.add(or);
			}
		}
		return set;
	}

	/*
	print out a summary/total for orders from a given (company) in a given Date interval (3 parameters)
	 */

//	public Set<Order> summaryForCompany(String company) {
//
//	}

	public String toString() {
		String result = "";
		for (Date date : database.keySet()) {
			String pattern = "MM-dd-yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			result += simpleDateFormat.format(date) + "\t";
			result += database.get(date);
			result += "\n";
		}
		return result;
	}

//	public void addOrder(Order o) {
//
//	}

}
