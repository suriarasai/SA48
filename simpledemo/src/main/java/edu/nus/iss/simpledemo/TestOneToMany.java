package edu.nus.iss.simpledemo;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import edu.nus.iss.simpledemo.model.Department;
import edu.nus.iss.simpledemo.model.Employee;
import edu.nus.iss.simpledemo.util.PersistenceManager;

public class TestOneToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		System.out.println("One to Many From Department");
		List<Department> dlist = em.createQuery("Select d From Department d Where d.name like \'Eng%\'", Department.class).getResultList();
		for (Iterator iterator = dlist.iterator(); iterator.hasNext();) {
			Department department = (Department) iterator.next();
			System.out.println("Department"+department);
			Collection<Employee> elist = department.getEmployees();
			for (Iterator iterator2 = elist.iterator(); iterator2.hasNext();) {
				Employee employee = (Employee) iterator2.next();
				System.out.println("Employee"+employee);
			}
		}
		em.close();
		
	}

}
