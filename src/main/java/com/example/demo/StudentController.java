package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This is spring rest controller witch is used to for example create web api used by multiple clients app.
 * For example we can create android/iOS app which will use this to communication with this app server and database.
 * example request localhost:8080/test/test will return String "hello"
 * localhost:8080/test/account/tom/jensen will create database entity in table student
 */
@RestController
@RequestMapping("/test")
public class StudentController {

    @RequestMapping("/test")
    public String hello(){
        return "hello";
    }

    @Autowired
   StudentRepository StudentRepository;

    @RequestMapping("/account/{name}/{lastname}")
    public String addStudent(@PathVariable String Imie, @PathVariable String Nazwisko, @PathVariable String Pesel){

        Student student = new Student(Imie, Nazwisko, Pesel);
        StudentRepository.save(student);


        return "hello";
    }

    @RequestMapping("/student/all")
    public List<Student> findAllStudent(){
        return StudentRepository.findAll();
    }
}
