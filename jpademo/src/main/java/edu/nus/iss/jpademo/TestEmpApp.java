package edu.nus.iss.jpademo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class TestEmpApp {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		EmployeeService service = new EmployeeService();
		//   create and persist an employee
		Employee emp1 = service.createEmployee(150, "Kung Fu Panda Po", 40000);
		System.out.println("Persisted " + emp1.toString());
		Employee emp2 = service.createEmployee(152, "Master Oogway", 41000);
		System.out.println("Persisted " + emp2.toString());
		Employee emp3 = service.createEmployee(154, "Master Shifu", 42000);
		System.out.println("Persisted " + emp3.toString());
		Employee emp4 = service.createEmployee(156, "Tai Lung", 43000);
		System.out.println("Persisted " + emp4.toString());
		Employee emp = service.createEmployee(158, "Master Tigress", 45000);
		System.out.println("Persisted " + emp.toString());
		// find a specific employee
		emp = service.findEmployee(158);
		System.out.println("Found " + emp);
		// find all employees
		List<Employee> emps = service.findAllEmployees();
		System.out.println("Listing" + emps.size());
		for (Employee e : emps)
			System.out.println(e);
		emp = service.raiseEmployeeSalary(158, 1000);
		System.out.println("Updated " + emp);
	    emps = service.findAllEmployees();
	    System.out.println("Listing");
		for (Employee e : emps)
			System.out.println(e);
		service.removeEmployee(158);
		System.out.println("Removed Employee 158");
		emps = service.findAllEmployees();
		System.out.println("Listing");
		for (Employee e : emps)
			System.out.println(e);

	}
}
