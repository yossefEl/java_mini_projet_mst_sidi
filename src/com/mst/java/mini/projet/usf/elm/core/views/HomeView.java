package com.mst.java.mini.projet.usf.elm.core.views;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class HomeView extends JFrame {

    ArrayList<JPanel> items;
    private DashboardView dashboardView;
    private LoginView loginView;
    private ConfigureDatabaseView configureDatabaseView;


    public HomeView(DashboardView dashboardView,
                    LoginView loginView,
                    ConfigureDatabaseView configureDatabaseView) {
        System.out.println("home initialized");
        this.dashboardView = dashboardView;
        this.loginView = loginView;
        this.configureDatabaseView = configureDatabaseView;
        items = new ArrayList<>(Arrays.asList(dashboardView, loginView, configureDatabaseView));
        addAllItems();
        buildView();

    }


    private void buildView() {
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
//            System.out.println(view.isVisible());
            repaint();
        }
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public DashboardView getDashboardView() {
        return dashboardView;
    }

    public ConfigureDatabaseView getConfigureDatabaseView() {
        return configureDatabaseView;
    }
}
