package com.example.demo.model;

import javax.persistence.*;
import java.util.List;



@Entity
public class Kierunek {

   
    @Id
    @GeneratedValue
    private long kierunekId;
    private String nazwa;
    private String opis;
    private String stopien;
    private int sets;
    @OneToMany
    @JoinColumn(name = "kierunek_id")
    private List<Student> Students;
    @OneToMany
    @JoinColumn(name = "kierunek_id")
    private List<Przedmiot> Przedmiot;
    @OneToMany
    @JoinColumn(name = "kierunek_id")
    private List<Wykladowca> Wykladowca;

    public Kierunek() {
    }

    public Kierunek(long kierunekId, String nazwa, String opis, String stopien, int sets, List<Student> Students, List<Przedmiot> Przedmiot, List<Wykladowca> Wykladowca) {
        this.kierunekId = kierunekId;
        this.nazwa = nazwa;
        this.opis = opis;
        this.stopien = stopien;
        this.sets = sets;
        this.Students = Students;
        this.Przedmiot = Przedmiot;
        this.Wykladowca = Wykladowca;
    }

    public long getKierunekId() {
        return kierunekId;
    }

    public void setKierunekId(long kierunekId) {
        this.kierunekId = kierunekId;
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

    public String getStopien() {
        return stopien;
    }

    public void setStopien(String stopien) {
        this.stopien = stopien;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public List<Student> getStudents() {
        return Students;
    }

    public void setStudents(List<Student> Students) {
        this.Students = Students;
    }

    public List<Przedmiot> getPrzedmiot() {
        return Przedmiot;
    }

    public void setPrzedmiot(List<Przedmiot> Przedmiot) {
        this.Przedmiot = Przedmiot;
    }

    public List<Wykladowca> getWykladowca() {
        return Wykladowca;
    }

    public void setWykladowca(List<Wykladowca> Wykladowca) {
        this.Wykladowca = Wykladowca;
    }

 
}