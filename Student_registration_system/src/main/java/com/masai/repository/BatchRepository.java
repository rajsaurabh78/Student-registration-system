package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.modal.Batch;
@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer>{
		
	Optional<Batch> findByName(String name);
	
}
