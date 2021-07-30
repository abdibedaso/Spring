package com.geekcolab.development.service;

import com.geekcolab.development.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.geekcolab.development.dao.StudentDAO;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public StudentService() {
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Student getStudent(long studentId) {
		return studentDAO.load(studentId);
	}

}
