package com.testgreetgo.eSchool.model;

public class Student {
  private int id;
  private String name;
  private String faculty;
  private int course;

  public Student(int id, String name, String faculty, int course) {
    this.id = id;
    this.name = name;
    this.faculty = faculty;
    this.course = course;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFaculty() {
    return faculty;
  }

  public void setFaculty(String faculty) {
    this.faculty = faculty;
  }

  public int getCourse() {
    return course;
  }

  public void setCourse(int course) {
    this.course = course;
  }
}
