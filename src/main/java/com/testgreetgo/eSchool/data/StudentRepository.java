package com.testgreetgo.eSchool.data;

import com.testgreetgo.eSchool.model.Student;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StudentRepository {
  private static final List<Student> ALL_STUDENTS = Arrays.asList(
  );

  public Student findByName(String name) {
    for (Student student : ALL_STUDENTS)
      if (student.getName().equals((name))) {
        return student;
      }
    return null;
  }

  public List<Student> getAllStudents() {
    return ALL_STUDENTS;
  }
}
