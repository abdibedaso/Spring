package com.geekcolab.development.dao;

import com.geekcolab.development.domain.Course;
import com.geekcolab.development.domain.Student;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StudentDAO {

    @Autowired
    private SessionFactory sf;

    public StudentDAO() {

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Student load(long studentId) {

        Query query = sf.getCurrentSession().createQuery("from Student s where s.studentId =:studentId");
        query.setParameter("studentId", studentId);
        Student student = (Student) query.list().get(0);
        if (student != null)
            return student;

        return null;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addData() {

        System.out.println("Add student data");

        Student student = new Student(11334l, "Frank", "Brown");
        Course course1 = new Course(1101l, "Java", "A");
        Course course2 = new Course(1102l, "Math", "B-");

        student.addCourse(course1);
        student.addCourse(course2);
        sf.getCurrentSession().persist(student);

    }

}
