package com.infosys.employeeproject.model;

import org.springframework.stereotype.Service;

@Service
public class EmployeeDetails {

	private int id;
	private String name;
	private String city;
	private String zipCode;
	private int courseId;
	private String courseName;
	private int marks;
	
	public EmployeeDetails(){
		
	}
	
	public EmployeeDetails(Integer id, String name, String city, String zipCode, Integer courseId, Integer marks) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.zipCode = zipCode;
		this.courseId = courseId;
		this.marks = marks;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}


}
