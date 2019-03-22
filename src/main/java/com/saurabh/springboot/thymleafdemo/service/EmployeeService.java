package com.saurabh.springboot.thymleafdemo.service;

import java.util.List;

import com.saurabh.springboot.thymleafdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int empId);
	public void addorUpdateEmployee(Employee emp);
	public String deleteEmployee(int empId);
}
