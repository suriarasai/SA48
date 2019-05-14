package edu.nus.iss.simpledemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.nus.iss.simpledemo.model.Department;
import edu.nus.iss.simpledemo.model.Employee;
import edu.nus.iss.simpledemo.model.User;
import edu.nus.iss.simpledemo.util.PersistenceManager;

public class QueryExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		System.out.println("Query Examples");
		System.out.println("Simple Query Example");
		Query qry = em.createQuery("Select e From Employee e");
		ArrayList<Employee> elist = (ArrayList<Employee>) qry.getResultList();
		for (Employee employee : elist) {
			System.out.println(employee);
		}
		System.out.println("Named Query Example");
		String queryName = "Department.findAll";
		Query query = em.createNamedQuery(queryName);
		List<Department> listDepartments = query.getResultList();
		for (Department department : listDepartments) {
			System.out.println(department);
		}
		System.out.println("Named Query with Parameters Example");
		String queryNName = "Employee.findByName";
		Query query1 = em.createNamedQuery(queryNName);
		query1.setParameter("name", "Dilbert");
		List<Employee> listEmployee = query1.getResultList();
		for (Employee employee : listEmployee) {
			System.out.println(employee);
		}
		System.out.println("Native Query Example");
		Query queryNative = em.createNativeQuery("SELECT USER.* FROM USER WHERE USERID = ?");
		queryNative.setParameter(1, 1);
		User u = (User) queryNative.getSingleResult();
		System.out.println(u.toString());
		System.out.println("Criteria Query Example");
	}

}
