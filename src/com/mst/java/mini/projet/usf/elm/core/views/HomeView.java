package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.controllers.SidebarController;
import com.mst.java.mini.projet.usf.elm.core.views.components.MainDashboardContentArea;
import com.mst.java.mini.projet.usf.elm.core.views.components.Sidebar;
import com.mst.java.mini.projet.usf.elm.core.views.components.SidebarItem;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class HomeView extends JFrame  {
    public Sidebar sidebar;
    public SidebarController sidebarController;
    public final ArrayList<MainDashboardContentArea> contentAreaItems = new ArrayList<>(
            Arrays.asList(new AddClientView(),
                    new UpdateDeleteClientView(),
                    new ShowClientsView(),
                    new UpdateDatabaseConfigView()
            )
    );

    public HomeView() {
        buildView();

    }

    private void buildView() {

        //init sidebar controller
        sidebarController = new SidebarController();

        //init view
        setLayout(null);
        setBackground(AppColors.whiteColor);
        //init components
        sidebar = new Sidebar();

        //composing the view
        add(sidebar);
        setLocationRelativeTo(null);
        setSize(819, 512);
        setVisible(true);


        sidebarController.initialize(this);

    }





}
