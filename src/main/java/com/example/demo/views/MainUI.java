package com.example.demo.views;


import com.example.demo.repository.KierunekRepository;
import com.example.demo.repository.PrzedmiotRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.WykladowcaRepository;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Vaadin main view component.
 * From this class we can switch view.
 */
@SpringUI
@Component
public class MainUI extends UI {


  /*  @Autowired
    KierunekRepository kierunekRepository;
    @Autowired
    PrzedmiotRepository przedmiotRepository;*/
    @Autowired
    StudentRepository StudentRepository;
   /* @Autowired
    WykladowcaRepository wykladowcaRepository;*/

    /**
     * init is constructor like method which is called when we go to the main site (fe. localhost:8080).
     * There is initialization of menu objects etc.
     * @param vaadinRequest
     */
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Button title = new Button("Menu");
        Button title2 = new Button("Menu");
        title2.addStyleNames(ValoTheme.MENU_TITLE);
        //title2.addStyleName(ValoTheme.MENU_ROOT);
        title2.addStyleName(ValoTheme.MENU_APPEAR_ON_HOVER);
        title2.addStyleName(ValoTheme.UI_WITH_MENU);
        //title2.addStyleNames(ValoTheme.BUTTON_BORDERLESS);

        title.addStyleName(ValoTheme.MENU_TITLE);

        /**
         * Buttons in menu on left side of site.
         */
        Button buttonView1 = new Button("Account View", e -> getNavigator().navigateTo("AccountView"));
        buttonView1.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button buttonView2 = new Button("Author View",  e -> getNavigator().navigateTo("AuthorView"));
        buttonView2.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button buttonView3 = new Button("Book View",  e -> getNavigator().navigateTo("BookView"));
        buttonView3.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        Button buttonView4 = new Button("Rent View",  e -> getNavigator().navigateTo("RentView"));
        buttonView4.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);

        CssLayout menu = new CssLayout(title, buttonView1, buttonView2, buttonView3, buttonView4);
        menu.addStyleName(ValoTheme.MENU_ROOT);
        menu.addStyleName(ValoTheme.MENU_APPEAR_ON_HOVER);
        menu.setSizeFull();
        menu.addStyleName(ValoTheme.UI_WITH_MENU);

        CssLayout viewContainer = new CssLayout();

        HorizontalLayout mainLayout = new HorizontalLayout(menu, viewContainer);
        mainLayout.setWidthUndefined();
        mainLayout.setHeight("100%");

        HorizontalLayout mainLayout2 = new HorizontalLayout(title2);
        mainLayout2.setWidthUndefined();

        title.addClickListener(click -> {
            if(menu.isVisible()) {
                menu.setVisible(false);
                mainLayout.replaceComponent(menu, mainLayout2);
                mainLayout2.setVisible(true);
            }
        });

        title2.addClickListener(click -> {
            if(!menu.isVisible()) {
                menu.setVisible(true);
                mainLayout.replaceComponent(mainLayout2, menu);
                mainLayout2.setVisible(false);
            }
        });

        setContent(mainLayout);
        this.setSizeFull();

        /**
         * Navigator which is used to switch view.
         * Simple, we point view and class which we want to initialize this view.
         */
        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addView("", DefaultView.class);
        navigator.addView("AccountView", new StudentView(StudentRepository));
     /*   navigator.addView("AuthorView", new KierunekView(kierunekRepository));
        navigator.addView("BookView", new PrzedmiotView(przedmiotRepository/* authorsRepository*///));
      //  navigator.addView("RentView", new WykladowcaView(/*booksRepository, accountsRepository, rentRepository*/wykladowcaRepository));
    }
}
