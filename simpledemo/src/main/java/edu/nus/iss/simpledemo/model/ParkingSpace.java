package edu.nus.iss.simpledemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PARKING_SPACE")
public class ParkingSpace {
	
	@Id
	private int id;
	private int lot;
	private String location;
	@OneToOne(mappedBy="parkingSpace")
    private Employee employee;

	public ParkingSpace(int id, int lot, String location) {
		super();
		this.id = id;
		this.lot = lot;
		this.location = location;
	}
	public ParkingSpace() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLot() {
		return lot;
	}
	public void setLot(int lot) {
		this.lot = lot;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "ParkingSpace [id=" + id + ", lot=" + lot + ", location=" + location + "]";
	}

}
