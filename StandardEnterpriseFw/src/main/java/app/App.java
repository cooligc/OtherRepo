package app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skc.dao.emp.DepartnmentDao;
import com.skc.dao.emp.EmployeeDao;
import com.skc.domain.Departnment;
import com.skc.domain.Employee;

public class App {
	
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		

		DepartnmentDao departnmentDao = (DepartnmentDao) applicationContext.getBean("deptDao");
		EmployeeDao employeeDao = (EmployeeDao) applicationContext.getBean("empDao");
		
		Departnment departnment = new Departnment();
		departnment.setName("it");
		departnment.setDescription("IT dzxcjn");
		departnmentDao.save(departnment);
		System.out.println(departnment);
		
		Employee employee = new Employee();
		employee.setName("dsvisv");
		employee.setSalery(1500L);
		employee.setDepartnment(departnment);
		employeeDao.save(employee);
		System.out.println(employee);
		
		applicationContext.close();
		
	}
}
