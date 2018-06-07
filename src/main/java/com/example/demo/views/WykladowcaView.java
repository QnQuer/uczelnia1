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
    addButton.addClickListener(click -> {

            try {
                /**
                 * If values at textfield are > 0 which mean there is something more than null or ""
                 * There will be created a new Account class object which is filled with values of texfield.
                 * We use repository to add object to database as a entity.
                 */
                if (imie.getValue().length() > 0 && nazwisko.getValue().length() > 0 ) {

                    //We use repository to add object to database as a entity.
                    Wykladowca Wykladowca = new Wykladowca(imie.getValue(), nazwisko.getValue(), kod.getValue(), miasto.getValue(), e_mail.getValue());
                    wykladowcaRepository.save(Wykladowca);
                    setGridElements(grid, wykladowcaRepository.findAll());
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
                    wykladowcaRepository.deleteById(grid.getSelectionModel().getFirstSelectedItem().get().getWykladowcaId());
                    setGridElements(grid, wykladowcaRepository.findAll());
                    updateButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                    imie.setValue("");
                    nazwisko.setValue("");
                    kod.setValue("");
                    miasto.setValue("");
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
            item.getFirstSelectedItem().ifPresent(selectedItem -> {
                updateButton.setEnabled(true);
                deleteButton.setEnabled(true);
                imie.setValue(selectedItem.getImie());
                nazwisko.setValue(selectedItem.getNazwisko());
                kod.setValue(selectedItem.getKod());
                miasto.setValue(selectedItem.getMiasto());               
                e_mail.setValue(selectedItem.getE_mail());

            });
        });
        updateButton.addClickListener(click -> {

            if (grid.getSelectionModel().getFirstSelectedItem().isPresent()) {
                Wykladowca wykladowca = wykladowcaRepository.findOneByWykladowcaId(grid.getSelectionModel().getFirstSelectedItem().get().getWykladowcaId());
               wykladowca.setImie(imie.getValue());
               wykladowca.setNazwisko(nazwisko.getValue());
               wykladowca.setKod(kod.getValue());
               wykladowca.setMiasto(miasto.getValue());
                wykladowca.setE_mail(e_mail.getValue());

                wykladowcaRepository.save(wykladowca);
                updateButton.setEnabled(false);
                deleteButton.setEnabled(false);
                setGridElements(grid, wykladowcaRepository.findAll());
                imie.setValue("");
                nazwisko.setValue("");
                kod.setValue("");
                miasto.setValue("");
                e_mail.setValue("");
            } else {
                Notification.show("Something went wrong!");
            }

        });

        addComponent(verticalLayout);
    }

    private void setGridElements(Grid grid, List<Wykladowca> wykladowcaList) {
        grid.setItems(wykladowcaList);
    }
}