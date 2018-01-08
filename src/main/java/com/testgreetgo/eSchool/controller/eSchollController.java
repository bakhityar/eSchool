package com.testgreetgo.eSchool.controller;

import com.testgreetgo.eSchool.config.FlashMessage;
import com.testgreetgo.eSchool.dao.StudentDaoImpl;
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
  private StudentService studentService;

  @SuppressWarnings("unchecked")
  @RequestMapping(value = "/")
  public String listStudents(ModelMap modelMap) {
    List<Student> students = studentService.findAll();
    modelMap.put("students", students);
    return "home";
  }
  @RequestMapping(value = "/student/{id}")
  public String studentDetails(@PathVariable Long id, ModelMap modelMap) {
    Student student = studentService.findById(id);
    modelMap.put("student", student);
    return "student-detail";
  }

  //Add a student
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
    redirectAttributes.addFlashAttribute("flash", new FlashMessage("Новый студент добавлен!", FlashMessage.Status.SUCCESS ));

    return "redirect:/";
  }

  @RequestMapping(value="students/add")
  public String formNewStudent(Model model) {
    if (!model.containsAttribute("student")) {
      model.addAttribute("student", new Student());
    }
    model.addAttribute("action", "/students");
    model.addAttribute("submit", "Добавить");
    return "form";
  }

  @RequestMapping(value="/students/{id}/edit")
  public String formEditStudent(@PathVariable Long id, Model model) {
    if (!model.containsAttribute("student")) {
      model.addAttribute("student", studentService.findById(id));
    }
    model.addAttribute("action", String.format("/students/%s", id));
    model.addAttribute("submit", "Сохранить");
    return "form";
  }

  //Update an existing student
  @RequestMapping(value="students/{id}")
  public String updateStudent(@Valid Student student, BindingResult result, RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
      //Include valiation errors upon redirect
      redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.student", result);

      //Add student if invalid was received
      redirectAttributes.addFlashAttribute("student", student);
      return String.format("redirect:/students/%s/add", student.getId());
    }
    studentService.save(student);
    redirectAttributes.addFlashAttribute("flash", new FlashMessage("Студент обновлен!", FlashMessage.Status.SUCCESS ));

    return "redirect:/";
  }

  //Delete an existing student
  @RequestMapping(value="/students/{id}/delete", method = RequestMethod.POST)
  public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    Student student = studentService.findById(id);
    studentService.delete(student);
    redirectAttributes.addFlashAttribute("flash", new FlashMessage("Студент успешно удален!", FlashMessage.Status.SUCCESS));
    return "redirect:/";
  }

  @SuppressWarnings("unchecked")
  @RequestMapping(value="/login")
  public String loginForm(ModelMap modelMap) {
  return "login";
  }
}
