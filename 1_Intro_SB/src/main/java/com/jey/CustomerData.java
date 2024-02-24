package com.jey;

import java.util.ArrayList;
import java.util.List;

public class CustomerData {
	
	private List<Customer> customers = new ArrayList<>();

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public void addCustomer(Customer cus) {
        customers.add(cus);
    }
	
	public void updateCustomer(Customer cus) {
		for (Customer customer : customers) {
            if(customer.getName().equals(cus.getName())) {
                customer.setAge(cus.getAge());
            }
        }
    }
	
	public void deleteCustomer(String name) {
		customers.removeIf(c -> c.getName().equals(name));
	}
}