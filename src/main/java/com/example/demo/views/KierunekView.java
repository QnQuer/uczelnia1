package com.example.demo.views;


import com.example.demo.repository.KierunekRepository;
import com.example.demo.model.Kierunek;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@SpringUI
public class KierunekView extends HorizontalLayout implements View {

    private final KierunekRepository kierunekRepository; //book
   
    public Kierunek updateObject;
  

     /**
     * Constructor called when we enter this site (fe. localhost:8080/#!AccountView)
     *
     * @param kierunekRepository
     */
    
    @Autowired
    public KierunekView(KierunekRepository kierunekRepository) {
        
        this.kierunekRepository = kierunekRepository;
        
         TextField nazwa = new TextField();
        nazwa.setPlaceholder("Nazwa");
         TextField opis = new TextField();
        opis.setPlaceholder("Opis");
         TextField stopien = new TextField();
        stopien.setPlaceholder("Stopien");
         TextField sets = new TextField();
        sets.setPlaceholder("ECTS");

        HorizontalLayout horizontalTextFieldLayout = new HorizontalLayout();
        horizontalTextFieldLayout.addComponents(nazwa, opis, stopien, sets);
        
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
        grid.addColumn(Kierunek::getSets).setCaption("ECTS");

        VerticalLayout verticalLayout = new VerticalLayout();

        HorizontalLayout horizontallAddAndDeleteButtonLayout = new HorizontalLayout();
        horizontallAddAndDeleteButtonLayout.addComponents(addButton, updateButton, deleteButton);
        verticalLayout.addComponents(horizontalTextFieldLayout, horizontallAddAndDeleteButtonLayout, grid);
       
        setGridElements(grid, kierunekRepository.findAll());
        
      addButton.addClickListener(click -> {

            try {
                /**
                 * If values at textfield are > 0 which mean there is something more than null or ""
                 * There will be created a new Account class object which is filled with values of texfield.
                 * We use repository to add object to database as a entity.
                 */
                if (nazwa.getValue().length() > 0 && stopien.getValue().length() > 0 && sets.getValue().length() > 0) {

                    //We use repository to add object to database as a entity.
                    Kierunek Kierunek = new Kierunek(nazwa.getValue(), stopien.getValue(), opis.getValue(), sets.getValue());
                    kierunekRepository.save(Kierunek);
                    setGridElements(grid, kierunekRepository.findAll());
                } else {
                    Notification.show("Warning!", "Uzupełnij nazwa, stopien i ECTS", Notification.Type.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                Notification.show(e.getClass().getName(), e.getMessage(), Notification.Type.ERROR_MESSAGE);
                e.printStackTrace();
            }

        });
        deleteButton.addClickListener(click -> {
            try {
                if (grid.getSelectionModel().getFirstSelectedItem().isPresent()) {
                   kierunekRepository.deleteById(grid.getSelectionModel().getFirstSelectedItem().get().getKierunekId());
                    setGridElements(grid, kierunekRepository.findAll());
                    updateButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                    nazwa.setValue("");
                    stopien.setValue("");
                    opis.setValue("");
                    sets.setValue("");
                    
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
                stopien.setValue(selectedItem.getStopien());
                sets.setValue(selectedItem.getSets());
                

            });
        });
        updateButton.addClickListener(click -> {

            if (grid.getSelectionModel().getFirstSelectedItem().isPresent()) {
                Kierunek kierunek = kierunekRepository.findOneByKierunekId(grid.getSelectionModel().getFirstSelectedItem().get().getKierunekId());
                kierunek.setNazwa(nazwa.getValue());
                kierunek.setOpis(opis.getValue());
                kierunek.setStopien(stopien.getValue());
                kierunek.setSets(sets.getValue());
               

                kierunekRepository.save(kierunek);
                updateButton.setEnabled(false);
                deleteButton.setEnabled(false);
                setGridElements(grid, kierunekRepository.findAll());
                nazwa.setValue("");
                opis.setValue("");
                stopien.setValue("");
                sets.setValue("");
                
            } else {
                Notification.show("Something went wrong!");
            }

        });

        addComponent(verticalLayout);
    }



    private void setGridElements(Grid grid, List<Kierunek> kierunekList) {
        grid.setItems(kierunekList);
    }
}