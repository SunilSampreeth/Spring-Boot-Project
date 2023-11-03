package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class FirstController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/first")
	public String firstApi() {
		String str = "This is my first api in spring boot";
		return str;
	}

	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Student std) {
		String result = studentService.addStudent(std);
		return result;

	}

	@GetMapping("/allstudents")
	public List<Student> getAllStudent() {

		List<Student> students = studentService.getAllStudent();

		return students;
	}

	@RequestMapping("/deleteStudent/{id}")
	public String deleteStudentById(@PathVariable Integer id) {
		String str = studentService.removeStudent(id);
		return str;
	}

	@RequestMapping("findStudentById/{id}")
	public Optional<Student> getStudentById(@PathVariable int id) {
		Optional<Student> student = studentService.getStudentById(id);

		return student;
	}

	@PutMapping("/updateStudentById/{id}")
	public String updateStudetById(@PathVariable("id") int id, @RequestBody Student std) {
		String result = studentService.updateStudent(id, std);
		return result;
	}
}
