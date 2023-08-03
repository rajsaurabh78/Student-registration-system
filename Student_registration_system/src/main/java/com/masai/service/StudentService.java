package com.masai.service;

import java.util.List;

import com.masai.modal.Course;
import com.masai.modal.User;

public interface StudentService {
		
	public User registerInaCourse(Integer courseId,Integer id);
	public User updateStudent(User user);
	public List<Course> seeAllDetailsOfAllCourses();
	
}
