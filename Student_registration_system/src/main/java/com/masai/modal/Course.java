package com.masai.modal;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Course {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="course_seq")
	@SequenceGenerator(name="course_seq", sequenceName="course_seq",allocationSize=1, initialValue=500)
	private Integer Cid;
	
	@Column(unique = true)	@NotBlank(message ="Name should not Blank." )
	@NotEmpty(message ="Name should not Empty." )
	@NotNull(message ="Name should not Null." )
	private String name;
	
	@NotNull(message ="Name should not Null." )
	private Integer fee;
	
	@NotBlank(message ="Name should not Blank." )
	@NotEmpty(message ="Name should not Empty." )
	@NotNull(message ="Name should not Null." )
	private String duration;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "course",fetch = FetchType.EAGER)
	private List<Batch> batchs=new ArrayList<>();
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "courseList")
	private List<User> userList = new ArrayList<>();
}
