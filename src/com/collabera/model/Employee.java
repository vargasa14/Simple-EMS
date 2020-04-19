package com.collabera.model;

import com.collabera.type.Department;

public class Employee {

	private int ID;
	private String firstName;
	private String lastName;
	private Department department;

	public Employee(int id, String firstName, String lastName, Department department ) 
	{
		this.ID = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return ("Employee ID:  " + ID + ", First name: " +  firstName +", last name: "  + lastName + ", works in " + department + " department");
	}
}