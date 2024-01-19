package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "studtab")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "std_id")
	private Integer stdId;
	@Column(name = "std_code")
	private String stdCode;
	@Column(name = "std_name")
	private String stdName;
	@Column(name = "std_gen")
	private String stdGen;
	@Column(name = "std_course")
	private String stdCourse;
	@Column(name = "std_addr")
	private String stdAddress;
}
