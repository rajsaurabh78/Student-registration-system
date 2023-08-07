package com.masai.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Entity
@Data
public class Address {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="address_seq")
	@SequenceGenerator(name="address_seq", sequenceName="address_seq",allocationSize=1, initialValue=1)
	private Integer SN;
	
	@NotBlank(message ="Address type should not Blank." )
	@NotEmpty(message ="Address type should not Empty." )
	@NotNull(message ="Address type should not Null." )
	private String type;
	
	@NotBlank(message ="City should not Blank." )
	@NotEmpty(message ="City should not Empty." )
	@NotNull(message ="City should not Null." )
	private String city;
	
	@NotBlank(message ="District should not Blank." )
	@NotEmpty(message ="District should not Empty." )
	@NotNull(message ="District should not Null." )
	private String district;
	
	@NotBlank(message ="State should not Blank." )
	@NotEmpty(message ="State should not Empty." )
	@NotNull(message ="State should not Null." )
	private String state;
	
	@NotNull(message ="Address should not Null." )
	@Pattern(regexp = "^[1-9]\\d{5}$", message = "The Pincode should be 6 digits and start with a number from 1 to 9.")
	private String pincode;
	
	final String country="India";
	
	@ManyToOne
	@JsonIgnore
	private User user;

}
