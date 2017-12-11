package com.testgreetgo.eSchool.controller;

import com.testgreetgo.eSchool.dao.StudentDaoImpl;
import com.testgreetgo.eSchool.data.StudentRepository;
import com.testgreetgo.eSchool.model.Student;
import com.testgreetgo.eSchool.service.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class eSchollController {
  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private StudentService studentService;

  @SuppressWarnings("unchecked")
  @RequestMapping(value = "/")
  public String listStudents(ModelMap modelMap) {
    List<Student> students = studentService.findAll();
    modelMap.put("students", students);
    return "home";
  }
  @RequestMapping(value = "/student/{name}")
  public String studentDetails(@PathVariable String name, ModelMap modelMap) {
    Student student = studentRepository.findByName(name);
    modelMap.put("student", student);
    return "student-detail";
  }
}
