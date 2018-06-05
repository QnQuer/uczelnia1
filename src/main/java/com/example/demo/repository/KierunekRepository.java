package com.example.demo.repository;

import com.example.demo.model.Kierunek;
import com.example.demo.model.Przedmiot;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;



 /*
 * @author micha
 */

public interface KierunekRepository extends JpaRepository <Kierunek, Long> {
     public Kierunek findOneByPrzedmiotId(Long kierunekId);
    public List<Kierunek> findAllByPrzedmiot(Przedmiot a);
}
