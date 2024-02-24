package streams_assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StreamAPIExample {

	static List<Product> productList;
	static List<Customer> customerList;
	static List<Order> orderList;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		loadData();
		assignment6();
	}
	/**
	 * Obtain a list of products belongs to category “Games” with price > 100
	 */
	public static void assignment1(){

		List<Product> res = productList.stream().filter(product -> product.getCategory().equals("Games"))
				.filter(product -> product.getPrice() > 100).collect(Collectors.toList());
		res.forEach(product -> System.out.println(product.getName() + " " + product.getCategory() + " " + product.getPrice()));
	}
	
	/**
	 * Obtain a list of product with category = “Course” and then apply 10% discount
	 */
	public static void assignment2(){
		
		List<Product> res = productList.stream().filter(product -> product.getCategory().equals("Course"))
		.map(product -> {
			double newPrice = (0.1*product.getPrice())+ product.getPrice();
			return new Product(product.getId(), product.getName(), product.getCategory(), newPrice);
		})
		.collect(Collectors.toList());
		res.forEach(product -> System.out.println(product.getName() + " " + product.getCategory() + " " + product.getPrice()));
		
		
	}
	
	/**
	 * Get the cheapest products of “Books” category
	 */
	public static void assignment3(){
		
		productList.stream().filter(product -> product.getCategory().equals("Books"))
		.sorted(Comparator.comparing(Product::getPrice)).limit(1)
		.forEach(product -> System.out.println(product.getName() + " " + product.getCategory() + " " + product.getPrice()));
		
	}
	
	/**
	 * Get the 3 most recent placed order
	 */
	public static void assignment4(){

		List<Order> orders = orderList.stream().sorted(Comparator.comparing(Order::getOrderDate).reversed()).limit(3).collect(Collectors.toList());
		orders.forEach(order -> System.out.println(order.getCustomer().getName() + " " + order.getOrderDate()));
		
	}	
	
	/**
	 * Get a list of orders which were ordered on 15-June-2023, log the order records to the console and then return its product list
	 */
	public static void assignment5(){

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		orderList.stream().filter(order -> {
			try {
				return order.getOrderDate().equals(dateFormat.parse("2023-06-15"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		})
		.forEach(order -> System.out.println(order.getCustomer().getName() + " " + order.getOrderDate()));
		
	}
	
	/**
	 * Calculate total lump sum of all orders placed in May 2023
	 */
	public static void assignment6(){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		double res = orderList.stream().filter(order -> order.getOrderDate().getMonth() == 2)
		.mapToDouble(order -> order.getProducts().stream().mapToDouble(product -> product.getPrice()).sum()).sum();
		
		System.out.println(res);	
	}
	
	/**
	 * Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category “Books”
	 */
	public static void assignment7(){
		
		long count = productList.stream().filter(product -> product.getCategory().equals("Books")).count();
		System.out.println(count);
		double sum = productList.stream().filter(product -> product.getCategory().equals("Books")).mapToDouble(product -> product.getPrice()).sum();
		System.out.println(sum);
		double max = productList.stream().filter(product -> product.getCategory().equals("Books")).mapToDouble(product -> product.getPrice()).max().orElse(0.0);	
		double min = productList.stream().filter(product -> product.getCategory().equals("Books")).mapToDouble(product -> product.getPrice()).min().orElse(0.0);	
		System.out.println(max);
		System.out.println(min);
	
	}
	
	/**
	 * Obtain a data map with list of product name by category
	 */
	public static void assignment8(){
		
		Map<String, List<Product>> products = productList.stream().collect(Collectors.groupingBy(Product::getCategory));
		
		System.out.println("**************************");
		for(Entry<String, List<Product>> product: products.entrySet()) {
			System.out.println(product.getKey().toUpperCase());
			product.getValue().forEach(System.out::println);
			System.out.println("**************************");
		}
		
	}
	
	/**
	 * Get the most expensive product by category
	 */
	public static void assignment9(){
		
	}
	
	public static void loadData() {
		try {
			productList = new ArrayList<>();
			customerList = new ArrayList<>();
			orderList = new ArrayList<Order>();
			
			
			customerList.add(new Customer(1, "John Walker", 1));
			customerList.add(new Customer(2, "Marcus Tucker", 1));
			customerList.add(new Customer(3, "Sheldon Cooper", 1));
			customerList.add(new Customer(4, "Harry Potter", 2));
			customerList.add(new Customer(5, "Jack B. Daniel", 0));
			customerList.add(new Customer(6, "Dino Walter", 2));
			customerList.add(new Customer(7, "Sir Issac Newton", 1));
			customerList.add(new Customer(8, "Eroy Dickson", 2));
			customerList.add(new Customer(9, "Nick Donton", 1));
			customerList.add(new Customer(10, "Away Retuer", 1));
			
			productList.add(new Product(1, "Super Mario", "Games", 180));
			productList.add(new Product(2, "Pokemon", "Toys", 2));
			productList.add(new Product(3, "Wheat", "Grocery", 5));
			productList.add(new Product(4, "Java : A Definative Guide", "Books", 12));
			productList.add(new Product(5, "Java Backend Development Live", "Course", 50));
			productList.add(new Product(6, "Nintendo Switch", "Games", 250));
			productList.add(new Product(7, "Macbook Sleeve", "Tech", 20));
			productList.add(new Product(8, "Infinte Loop Tshirt", "Apparel", 100));
			productList.add(new Product(9, "MERN Stack Live", "Course", 45));
			productList.add(new Product(10, "Tzar", "Games", 25));
			productList.add(new Product(11, "Call Of Duty", "Books", 55));
			productList.add(new Product(12, "UNO Club Cards", "Toys", 24));
			productList.add(new Product(13, "Dancing Car", "Toys", 50));
			productList.add(new Product(14, "Lays Masala Magic", "Books", 2));
			productList.add(new Product(15, "Butter Salted", "Grocery", 1));
			
			List<Product> orderProductList = new ArrayList<>();
			orderProductList.add(new Product(1, "Super Mario", "Games", 180));
			orderProductList.add(new Product(2, "Pokemon", "Toys", 2));
			orderProductList.add(new Product(12, "UNO Club Cards", "Toys", 24));
			orderProductList.add(new Product(11, "Call Of Duty", "Games", 55));
			
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			orderList.add(new Order(1, dateFormat.parse("2023-02-28"), dateFormat.parse("2023-03-08"), "DELIVERED", new Customer(2, "Marcus Tucker", 1),orderProductList) );

			
			orderProductList = new ArrayList<>();
			orderProductList.add(new Product(3, "Wheat", "Grocery", 5));
			orderProductList.add(new Product(7, "Macbook Sleeve", "Tech", 20));
			orderProductList.add(new Product(10, "Tzar", "Games", 25));
			
			orderList.add(new Order(2, dateFormat.parse("2023-04-10"), null, "NEW", new Customer(4, "Harry Potter", 2),orderProductList) );
		
			orderProductList = new ArrayList<>();
			orderProductList.add(new Product(5, "Java Backend Development Live", "Course", 50));
			orderProductList.add(new Product(7, "Macbook Sleeve", "Tech", 20));
			orderProductList.add(new Product(8, "Infinte Loop Tshirt", "Apparel", 100));
			
			orderList.add(new Order(3, dateFormat.parse("2023-03-22"), null, "DELIVERED", new Customer(4, "Harry Potter", 2),orderProductList) );
		

			orderProductList = new ArrayList<>();
			orderProductList.add(new Product(3, "Wheat", "Grocery", 5));
			orderProductList.add(new Product(7, "Macbook Sleeve", "Tech", 20));
			orderProductList.add(new Product(5, "Java Backend Development Live", "Course", 50));
			
			orderList.add(new Order(4, dateFormat.parse("2023-03-28"), null, "DELIVERED", new Customer(4, "Harry Potter", 2),orderProductList) );
		
			orderProductList = new ArrayList<>();
			orderProductList.add(new Product(5, "Java Backend Development Live", "Course", 50));
			orderProductList.add(new Product(8, "Infinte Loop Tshirt", "Apparel", 100));
			orderProductList.add(new Product(10, "Tzar", "Games", 25));
			
			orderList.add(new Order(5, dateFormat.parse("2023-03-15"), null, "PENDING", new Customer(4, "Harry Potter", 2),orderProductList) );
		

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	

}