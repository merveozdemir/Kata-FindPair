package com.vaadin.components;

import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;


public class MyHeader extends Label {

    public MyHeader() {
        setValue("FIND PAIR");
        addStyleName(ValoTheme.LABEL_H2);
        addStyleName(ValoTheme.LABEL_COLORED);
        addStyleName(ValoTheme.TEXTAREA_ALIGN_CENTER);
    }
}
