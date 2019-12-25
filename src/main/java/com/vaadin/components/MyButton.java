package com.vaadin.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Random;

public class MyButton extends Button {

    public MyButton() {
        super();

        this.setWidth("100px");
        this.setHeight("100px");
        this.addStyleName(ValoTheme.BUTTON_PRIMARY);

    }

}
