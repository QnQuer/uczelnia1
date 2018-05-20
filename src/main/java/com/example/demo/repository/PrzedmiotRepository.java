package com.example.demo.repository;

import com.example.demo.model.Student;
import com.example.demo.model.Przedmiot;
import com.example.demo.model.Wykladowca;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
/**
 *
 * @author micha
 */
public interface PrzedmiotRepository extends JpaRepository <Przedmiot, Long> {
    
}
