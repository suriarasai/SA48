package edu.nus.iss.simpledemo;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import edu.nus.iss.simpledemo.model.Employee;
import edu.nus.iss.simpledemo.model.ParkingSpace;
import edu.nus.iss.simpledemo.util.PersistenceManager;

public class TestOneToOne {
	public static void main(String[] args) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		System.out.println("One to One From Employee");
		List<Employee> e = em.createQuery("Select e From Employee e Where e.name LIKE \'Dilbert\'", Employee.class).getResultList();
		for (Iterator iterator = e.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee);
			System.out.println(employee.getParkingSpace().toString());
		}
		System.out.println("One to One From Parking Space");
		ParkingSpace ps = em.find(ParkingSpace.class, 6);
		System.out.println(ps);
		System.out.println(ps.getEmployee().toString());
		em.close();
	}
}
