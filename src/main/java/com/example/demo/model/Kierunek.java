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

 

    public Kierunek(String nazwa, String opis, String stopien, int sets) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.stopien = stopien;
        this.sets = sets;
        
    }

    public Kierunek() {
    }
 @OneToMany
    @JoinColumn(name = "kierunek_id")
    private List<Student> Students;
  @OneToMany
    @JoinColumn(name = "kierunek_id")
    private List<Przedmiot> Przedmiot;


    public long getkierunek_id() {
        return kierunek_id;
    }

    public void setId(long kierunek_id) {
        this.kierunek_id = kierunek_id;
    }

    public String getnazwa() {
        return nazwa;
    }

    public void setnazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getopis() {
        return opis;
    }

    public void setopis(String opis) {
        this.opis = opis;
    }
    public String getstopien(){
        return stopien;
    }
    public void setstopien(String stopien){
        this.stopien = stopien;
    }
    public int getsets(){
        return sets;
    }
    public void setsets(int sets){
        this.sets = sets;
    }
    
}
