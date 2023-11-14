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
	public Integer saveStudent(Student student) {
Student save = repo.save(student);
		return save.getStdId();
	}

	@Override
	public void updateStudent(Student student) {
if(student==null || !repo.existsById(student.getStdId())) {
	throw new StudentNotFoundException("Studetn '"+student.getStdId()+"' Not Exist");
}else {
	repo.save(student);
}
	}

	@Override
	public void deleteStudent(Integer id) {
repo.delete(getOneStudent(id));
	}

	@Override
	public Student getOneStudent(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow();
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
