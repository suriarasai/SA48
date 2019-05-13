package edu.nus.iss.jpademo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmployeeService {

	protected EntityManager em;

	public EmployeeService() {
		this.em = PersistanceManager.INSTANCE.getEntityManager();
	}

	public Employee createEmployee(int id, String name, long salary) {
		em.getTransaction().begin();
		Employee emp = new Employee(id);
		emp.setName(name);
		emp.setSalary(salary);
		em.persist(emp);
		em.getTransaction().commit();
		return emp;
	}

	public void removeEmployee(int id) {
		em.getTransaction().begin();
		Employee emp = findEmployee(id);
		if (emp != null) {
			em.remove(emp);
		}
		em.getTransaction().commit();
	}

	public Employee raiseEmployeeSalary(int id, long raise) {
		em.getTransaction().begin();
		Employee emp = em.find(Employee.class, id);
		if (emp != null) {
			emp.setSalary(emp.getSalary() + raise);
		}
		em.getTransaction().commit();
		return emp;
	}

	public Employee findEmployee(int id) {
		return em.find(Employee.class, id);
	}

	public List<Employee> findAllEmployees() {
		TypedQuery<Employee> query = em.createQuery("Select e FROM Employee e", Employee.class);
		return query.getResultList();
	}
}
