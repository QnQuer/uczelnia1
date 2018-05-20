package com.example.demo.repository;


import com.example.demo.model.Kierunek;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *
 * @author micha
 */
public interface StudentRepository extends JpaRepository <Student, Long> {
    public Student findOneById(Long student_id);
    public List<Student> findAllByAuthor(Kierunek a);
}
