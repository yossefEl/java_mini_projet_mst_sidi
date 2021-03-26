package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.views.components.*;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;
import com.mst.java.mini.projet.usf.elm.helpers.DateTimeHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class AddClientView extends MainDashboardContentArea {

    private InputLabel clientNumberLabel;
    private InputField clientNumberField;

    private InputLabel clientFirstNameLabel;
    private InputField clientFirstNameField;

    private InputLabel clientLastNameLabel;
    private InputField clientLastNameField;

    private InputLabel clientBirthdayLabel;
    private JComboBox<String> dayBox;
    private JComboBox<String> monthBox;
    private JComboBox<String> yearBox;

    private InputLabel clientAddressLabel;
    private InputField clientAddressField;

    private PrimaryButton addClientButton;
    private PrimaryButton cancelButton;

    private JLabel successMessage;

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
        dayBox = new JComboBox<>(DateTimeHelper.getDays());
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

        addClientButton = new PrimaryButton("Ajouter",
                new Rectangle(400, 286, 126, 35),
                AppColors.blueColor
        );
        cancelButton = new PrimaryButton("Annuler",
                new Rectangle(266, 286, 126, 35),
                AppColors.redColor
        );


         successMessage = new JLabel("Le client a été enregistré avec succès", SwingConstants.LEFT);
        successMessage.setForeground(Color.decode("#079f07"));
        successMessage.setBounds(cancelButton.getX(),
                addClientButton.getY() + 30,
                getWidth() - cancelButton.getX(),
                40);
        successMessage.setVisible(false);

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
        add(successMessage);
        setVisible(true);
    }

    /**
     * adds an action listener to catch admin actions [add and clear|cancel]
     *
     * @param clientActionListener the action listener of the client Controller
     */
    public void addClientActionListener(ActionListener clientActionListener) {
        addClientButton.addActionListener(clientActionListener);
        cancelButton.addActionListener(clientActionListener);

    }


    /**
     * clears the user inputs
     */
    public void clearForm() {
        clientNumberField.setText(null);
        clientFirstNameField.setText(null);
        clientLastNameField.setText(null);
        clientNumberField.setText(null);
        dayBox.setSelectedItem(null);
        monthBox.setSelectedItem(null);
        yearBox.setSelectedItem(null);
        clientAddressField.setText(null);


    }


    //getters

    public String getClientNumber() {
        return clientNumberField.getText();
    }

    public String getClientFirstName() {
        return clientFirstNameField.getText();
    }

    public String getClientLastName() {
        return clientLastNameField.getText();
    }

    public String getClientAddress() {
        return clientAddressField.getText();
    }

    /**
     * @return the composition of [day, month, year] combo boxes that the admin selected as
     * a date with the un
     */


    //getters
    public String getBirthday() {
        //date format yyyy-MM-dd HH:mm:ss
        return yearBox.getSelectedItem() + "-" +
                (monthBox.getSelectedIndex() + 1) + "-" +
                dayBox.getSelectedItem() +
                " 00:00:00";
    }

    public PrimaryButton getAddClientButton() {
        return addClientButton;
    }

    public PrimaryButton getCancelButton() {
        return cancelButton;
    }

    public void showSuccessMessage() {
        successMessage.setVisible(true);
        try {
            TimeUnit.SECONDS.sleep(1);
            successMessage.setVisible(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
