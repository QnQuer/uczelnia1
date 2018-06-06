/***/
package com.example.demo.views;

import com.example.demo.repository.PrzedmiotRepository;
import com.example.demo.model.Przedmiot;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


    @SpringUI
public class PrzedmiotView extends HorizontalLayout implements View{
    private final PrzedmiotRepository przedmiotRepository;
    public Przedmiot updateObject;


    
    @Autowired
    public PrzedmiotView(PrzedmiotRepository przedmiotRepository) {


        //TODO: https://vaadin.com/docs/v8/framework/components/components-menubar.html

        this.przedmiotRepository = przedmiotRepository;

        /**
         * We can find here objects wich are visible on site. Buttons etc.
         */
        TextField przedmiotId = new TextField();
        przedmiotId.setPlaceholder("ID Przedmiotu");
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
        horizontalTextFieldLayout.addComponents(przedmiotId, nazwa, opis, rodzaj, ects, Wykladowca, kierunek, studenci);

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
        grid.addColumn(Przedmiot::getWykladowca).setCaption("Wykladowca");
        grid.addColumn(Przedmiot::getKierunek).setCaption("Kierunek");
      
        

      VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontallAddAndDeleteButtonLayout = new HorizontalLayout();
        horizontallAddAndDeleteButtonLayout.addComponents(addButton, updateButton, deleteButton);
        verticalLayout.addComponents(horizontalTextFieldLayout, horizontallAddAndDeleteButtonLayout, grid);

       // setGridElements(grid, przedmiotRepository.findAll());

        /**
         * Example of listener on button.
         * Listener is a mechanism which listen events. If listener detect event, (in this example there is click event)
         * he will execute some code
         */
   /*  addButton.addClickListener((<any> click) -> {

            try {
                /**
                 * If values at textfield are > 0 which mean there is something more than null or ""
                 * There will be created a new Account class object which is filled with values of texfield.
                 * We use repository to add object to database as a entity.
                
               if (przedmiot_id.getValue().length() > 0 && nazwa.getValue().length() > 0 && opis.getValue().length() > 0 && rodzaj.getValue().length() > 0
                        && ects.getValue().length() > 0 && Wykladowca.getValue().length() > 0 && kierunek.getValue().length() > 0 && studenci.getValue().length() > 0) {

                    //We use repository to add object to database as a entity.
                    Przedmiot przedmiot = new Przedmiot(przedmiot_id.getValue(), nazwa.getValue(), opis.getValue(), rodzaj.getValue(), ects.getValue(), Wykladowca.getValue(), kierunek.getValue(), studenci.getValue());
                    PrzedmiotRepository.save(przedmiot);
                    setGridElements(grid, przedmiotRepository.findAll());
                } else {
                    Notification.show("Warning!", "You need fill all fields!", Notification.Type.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                Notification.show(e.getClass().getName(), e.getMessage(), Notification.Type.ERROR_MESSAGE);
            }
        });

        deleteButton.addClickListener((<any> click) -> {
            try {
                if (grid.getSelectionModel().getFirstSelectedItem().isPresent()) {
                    przedmiotRepository.deleteById(grid.getSelectionModel().getFirstSelectedItem().get().getId());
                    setGridElements(grid, przedmiotRepository.findAll());
                    updateButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                    przedmiot_id.setValue("");
                    nazwa.setValue("");
                    opis.setValue("");
                    rodzaj.setValue("");
                    ects.setValue("");
                    Wykladowca.setValue("");
                    kierunek.setValue("");
                    studenci.setValue("");
                    
                } else {
                    Notification.show("Warning!", "You need select element from table!", Notification.Type.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                Notification.show(e.getClass().getName(), e.getMessage(), Notification.Type.ERROR_MESSAGE);
            }
        });

        grid.addSelectionListener(item -> {
            item.getFirstSelectedItem().ifPresent( selectedItem -> {
                    updateButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                    przedmiot_id.setValue(selectedItem.getPrzedmiot_id());
                    nazwa.setValue(selectedItem.getNazwa());
                    opis.setValue(selectedItem.getOpis());
                    rodzaj.setValue(selectedItem.getRodzaj());
                    ects.setValue(selectedItem.getEcts());
                    Wykladowca.setValue(selectedItem.getWykladowca());
                    kierunek.setValue(selectedItem.getKierunek());
                    studenci.setValue(selectedItem.getStudenci());

            });
        });

        updateButton.addClickListener((<any> click) -> {

            if (grid.getSelectionModel().getFirstSelectedItem().isPresent()) {
                Przedmiot przedmiot = przedmiotRepository.findOneById(grid.getSelectionModel().getFirstSelectedItem().get().getId());
                przedmiot.setprzedmiot_id(przedmiot.getValue());
                przedmiot.setNazwa(nazwa.getValue());
                przedmiot.setOpis(opis.getValue());
                przedmiot.setRodzaj(rodzaj.getValue());
                przedmiot.setEcts(ects.getValue());
                przedmiot.setWykladowca(Wykladowca.getValue());
                przedmiot.setKierunek(kierunek.getValue());
                przedmiot.setStudenci(studenci.getValue());
                przedmiotRepository.save(przedmiot);
                updateButton.setEnabled(false);
                deleteButton.setEnabled(false);
                setGridElements(grid, przedmiotRepository.findAll());
                przedmiot_id.setValue("");
                nazwa.setValue("");
                opis.setValue("");
                rodzaj.setValue("");
                ects.setValue("");
                Wykladowca.setValue("");
                kierunek.setValue("");
                studenci.setValue("");
            } else {
                Notification.show("Something went wrong!");
            }

        });

        addComponent(verticalLayout);
        //HorizontalLayout horizontalLayout = new HorizontalLayout();
        //horizontalLayout.addComponents();

        //setComponentAlignment(verticalLayout, Alignment.TOP_LEFT);
    }*/

    public void setGridElements(Grid grid, List<Przedmiot> przedmiotList) {
        grid.setItems(przedmiotList);
    }

@Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {
      Notification.show("Welcome to the Animal Farm");
 
