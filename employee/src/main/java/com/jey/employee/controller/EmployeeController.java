package com.jey.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jey.employee.entity.Employee;
import com.jey.employee.service.EmployeeServiceImpl;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl empService;
	
	@GetMapping("/test")
	public ResponseEntity<String> testAPI(){
		return new ResponseEntity<>("Employee API is working fine", HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<>(empService.getAllEmployee(), HttpStatus.OK);
	}
	
	@PostMapping("/{name}")
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name){
		return new ResponseEntity<Employee>(empService.getEmployeeByName(name), HttpStatus.OK);	
	}
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
	return new ResponseEntity<Employee>(empService.createEmployee(employee), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(empService.updateEmployee(id, employee), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
		return new ResponseEntity<Employee>(empService.deleteEmployee(id), HttpStatus.OK);
	}

}
