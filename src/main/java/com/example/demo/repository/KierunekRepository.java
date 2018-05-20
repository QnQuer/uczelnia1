package com.example.demo.repository;

import com.example.demo.model.Kierunek;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

 /*
 * @author micha
 */

public interface KierunekRepository extends JpaRepository <Kierunek, Long> {
    
}
