package com.micro.shyam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.shyam.entity.Student;
import com.micro.shyam.exception.StudentNotFoundException;
import com.micro.shyam.repo.StudentRepository;
import com.micro.shyam.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;

	@Override
	public Integer saveStudent(Student s) {
		s = repo.save(s);
		return s.getStdId();
	}

	@Override
	public void updateStudent(Student s) {
		if (s.getStdId() == null || !repo.existsById(s.getStdId()))
			throw new StudentNotFoundException("STUDENT '" + s.getStdId() + "' ");
		else
			repo.save(s);
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.delete(getStudent(id));

	}

	@Override
	public Student getStudent(Integer id) {

		return repo.findById(id).orElseThrow();
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> all = repo.findAll();
		return all;
	}

}
