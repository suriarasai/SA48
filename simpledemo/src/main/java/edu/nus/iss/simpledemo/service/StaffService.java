package edu.nus.iss.simpledemo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.nus.iss.simpledemo.model.Staff;
import edu.nus.iss.simpledemo.util.PersistenceManager;

public class StaffService {
	
	private EntityManager em;

	public StaffService() {
		em = PersistenceManager.INSTANCE.getEntityManager();
	}
	
	public Staff createStaff(Staff s) {
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		return s;
	}
	public Staff updateStaffNickName(int id, String nn) {
		em.getTransaction().begin();
		Staff s = findStaffById(id);
		s.setNickname(nn);
		em.persist(s);
		// specific setters and persist
		em.getTransaction().commit();
		return s;
	}
	public Staff findStaffById(int id) {
		return em.find(Staff.class, id);
	}
	
	public List<Staff> findAllStaff() {
		//1. Criteria Query
		//2. Typed Query
		//3. Named Query
		//4. Native Query
		// Typed Query - select * from staff 
		TypedQuery<Staff> tquery = em.createQuery("Select s From Staff s",Staff.class);
		return tquery.getResultList();
	}
	
	public void removeStaff(int id) {
		em.getTransaction().begin();
		Staff s = findStaffById(id);
		em.remove(s);
		em.getTransaction().commit();
		System.out.println("Remove"+s);
	}
	
	

}
