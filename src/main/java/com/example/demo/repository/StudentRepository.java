package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 *
 * @author micha
 */
public interface StudentRepository extends JpaRepository <Student, Long> {

    public void deleteByStudent_id(Long student_id);

    public Student findOneByStudent_id(Long student_id);

  
}
