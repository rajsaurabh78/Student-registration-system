package com.masai.service;

import java.util.List;

import com.masai.modal.Batch;
import com.masai.modal.Course;
import com.masai.modal.User;

public interface AdminService {
	
	public User createAdmin(User user);
	public Course createCourse(Course course);
	public Batch createBatchUnderCourse(Batch batch,Integer courseId);
	public String updateFees(Integer courseId,Integer fee);
	public String deleteCourse(Integer courseId);
	public Course getAllCourseDetailsById(Integer courseId);
	public Course getAllCourseDetailsByName(String courseName);
	public String allocateStudentsCourseAndBatch(Integer id,Integer courseId,Integer batchId);
	public String updateSeatsOfaBatch(Integer batchId, Integer seats);
	public List<User> getStudentByBatch(String BatchName);
	
	
	
}
