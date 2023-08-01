package com.masai.modal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String mobile;
	private Integer pinCode;
	private LocalDate dob;
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.EAGER)
	private List<Authority> authorities=new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_course", joinColumns = @JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name="Cid") )
	private List<Course> courseList;

}
