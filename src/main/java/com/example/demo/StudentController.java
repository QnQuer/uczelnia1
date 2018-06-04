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
 * localhost:8080/test/account/tom/jensen will create database entity in table accounts
 */
@RestController
@RequestMapping("/test")
public class StudentController {

    @RequestMapping("/test")
    public String hello(){
        return "hello";
    }

    @Autowired
   StudentRepository studentRepository;

    @RequestMapping("/account/{name}/{lastname}")
    public String addAcount(@PathVariable String Imie, @PathVariable String Nazwisko){

        Student account = new Student(Imie, Nazwisko);
        studentRepository.save(account);


        return "hello";
    }

    @RequestMapping("/account/all")
    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }
}
