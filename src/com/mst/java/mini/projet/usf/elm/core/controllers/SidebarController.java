package com.mst.java.mini.projet.usf.elm.core.controllers;

import com.mst.java.mini.projet.usf.elm.core.views.DashboardView;
import com.mst.java.mini.projet.usf.elm.core.views.components.MainDashboardContentArea;
import com.mst.java.mini.projet.usf.elm.core.views.components.SidebarItem;

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
        contentAreaItems = parentView.contentAreaItems;
        sidebarItems = parentView.sidebar.sidebarItems;
        initializeSidebarItemsListeners();
        initializeContentItems();
    }


    public void initialize(
            DashboardView parentView
    ) {
        this.parentView = parentView;
        contentAreaItems = parentView.contentAreaItems;
        sidebarItems = parentView.sidebar.sidebarItems;
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
        for (MainDashboardContentArea item: contentAreaItems
             ) {
            item.setVisible(contentAreaItems.get(itemIndex)==item);
        }

    }

}
