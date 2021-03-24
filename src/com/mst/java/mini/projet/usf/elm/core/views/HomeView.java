package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.controllers.AuthController;
import com.mst.java.mini.projet.usf.elm.helpers.DBHelper;
import com.mst.java.mini.projet.usf.elm.helpers.DialogHelper;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class HomeView extends JFrame {

    public DBHelper databaseController;
    public AuthController authController;
    ArrayList<JPanel> items;
    public DashboardView dashboardView;
    public LoginView loginView;
    public ConfigureDatabaseView configureDatabaseView;


    public HomeView() {
        super();

        dashboardView = new DashboardView();
        loginView = new LoginView();
        configureDatabaseView = new ConfigureDatabaseView();
        items = new ArrayList<>(Arrays.asList(dashboardView, loginView, configureDatabaseView));
        addAllItems();












































































        authController = new AuthController();
        buildView();

    }


    private void buildView() {
        try {
            if (databaseController.isDatabaseConfigured()) {
                if (!authController.isAuthenticated()) {
                    showContent(dashboardView);
                } else {
                    showContent(loginView);
                }
            } else {
                showContent(configureDatabaseView);
            }
        } catch (SQLException | ClassNotFoundException exception) {
            DialogHelper.showErrorMessage(this,exception.getMessage());
        }
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(819, 512);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void addAllItems() {
        for (JPanel item : items
        ) {
            item.setVisible(false);
            add(item);
        }
    }

    public void showContent(JPanel view) {
        for (JPanel item : items
        ) {
            item.setVisible(view == item);
            System.out.println(view.isVisible());
            repaint();
        }
    }


}
