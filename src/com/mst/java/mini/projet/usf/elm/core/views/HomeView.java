package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.views.components.MainDashboardContentArea;
import com.mst.java.mini.projet.usf.elm.core.views.components.Sidebar;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.*;

public class HomeView extends JFrame {
    Sidebar sidebar;
    MainDashboardContentArea mainContent;


    public HomeView() {

        buildView();

    }

    private void buildView() {
        setLayout(null);
        setBackground(AppColors.whiteColor);
        //init components
        sidebar = new Sidebar();
        mainContent=new ShowClientsView();

        //composing the view
        add(sidebar);
        add(mainContent);
        setLocationRelativeTo(null);
        setSize(819, 512);
        setVisible(true);
    }
}
