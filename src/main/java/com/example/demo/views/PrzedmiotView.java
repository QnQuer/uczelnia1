/***/
package com.example.demo.views;

import com.example.demo.repository.PrzedmiotRepository;
import com.example.demo.model.Przedmiot;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


    @SpringUI
public class PrzedmiotView extends HorizontalLayout implements View{

    private PrzedmiotRepository przedmiotRepository;
    public Przedmiot updateObject;

    public PrzedmiotView(PrzedmiotRepository pr) {


        //TODO: https://vaadin.com/docs/v8/framework/components/components-menubar.html

        this.przedmiotRepository = pr;

        /**
         * We can find here objects wich are visible on site. Buttons etc.
         */
       
        TextField nazwa = new TextField();
        nazwa.setPlaceholder("Nazwa");
        TextField opis = new TextField();
        opis.setPlaceholder("Opis");
        TextField rodzaj = new TextField();
        rodzaj.setPlaceholder("Rodzaj");
        TextField ects = new TextField();
        ects.setPlaceholder("ECTS");
        TextField Wykladowca = new TextField();
        Wykladowca.setPlaceholder("Wykladowca");
        TextField kierunek = new TextField();
        kierunek.setPlaceholder("Kierunek");
        TextField studenci = new TextField();
        studenci.setPlaceholder("Studenci");


        HorizontalLayout horizontalTextFieldLayout = new HorizontalLayout();
        horizontalTextFieldLayout.addComponents(nazwa, opis, rodzaj, ects);

        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");
        addButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
        updateButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        updateButton.setEnabled(false);
        deleteButton.setStyleName(ValoTheme.BUTTON_DANGER);
        deleteButton.setEnabled(false);
        Grid<Przedmiot> grid = new Grid<>();
        grid.addColumn(Przedmiot::getPrzedmiotId).setCaption("ID Przedmiotu");
        grid.addColumn(Przedmiot::getNazwa).setCaption("Nazwa");
        grid.addColumn(Przedmiot::getOpis).setCaption("Opis");
        grid.addColumn(Przedmiot::getRodzaj).setCaption("Rodzaj");
        grid.addColumn(Przedmiot::getEcts).setCaption("ECTS");
        


        VerticalLayout verticalLayout = new VerticalLayout();

        HorizontalLayout horizontallAddAndDeleteButtonLayout = new HorizontalLayout();
        horizontallAddAndDeleteButtonLayout.addComponents(addButton, updateButton, deleteButton);
        verticalLayout.addComponents(horizontalTextFieldLayout, horizontallAddAndDeleteButtonLayout, grid);

        setGridElements(grid, przedmiotRepository.findAll());

        addButton.addClickListener(click -> {

            try {
                /**
                 * If values at textfield are > 0 which mean there is something more than null or ""
                 * There will be created a new Account class object which is filled with values of texfield.
                 * We use repository to add object to database as a entity.
                 */
                if (nazwa.getValue().length() > 0 && ects.getValue().length() > 0) {

                    //We use repository to add object to database as a entity.
                    Przedmiot Przedmiot = new Przedmiot(nazwa.getValue(), opis.getValue(), rodzaj.getValue(), ects.getValue());
                    przedmiotRepository.save(Przedmiot);
                    setGridElements(grid, przedmiotRepository.findAll());
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
                    przedmiotRepository.deleteById(grid.getSelectionModel().getFirstSelectedItem().get().getPrzedmiotId());
                    setGridElements(grid, przedmiotRepository.findAll());
                    updateButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                    nazwa.setValue("");
                    opis.setValue("");
                    rodzaj.setValue("");
                    ects.setValue("");
                   
                } else {
                    Notification.show("Warning!", "You need select element from table!", Notification.Type.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                Notification.show(e.getClass().getName(), e.getMessage(), Notification.Type.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });
        grid.addSelectionListener(item -> {
            item.getFirstSelectedItem().ifPresent(selectedItem -> {
                updateButton.setEnabled(true);
                deleteButton.setEnabled(true);
                nazwa.setValue(selectedItem.getNazwa());
                opis.setValue(selectedItem.getOpis());
                rodzaj.setValue(selectedItem.getRodzaj());
                ects.setValue(selectedItem.getEcts());
                

            });
        });
        updateButton.addClickListener(click -> {

            if (grid.getSelectionModel().getFirstSelectedItem().isPresent()) {
                Przedmiot przedmiot = przedmiotRepository.findOneByPrzedmiotId(grid.getSelectionModel().getFirstSelectedItem().get().getPrzedmiotId());
                przedmiot.setNazwa(nazwa.getValue());
                przedmiot.setOpis(opis.getValue());
                przedmiot.setRodzaj(rodzaj.getValue());
                przedmiot.setEcts(ects.getValue());
               

                przedmiotRepository.save(przedmiot);
                updateButton.setEnabled(false);
                deleteButton.setEnabled(false);
                setGridElements(grid, przedmiotRepository.findAll());
                nazwa.setValue("");
                opis.setValue("");
                rodzaj.setValue("");
                ects.setValue("");
               
            } else {
                Notification.show("Something went wrong!");
            }

        });

        addComponent(verticalLayout);
    }

    private void setGridElements(Grid grid, List<Przedmiot> przedmiotList) {
        grid.setItems(przedmiotList);
    }
}