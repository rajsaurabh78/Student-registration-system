package com.masai.modal;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Cid;
	private String name;
	private Integer fee;
	private String duration;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "course",fetch = FetchType.EAGER)
	private List<Batch> batchs=new ArrayList<>();
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "courseList")
	private List<User> userList = new ArrayList<>();
}
