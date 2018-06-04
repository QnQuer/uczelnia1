package com.example.demo.views;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;

@SpringView
public class DefaultView extends Composite implements View {

    public DefaultView(){
        setCompositionRoot(new Label("This is default view"));
    }
}
