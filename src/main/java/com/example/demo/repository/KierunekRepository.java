package com.example.demo.repository;

import com.example.demo.model.Kierunek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

 /*
 * @author micha
 */
@Repository
public interface KierunekRepository {
    public List<Kierunek> findAll();
    public Kierunek save(Kierunek a);
    public boolean deleteById(Kierunek s);
    public Kierunek findOneById(Long kierunek_id);
    
}
