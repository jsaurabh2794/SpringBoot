package com.saurabh.springboot.thymleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saurabh.springboot.thymleafdemo.entity.Employee;
import com.saurabh.springboot.thymleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/list")
	public String getEmployeesList(Model model)
	{
		List<Employee> employees=employeeservice.getAllEmployee();
		model.addAttribute("theEmployee", employees);
		return "employee-list";
	}

	@GetMapping("/showForm")
	public String showForm(Model model)
	{
		Employee emp=new Employee();
		model.addAttribute("Employee", emp);
		return "employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int employeeId,Model model)
	{
		Employee emp=employeeservice.getEmployeeById(employeeId);
		model.addAttribute("Employee", emp);
		return "employee-form";
	}
	
	@GetMapping("/deleteById")
	public String deleteById(@RequestParam("id") int employeeId,Model model)
	{
		employeeservice.deleteEmployee(employeeId);
		return "redirect:/employees/list";
	}
	
	
	@PostMapping("/save")
	public String saveForm(@ModelAttribute("Employee") Employee employee)
	{
		employeeservice.addorUpdateEmployee(employee);
		return "redirect:/employees/list";
	}
}
