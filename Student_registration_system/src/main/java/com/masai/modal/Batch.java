package com.masai.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Batch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Bid;
	private String name;
	private Integer seats;
	@ManyToOne
	@JsonIgnore
	private Course course;

}
