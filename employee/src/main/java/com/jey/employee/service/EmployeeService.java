package com.jey.employee.service;

import java.util.List;

import com.jey.employee.entity.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee getEmployeeByName(String name);
	public Employee updateEmployee(Long id, Employee employee);
	public Employee deleteEmployee(Long id);

}
