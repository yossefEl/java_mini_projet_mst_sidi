package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.controllers.SidebarController;
import com.mst.java.mini.projet.usf.elm.core.views.components.MainDashboardContentArea;
import com.mst.java.mini.projet.usf.elm.core.views.components.Sidebar;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DashboardView extends JPanel {
    private ArrayList<MainDashboardContentArea> contentAreaItems;
    private Sidebar sidebar;
    private final SidebarController sidebarController;
    private AddClientView addClientView;
    private UpdateDeleteClientView updateDeleteClientView;
    private ShowClientsView showClientsView;
    private HomeView homeView;

    public DashboardView(AddClientView addClientView,
                         UpdateDeleteClientView updateDeleteClientView,
                         ShowClientsView showClientsView,
                         SidebarController sidebarController) {
//        inits the children
        this.addClientView = addClientView;
        this.updateDeleteClientView = updateDeleteClientView;
        this.showClientsView = showClientsView;
        //init sidebar controller
        this.sidebarController = sidebarController;
        buildView();
    }


    private void buildView() {


        //init view
        setLayout(null);
        setBackground(AppColors.whiteColor);

        //init components
        sidebar = new Sidebar();
        contentAreaItems = new ArrayList<>(Arrays.asList(
                addClientView, updateDeleteClientView, showClientsView
        ));

        //composing the view
        add(sidebar);
        add(addClientView);
        sidebarController.initialize(this);

        setSize(819, 512);
        setVisible(true);


    }





    //getters //setters

    public Sidebar getSidebar() {
        return sidebar;
    }

    public ArrayList<MainDashboardContentArea> getContentAreaItems() {
        return contentAreaItems;
    }

    public AddClientView getAddClientView() {
        return addClientView;
    }

    public void setAddClientView(AddClientView addClientView) {
        this.addClientView = addClientView;
    }

    public UpdateDeleteClientView getUpdateDeleteClientView() {
        return updateDeleteClientView;
    }

    public void setUpdateDeleteClientView(UpdateDeleteClientView updateDeleteClientView) {
        this.updateDeleteClientView = updateDeleteClientView;
    }

    public ShowClientsView getShowClientsView() {
        return showClientsView;
    }

    public void setShowClientsView(ShowClientsView showClientsView) {
        this.showClientsView = showClientsView;
    }

    public HomeView getHomeView() {
        return homeView;
    }

    public void setHomeView(HomeView homeView) {
        this.homeView = homeView;
    }


}
