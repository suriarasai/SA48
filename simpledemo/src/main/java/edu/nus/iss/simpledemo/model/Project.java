package edu.nus.iss.simpledemo.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int id;
	private String name;
    @ManyToMany(mappedBy="projects")
    private Collection<Employee> employees;

	public Project(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
	

}
