package com.testgreetgo.eSchool.dao;

import com.testgreetgo.eSchool.model.Student;

import java.util.List;

public interface StudentDao {
  List<Student> findAll();
  Student findById(Long id);
  void save(Student student);
  void delete(Student student);
}
