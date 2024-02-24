package com.jey;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	CustomerData data = new CustomerData();
	
	@GetMapping("/get")
	public String get() {
		return "Testing Get Mapping";
	}

//	@PostMapping("post/{name}")
//	public String test2(@PathVariable String name) {
//		return name + " is a naughty girl";
//	}
	
	@PostMapping("/post")
	public String test2(@RequestBody Customer customer) {
		data.addCustomer(customer);
		return customer.getName() + " is a naughty girl and age: " + customer.getAge();
	}
	
	@GetMapping("/get/all")
	public List<Customer> getAllCustomers() {
		
		return data.getCustomers();
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Customer customer) {
		data.updateCustomer(customer);
		return customer.getName() + " is updated";
	}
	
	@DeleteMapping("/delete/{name}")
	public String delete(@PathVariable String name) {
		data.deleteCustomer(name);
		return name + " is deleted";
	}
}
