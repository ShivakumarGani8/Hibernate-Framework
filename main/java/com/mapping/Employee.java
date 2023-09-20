package com.mapping;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	
	@Id
	@Column(name="emp_id")
	private int id;
	
	private String name;
	
	@ManyToMany(mappedBy = "employees")
	private List<Projects> projects;
	
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
	
	
	public List<Projects> getProjects() {
		return projects;
	}
	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
