package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.views.components.*;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;
import com.mst.java.mini.projet.usf.elm.helpers.DateTimeHelper;

import javax.swing.*;
import java.awt.Rectangle;

public class AddClientView extends MainDashboardContentArea {

    InputLabel clientNumberLabel;
    InputField clientNumberField;

    InputLabel clientFirstNameLabel;
    InputField clientFirstNameField;

    InputLabel clientLastNameLabel;
    InputField clientLastNameField;

    InputLabel clientBirthdayLabel;
    JComboBox<String> dayBox;
    JComboBox<String> monthBox;
    JComboBox<String> yearBox;

    InputLabel clientAddressLabel;
    InputField clientAddressField;

    CButton addClientButton;
    CButton cancelButton;

    public AddClientView() {
        buildView();
    }

    private void buildView() {

        //init components
        title = new DashAreaTitle(new Rectangle(236, 26, 200, 20), "Ajouter un client");
        clientNumberLabel = new InputLabel("Numero",
                new Rectangle(111, 70, 53, 17)
        );
        clientNumberField = new InputField(new Rectangle(266, 60, 260, 35));

        clientFirstNameLabel = new InputLabel("Nom", new Rectangle(111, 113, 32, 17));
        clientFirstNameField = new InputField(new Rectangle(266, 104, 260, 35));

        clientLastNameLabel = new InputLabel("Prénom", new Rectangle(111, 157, 53, 17));
        clientLastNameField = new InputField(new Rectangle(266, 148, 260, 35));

        clientBirthdayLabel = new InputLabel("Date naissance", new Rectangle(111, 200, 103, 17));
        dayBox = new JComboBox<>(DateTimeHelper.getDays(1, 2012));
        dayBox.setBounds(266, 192, 68, 35);
        dayBox.setBackground(AppColors.lightGreyColor);
        monthBox = new JComboBox<>(DateTimeHelper.getMonths());
        monthBox.setBounds(332, 192, 105, 35);
        monthBox.setBackground(AppColors.lightGreyColor);
        yearBox = new JComboBox<>(DateTimeHelper.getYears());
        yearBox.setBounds(435, 192, 91, 35);
        yearBox.setBackground(AppColors.lightGreyColor);


        clientAddressLabel = new InputLabel("Adresse", new Rectangle(111, 244, 55, 17));
        clientAddressField = new InputField(new Rectangle(266, 236, 260, 35));

        addClientButton = new CButton("Ajouter",
                new Rectangle(400, 286, 126, 35),
                AppColors.blueColor
        );
        cancelButton = new CButton("Annuler",
                new Rectangle(266, 286, 126, 35),
                AppColors.redColor
        );

//        composing the view
        add(title);
        add(clientNumberLabel);
        add(clientNumberField);
        add(clientFirstNameLabel);
        add(clientFirstNameField);
        add(clientLastNameLabel);
        add(clientLastNameField);
        add(clientBirthdayLabel);
        add(dayBox);
        add(monthBox);
        add(yearBox);
        add(clientAddressLabel);
        add(clientAddressField);
        add(addClientButton);
        add(cancelButton);
        setVisible(true);
    }
}
