package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Przedmiot {
     
    @Id
    @GeneratedValue
    private Long przedmiotId;
    private String nazwa;
    private String opis;
    private String rodzaj;
    private int ects;
    @ManyToOne
    private Wykladowca Wykladowca;
    @ManyToOne
    private Kierunek kierunek;
    @ManyToMany    
    @JoinTable(
        name = "Przedmiot_Student", 
        joinColumns = { @JoinColumn(name = "przedmiotId") }, 
        inverseJoinColumns = { @JoinColumn(name = "student_id") }
    )
    private List<Student> studenci;

    public Przedmiot() {
    }

    public Przedmiot(Long przedmiotId, String nazwa, String opis, String rodzaj, int ects, Wykladowca Wykladowca, Kierunek kierunek, List<Student> studenci) {
        this.przedmiotId = przedmiotId;
        this.nazwa = nazwa;
        this.opis = opis;
        this.rodzaj = rodzaj;
        this.ects = ects;
        this.Wykladowca = Wykladowca;
        this.kierunek = kierunek;
        this.studenci = studenci;
    }

    public Long getPrzedmiotId() {
        return przedmiotId;
    }

    public void setPrzedmiotId(Long przedmiotId) {
        this.przedmiotId = przedmiotId;
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

    public Wykladowca getWykladowca() {
        return Wykladowca;
    }

    public void setWykladowca(Wykladowca Wykladowca) {
        this.Wykladowca = Wykladowca;
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