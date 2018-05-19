package com.example.demo.model;

import javax.persistence.*;
import java.util.List;


/**
 * Class of user accounts
 *
 * @Entity mean this class is database entity and will be mapped into database table
 */
@Entity
public class Kierunek {

    /**
     * Primary Key of Accounts table
     * @GeneratedValue mean this column will be autoincrement and we don't need to put this value into INSERT statement
     */
    @Id
    @GeneratedValue
    private long kierunek_id;
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

    public Kierunek(long kierunek_id, String nazwa, String opis, String stopien, int sets, List<Student> Students, List<Przedmiot> Przedmiot, List<Wykladowca> Wykladowca) {
        this.kierunek_id = kierunek_id;
        this.nazwa = nazwa;
        this.opis = opis;
        this.stopien = stopien;
        this.sets = sets;
        this.Students = Students;
        this.Przedmiot = Przedmiot;
        this.Wykladowca = Wykladowca;
    }

    public long getKierunek_id() {
        return kierunek_id;
    }

    public void setKierunek_id(long kierunek_id) {
        this.kierunek_id = kierunek_id;
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