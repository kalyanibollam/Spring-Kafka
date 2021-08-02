package com.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.kafka.model.Employee1;

@Repository
@EnableJpaRepositories
public interface Employee1Repository extends JpaRepository<Employee1, Long>{

}
