package com.micro.shyam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "stdtab")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stdId;
	// @NotNull(message = "Name can not be null")
	//@javax.validation.constraints.NotEmpty(message = "STUDENT CAN'T BE EMPTY")
	@NotBlank(message = "STUDETN CAN'T BE BLANK")
	@Size(min=2,max=6,message = "NAME MUST BE 2 TO 6 CHARS ONLY")
	@Pattern(regexp = "[A-Za-z]{2,6}",message = "Only A-Z/a-z are allowed")
	private String stdName;
	@NotBlank(message = "STUDENT GENDER CAN'T BE EMPTY")
	private String stdGen;
	private String stdCourse;
	private String stdAddr;

}
