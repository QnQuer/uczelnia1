package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Przedmiot {
     
    @Id
    @GeneratedValue
    private Long przedmiot_id;
    private String nazwa;
    private String opis;
    private String rodzaj;
    private int ects;
    @ManyToOne
    private Kierunek kierunek;
    @ManyToMany    
    @JoinTable(
        name = "Przedmiot_Student", 
        joinColumns = { @JoinColumn(name = "przedmiot_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "student_id") }
    )
    private List<Student> studenci;


   
 
}

