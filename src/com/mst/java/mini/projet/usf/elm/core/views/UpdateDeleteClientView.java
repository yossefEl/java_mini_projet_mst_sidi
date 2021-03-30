package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.views.components.*;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;
import com.mst.java.mini.projet.usf.elm.helpers.DateTimeHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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

    PrimaryButton updateClientButton;
    PrimaryButton deleteButton;
    PrimaryButton searchButton;

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
        dayBox = new JComboBox<>(DateTimeHelper.getDays());
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

        updateClientButton = new PrimaryButton("Modifier",
                new Rectangle(318, 286, 126, 35),
                AppColors.blueColor
        );
        deleteButton = new PrimaryButton("Supprimer",
                new Rectangle(184, 286, 126, 35),
                AppColors.redColor
        );
        searchButton = new PrimaryButton("Chercher",
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
        add(updateClientButton);
        add(deleteButton);
        add(searchButton);
        setVisible(true);

    }


    /**
     * adds an action listeners to the clickable elements in this view
     *
     * @param clientActionListener comes from the ClientController
     */
    public void addClientActionListener(ActionListener clientActionListener) {
        updateClientButton.addActionListener(clientActionListener);
        deleteButton.addActionListener(clientActionListener);
        searchButton.addActionListener(clientActionListener);
    }

    /**
     * Clears the fields
     */
    public void clearForm() {
        clientNumberField.setText(null);
        clientFirstNameField.setText(null);
        clientLastNameField.setText(null);
        clientNumberField.setText(null);
        dayBox.setSelectedIndex(0);
        monthBox.setSelectedIndex(0);
        yearBox.setSelectedIndex(0);
        clientAddressField.setText(null);


    }


    //getters and setters

    public PrimaryButton getUpdateClientButton() {
        return updateClientButton;
    }

    public PrimaryButton getDeleteButton() {
        return deleteButton;
    }

    public PrimaryButton getSearchButton() {
        return searchButton;
    }


    public String getClientNumber() {
        return clientNumberField.getText();
    }

    public String getClientFirstName() {
        return clientFirstNameField.getText();
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstNameField.setText(clientFirstName);
    }

    public String getClientLastName() {
        return clientLastNameField.getText();
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastNameField.setText(clientLastName);
    }

    public String getClientAddress() {
        return clientAddressField.getText();
    }

    /**
     * @return the composition of [day, month, year] combo boxes that the admin selected as
     * a date with the un
     */

    public String getBirthday() {
        //date format yyyy-MM-dd HH:mm:ss
        return yearBox.getSelectedItem() + "-" +
                (monthBox.getSelectedIndex() + 1) + "-" +
                dayBox.getSelectedItem() ;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumberField.setText(String.valueOf(clientNumber));
    }

    public void setClientBirthday(String fullBirthday) {

        if (fullBirthday != null) {
            final String[] birdayArray = fullBirthday.split("-");
            if (birdayArray.length >= 3) {
                dayBox.setSelectedItem(birdayArray[2]);
                monthBox.setSelectedIndex(Integer.parseInt(birdayArray[1]) - 1);
                yearBox.setSelectedItem(birdayArray[0]);
            }
        }
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddressField.setText(clientAddress);
    }


}


