package com.kafka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kafka.model.Employee1;
import com.kafka.model.Employee2;
import com.kafka.repository.Employee1Repository;
import com.kafka.repository.Employee2Repository;


public class EmployeeService {
	
	@Autowired
	Employee1Repository employee1Repository;

	@Autowired
	Employee2Repository employee2Repository;
	
	public List<Employee1> getAllEmployees() {
		List<Employee1> response = employee1Repository.findAll();
		return response;
	}

	public void saveEmployee(Employee2 employee2) {
		employee2Repository.save(employee2);
	}

}
