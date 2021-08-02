package com.kafka.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.kafka.model.Employee1;
import com.kafka.model.Employee2;
import com.kafka.service.EmployeeService;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

@Component
@RestController
public class ConsumerController {

	private final EmployeeService employeeService;

	public ConsumerController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	
	@Autowired
    private Gson gson;
	
	@PostMapping("/saveEmployess")
    @KafkaListener(topics = "topic2", groupId = "myGroupId",containerFactory = "kafkaListener")
    public void consume(Employee1 emp){
        //for (Employee1 emp : empList) {
        	//Employee2 employee =  gson.fromJson(emp, Employee1.class);
        	Employee2 employee = new Employee2();
        	BeanUtils.copyProperties(emp, employee);
        	employeeService.saveEmployee(employee);
		//}
        
    }

}