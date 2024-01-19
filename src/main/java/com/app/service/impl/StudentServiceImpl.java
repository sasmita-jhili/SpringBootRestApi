package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Student;
import com.app.exception.StudentNotFoundException;
import com.app.repo.StudentRepository;
import com.app.service.IStudentService;
import com.app.util.AppUtil;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentRepository repo;
	@Autowired
	private AppUtil appUtil;

	@Override
	public Integer SaveStudent(Student std) {
		std.setStdCode(appUtil.studentCodeGenerator(std.getStdName()));
		std = repo.save(std);
		return std.getStdId();
	}

	@Override
	public void updateStudent(Student s) {
		if (s.getStdId() == null || !repo.existsById(s.getStdId()))
			throw new StudentNotFoundException("STUDENT  '" + s.getStdId() + "'  NOT EXIST");
		else
			repo.save(s);

	}

	@Override
	public void DeleteStudent(Integer id) {
		repo.delete(getOneStudent(id));

	}

	@Override
	public Student getOneStudent(Integer id) {
		return repo.findById(id).orElseThrow(() -> new StudentNotFoundException("STUDENT '" + id + "' NOT EXIST"));
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = repo.findAll();
		return list;
	}

}
