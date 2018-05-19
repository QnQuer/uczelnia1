package com.example.demo.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlIDREF;
import java.util.List;

@Entity
public class Wykladowcy {

    @Id
    @GeneratedValue
    private Long wykladowca_id;
    private String nazwisko;
    private String imie;
    private String kod;
    private String miasto;
    private String e_mail;
   /* @ManyToOne
    private Author author;
    private String publisher;
    private int year;

    @ManyToMany
    private List<Rent> accounts;*/

    public Wykladowcy() {
    }

    public Wykladowcy(Long wykladowca_id, String nazwisko,String imie,String kod, String miasto, String e_mail){ //Author author, String publisher, int year) {
        this.wykladowca_id = wykladowca_id;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.kod = kod;
        this.miasto = miasto;
        this.e_mail = e_mail;
        //this.author = author;
        //this.publisher = publisher;
       // this.year = year;
    }

    public Long getId() {
        return wykladowca_id;
    }

    public void setId(Long id) {
        this.wykladowca_id = wykladowca_id;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }
     public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
}
