package com.testgreetgo.eSchool.data;

import com.testgreetgo.eSchool.model.Student;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StudentRepository {
  private static final List<Student> ALL_STUDENTS = Arrays.asList(
      new Student(1,"Бахтияр Сейдахметов", "ВТиПО", 4),
      new Student(2,"Омаров Данат", "РЭТ", 2),
      new Student(3,"Кулсейтова Айнур", "БиоТ", 3),
      new Student(4,"Маханов Бауыржан", "АиУ", 1),
      new Student(5,"Айдарбекова Мадина", "ИС", 2),
      new Student(6,"Исаев Адилет", "ВТиПО", 4)
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
