package com.example.demo.repository;

import com.example.demo.model.Przedmiot;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author micha
 */
public interface PrzedmiotRepository extends JpaRepository <Przedmiot, Long> {   
    
    public Przedmiot findOneByPrzedmiotId(Long id);
}
