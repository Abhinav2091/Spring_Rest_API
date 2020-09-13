package com.luv2code.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> studentList;

	// define @postConstruct to load student data as it will execute only once
	// good for hard code value

	@PostConstruct
	public void populateHardCodedStudent() {
		studentList = new ArrayList<Student>();
		studentList.add(new Student("Abhinav", "Sharma"));
		studentList.add(new Student("Aju", "Singh"));
		studentList.add(new Student("Ajay", "Tiwari"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return studentList;

	}

	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable(required = true) int studentId) {

		return studentList.get(studentId);

	}

}
