package com.testgreetgo.eSchool.controller;

import com.testgreetgo.eSchool.config.FlashMessage;
import com.testgreetgo.eSchool.dao.StudentDaoImpl;
import com.testgreetgo.eSchool.data.StudentRepository;
import com.testgreetgo.eSchool.model.Student;
import com.testgreetgo.eSchool.service.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import javax.validation.Valid;

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
  @RequestMapping(value = "/students", method = RequestMethod.POST)
  public String addStudent(@Valid Student student, BindingResult result, RedirectAttributes redirectAttributes) {
    //Check if there errors on validation
    if (result.hasErrors()) {
      //Include valiation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.student", result);

      //Add student if invalid was received
      redirectAttributes.addFlashAttribute("student", student);
      return "redirect:/students/add";
    }
    studentService.save(student);
    FlashMessage Fm = new FlashMessage("Новый студент добавлен!", FlashMessage.Status.SUCCESS );
    redirectAttributes.addFlashAttribute("flash", Fm );

    return "redirect:/";
  }

  @RequestMapping(value="students/add")
  public String formNewStudent(Model model) {
    if (!model.containsAttribute("student")) {
      model.addAttribute("student", new Student());
    }
    return "form";
  }
}
