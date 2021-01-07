package com.infosys.employeeproject.dto;

public class TrainingDTO {
	
	private int id;
	private int courseId;
	private String courseName;
	private int marks;
	
	public TrainingDTO() {
		
	}
	
	public TrainingDTO(Integer id, Integer courseId, String courseName, int marks) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.courseName = courseName;
		this.marks = marks;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
