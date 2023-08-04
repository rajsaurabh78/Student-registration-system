package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CourseException;
import com.masai.exception.UserException;
import com.masai.modal.Address;
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
	public String registerInaCourse(Integer courseId, Integer id) {
		boolean flag=true;
		Optional<User> opt=userRepository.findById(id);
		if(opt.isPresent()) {
			User user=opt.get();
			List<Course> clist=user.getCourseList();
			for(Course i:clist) {
				if(i.getCid()==courseId) {
					flag=false;
					break;
				}
			}
				if(flag) {
					Optional<Course> crs=courseRepository.findById(courseId);
					if(crs.isPresent()) {
						Course course=crs.get();	
						List<Course> list=new ArrayList<>();
						list.add(course);
						user.setCourseList(list);
						userRepository.save(user);
						return "You are successfully registered with course : "+course.getName();
					}else {
						throw new CourseException("Inviled course id...");
					}
			}else {
				throw new CourseException("You are already applied for this course.");
			}
		}else {
			throw new UserException("Inviled user id..");
		}
			
		
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

	@Override
	public List<Address> updateStudentAddress(Integer id,Address address) {
		boolean flag=true;
		Optional<User> opt=userRepository.findById(id);
		if(opt.isPresent()) {
			User user=opt.get();
			List<Address> list=user.getAddressList();
			List<Address> aList=new ArrayList<>();
			for(Address adrs:list) {
				if(adrs.getType().toUpperCase().equals(address.getType().toUpperCase())) {
					adrs.setCity(address.getCity());
					adrs.setDistrict(address.getDistrict());
					adrs.setPincode(address.getPincode());
					adrs.setState(address.getState());
					flag=false;
					}
				adrs.setUser(user);
				aList.add(adrs);
			}
			if(flag) {
				address.setUser(user);
				aList.add(address);
			}
			user.setAddressList(aList);
			userRepository.save(user);
			return aList;
		}else {
			throw new UserException("Inviled user id.");
		}
	}


}
