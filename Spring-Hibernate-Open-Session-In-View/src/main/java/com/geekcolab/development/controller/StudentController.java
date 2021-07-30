package com.geekcolab.development.controller;

import com.geekcolab.development.domain.Student;
import com.geekcolab.development.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;

import com.geekcolab.development.dao.StudentDAO;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;


    @Resource
    private StudentDAO studentDAO;

    @RequestMapping("/")
    public String home() {
        studentDAO.addData();
        return ("index");
    }

    @RequestMapping(value = "/StudentsCourseServlet", method = RequestMethod.GET)
    public String getAll(@RequestParam long studentId, Model model) {

        System.out.println("in get all " + studentId);
        Student stu = studentService.getStudent(studentId);

        System.out.println(stu.getCourses().toString());

        model.addAttribute("student", studentService.getStudent(studentId));
        return "courseList";

    }
}
