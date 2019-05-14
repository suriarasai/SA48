package edu.nus.iss.simpledemo;

import javax.persistence.EntityManager;

import edu.nus.iss.simpledemo.model.Employee;
import edu.nus.iss.simpledemo.util.PersistenceManager;

public class TestManyToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		System.out.println("Many to One From Employee");
		Employee employee = em.createQuery("Select e from Employee e Where e.name like \'Cat%\'", Employee.class).getSingleResult();
		System.out.println(employee);
		System.out.println(employee.getDepartment().toString());
		em.close();
	}

}
