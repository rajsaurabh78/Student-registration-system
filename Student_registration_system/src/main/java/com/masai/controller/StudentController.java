package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.modal.Course;
import com.masai.modal.User;
import com.masai.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PutMapping("/students{courseId}/{id}")
	public ResponseEntity<User> updateStudentHandler(@Valid @PathVariable("courseId")Integer courseId,
			@Valid @PathVariable("id")Integer id){
		User usr=studentService.registerInaCourse(courseId, id);
		
		return new ResponseEntity<>(usr,HttpStatus.OK);
	}
	
	@PutMapping("/students")
	public ResponseEntity<User> updateStudentHandler(@Valid @RequestBody User user){
		User usr=studentService.updateStudent(user);
		
		return new ResponseEntity<>(usr,HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Course>> seeAllDetailsOfAllCoursesHandler(){
		List<Course> list=studentService.seeAllDetailsOfAllCourses();
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
}
