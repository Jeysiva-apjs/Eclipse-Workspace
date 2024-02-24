package com.jey.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jey.employee.entity.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
}
