package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.modal.Batch;
import com.masai.modal.Course;
import com.masai.modal.User;
import com.masai.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/courses")
	public ResponseEntity<Course> createCourseHandler(@Valid @RequestBody Course course){
		Course cour=adminService.createCourse(course);
		return new ResponseEntity<>(cour,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/batches/{id}")
	public ResponseEntity<Batch> createBatchUnderCourseHandler(@Valid @RequestBody Batch batch,@Valid @PathVariable("id")Integer id){
		Batch bth=adminService.createBatchUnderCourse(batch, id);
		return new ResponseEntity<>(bth,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/courses/{cId}")
	public ResponseEntity<String> updateFeesHandler(@Valid @PathVariable("cId")Integer cId,@Valid @RequestParam("rs")Integer rs){
		String msg=adminService.updateFees(cId, rs);
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/courses/{cId}")
	public ResponseEntity<String> deleteCourseHandler(@Valid @PathVariable("cId")Integer cId){
		String msg=adminService.deleteCourse(cId);
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	@GetMapping("/courses/{cId}")
	public ResponseEntity<Course> getAllCourseDetailsByIdHandler(@Valid @PathVariable("cId")Integer cId){
		Course cour=adminService.getAllCourseDetailsById(cId);
		return new ResponseEntity<>(cour,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/courses")
	public ResponseEntity<Course> getAllCourseDetailsByNameHandler(@Valid @RequestParam("name")String name){
		Course cour=adminService.getAllCourseDetailsByName(name);
		return new ResponseEntity<>(cour,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/courses/{id}/{cId}")
	public ResponseEntity<String> allocateStudentsCourseAndBatchHandler(@Valid @PathVariable("id")Integer id
			,@Valid @PathVariable("cId")Integer cId){
		String msg=adminService.allocateStudentsCourseAndBatch(id, cId);
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	@PutMapping("/batches/{bId}")
	public ResponseEntity<String> updateSeatsOfaBatchHandler(@Valid @RequestParam("seats")Integer seats,@Valid @PathVariable("bId")Integer bId){
		String msg=adminService.updateSeatsOfaBatch(bId, seats);
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/students/{cId}")
	public ResponseEntity<List<User>> getStudentsBycourseIdHandler(@Valid @PathVariable("cId") Integer cId){
		List<User> list=adminService.getStudentsBycourseId(cId);
		return new ResponseEntity<>(list,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/batches/{bId}")
	public ResponseEntity<List<User>> getStudentByBatchIdHandler(@Valid @PathVariable("bId")Integer bId){
		List<User> list=adminService.getStudentByBatchId(bId);
		return new ResponseEntity<>(list,HttpStatus.CREATED);
		
	}

}
