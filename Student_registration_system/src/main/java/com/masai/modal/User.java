package com.masai.modal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class User {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="user_seq")
	@SequenceGenerator(name="user_seq", sequenceName="user_seq",allocationSize=1, initialValue=1)
	private Integer id;
	@NotBlank(message ="Name should not Blank." )
	@NotEmpty(message ="Name should not Empty." )
	@NotNull(message ="Name should not Null." )
	private String name;
	
	@Column(unique = true)
	@Email(message = "Email should be in right format")
	private String email;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
	message ="Password must be of atleast 8 characters, contains at least one uppercase, one lowercase,a special "
	+ "character and a number in it.")
	private String password;
	
	@Column(unique = true)
	@Pattern(regexp = "^[6-9]\\d{9}$",message= "Mobile Number Should be of 10 digits and starts with 6-9")
	private String mobile;
	
//	@Size(min=6,max=6,message = "PinCode should be in 6 digit only.")
//	private String pinCode;
	
	@Past(message = "DOB should be in past.")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dob;
	
//	@NotBlank(message ="Address should not Blank." )
//	@NotEmpty(message ="Address should not Empty." )
//	@NotNull(message ="Address should not Null." )
//	private String address;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.EAGER)
	private List<Authority> authorities=new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.EAGER)
	private List<Address> addressList=new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_course", joinColumns = @JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name="Cid") )
	private List<Course> courseList;

}
