package com.example.demo.views;

import com.example.demo.model.Student;
import com.example.demo.model.Wykladowca;
import com.example.demo.repository.WykladowcaRepository;
import com.vaadin.navigator.View;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WykladowcaView extends HorizontalLayout implements View {

    private final WykladowcaRepository wykladowcaRepository;
    public Student updateObject;

    @Autowired
    public WykladowcaView (WykladowcaRepository wykladowcaRepository) {
    
        
        this.wykladowcaRepository = wykladowcaRepository;
        TextField imie = new TextField();
        imie.setPlaceholder("Imie");
        TextField nazwisko = new TextField();
        nazwisko.setPlaceholder("Nazwisko");
        TextField kod = new TextField();
        kod.setPlaceholder("Kod");
        TextField miasto = new TextField();
        miasto.setPlaceholder("Miasto");
        TextField e_mail = new TextField();
        e_mail.setPlaceholder("E-mail");

        HorizontalLayout horizontalTextFieldLayout = new HorizontalLayout();
        horizontalTextFieldLayout.addComponents(imie, nazwisko, kod, miasto, e_mail);

        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");
        addButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
        updateButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        updateButton.setEnabled(false);
        deleteButton.setStyleName(ValoTheme.BUTTON_DANGER);
        deleteButton.setEnabled(false);
        Grid<Wykladowca> grid = new Grid<>();
        grid.addColumn(Wykladowca::getWykladowcaId).setCaption("ID");
        grid.addColumn(Wykladowca::getImie).setCaption("Imie");
        grid.addColumn(Wykladowca::getNazwisko).setCaption("Nazwisko");
        grid.addColumn(Wykladowca::getKod).setCaption("Kod");
        grid.addColumn(Wykladowca::getMiasto).setCaption("Miasto");
        grid.addColumn(Wykladowca::getE_mail).setCaption("E-mail");

        VerticalLayout verticalLayout = new VerticalLayout();

        HorizontalLayout horizontallAddAndDeleteButtonLayout = new HorizontalLayout();
        horizontallAddAndDeleteButtonLayout.addComponents(addButton, updateButton, deleteButton);
        verticalLayout.addComponents(horizontalTextFieldLayout, horizontallAddAndDeleteButtonLayout, grid);

        setGridElements(grid, wykladowcaRepository.findAll());
    }

   public void setGridElements(Grid grid, List<?> wykladowcaList) {
        grid.setItems(wykladowcaList);
    }}