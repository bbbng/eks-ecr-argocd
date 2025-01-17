package actions.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import actions.entity.Student;
import actions.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	
	private final StudentRepository studentRepository;

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElseThrow();
	}

	@Transactional
	public Student registerStudent(Student newStudent) {
		return studentRepository.save(newStudent);
	}

	@Transactional
	public Student updateStudent(Student updateStudent, Long id) {
		Student stu = studentRepository.findById(id).orElseThrow();
		stu.setName(updateStudent.getName());
		return stu;
	}

	@Transactional
	public Student deleteStudentById(Long id) {
		Student stu = studentRepository.findById(id).orElseThrow();
		studentRepository.delete(stu);
		return stu;
	}

}
