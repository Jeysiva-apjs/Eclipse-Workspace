package com.jey.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jey.employee.entity.Employee;
import com.jey.employee.exception.EmployeeNotFoundException;
import com.jey.employee.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository emplRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return emplRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return (List<Employee>)emplRepository.findAll();
	}
	
	@Override
	public Employee getEmployeeByName(String name) {
		return this.getAllEmployee().stream().filter(emp -> emp.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee updatedEmployee =  emplRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
		updatedEmployee.setName(employee.getName());
		updatedEmployee.setAge(employee.getAge());
		emplRepository.save(updatedEmployee);
		return updatedEmployee;	
	}

	@Override
	public Employee deleteEmployee(Long id) {
		Employee deletedEmployee =  emplRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
		emplRepository.deleteById(id);
		return deletedEmployee;
	}

}
