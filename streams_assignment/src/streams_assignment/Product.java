package streams_assignment;

public class Product {

	 long id;
	 String name;
	 String category;	
	 double price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(long id, String name, String category, double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}


	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.getName() + " " + this.getCategory() + " " + this.getPrice();
	}

	 
	 
}