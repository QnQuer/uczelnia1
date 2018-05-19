package com.example.demo.model;

import javax.persistence.*;
import java.util.List;



@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long student_id;
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
    
    @ManyToMany(mappedBy = "studenci")
    private List<Przedmiot> przedmioty;

     public Student() {
    }
    
    public Student (Long student_id, String imie, String nazwisko, String data_ur, String miejsce, String pesel , String kod , String miasto, String ulica, String numer, String tel, String e_mail/* ,List<Book> listOfAuthorBooks*/) {
        this.student_id = student_id;
        this.imie = imie;
        this.nazwisko= nazwisko;
        this.data_ur = data_ur;
        this.miejsce = miejsce;
        this.pesel = pesel;
        this.kod = kod;
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer = numer;
        this.tel = tel;
        this.e_mail = e_mail;
        
    }

    public Student(String imie, String nazwisko, String data_ur, String miejsce, String pesel , String kod , String miasto, String ulica, String numer, String tel, String e_mail) {
        this.imie = imie;      
        this.nazwisko= nazwisko;
        this.data_ur = data_ur;
        this.miejsce = miejsce;
        this.pesel = pesel;
        this.kod = kod;
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer = numer;
        this.tel = tel;
        this.e_mail = e_mail;
        
    }

    public Long getId() {
        return student_id;
    }

    public void setId(Long przedmiot_id) {
        this.student_id = student_id;
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
}
    
 /*   @ManyToMany
    private List<Accounts> accounts;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Book> listOfRentedBooks;


    public Rent() {
    }

    public Rent(List<Accounts> accounts, List<Book> listOfRentedBooks) {
        this.accounts = accounts;
        this.listOfRentedBooks = listOfRentedBooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }

    public List<Book> getListOfRentedBooks() {
        return listOfRentedBooks;
    }

    public void setListOfRentedBooks(List<Book> listOfRentedBooks) {
        this.listOfRentedBooks = listOfRentedBooks;
    }
}*/
