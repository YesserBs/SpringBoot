package com.black.bl.service;

import java.util.List;

import com.black.bl.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.black.bl.model.Student;
import com.black.bl.repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService (StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student updateStudent(Long id, Student studentDetails) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());

		return studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

		studentRepository.delete(student);
	}
}
