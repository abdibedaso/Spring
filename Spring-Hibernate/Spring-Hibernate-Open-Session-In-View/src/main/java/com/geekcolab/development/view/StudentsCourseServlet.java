package com.geekcolab.development.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geekcolab.development.dao._HibernateUtil;
import com.geekcolab.development.domain.Student;
import com.geekcolab.development.service.StudentService;

public class StudentsCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("in student servlet");
        String studentIdStr = request.getParameter("studentId");
        try {
            long studentId = -1;
            Student student = null;

            if (studentIdStr != null && studentIdStr.matches("\\d+")) {
				studentId = Long.parseLong(studentIdStr);
                StudentService studentService = new StudentService();
                student = studentService.getStudent(studentId);
            }

            request.setAttribute("student", student);
            request.getRequestDispatcher("student.jsp").forward(request, response);

        } catch (RuntimeException e) {

            _HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();

            request.setAttribute("student", e);
            request.getRequestDispatcher("error.jsp").forward(request, response);
            e.printStackTrace();

        }
    }

}
