package com.example.demo.views;

import com.example.demo.repository.StudentRepository;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class Test extends HorizontalLayout implements View {

    @Autowired
    public Test() {

        Button b = new Button("Test");
        this.addComponent(b);
    }
}
