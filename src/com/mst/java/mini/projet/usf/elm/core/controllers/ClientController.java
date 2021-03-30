package com.mst.java.mini.projet.usf.elm.core.controllers;

import com.mst.java.mini.projet.usf.elm.core.models.Client;
import com.mst.java.mini.projet.usf.elm.core.views.AddClientView;
import com.mst.java.mini.projet.usf.elm.core.views.DashboardView;
import com.mst.java.mini.projet.usf.elm.core.views.ShowClientsView;
import com.mst.java.mini.projet.usf.elm.core.views.UpdateDeleteClientView;
import com.mst.java.mini.projet.usf.elm.helpers.DialogHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientController {
    private final AddClientView addClientView;
    private final UpdateDeleteClientView updateDeleteClientView;
    private final ShowClientsView showClientsView;
    private final DashboardView dashboardView;

    public ClientController(DashboardView view) {

        dashboardView = view;
        addClientView = dashboardView.getAddClientView();
        updateDeleteClientView = dashboardView.getUpdateDeleteClientView();
        showClientsView = dashboardView.getShowClientsView();
        showClientsView.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent e) {
                loadClientsIntoTable();
            }
        });

        addClientView.addClientActionListener(new ClientActionListener());
        updateDeleteClientView.addClientActionListener(new ClientActionListener());
        showClientsView.addClientActionListener(new ClientActionListener());


    }


    /**
     * @param str the string to check
     * @return return true if the input is a set of digits else it returns false
     */
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
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

        if(!isNumeric(addClientView.getClientNumber())){
            DialogHelper.showErrorMessage(
                    addClientView,
                    "Identifiant incorrect",
                    "L'identifiant doit être un entier!"

            );
            return;
        }


        final Client client = new Client(
                Integer.parseInt(addClientView.getClientNumber()),
                addClientView.getClientFirstName(),
                addClientView.getClientLastName(),
                addClientView.getBirthday(),
                addClientView.getClientAddress()
        );


        if (client.validate()) {
            if (!client.existInDatabase()) {
                final int confirmation = DialogHelper.showConfirmationDialog(addClientView,
                        "Êtes-vous sûr d'enregistrer ce client dans la base de données?");
                if (confirmation == 0) {
                    try {
                        client.create();
                        addClientView.showSuccessMessage();
                        addClientView.clearForm();

                    } catch (SQLException | ClassNotFoundException exception) {
                        DialogHelper.showErrorMessage(
                                addClientView,
                                "Erreur est survenue",
                                "Un problème est survenu" + exception.getMessage()
                        );
                        exception.printStackTrace();
                    }
                }
            } else {
                DialogHelper.showErrorMessage(
                        addClientView,
                        "Existe déjà",
                        "Un client avec l'identifiant que vous avez entré existe déjà dans la base de données, veuillez changer l'identifiant"

                );
            }
        } else {
            DialogHelper.showErrorMessage(
                    addClientView,
                    "Informations invalide",
                    "Veuillez saisir toutes les informations sur le client pour continuer!"

            );

        }
    }


    /**
     * Searches the user in the database using his identifier (Number)
     */
    public void searchUserByID() {

        if (Client.isBlankOrNull(updateDeleteClientView.getClientNumber())) {
            DialogHelper.showErrorMessage(updateDeleteClientView, "L'identifiant n'est pas spécifié", "Veuillez saisir l'identifiant d'un client et réessayer");
            return;
        }

        if(!isNumeric(updateDeleteClientView.getClientNumber())){
            DialogHelper.showErrorMessage(
                    updateDeleteClientView,
                    "Identifiant incorrect",
                    "L'identifiant doit être un entier!"

            );
            return;
        }
        final int clientID = Integer.parseInt(updateDeleteClientView.getClientNumber());
        Client client = new Client();
        client.setId(clientID);

            try {
                if (client.existInDatabase()) {
                    client.get();
                    updateDeleteClientView.setClientNumber(client.getId());
                    updateDeleteClientView.setClientFirstName(client.getFirstName());
                    updateDeleteClientView.setClientLastName(client.getLastName());
                    updateDeleteClientView.setClientBirthday(client.getBirthday());
                    updateDeleteClientView.setClientAddress(client.getAddress());
                } else {
                    JOptionPane.showMessageDialog(updateDeleteClientView, "Il n'existe aucun client avec l'identifiant entré!", "Client inexiste", JOptionPane.INFORMATION_MESSAGE);

                }

            } catch (Exception exception) {
                DialogHelper.showErrorMessage(updateDeleteClientView, "Oups, quelque chose s'est mal passé:\n" + exception.getMessage());
            }



    }


    /**
     * updates the client information based on what the user entered
     * if any error occurred, this will catch it and show it
     */
    private void updateClient() {
        if(!isNumeric(updateDeleteClientView.getClientNumber())){
            DialogHelper.showErrorMessage(
                    updateDeleteClientView,
                    "Identifiant incorrect",
                    "L'identifiant doit être un entier!"

            );
            return;
        }
        final Client client = new Client(
                Integer.parseInt(updateDeleteClientView.getClientNumber()),
                updateDeleteClientView.getClientFirstName(),
                updateDeleteClientView.getClientLastName(),
                updateDeleteClientView.getBirthday(),
                updateDeleteClientView.getClientAddress()
        );


        if (client.existInDatabase()) {
            if (client.validate()) {

                final int confirmation = DialogHelper.showConfirmationDialog(updateDeleteClientView,
                        "Êtes-vous sûr de modifier ce client dans la base de données?");
                if (confirmation == 0) {
                    try {
                        client.update();

                        updateDeleteClientView.clearForm();
                        JLabel successMessage = new JLabel("Le client a été mis à jour avec succès", SwingConstants.LEFT);
                        successMessage.setVisible(true);
                        JOptionPane.showMessageDialog(updateDeleteClientView,successMessage,"Succès",JOptionPane.PLAIN_MESSAGE);


                    } catch (SQLException exception) {
                        DialogHelper.showErrorMessage(
                                updateDeleteClientView,
                                "Erreur est survenue",
                                "Un problème est survenu" + exception.getMessage()
                        );
                        exception.printStackTrace();
                    }
                }

            } else {
                DialogHelper.showErrorMessage(
                        updateDeleteClientView,
                        "Informations invalide",
                        "Veuillez saisir toutes les informations sur le client pour continuer!"

                );

            }
        } else {
            DialogHelper.showErrorMessage(
                    updateDeleteClientView,
                    "Client n'existe pas",
                    "Veuillez vous assurer que vous avez sélectionné un identifiant client approprié et réessayer"

            );

        }
    }


    /**
     * This method deletes the user from the database
     */
    private void deleteClient() {
        if(!isNumeric(updateDeleteClientView.getClientNumber())){
            DialogHelper.showErrorMessage(
                    updateDeleteClientView,
                    "Identifiant incorrect",
                    "L'identifiant doit être un entier!"

            );
            return;
        }
        final int confirmValue = DialogHelper.showConfirmationDialog(
                updateDeleteClientView,
                "Êtes-vous sûr de vouloir supprimer ce client?"
        );
        if (confirmValue == 0) {
            final Client client = new Client();
            client.setId(Integer.parseInt(updateDeleteClientView.getClientNumber()));
            try {

                client.delete();
                updateDeleteClientView.clearForm();
                JOptionPane.showMessageDialog(
                        updateDeleteClientView,
                        "le client a bien été supprimé!",
                        "Suppression du client",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (SQLException exception) {
                DialogHelper.showErrorMessage(
                        updateDeleteClientView,
                        "Erreur est survenue",
                        "Un problème est survenu:\n" + exception.getMessage()
                );
            }
        }

    }


    /**
     * this clears all the data entered in the add client view after
     * user confirmation
     */
    private void clearAddClientViewForm() {
        final int confirmValue = DialogHelper.showConfirmationDialog(
                addClientView,
                "Vous perdrez toutes les données que \nvous avez saisies, êtes-vous sûr de continuer?"
        );
        if (confirmValue == 0) {
            addClientView.clearForm();
        }
    }


    private void loadClientsIntoTable() {

        try {
            ArrayList<Client> clients = Client.all();
            DefaultTableModel tableModel = showClientsView.getTableModel();
            tableModel.setRowCount(0);
            showClientsView.getTable().setRowSorter(null);
            tableModel.fireTableDataChanged();

            for (Client client : clients
            ) {
                tableModel.addRow(new Object[]{
                        client.getId(),
                        client.getFirstName(),
                        client.getLastName(),
                        client.getBirthday(),
                        client.getAddress()});
            }


        } catch (SQLException exception) {
            DialogHelper.showErrorMessage(
                    updateDeleteClientView,
                    "Erreur est survenue",
                    "Un problème est survenu:\n" + exception.getMessage()
            );
        }

    }

    /**
     * sort the table based on the column selected [Num,Nom,Date Naissance]
     *
     * @param columnIndex the column index of the table in the ShowCLientsView
     */
    private void sortClientsListBy(int columnIndex) {
        final JTable table = showClientsView.getTable();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(showClientsView.getTableModel());
        // Classify
        table.setRowSorter(sorter);
        java.util.List<RowSorter.SortKey> sortList = new ArrayList<>();
        sortList.add(new RowSorter.SortKey(columnIndex, SortOrder.ASCENDING));
        sorter.setSortKeys(sortList);
    }

    /**
     * The action listener for the Client CRUD views
     */
    private class ClientActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            ///
            if (addClientView.getAddClientButton().equals(source)) {
                addClient();
            } else if (addClientView.getCancelButton().equals(source)) {
                clearAddClientViewForm();
            } else if (updateDeleteClientView.getSearchButton().equals(source)) {
                searchUserByID();
            } else if (updateDeleteClientView.getUpdateClientButton().equals(source)) {
                updateClient();
            } else if (updateDeleteClientView.getDeleteButton().equals(source)) {
                deleteClient();
            } else if (showClientsView.getRefreshClientsListButton().equals(source)) {
                showClientsView.getSortClientsCheckGroup().clearSelection();
                loadClientsIntoTable();
            } else if (showClientsView.getSortByID().equals(source)) {
            //the index of the Column 'Numero' in the table is 0
                sortClientsListBy(0);
            } else if (showClientsView.getSortByName().equals(source)) {
                //the index of the Column 'Numero' in the table is 1
                sortClientsListBy(1);
            } else if (showClientsView.getSortByBirthday().equals(source)) {
                //the index of the Column 'Date Naissane' in the table is 3
                sortClientsListBy(3);
            }


        }
    }





}
