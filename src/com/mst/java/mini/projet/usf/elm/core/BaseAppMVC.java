package com.mst.java.mini.projet.usf.elm.core;

import com.mst.java.mini.projet.usf.elm.core.controllers.AuthController;
import com.mst.java.mini.projet.usf.elm.core.controllers.ClientController;
import com.mst.java.mini.projet.usf.elm.core.controllers.DBConfigController;
import com.mst.java.mini.projet.usf.elm.core.controllers.SidebarController;
import com.mst.java.mini.projet.usf.elm.core.views.*;
import com.mst.java.mini.projet.usf.elm.helpers.DBHelper;
import com.mst.java.mini.projet.usf.elm.helpers.DialogHelper;

import java.sql.SQLException;

/**
 * Assembles all the controllers and views together
 * This is the entry point to the application
 */
public class BaseAppMVC {
    // //************* Home ************* //
    private final HomeView homeView;


    // //************* Database  ************* //
    private final ConfigureDatabaseView configureDatabaseView;
    private final DBHelper dbHelper;
    //************* Authentication ************* //
    private final LoginView loginView;
    private final AuthController authController;
    private final DashboardView dashboardView;
    private DBConfigController dbConfigController;
    //************* Client CRUD (Create | Read | Update | Delete) ************* //
    private ClientController clientController;
    //dashboard items
    private AddClientView addClientView;
    private UpdateDeleteClientView updateDeleteClientView;
    private ShowClientsView showClientsView;
    private SidebarController sidebarController;


    public BaseAppMVC() {
        //************* Client CRUD (Create | Read | Update | Delete) ************* //
        addClientView = new AddClientView();
        updateDeleteClientView = new UpdateDeleteClientView();
        showClientsView = new ShowClientsView();
        sidebarController = new SidebarController();
        dashboardView = new DashboardView(
                addClientView,
                updateDeleteClientView,
                showClientsView,
                sidebarController);
        clientController = new ClientController(dashboardView);


        //************* Authentication ************* //
        loginView = new LoginView();
        authController = new AuthController(loginView);
        // //************* Database  ************* //

        configureDatabaseView = new ConfigureDatabaseView();
        dbConfigController = new DBConfigController(configureDatabaseView);


        // //************* Home ************* //
        homeView = new HomeView(dashboardView, loginView, configureDatabaseView);

        //Controller set home view

        authController.setHomeView(homeView);
        dbConfigController.setHomeView(homeView);

        //creating a database helper instance
        dbHelper = new DBHelper();

    }


    /**
     * Starts the app and decides which view to show, it shows :
     * Configuration view: if the database configurations not set or not valid
     * else: it shows:
     * Login view if the Admin is not authenticated
     * otherwise it pushes the Dashboard View to the front
     */
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
