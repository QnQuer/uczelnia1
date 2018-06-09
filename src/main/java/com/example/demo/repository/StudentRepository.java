package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

/**
 *
 * @author micha
 */
public interface StudentRepository extends JpaRepository <Student, Long> {

    public Student findOneByStudentId(Long id);
    
    @Procedure(name = "deleteAllStudents")
    public void runProcedure();

}
