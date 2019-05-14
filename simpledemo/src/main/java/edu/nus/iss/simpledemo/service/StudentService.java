package edu.nus.iss.simpledemo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.nus.iss.simpledemo.model.Student;
import edu.nus.iss.simpledemo.util.PersistenceManager;

public class StudentService {
	
	protected EntityManager em;

	public StudentService() {
		// TODO Auto-generated constructor stub
		em = PersistenceManager.INSTANCE.getEntityManager();
	}
	
	public Student createStudent(Student s) {
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		return s;
	}
	
	public Student updateStudent(Student s) {
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		return s;
	}
	
	public void removeStudent(int id) {
		Student s = em.find(Student.class, id);
		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();
	}
	
	public List<Student> findAll() {
		// Typed Query Criteria Query Native Query
		TypedQuery<Student> query = em.createQuery("Select s From Student s",Student.class);
		return query.getResultList();
	}
	
	

}
