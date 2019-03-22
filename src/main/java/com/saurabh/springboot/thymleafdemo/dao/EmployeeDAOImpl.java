package com.saurabh.springboot.thymleafdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saurabh.springboot.thymleafdemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private EntityManager entitymanager;
	
	@Autowired //automatically created by spring boot(entitymanager) and injected
	public EmployeeDAOImpl(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}



	@Override
	public List<Employee> getAllEmployee() {
		Session session=entitymanager.unwrap(Session.class);
		Query<Employee> query=session.createQuery("from Employee",Employee.class);
		List<Employee> list=query.getResultList();
		return list;
	}



	@Override
	public Employee getEmployeeById(int empId) {
		Session session=entitymanager.unwrap(Session.class);
		Employee employee=session.get(Employee.class,empId);
		
		return employee;
	}



	@Override
	public void addorUpdateEmployee(Employee emp) {
		Session session=entitymanager.unwrap(Session.class);
		if(emp.getId()!=0)
		{
			session.update(emp);
		}else
		{
			session.save(emp);
		}
	}



	@Override
	public String deleteEmployee(int empId) {
		Session session=entitymanager.unwrap(Session.class);
		Employee employee=session.get(Employee.class,empId);
		if(employee!=null)
		{
			session.delete(employee);
			
		}
		return "Employee with Id :"+empId+" is  deleted.";
	}

}
