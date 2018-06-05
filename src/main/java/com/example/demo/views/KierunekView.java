package com.example.demo.views;

import com.example.demo.model.Kierunek;
import com.example.demo.model.Student;
import com.example.demo.model.Przedmiot;
import com.example.demo.repository.KierunekRepository;
import com.example.demo.repository.PrzedmiotRepository;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringUI
public class KierunekView extends HorizontalLayout implements View {

    private final KierunekRepository kierunekRepository; //book
    private final PrzedmiotRepository przedmiotRepository;//author
    public Student updateObject;
    List<Przedmiot> przedmiotList;
    ComboBox<Przedmiot> przedmiotComboBox;
    TextField nazwa;

    @Autowired
    public KierunekView(KierunekRepository kierunekRepository, PrzedmiotRepository przedmiotRepository) {

        this.kierunekRepository = kierunekRepository;
        this.przedmiotRepository = przedmiotRepository;
        przedmiotList = przedmiotRepository.findAll();
        przedmiotComboBox = new ComboBox<>();
        przedmiotComboBox.setItems(przedmiotList);
        przedmiotComboBox.setItemCaptionGenerator(Przedmiot::getNazwa);
        nazwa = new TextField();
        nazwa.setPlaceholder("Nazwa");

        HorizontalLayout horizontalTextFieldLayout = new HorizontalLayout();
        horizontalTextFieldLayout.addComponents(nazwa);
        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");
        addButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
        updateButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        updateButton.setEnabled(false);
        deleteButton.setStyleName(ValoTheme.BUTTON_DANGER);
        deleteButton.setEnabled(false);
        Grid<Kierunek> grid = new Grid<>();
        grid.addColumn(Kierunek::getKierunekId).setCaption("ID");
        grid.addColumn(Kierunek::getNazwa).setCaption("Nazwa");
        grid.addColumn(Kierunek::getOpis).setCaption("Opis");
        grid.addColumn(Kierunek::getStopien).setCaption("Stopien");
        grid.addColumn(Kierunek::getSets).setCaption("Ets");

        VerticalLayout verticalLayout = new VerticalLayout();

        HorizontalLayout horizontallAddAndDeleteButtonLayout = new HorizontalLayout();
        horizontallAddAndDeleteButtonLayout.addComponents(addButton, updateButton, deleteButton);
        verticalLayout.addComponents(przedmiotComboBox, horizontalTextFieldLayout, horizontallAddAndDeleteButtonLayout, grid);

//        przedmiotComboBox.addSelectionListener(select -> {
//            setGridElements(grid, kierunekRepository.findAllByPrzedmiot_przedmiotId(select.getValue().getPrzedmiotId()));
//        });
//        addButton.addClickListener(click -> {
//            try {
//                if (nazwa.getValue().length() > 0 && przedmiotComboBox.getSelectedItem().get().getPrzedmiotId() != null) {
//                    Kierunek kierunek = new Kierunek();
//                    kierunek.setNazwa(nazwa.getValue());
//                    kierunek.setPrzedmiot(new ArrayList<>());
//                    kierunek.getPrzedmiot().add(przedmiotComboBox.getSelectedItem().get());
//                    kierunekRepository.save(kierunek);
//                    setGridElements(grid, kierunekRepository.findAllByPrzedmiot_przedmiotId(przedmiotComboBox.getSelectedItem().get().getPrzedmiotId()));
//
//                    clearTextFields();
//                } else {
//                    Notification.show("Warning!", "You need fill all fields.", Notification.Type.WARNING_MESSAGE);
//                }
//            } catch (NumberFormatException e) {
//                Notification.show("Warning!", "Year should be a number.", Notification.Type.WARNING_MESSAGE);
//                e.printStackTrace();
//            } catch (Exception e) {
//                Notification.show(e.getClass().getName(), e.getMessage(), Notification.Type.ERROR_MESSAGE);
//                e.printStackTrace();
//            }
//
//        });
//        grid.addSelectionListener(item -> {
//            item.getFirstSelectedItem().ifPresent(selectedItem -> {
//                updateButton.setEnabled(true);
//                deleteButton.setEnabled(true);
//                nazwa.setValue(selectedItem.getNazwa());
//            });
//        });
//        updateButton.addClickListener(click -> {
//
//            if (grid.getSelectionModel().getFirstSelectedItem().isPresent()) {
//                Kierunek kierunek = kierunekRepository.findOne(grid.getSelectionModel().getFirstSelectedItem().get().getKierunekId());
//                kierunek.setNazwa(nazwa.getValue());
//                kierunekRepository.save(kierunek);
//                updateButton.setEnabled(false);
//                deleteButton.setEnabled(false);
//                setGridElements(grid, kierunekRepository.findAllByPrzedmiot_przedmiotId(przedmiotComboBox.getSelectedItem().get().getPrzedmiotId()));
//                clearTextFields();
//            } else {
//                Notification.show("Something went wrong!");
//            }
//
//        });
//        addComponent(verticalLayout);
//        //HorizontalLayout horizontalLayout = new HorizontalLayout();
//        //horizontalLayout.addComponents();
//
//        //setComponentAlignment(verticalLayout, Alignment.TOP_LEFT);
    }

    public void setGridElements(Grid grid, List<Kierunek> studentList) {
        grid.setItems(studentList);
    }

    /**
     * Method called onice we ENTER the site (which mean no refresh, just enter
     * or switch (using side menu for example).
     *
     * @param event
     */
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        przedmiotComboBox.setItems(przedmiotRepository.findAll());
        przedmiotComboBox.setItemCaptionGenerator(Przedmiot::getNazwa);
    }

    private void clearTextFields() {
        nazwa.setValue("");
    }
}
