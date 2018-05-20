package com.example.demo.repository;

import com.example.demo.model.Przedmiot;
import com.example.demo.model.Wykladowca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

 /*
 * @author micha
 */
public interface WykladowcaRepository extends JpaRepository <Wykladowca, Long> {
    public Wykladowca findOneById(Long wyklaowca_id);
    public List<Wykladowca> findAllByAuthor(Przedmiot a);
}