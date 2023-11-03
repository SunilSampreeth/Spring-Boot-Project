package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	public String addStudent(Student student) {

		Student student1 = studentRepo.save(student);
		if (student1 != null) {
			return "student added successfully";

		}
		return "sometime went wrong";
	}

	public List<Student> getAllStudent() {
		List<Student> allStudents = studentRepo.findAll();

		return allStudents;

	}

	public String removeStudent(int id) {
		studentRepo.deleteById(id);
		return "Deleted successfully";
	}

	public Optional<Student> getStudentById(int id) {
		Optional<Student> student = studentRepo.findById(id);
		return student;
	}

	public String updateStudent(int id, Student std) {
		std.setId(id);
		Student student1 = studentRepo.save(std);

		if (student1 != null) {
			return "student update successfully";

		}
		return "sometime went wrong";
	}

}
