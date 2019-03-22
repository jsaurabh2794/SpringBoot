package com.saurabh.springboot.thymleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saurabh.springboot.thymleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepositorySpringJPA employeeSpringJpa;
	
	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		
		//return employeeSpringJpa.findAll() ;
		return employeeSpringJpa.findAllByOrderByLastNameAsc();
	}

	@Override
	@Transactional // no need of @transactional....spring jpa provides automatically
	public Employee getEmployeeById(int empId) {
		
		Optional<Employee> result = employeeSpringJpa.findById(empId);
		Employee employee=null;
		if(result.isPresent())
		{
			employee=result.get();
		}else
		{
			throw new RuntimeException("Did not find employee with id: "+empId+" .");
		}
		return employee;
	}

	@Override
	@Transactional
	public void addorUpdateEmployee(Employee emp) {
		
		employeeSpringJpa.save(emp); //free mthoda given by jparepository
	}

	@Override
	@Transactional
	public String deleteEmployee(int empId) {
		employeeSpringJpa.deleteById(empId);
		return "Employee with id: "+empId+" is deleted successfully";
	}

}
