package com.mst.java.mini.projet.usf.elm.core.controllers;

import com.mst.java.mini.projet.usf.elm.core.views.DashboardView;
import com.mst.java.mini.projet.usf.elm.core.views.HomeView;
import com.mst.java.mini.projet.usf.elm.core.views.components.MainDashboardContentArea;
import com.mst.java.mini.projet.usf.elm.core.views.components.SidebarItem;
import com.mst.java.mini.projet.usf.elm.helpers.DialogHelper;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SidebarController {
    DashboardView parentView;
    ArrayList<SidebarItem> sidebarItems;
    ArrayList<MainDashboardContentArea> contentAreaItems;

    public SidebarController() {

    }
    public SidebarController(DashboardView parentView) {
        this.parentView = parentView;
        contentAreaItems = parentView.getContentAreaItems();
        sidebarItems = parentView.getSidebar().sidebarItems;
        initializeSidebarItemsListeners();
        initializeContentItems();
    }


    public void initialize(
            DashboardView parentView
    ) {
        this.parentView = parentView;
        contentAreaItems = parentView.getContentAreaItems();
        sidebarItems = parentView.getSidebar().sidebarItems;
        initializeSidebarItemsListeners();
        initializeContentItems();
    }


    private void initializeSidebarItemsListeners() {
        for (SidebarItem item : sidebarItems
        ) {
            item.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                           handleSidebarSelection(item);
                }
            });
        }
    }

    private void initializeContentItems() {
        for (MainDashboardContentArea item : contentAreaItems
        ) {
            item.setVisible(false);
           parentView.add(item);
        }
        contentAreaItems.get(0).setVisible(true);
    }


    public void handleSidebarSelection(SidebarItem selectedItem) {
        System.out.println(selectedItem.getItemLabelText());
        if(selectedItem.getItemLabelText().equalsIgnoreCase("Déconnexion")){
            final int confirmation= DialogHelper.showConfirmationDialog(
                    parentView,
                    "Êtes-vous sûr de vous déconnecter?"

            );
            if(confirmation==0){
                HomeView homeView =parentView.getHomeView();
                homeView.showContent(homeView.getLoginView());
            }
        }else{
        setActiveSidebarItem(selectedItem);
        showRelatedContent(sidebarItems.indexOf(selectedItem));}

    }

    private void setActiveSidebarItem(SidebarItem selectedItem) {
        for (SidebarItem sidebarItem : sidebarItems) {
            if (sidebarItem == selectedItem) {
                selectedItem.setActive(true);
            } else {
                sidebarItem.setActive(false);
            }
        }
        parentView.repaint();
    }

    private void showRelatedContent(int itemIndex) {
        for (MainDashboardContentArea item: contentAreaItems
             ) {
            item.setVisible(contentAreaItems.get(itemIndex)==item);
        }

    }

}
