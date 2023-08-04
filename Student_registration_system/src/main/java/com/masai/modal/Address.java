package com.masai.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="address_seq")
	@SequenceGenerator(name="address_seq", sequenceName="address_seq",allocationSize=1, initialValue=1)
	private Integer SN;
	private String type;
	private String city;
	private String district;
	private String state;
	private String pincode;
	final String country="India";
	
	@ManyToOne
	@JsonIgnore
	private User user;

}
