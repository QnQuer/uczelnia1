package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Przedmioty {

    @Id
    @GeneratedValue
    private Long przedmiot_id;
    private String nazwa;
    private String opis;
    private String rodzaj;
    private int ects;

 /* @OneToMany
    @JoinColumn(name = "author_id")
    private List<Book> listOfAuthorBooks;*/

    public Przedmioty() {
    }

    public Przedmioty (Long przedmiot_id, String nazwa, String opis, String rodzaj, int ects/* ,List<Book> listOfAuthorBooks*/) {
        this.przedmiot_id = przedmiot_id;
        this.nazwa = nazwa;
        this.opis = opis;
        this.rodzaj = rodzaj;
        this.ects = ects;
        //this.listOfAuthorBooks = listOfAuthorBooks;
    }

    public Przedmioty(String nazwa, String opis, String rodzaj, int ects) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.rodzaj = rodzaj;
        this.ects = ects;
    }

    public Long getId() {
        return przedmiot_id;
    }

    public void setId(Long przedmiot_id) {
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



   /* public List<Book> getListOfAuthorBooks() {
        return listOfAuthorBooks;
    }

    public void setListOfAuthorBooks(List<Book> listOfAuthorBooks) {
        this.listOfAuthorBooks = listOfAuthorBooks;
    }*/
}
