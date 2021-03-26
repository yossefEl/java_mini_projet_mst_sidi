package com.mst.java.mini.projet.usf.elm.core.controllers;

import com.mst.java.mini.projet.usf.elm.core.models.Client;
import com.mst.java.mini.projet.usf.elm.core.views.AddClientView;
import com.mst.java.mini.projet.usf.elm.core.views.DashboardView;
import com.mst.java.mini.projet.usf.elm.core.views.ShowClientsView;
import com.mst.java.mini.projet.usf.elm.core.views.UpdateDeleteClientView;
import com.mst.java.mini.projet.usf.elm.helpers.DialogHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ClientController {
    private final AddClientView addClientView;
    private final UpdateDeleteClientView updateDeleteClientView;
    private final ShowClientsView showClientsView;
    private final DashboardView dashboardView;

    public ClientController(DashboardView view) {

        dashboardView = view;
        addClientView =dashboardView.getAddClientView();
        updateDeleteClientView = dashboardView.getUpdateDeleteClientView();
        showClientsView = dashboardView.getShowClientsView();

        addClientView.addClientActionListener(new ClientActionListener());
        updateDeleteClientView.addClientActionListener(new ClientActionListener());
        showClientsView.addClientActionListener(new ClientActionListener());


    }


    private class ClientActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (addClientView.getAddClientButton().equals(source)) {
                addClient();
            }

        }
    }

    /**
     * This method will be invoked only when the user clicks the [Ajouter] button in
     * the AddClient view
     * this method constructs a client instance from the information inputted
     * validates it and then if all information are valid
     * then it inserts it in the database
     */
    private void addClient() {
        final Client client = new Client(
                addClientView.getClientNumber(),
                addClientView.getClientFirstName(),
                addClientView.getClientLastName(),
                addClientView.getBirthday(),
                addClientView.getClientAddress()
        );

        System.out.println(client.toString());
        if(client.validate()){
            final int confirmation= DialogHelper.showConfirmationDialog(addClientView,
                    "Are you sure to save this client to the database?");
            if(confirmation==0){
                try {
                    client.create();
                    addClientView.showSuccessMessage();
                    addClientView.clearForm();

                } catch (SQLException | ClassNotFoundException exception) {
                    DialogHelper.showErrorMessage(
                            addClientView,
                            "Erreur est survenue",
                            "Un problème est survenu"+exception.getMessage()
                    );
                    exception.printStackTrace();
                }
            }
        }else{
            DialogHelper.showErrorMessage(
                    addClientView,
                    "Informations invalide",
                    "Veuillez saisir toutes les informations sur le client pour continuer!"

            );

        }
    }

}
