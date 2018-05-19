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

    public Przedmiot(Long przedmiot_id, String nazwa, String opis, String rodzaj, int ects, Kierunek kierunek, List<Student> studenci) {
        this.przedmiot_id = przedmiot_id;
        this.nazwa = nazwa;
        this.opis = opis;
        this.rodzaj = rodzaj;
        this.ects = ects;
        this.kierunek = kierunek;
        this.studenci = studenci;
    }

    public Przedmiot() {
    }
    

    public Long getPrzedmiot_id() {
        return przedmiot_id;
    }

    public void setPrzedmiot_id(Long przedmiot_id) {
        this.przedmiot_id = przedmiot_id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public Kierunek getKierunek() {
        return kierunek;
    }

    public void setKierunek(Kierunek kierunek) {
        this.kierunek = kierunek;
    }

    public List<Student> getStudenci() {
        return studenci;
    }

    public void setStudenci(List<Student> studenci) {
        this.studenci = studenci;
    }


   
 
}

