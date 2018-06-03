package com.example.demo.views;
import com.example.demo.repository.StudentRepository;
import com.example.demo.model.Student;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringUI
public class StudentView extends HorizontalLayout implements View {

    private final StudentRepository StudentRepository;
    public Student updateObject;
      /**
     * Constructor called when we enter this site (fe. localhost:8080/#!AccountView)
     * @param accountsRepository
     */
    @Autowired
    public StudentView(StudentRepository StudentRepository){
        this.StudentRepository = StudentRepository;
        
        TextField imie = new TextField();
        imie.setPlaceholder("Imie");
        TextField nazwisko = new TextField();
        nazwisko.setPlaceholder("Nazwisko");
         TextField data_ur = new TextField();
        data_ur.setPlaceholder("Data Urodzenia");
        TextField miejsce = new TextField();
        miejsce.setPlaceholder("Miejsce");
        TextField pesel = new TextField();
        pesel.setPlaceholder("Pesel");
        TextField kod = new TextField();
        kod.setPlaceholder("Kod");
        TextField miasto = new TextField();
        miasto.setPlaceholder("Miasto");
        TextField ulica = new TextField();
        ulica.setPlaceholder("Ulica");
        TextField numer = new TextField();
        numer.setPlaceholder("Numer");
        TextField tel = new TextField();
        tel.setPlaceholder("Telefon");
        TextField e_mail = new TextField();
        e_mail.setPlaceholder("E-mail");
        HorizontalLayout horizontalTextFieldLayout = new HorizontalLayout();
        horizontalTextFieldLayout.addComponents(imie,nazwisko,miejsce,pesel,kod,miasto,ulica,numer,tel,e_mail);
        
        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");
        addButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
        updateButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        updateButton.setEnabled(false);
        deleteButton.setStyleName(ValoTheme.BUTTON_DANGER);
        deleteButton.setEnabled(false);
        Grid<Student> grid = new Grid<>();
        grid.addColumn(Student::getStudent_id).setCaption("ID");
        grid.addColumn(Student::getImie).setCaption("Imie");
        grid.addColumn(Student::getNazwisko).setCaption("Nazwisko");
        grid.addColumn(Student::getData_ur).setCaption("Data urodzenia");
        grid.addColumn(Student::getMiejsce).setCaption("Miejsce");
        grid.addColumn(Student::getPesel).setCaption("Pesel");
        grid.addColumn(Student::getKod).setCaption("Kod");
        grid.addColumn(Student::getMiasto).setCaption("Miasto");
        grid.addColumn(Student::getUlica).setCaption("Ulica");
        grid.addColumn(Student::getTel).setCaption("Telefon");
        grid.addColumn(Student::getE_mail).setCaption("E-mail");
        
        VerticalLayout verticalLayout = new VerticalLayout();

        HorizontalLayout horizontallAddAndDeleteButtonLayout = new HorizontalLayout();
        horizontallAddAndDeleteButtonLayout.addComponents(addButton, updateButton, deleteButton);
        verticalLayout.addComponents(horizontalTextFieldLayout, horizontallAddAndDeleteButtonLayout, grid);

        setGridElements(grid, StudentRepository.findAll());
       
        addButton.addClickListener(click -> {

            try {
                /**
                 * If values at textfield are > 0 which mean there is something more than null or ""
                 * There will be created a new Account class object which is filled with values of texfield.
                 * We use repository to add object to database as a entity.
                 */
                if (imie.getValue().length() > 0 && nazwisko.getValue().length() > 0) {

                    //We use repository to add object to database as a entity.
                    Student Student = new Student(imie.getValue(), nazwisko.getValue());
                    StudentRepository.save(Student);
                    setGridElements(grid, StudentRepository.findAll());
                } else {
                    Notification.show("Warning!", "You need fill all fields!", Notification.Type.WARNING_MESSAGE);
                }
                 } catch (Exception e) {
                Notification.show(e.getClass().getImie(), e.getMessage(), Notification.Type.ERROR_MESSAGE);
                e.printStackTrace();
            }
            
    });
}
}