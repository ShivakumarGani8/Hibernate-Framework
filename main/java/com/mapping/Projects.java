package com.mapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Projects {
	@Id
	@Column(name="project_id")
	private int id;
	@Column(name="project_name")
	private String name;

	@ManyToMany
	private List<Employee> employees;
	
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
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public Projects() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Projects(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
