package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 *
 * @author micha
 */
public interface StudentRepository extends JpaRepository <Student, Long> {

   

  

    public void deleteByStudentId(Long studentId);

    public Student findOneByStudentId(Long studentId);

  
}
