package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BatchException;
import com.masai.exception.CourseException;
import com.masai.exception.UserException;
import com.masai.modal.Address;
import com.masai.modal.Authority;
import com.masai.modal.Batch;
import com.masai.modal.Course;
import com.masai.modal.User;
import com.masai.repository.BatchRepository;
import com.masai.repository.CourseRepository;
import com.masai.repository.UserRepository;
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CourseRepository courseRepository ;
	
	@Autowired
	private BatchRepository batchRepository;
	


	@Override
	public User createAdmin(User user) {
		
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		List<Authority> authorities= user.getAuthorities();
		
		for(Authority authority:authorities) {
			authority.setName("ROLE_"+authority.getName().toUpperCase());
			authority.setUser(user);
		}
		List<Address>alist=user.getAddressList();
		for(Address add:alist) {
			add.setUser(user);
		}
		return userRepository.save(user);
		
	}

	@Override
	public Course createCourse(Course course) {

		return courseRepository.save(course);
	}

	@Override
	public Batch createBatchUnderCourse(Batch batch, Integer courseId) {
		
		Optional<Course> opt=courseRepository.findById(courseId);
		if(opt.isPresent()) {
			Course course=opt.get();
			batch.setCourse(course);
			return batchRepository.save(batch);
		}else 
			throw new CourseException("Inviled course Id...");
		
	}

	@Override
	public String updateFees(Integer courseId, Integer fee) {
		Optional<Course> opt=courseRepository.findById(courseId);
		if(opt.isPresent()) {
			Course course=opt.get();
			course.setFee(fee);
			courseRepository.save(course);
			return "Course fee updated";
		}else 
			throw new CourseException("Inviled course Id...");
	}

	@Override
	public String deleteCourse(Integer courseId) {
		Optional<Course> opt=courseRepository.findById(courseId);
		if(opt.isPresent()) {
			courseRepository.delete(opt.get());
			return "Course deleted Successfully";
		}else
			throw new CourseException("Inviled course Id...");
	}

	@Override
	public Course getAllCourseDetailsById(Integer courseId) {

		Optional<Course> opt=courseRepository.findById(courseId);
		if(opt.isPresent()){
			return opt.get();
		}else
			throw new CourseException("Inviled course Id...");
		
	}

	@Override
	public Course getAllCourseDetailsByName(String courseName) {
		
		Optional<Course> opt=courseRepository.findByName(courseName);
		if(opt.isPresent()){
			return opt.get();
		}else
			throw new CourseException("Inviled course name...");
		
	}

	@Override
	public String allocateStudentsCourseAndBatch(Integer id, Integer courseId) {
		boolean flag=false;
		boolean flag2=true;
		String bName="";
		Optional<User> opt=userRepository.findById(id);
		if(opt.isEmpty()) {
			throw new UserException("Inviled user id...");
		}else {
			User user=opt.get();
			List<Course> clist=user.getCourseList();
			for(Course i:clist) {
				if(i.getCid()==courseId) {
					flag2=false;
					break;
				}
			}
			
			
			if(flag2) {
				
				Optional<Course> cors=courseRepository.findById(courseId);
				if(cors.isPresent()) {
					Course course=cors.get();
					List<Batch> blist= course.getBatchs();
					
					for(Batch i:blist) {
						if(i.getSeats()>0) {
							bName+=i.getName();
							i.setSeats(i.getSeats()-1);
							List<Course> list=new ArrayList<>();
							list.add(course);
							user.setCourseList(list);
							userRepository.save(user);
							flag=true;
							break;
						}
					}
					if(flag) {
						return "seat got alloted in course :"+course.getName()+" & Batch : "+bName;
					}else {
						throw new BatchException("Seat not avalible...");
					}		
				
				}else {
					throw new CourseException("Inviled Course id...");
				}	
			}else {
				throw new CourseException("Student already present in this course.");
			}
		}
	}

	@Override
	public String updateSeatsOfaBatch(Integer batchId, Integer seats) {
		Optional<Batch> opt=batchRepository.findById(batchId);
		if(opt.isPresent()) {
			Batch b=opt.get();
			b.setSeats(b.getSeats()+seats);
			batchRepository.save(b);
			return "Seat got apdated";
		}else
			throw new CourseException("Inviled course Id...");
		
	}

	@Override
	public List<User> getStudentByBatchName(String BatchName) {

		Optional<Batch> opt=batchRepository.findByName(BatchName);
		if(opt.isPresent()) {
			Batch bat=opt.get();
			Course cor=bat.getCourse();
			return cor.getUserList();
		}else {
			throw new BatchException("Invilade batch name");
		}
		
	}

	@Override
	public List<User> getStudentByBatchId(Integer bId) {
		
		Optional<Batch> opt=batchRepository.findById(bId);
		if(opt.isPresent()) {
			Batch bat=opt.get();
			Course cor=bat.getCourse();
			return cor.getUserList();
		}else {
			throw new BatchException("Invilade batch Id...");
		}
	}

}
