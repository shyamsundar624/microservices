package com.micro.shyam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.shyam.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
