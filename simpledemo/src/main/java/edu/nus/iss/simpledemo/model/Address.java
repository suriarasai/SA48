package edu.nus.iss.simpledemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	private int id;
	private String streetName;
	
	//private User u;
    
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String streetName) {
		super();
		this.id = id;
		this.streetName = streetName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/*
	 * public User getU() { return u; }
	 * 
	 * public void setU(User u) { this.u = u; }
	 */

	@Override
	public String toString() {
		return "Address [id=" + id + ", streetName=" + streetName +  "]";
	}
	

}
