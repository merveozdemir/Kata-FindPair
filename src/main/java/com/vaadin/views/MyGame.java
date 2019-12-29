package com.vaadin.views;

import com.vaadin.components.MyButton;
import com.vaadin.components.MyHeader;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class MyGame extends VerticalLayout {
    private GridLayout myGrid;
    private MyHeader myHeader;
    private int rowSize;
    private int columnSize;
    private MyButton firstCurrentButton = null;
    private MyButton secondCurrentButton = null;
    private List<FontAwesome> iconList;
    Random rand = new Random();

    public MyGame(int columnSize, int rowSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        setMargin(true);

        createIconList();

        buildMyHeader();

        buildMyGridLayout();

        createMyButtons();
    }


    private List<FontAwesome> getIconList() {
        return iconList;
    }

    private void createIconList() {
        iconList = new ArrayList<>();
        int numberOfIcon = rowSize * columnSize / 2;
        FontAwesome[] fontList = FontAwesome.values();
        for (int i = 0; i < numberOfIcon; i++) {
            int iconIndex = rand.nextInt(100);
            iconList.add(fontList[iconIndex]);
            iconList.add(fontList[iconIndex]);
            fontList[iconIndex] = null;
        }

    }

    private void buildMyHeader() {
        myHeader = new MyHeader();
        addComponent(myHeader);

    }

    private void buildMyGridLayout() {
        myGrid = new GridLayout(columnSize, rowSize);
        myGrid.setSpacing(true);
        addComponent(myGrid);
        setComponentAlignment(myGrid, Alignment.MIDDLE_CENTER);
    }

    private void createMyButtons() {

        for (int j = 0; j < rowSize; j++) {
            for (int i = 0; i < columnSize; i++) {
                int finalI = i;
                int finalJ = j;

                MyButton myButton = new MyButton();
                setIconToButton(myButton);

                myButton.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        //    myButton.addStyleName(ValoTheme.BUTTON_DANGER);
                        myButton.setIcon((FontAwesome) myButton.getData());
                        getTwoButtons(myButton);

                    }
                });
                myGrid.addComponent(myButton, i, j);
            }
        }
    }


    private void setIconToButton(MyButton myButton) {
        int iconIndex;
        if (iconList.size() != 0) {
            iconIndex = rand.nextInt(iconList.size());
            FontAwesome icon = iconList.get(iconIndex);
            myButton.setData(icon);
            iconList.remove(iconIndex);
        }
    }

    private void getTwoButtons(MyButton myClickButton) {
        if (firstCurrentButton == null) {
            firstCurrentButton = myClickButton;
        } else if (firstCurrentButton != myClickButton) {
            secondCurrentButton = myClickButton;
            compareTwoButtons();
        }
    }

    private void compareTwoButtons() {
        if (firstCurrentButton.getData().equals(secondCurrentButton.getData())) {
            firstCurrentButton.setEnabled(false);
            secondCurrentButton.setEnabled(false);
        } else {
            this.firstCurrentButton.setIcon(null);
            this.secondCurrentButton.setIcon(null);
        }

        firstCurrentButton = null;
        secondCurrentButton = null;


    }


}





