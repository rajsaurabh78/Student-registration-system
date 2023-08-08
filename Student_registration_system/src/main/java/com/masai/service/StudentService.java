package com.masai.service;

import java.util.List;

import com.masai.modal.Address;
import com.masai.modal.Course;
import com.masai.modal.User;

public interface StudentService {
		
	public String registerInaCourse(Integer courseId,Integer id);
	public User updateStudent(User user);
	public List<Address> updateOrAddStudentAddress(Integer id,Address address);
	public List<Course> seeAllDetailsOfAllCourses();
	
}
