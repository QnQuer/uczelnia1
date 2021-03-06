package com.example.demo.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlIDREF;
import java.util.List;

@Entity
public class Wykladowca {

    @Id
    @GeneratedValue
    private Long wykladowcaId;
    private String nazwisko;
    private String imie;
    private String kod;
    private String miasto;
    private String e_mail;
  /* @OneToMany
    @JoinColumn(name = "wykladowca_id")
    private List<Student> Students;*/
  @ManyToMany    
    @JoinTable(
        name = "Wykladowca_Student", 
        joinColumns = { @JoinColumn(name = "wykladowcaId") }, 
        inverseJoinColumns = { @JoinColumn(name = "studentId") })
    private List<Student> studenci;
    @OneToMany
    @JoinColumn(name = "wykladowcaId")
    private List<Przedmiot> Przedmiot;
    @ManyToOne
    private Kierunek kierunek;

    public Wykladowca() {
    }

    public Wykladowca(Long wykladowca_id, String nazwisko, String imie, String kod, String miasto, String e_mail, List<Student> studenci, List<Przedmiot> Przedmiot, Kierunek kierunek) {
        this.wykladowcaId = wykladowcaId;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.kod = kod;
        this.miasto = miasto;
        this.e_mail = e_mail;
        this.studenci = studenci;
        this.Przedmiot = Przedmiot;
        this.kierunek = kierunek;
    }

    public Wykladowca(String Imie, String Nazwisko, String Kod, String Miasto, String E_mail) {
       this.imie = Imie;
       this.nazwisko = Nazwisko;
       this.kod = Kod;
       this.miasto = Miasto;
       this.e_mail = E_mail;
    }

   

    public Long getWykladowcaId() {
        return wykladowcaId;
    }

    public void setWykladowcaId(Long wykladowcaId) {
        this.wykladowcaId = wykladowcaId;
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

    public List<Student> getStudenci() {
        return studenci;
    }

    public void setStudenci(List<Student> studenci) {
        this.studenci = studenci;
    }

    public List<Przedmiot> getPrzedmiot() {
        return Przedmiot;
    }

    public void setPrzedmiot(List<Przedmiot> Przedmiot) {
        this.Przedmiot = Przedmiot;
    }

    public Kierunek getKierunek() {
        return kierunek;
    }

    public void setKierunek(Kierunek kierunek) {
        this.kierunek = kierunek;
    }

  

  
    
}