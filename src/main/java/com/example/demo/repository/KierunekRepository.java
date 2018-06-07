package com.example.demo.repository;

import com.example.demo.model.Kierunek;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

 /*
 * @author micha
 */

public interface KierunekRepository extends JpaRepository <Kierunek, Long> {
   
    public Kierunek findOneByKierunekId(Long id);
}
