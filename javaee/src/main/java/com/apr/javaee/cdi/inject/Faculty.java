package com.apr.javaee.cdi.inject;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

public class Faculty {

	private List<String> facultyMembers;

	private String facultyName;

	@PostConstruct
	public void initialize() {
		this.facultyMembers = new ArrayList<String>();
		facultyMembers.add("Ian Schultz");
		facultyMembers.add("Diane Reyes");
		facultyName = "Computer Science";
	}

	public List<String> getFacultyMembers() {
		return facultyMembers;
	}

	public String getFacultyName() {
		return facultyName;
	}

}
