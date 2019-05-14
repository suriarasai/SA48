package edu.nus.iss.simpledemo;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;

import edu.nus.iss.simpledemo.model.Employee;
import edu.nus.iss.simpledemo.model.Project;
import edu.nus.iss.simpledemo.util.PersistenceManager;

public class TestManyToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		System.out.println("Many to Many From Employee");
		Employee employee = em.createQuery("Select e from Employee e Where e.name like \'Dil%\'",Employee.class).getSingleResult();
		System.out.println(employee);
		System.out.println("Project the employee works for:");
		Collection<Project> plist = employee.getProjects();
		for (Project project : plist) {
			System.out.println(project.toString());
		}
		System.out.println("Many to Many From Project");
		Project project = em.createQuery("Select p from Project p Where p.name like \'ASP%\'",Project.class).getSingleResult();
		System.out.println(project);
		System.out.println("Employees who work in the project:");
		Collection<Employee> elist = project.getEmployees();
		for (Employee employee1 : elist) {
			System.out.println(employee1.toString());
		}
		em.close();
	}
}
