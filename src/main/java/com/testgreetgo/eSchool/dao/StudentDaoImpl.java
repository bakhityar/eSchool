package com.testgreetgo.eSchool.dao;

import com.testgreetgo.eSchool.model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @SuppressWarnings("unchecked")
  public List<Student> findAll() {
    //Open session
    Session session = sessionFactory.openSession();

    //Get all students with a Hibernate criteria
    List<Student> students = session.createCriteria(Student.class).list();

    //Close the session
    session.close();

    return students;
  }

  @Override
  public Student findById(Long id) {
    return null;
  }

  @Override
  public void save(Student student) {

  }

  @Override
  public void delete(Student student) {

  }
}
