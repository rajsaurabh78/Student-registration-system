package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.modal.Batch;
import com.masai.modal.Course;
import com.masai.modal.User;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
		
	Optional<Course> findByName(String name);
	
}
