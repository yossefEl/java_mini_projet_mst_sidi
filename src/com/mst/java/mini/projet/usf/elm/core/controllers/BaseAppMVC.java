package com.mst.java.mini.projet.usf.elm.core.controllers;

import com.mst.java.mini.projet.usf.elm.core.views.*;
import com.mst.java.mini.projet.usf.elm.helpers.DBHelper;
import com.mst.java.mini.projet.usf.elm.helpers.DialogHelper;

import java.sql.SQLException;

public class BaseAppMVC {
    // //************* Home ************* //
    private final HomeView homeView;


    // //************* Database  ************* //
    private final ConfigureDatabaseView configureDatabaseView;
    private final DBHelper dbHelper;


    //************* Authentication ************* //
    private final LoginView loginView;
    private final AuthController authController;


    //************* Client CRUD (Create | Read | Update | Delete) ************* //
    private ClientController clientController;
    private final DashboardView dashboardView;
    //dashboard items
    private AddClientView addClientView;
    private UpdateDeleteClientView updateDeleteClientView;
    private ShowClientsView showClientsView;


    public BaseAppMVC() {
        //************* Client CRUD (Create | Read | Update | Delete) ************* //
        addClientView = new AddClientView();
        updateDeleteClientView = new UpdateDeleteClientView();
        showClientsView = new ShowClientsView();
        dashboardView = new DashboardView(addClientView, updateDeleteClientView, showClientsView);
        clientController = new ClientController(dashboardView);

        //************* Authentication ************* //
        loginView = new LoginView();
        authController = new AuthController(loginView);
        // //************* Database  ************* //

        configureDatabaseView = new ConfigureDatabaseView();


        // //************* Home ************* //
        homeView = new HomeView(dashboardView, loginView, configureDatabaseView);

        //

        authController.setHomeView(homeView);

        //creating a database helper instance
        dbHelper = new DBHelper();

    }


    public void start() {
        try {
            if (dbHelper.isDatabaseConfigured()) {
                if (authController.getAdmin().isLogged()) {
                    homeView.showContent(dashboardView);
                } else {
                    homeView.showContent(loginView);
                }
            } else {
                homeView.showContent(configureDatabaseView);
            }
        } catch (SQLException | ClassNotFoundException exception) {
            DialogHelper.showErrorMessage(homeView, exception.getMessage());
        }
    }
}
