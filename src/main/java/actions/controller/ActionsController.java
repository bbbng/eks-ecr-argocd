package actions.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import actions.entity.Student;
import actions.service.StudentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ActionsController {
	
	private final StudentService studentService;
	
	@GetMapping(value = "/actions")
	public String actionsTest() {
		return "app-with-actions version:1.0.2";
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = studentService.getStudents();
		return students;
	}
	
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable Long id) {
		Student student = studentService.getStudentById(id);
		return student;
	}
	
	@PostMapping("/students")
	public Student registerStudent(@RequestBody Student newStudent) {
		Student student = studentService.registerStudent(newStudent);
		return student;
	}
	
	@PutMapping("/students/{id}")
	public Student updateStudent(@RequestBody Student updateStudent, @PathVariable Long id) {
		Student student = studentService.updateStudent(updateStudent, id);
		return student;
	}
	
	@DeleteMapping("/students/{id}")
	public Student deleteStudentById(@PathVariable Long id) {
		Student student = studentService.deleteStudentById(id);
		return student;
	}
	
}
