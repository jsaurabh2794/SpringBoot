package com.saurabh.springboot.thymleafdemo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.springboot.thymleafdemo.entity.Employee;

public interface EmployeeRepositorySpringJPA extends JpaRepository<Employee,Integer> {

	//no need to write any implementation of this interface
	//all crud feature is automacally created by spring...i have to just call it
	
	public List<Employee> findAllByOrderByLastNameAsc();
}
