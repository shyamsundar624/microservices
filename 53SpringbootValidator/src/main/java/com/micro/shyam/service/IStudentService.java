package com.micro.shyam.service;

import java.util.List;

import com.micro.shyam.entity.Student;

public interface IStudentService {

	public Integer saveStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(Integer id);
	public Student getOneStudent(Integer id);
	public List<Student> getAllStudent();
}
