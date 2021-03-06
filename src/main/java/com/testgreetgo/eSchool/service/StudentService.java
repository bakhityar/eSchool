package com.testgreetgo.eSchool.service;

import com.testgreetgo.eSchool.model.Student;

import java.util.List;

public interface StudentService {
  List<Student> findAll();
  Student findById(Long id);
  void save(Student student);
  void delete(Student student);
}
