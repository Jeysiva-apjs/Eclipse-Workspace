package streams_assignment;
public class Customer {
	long id;
	String name;
	int tier;
	public Customer(long id, String name, int tier) {
		super();
		this.id = id;
		this.name = name;
		this.tier = tier;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getTier() {
		return this.tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

	
}
