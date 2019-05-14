package edu.nus.iss.simpledemo;

import javax.persistence.EntityManager;

import edu.nus.iss.simpledemo.model.Address;
import edu.nus.iss.simpledemo.model.User;
import edu.nus.iss.simpledemo.util.PersistenceManager;

public class UserAddressTest {

	public static void main(String[] args) {
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		User u = new User();
		u.setUserId(1);
		u.setUserName("Tai Lung");
		Address a = new Address();
		a.setId(1);
		a.setStreetName("Some snowy mountains");
		u.setAddress(a);
		em.getTransaction().begin();
		em.persist(a);
		em.persist(u);
		em.getTransaction().commit();
		em.close();

	}

}
