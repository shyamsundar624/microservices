package com.micro.shyam.service;

import java.util.List;

import com.micro.shyam.entity.Student;

public interface IStudentService {
public Integer saveStudent(Student s);
public void updateStudent(Student s);
public void deleteStudent(Integer id);
public Student getStudent(Integer id);
public List<Student> getAllStudent();
}
