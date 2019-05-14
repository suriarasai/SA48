package edu.nus.iss.simpledemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Staff {
	@Id
	private int id;
	private String name;
	private String nickname;
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(int id, String name, String nickname) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", nickname=" + nickname + "]";
	}
	

}
