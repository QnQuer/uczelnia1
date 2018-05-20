package com.example.demo.repository;

import com.example.demo.model.Student;
import com.example.demo.model.Przedmiot;
import com.example.demo.model.Wykladowca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *
 * @author micha
 */
public interface PrzedmiotRepository extends JpaRepository <Przedmiot, Long> {
    public Przedmiot findOneById(Long przedmiot_id);
    public List<Przedmiot> findAllByAuthor(Student a);
    public List<Przedmiot> findAllByAuthor(Wykladowca a);
}
