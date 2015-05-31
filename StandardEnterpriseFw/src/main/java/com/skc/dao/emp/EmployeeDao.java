package com.skc.dao.emp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skc.domain.Employee;

@Repository("empDao")
public class EmployeeDao {
	
	@PersistenceContext(unitName="myUnit")
	EntityManager em;
	
	@Transactional(value="transactionManager",readOnly=true)
	public List<Employee> fetchEmployeeByName(String name){
		TypedQuery<Employee> typedQuery = em.createNamedQuery("Employee.findAllByName", Employee.class);
		typedQuery.setParameter("name", name);
		return typedQuery.getResultList();
	}
	
	@Transactional("transactionManager")
	public void save(Employee employee){
		em.persist(employee);
	}
	
	@Transactional("transactionManager")
	public void delete(Employee employee){
		em.remove(employee);
	}
	
	@Transactional("transactionManager")
	public void update(Employee employee,Employee employee2){
		Employee employee3 = em.find(Employee.class, employee2.getId());
		employee3.setDepartnment(employee.getDepartnment());
		employee3.setName(employee.getName());
		employee3.setSalery(employee.getSalery());
		em.merge(employee3);
	}
}
