package com.masai.service;

import java.util.Map;

import com.masai.modal.Batch;
import com.masai.modal.Course;
import com.masai.modal.User;

public interface StudentService {
		
	public User registerInaCourse(Integer courseId);
	public User updateStudent(User user);
	public Map<Course,Batch> seallDetailsOfAllCourses();
	
}
