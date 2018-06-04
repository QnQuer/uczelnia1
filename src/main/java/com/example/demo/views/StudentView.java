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
     * @param StudentRepository
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
        grid.addColumn(Student::getStudentId).setCaption("ID");
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
                if (imie.getValue().length() > 0 && nazwisko.getValue().length() > 0 && pesel.getValue().length() > 0) {

                    //We use repository to add object to database as a entity.
                    Student Student = new Student(imie.getValue(), nazwisko.getValue(), pesel.getValue());
                    StudentRepository.save(Student);
                    setGridElements(grid, StudentRepository.findAll());
                } else {
                    Notification.show("Warning!", "Uzupełnij imie, nazwisko i pesel", Notification.Type.WARNING_MESSAGE);
                }
                 } catch (Exception e) {
                Notification.show(e.getClass().getName(), e.getMessage(), Notification.Type.ERROR_MESSAGE);
                e.printStackTrace();
                 }
            
    });
         deleteButton.addClickListener(click -> {
            try {
                if (grid.getSelectionModel().getFirstSelectedItem().isPresent()) {
                    StudentRepository.deleteByStudentId(grid.getSelectionModel().getFirstSelectedItem().get().getStudentId());
                    setGridElements(grid, StudentRepository.findAll());
                    updateButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                    imie.setValue("");
                    nazwisko.setValue("");
                    data_ur.setValue("");
                    miejsce.setValue("");
                    pesel.setValue("");
                    kod.setValue("");
                    miasto.setValue("");
                    ulica.setValue("");
                    numer.setValue("");
                    tel.setValue("");
                    e_mail.setValue("");
                } else {
                    Notification.show("Warning!", "You need select element from table!", Notification.Type.WARNING_MESSAGE);
                }
                 } catch (Exception e) {
                Notification.show(e.getClass().getName(), e.getMessage(), Notification.Type.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });
         grid.addSelectionListener(item -> {
            item.getFirstSelectedItem().ifPresent( selectedItem -> {
                    updateButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                    imie.setValue(selectedItem.getImie());
                    nazwisko.setValue(selectedItem.getNazwisko());
                    data_ur.setValue(selectedItem.getData_ur());
                    miejsce.setValue(selectedItem.getMiejsce());
                    pesel.setValue(selectedItem.getPesel());
                    kod.setValue(selectedItem.getKod());
                    miasto.setValue(selectedItem.getMiasto());
                    ulica.setValue(selectedItem.getUlica());
                    numer.setValue(selectedItem.getNumer());
                    tel.setValue(selectedItem.getTel());
                    e_mail.setValue(selectedItem.getE_mail());

            });
        });
updateButton.addClickListener(click -> {

            if (grid.getSelectionModel().getFirstSelectedItem().isPresent()) {
                Student student = StudentRepository.findOneByStudentId(grid.getSelectionModel().getFirstSelectedItem().get().getStudentId());
                student.setImie(imie.getValue());
                student.setNazwisko(nazwisko.getValue());
                student.setData_ur(data_ur.getValue());
                student.setMiejsce(miejsce.getValue());
                student.setPesel(pesel.getValue());
                student.setKod(kod.getValue());
                student.setMiasto(miasto.getValue());
                student.setUlica(ulica.getValue());
                student.setNumer(numer.getValue());
                student.setTel(tel.getValue());
                student.setE_mail(e_mail.getValue());
                
                StudentRepository.save(student);
                updateButton.setEnabled(false);
                deleteButton.setEnabled(false);
                setGridElements(grid, StudentRepository.findAll());
                 imie.setValue("");
                    nazwisko.setValue("");
                    data_ur.setValue("");
                    miejsce.setValue("");
                    pesel.setValue("");
                    kod.setValue("");
                    miasto.setValue("");
                    ulica.setValue("");
                    numer.setValue("");
                    tel.setValue("");
                    e_mail.setValue("");
            } else {
                Notification.show("Something went wrong!");
            }

        });
}

    private void setGridElements(Grid grid, List<Student> studentList){
        grid.setItems(studentList);
    }
}