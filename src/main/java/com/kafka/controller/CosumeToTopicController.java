package com.kafka.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.kafka.model.Employee1;
import com.kafka.service.EmployeeService;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

@Component
@RestController
public class CosumeToTopicController {

	private final EmployeeService empService;

	public CosumeToTopicController(EmployeeService empService) {
		this.empService = empService;
	}

	

	static final String TOPIC = "topic2";

	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
    private Gson gson;
	
	
    @KafkaListener(topics ="topic1" )
    public void getTopics(List<Employee1> empList) {
        for (Employee1 emp : empList) {
			String employeeId = Long.toString(emp.getEmployeeId());
			double sal = (emp.getSalary() * 10)/100;
			emp.setSalary(sal);
			kafkaTemplate.send(TOPIC, employeeId, gson.toJson(emp));
		}
        
    }


}
