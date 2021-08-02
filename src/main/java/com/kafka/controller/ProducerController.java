package com.kafka.controller;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.kafka.model.Employee1;
import com.kafka.service.EmployeeService;

@Component
@RestController
public class ProducerController {

	private final EmployeeService employeeService;

	public ProducerController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public static final String TOPIC = "topic1";
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
    private Gson gson;
	
	@GetMapping("/publish/employees")
	public String publishToTopic() throws Throwable {

		List<Employee1> empList = employeeService.getAllEmployees();
		
		for (Employee1 emp : empList) {
			String employeeId = Long.toString(emp.getEmployeeId());
			kafkaTemplate.send(TOPIC, employeeId, gson.toJson(emp));
		}
		kafkaTemplate.flush();
		

		return "Employee details Published to Kafka Topic Successfully";
	}

}