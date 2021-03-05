package com.mst.java.mini.projet.usf.elm.core.controllers;

import com.mst.java.mini.projet.usf.elm.core.views.DashboardView;
import com.mst.java.mini.projet.usf.elm.core.views.components.MainDashboardContentArea;
import com.mst.java.mini.projet.usf.elm.core.views.components.Sidebar;
import com.mst.java.mini.projet.usf.elm.core.views.components.SidebarItem;

import javax.swing.*;
import java.util.ArrayList;

public class SidebarController {
    DashboardView parentView;
    ArrayList<SidebarItem> sidebarItems;
    ArrayList<MainDashboardContentArea> contentAreaItems;

    public SidebarController() {


    } public SidebarController(DashboardView parentView) {
        this.parentView = parentView;
        contentAreaItems = parentView.contentAreaItems;
        sidebarItems = parentView.sidebar.sidebarItems;


    }



    public void initialize(
            DashboardView parentView
    ) {
        this.parentView = parentView;
        contentAreaItems = parentView.contentAreaItems;
        sidebarItems = parentView.sidebar.sidebarItems;
    }


    public void handleSidebarSelection(SidebarItem selectedItem) {
        setActiveSidebarItem(selectedItem);
        showRelatedContent(sidebarItems.indexOf(selectedItem));
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
        System.out.println("index of content area: "+ itemIndex);
        parentView.mainContent=contentAreaItems.get(itemIndex);
        parentView.mainContent.setVisible(true);

//        FIX the main content area is not working

    }

}
