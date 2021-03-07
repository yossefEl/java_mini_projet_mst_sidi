package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.controllers.SidebarController;
import com.mst.java.mini.projet.usf.elm.core.views.components.MainDashboardContentArea;
import com.mst.java.mini.projet.usf.elm.core.views.components.Sidebar;
import com.mst.java.mini.projet.usf.elm.core.views.components.SidebarItem;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class DashboardView extends JPanel implements ActionListener {
    public Sidebar sidebar;
    public MainDashboardContentArea mainContent;
    public SidebarController sidebarController;
    public final ArrayList<MainDashboardContentArea> contentAreaItems = new ArrayList<>(
            Arrays.asList(new AddClientView(),
                    new UpdateDeleteClientView(),
                    new ShowClientsView(),
                    new UpdateDatabaseConfigView()
            )
    );

    public DashboardView() {
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
        mainContent = contentAreaItems.get(0);

        //composing the view
        add(sidebar);
        add(mainContent);
        setSize(819, 512);
        setVisible(true);


        sidebarController.initialize(this);
        initializeSidebarItemsListeners();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    void initializeSidebarItemsListeners() {
        for (SidebarItem item : sidebar.sidebarItems
        ) {
            item.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    sidebarController.handleSidebarSelection(item);
                }
            });
        }
    }
}
