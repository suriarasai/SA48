package edu.nus.iss.simpledemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.nus.iss.simpledemo.model.Staff;
import edu.nus.iss.simpledemo.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("simpledemo");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student s = new Student(1, "Kung Fu Panda Po", 100, "Fatso");
        Staff st = new Staff(1, "Suria", "Blur");
        em.persist(s);
        em.persist(st);
        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println("Seems okay suria - go check DB");
    }
}
