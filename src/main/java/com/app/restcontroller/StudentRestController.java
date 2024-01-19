package com.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.exception.StudentNotFoundException;
import com.app.service.IStudentService;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/student")
public class StudentRestController {

	@Autowired
	private IStudentService service;

//	1. Create one student
	@PostMapping("/create")
	public ResponseEntity<String> createStudent(
			@RequestBody Student std) {
		Integer id = service.SaveStudent(std);
		String message = "STUDENT '" + id + "' CREATED ";
		
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}

//	2. fetch all students
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> list = service.getAllStudents();
//		return new ResponseEntity<>(list,HttpStatus.OK);
		return ResponseEntity.ok(list);
	}

//	3. fetch one by id
	@GetMapping("/find/{id}")
	public ResponseEntity<Student> getOneStudent(
			@PathVariable("id") Integer id) {
		ResponseEntity<Student> response = null;
		try {
			Student s = service.getOneStudent(id);
			response = ResponseEntity.ok(s);
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}

//	4. remove one by id
	@DeleteMapping("/remove/{id}")

	public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id) {
		ResponseEntity<String> response = null;
		try {
			service.DeleteStudent(id);
			response = ResponseEntity.ok("STUDENT '" + id + "' REMOVED");

		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}

//	5. update student
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student std) {
		ResponseEntity<String> response = null;
		try {
			service.updateStudent(std);
			response = ResponseEntity.ok("STUDENT '" + std.getStdId() + "' UPDATED");
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}

}
