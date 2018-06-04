package com.example.demo.model;

import javax.persistence.*;
import java.util.List;



@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long StudentId ;
    private String imie;
    private String nazwisko;
    private String data_ur;
    private String miejsce;
    private String pesel;
    private String kod;
    private String miasto;
    private String ulica;
    private String numer;
    private String tel;
    private String e_mail;
    @ManyToOne
    private Kierunek kierunek;
    /*@ManyToOne 
    private Wykladowca Wykladowca;*/
    @ManyToMany(mappedBy = "studenci")
    private List<Przedmiot> przedmioty;
    @ManyToMany(mappedBy = "studenci")
    private List<Wykladowca> Wykladowca;

    public Student() {
    }

    public Student(Long studentid, String imie, String nazwisko, String data_ur, String miejsce, String pesel, String kod, String miasto, String ulica, String numer, String tel, String e_mail, Kierunek kierunek, List<Wykladowca> Wykladowca, List<Przedmiot> przedmioty) {
        this.StudentId  = studentid;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_ur = data_ur;
        this.miejsce = miejsce;
        this.pesel = pesel;
        this.kod = kod;
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer = numer;
        this.tel = tel;
        this.e_mail = e_mail;
        this.kierunek = kierunek;
        this.Wykladowca = Wykladowca;
        this.przedmioty = przedmioty;
    }

    public Student(String value, String value0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Student(String value, String value0, String value1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getStudentId() {
        return StudentId;
    }

    public void setStudentId(Long StudentId) {
        this.StudentId = StudentId;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getData_ur() {
        return data_ur;
    }

    public void setData_ur(String data_ur) {
        this.data_ur = data_ur;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
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

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Kierunek getKierunek() {
        return kierunek;
    }

    public void setKierunek(Kierunek kierunek) {
        this.kierunek = kierunek;
    }

    public List<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }

    public void setPrzedmioty(List<Przedmiot> przedmioty) {
        this.przedmioty = przedmioty;
    }

    public List<Wykladowca> getWykladowca() {
        return Wykladowca;
    }

    public void setWykladowca(List<Wykladowca> Wykladowca) {
        this.Wykladowca = Wykladowca;
    }



   

   
    
    
}