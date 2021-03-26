package com.mst.java.mini.projet.usf.elm.core.views.components;

import com.mst.java.mini.projet.usf.elm.helpers.AppColors;
import com.mst.java.mini.projet.usf.elm.helpers.AssetsProvider;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Sidebar extends JPanel {
    public SidebarItem addClientSidebarItem;
    public SidebarItem updateDeleteSidebarItem;
    public SidebarItem showClientsSidebarItem;
    public SidebarItem logoutSidebarItem;
    public ArrayList<SidebarItem> sidebarItems;



    public Sidebar() {
        buildSidebar();
    }

    private void buildSidebar() {

        //init components
        JLabel appLogo = new JLabel(AssetsProvider.fsteLogo78);
        appLogo.setBounds(47,4,78,78);

        TitleLabel appName = new TitleLabel("Application de\n", "Gestion des Clients", 11);
        appName.setBounds(23,83,126,30);

        addClientSidebarItem=new SidebarItem(new Point(0,130),"Ajouter un client");
        addClientSidebarItem.setActive(true);
        updateDeleteSidebarItem=new SidebarItem(new Point(0,160),"Modifier /Supprimer client");
        showClientsSidebarItem=new SidebarItem(new Point(0,190),"Afficher les clients");
        logoutSidebarItem=new SidebarItem(new Point(0,220),"Déconnexion");
        logoutSidebarItem.setIsView(false);
        sidebarItems = new ArrayList<>(Arrays.asList(
                addClientSidebarItem,
                updateDeleteSidebarItem,
                showClientsSidebarItem,
                logoutSidebarItem
                ));
        //composing the U
        add(appLogo);
        add(appName);
        add(addClientSidebarItem);
        add(updateDeleteSidebarItem);
        add(showClientsSidebarItem);
        add(logoutSidebarItem);
        setLayout(null);
        setBounds(0, 0, 182, 512);
        setBackground(AppColors.darkGreyColor);

    }
}
