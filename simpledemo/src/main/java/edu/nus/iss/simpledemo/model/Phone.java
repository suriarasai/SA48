package edu.nus.iss.simpledemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phone {
	@Id
	private int id;
	private String type;
	private String num;
	public Phone(int id, String type, String num) {
		super();
		this.id = id;
		this.type = type;
		this.num = num;
	}
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Phone [id=" + id + ", type=" + type + ", num=" + num + "]";
	}

}
