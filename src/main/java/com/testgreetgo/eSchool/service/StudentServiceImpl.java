package com.testgreetgo.eSchool.service;

import com.testgreetgo.eSchool.dao.StudentDao;
import com.testgreetgo.eSchool.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired
  private StudentDao studentDao;
  @Override
  public List<Student> findAll() {
    return studentDao.findAll();
  }

  @Override
  public Student findById(Long id) {
    return studentDao.findById(id);
  }

  @Override
  public void save(Student student) {
    studentDao.save(student);

  }

  @Override
  public void delete(Student student) {
    studentDao.delete(student);

  }
}
