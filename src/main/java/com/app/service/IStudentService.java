package com.app.service;

import java.util.List;

import com.app.entity.Student;

public interface IStudentService {

	Integer SaveStudent(Student s);

	void updateStudent(Student s);

	void DeleteStudent(Integer id);

	Student getOneStudent(Integer id);

	List<Student> getAllStudents();
}
