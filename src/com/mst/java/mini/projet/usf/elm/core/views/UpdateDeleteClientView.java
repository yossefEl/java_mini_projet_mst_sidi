package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.views.components.*;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;
import com.mst.java.mini.projet.usf.elm.helpers.DateTimeHelper;

import javax.swing.*;
import java.awt.*;

public class UpdateDeleteClientView extends MainDashboardContentArea {


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
    CButton searchButton;

    public UpdateDeleteClientView() {
        buildView();
    }

    private void buildView() {
//        init component
        title = new DashAreaTitle(new Rectangle(185, 26, 350, 17), "Modifier/Supprimer un client");
        clientNumberLabel = new InputLabel("Numero",
                new Rectangle(50, 70, 53, 17)
        );
        clientNumberField = new InputField(new Rectangle(184, 60, 260, 35));

        clientFirstNameLabel = new InputLabel("Nom", new Rectangle(50, 113, 32, 17));
        clientFirstNameField = new InputField(new Rectangle(184, 104, 260, 35));

        clientLastNameLabel = new InputLabel("Prénom", new Rectangle(50, 157, 53, 17));
        clientLastNameField = new InputField(new Rectangle(184, 148, 260, 35));

        clientBirthdayLabel = new InputLabel("Date naissance", new Rectangle(50, 200, 103, 17));
        dayBox = new JComboBox<>(DateTimeHelper.getDays(1, 2012));
        dayBox.setBounds(184, 192, 68, 35);
        dayBox.setBackground(AppColors.lightGreyColor);
        monthBox = new JComboBox<>(DateTimeHelper.getMonths());
        monthBox.setBounds(250, 192, 105, 35);
        monthBox.setBackground(AppColors.lightGreyColor);
        yearBox = new JComboBox<>(DateTimeHelper.getYears());
        yearBox.setBounds(356, 192, 91, 35);
        yearBox.setBackground(AppColors.lightGreyColor);


        clientAddressLabel = new InputLabel("Adresse", new Rectangle(50, 244, 55, 17));
        clientAddressField = new InputField(new Rectangle(184, 236, 260, 35));

        addClientButton = new CButton("Modifier",
                new Rectangle(318, 286, 126, 35),
                AppColors.blueColor
        );
        cancelButton = new CButton("Supprimer",
                new Rectangle(184, 286, 126, 35),
                AppColors.redColor
        );
        searchButton = new CButton("Chercher",
                new Rectangle(461, 60, 126, 35),
                AppColors.orangeColor
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
        add(searchButton);
        setVisible(true);

    }
}
