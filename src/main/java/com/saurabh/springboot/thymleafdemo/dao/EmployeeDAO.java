package com.saurabh.springboot.thymleafdemo.dao;

import java.util.List;

import com.saurabh.springboot.thymleafdemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int empId);
	public void addorUpdateEmployee(Employee emp);
	public String deleteEmployee(int empId);
	

}
