package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author micha
 */
public interface StudentRepository extends JpaRepository <Student, Long> {
    
}
