package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CourseException;
import com.masai.exception.UserException;
import com.masai.modal.Course;
import com.masai.modal.User;
import com.masai.repository.CourseRepository;
import com.masai.repository.UserRepository;
@Service
public class studentServiceImpl implements StudentService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public User registerInaCourse(Integer courseId, Integer id) {
		
		Optional<User> opt=userRepository.findById(id);
		if(opt.isPresent()) {
			Optional<Course> crs=courseRepository.findById(id);
			if(crs.isPresent()) {
				User user=opt.get();
				List<Course> list=new ArrayList<>();
				list.add(crs.get());
				user.setCourseList(list);
				userRepository.save(user);
				return user;
			}else
				throw new CourseException("Inviled course id...");
			
		}else
			throw new UserException("Inviled user id..");
		
	}

	@Override
	public User updateStudent(User user) {
		Optional<User> opt=userRepository.findById(user.getId());
		if(opt.isPresent()) {
			User stu=opt.get();
			stu.setEmail(user.getEmail());
			stu.setName(user.getName());
			stu.setDob(user.getDob());
			stu.setMobile(user.getMobile());
			stu.setPassword(user.getPassword());
			stu.setPinCode(user.getPinCode());
			stu.setAddress(user.getAddress());
			
			return userRepository.save(stu);
		}else
			throw new UserException("Inviled user id..");
	}

	@Override
	public List<Course> seeAllDetailsOfAllCourses() {
		
		List<Course> list=courseRepository.findAll();
		if(!list.isEmpty()) {
			return list;
		}else
			throw new CourseException("No any course avalible now.");
		
	}


}
