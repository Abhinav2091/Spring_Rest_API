/**
 * createdBY-Abhinav.
 *Hard-coded values return by Rest API
 */

package com.luv2code.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.entity.Student;
import com.luv2code.exception.ErrorResponse;
import com.luv2code.exception.StudentNotFoundException;

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

		// check the student Id
		if ((studentId >= studentList.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student Id not found:" + studentId);
		}

		return studentList.get(studentId);

	}

	//Exception handler work only in same controller.
	// added Exception handler for Student
	@ExceptionHandler
	public ResponseEntity<Object> handleException(StudentNotFoundException notFound) {

		// create a Student Error
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage("Inside Controller:"+notFound.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	

}
