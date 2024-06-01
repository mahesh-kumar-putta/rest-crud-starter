package com.practice.rest_starter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.rest_starter.dto.Student;
import com.practice.rest_starter.exception.StudentErrorResponse;
import com.practice.rest_starter.exception.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/test")
public class StudentController {
	
	
	private List<Student> studentList;
	
	@PostConstruct
	public List<Student> loadStudentData(){
		
		studentList = new ArrayList<>();
		studentList.add(new Student("mahesh","kumar"));
		studentList.add(new Student("rahesh","fumar"));
		studentList.add(new Student("sahesh","lumar"));
		studentList.add(new Student("bahesh","dumar"));
		
		return studentList;
	}
	

	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return studentList;
	}
	
	@GetMapping("/student/{id}")
	public Student getStudents(@PathVariable int id){
		
		if(id>=studentList.size() || id<0) {
			throw new StudentNotFoundException("Student not found with id :"+id);
		}
		return studentList.get(id);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleGenericException(Exception ex){
		
		StudentErrorResponse response = new StudentErrorResponse();
		response.setErrorMessage(ex.getMessage());
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
