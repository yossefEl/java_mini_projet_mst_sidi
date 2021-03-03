package com.mst.java.mini.projet.usf.elm.core.views.components;

import com.mst.java.mini.projet.usf.elm.helpers.AppColors;
import com.mst.java.mini.projet.usf.elm.helpers.AssetsProvider;

import javax.swing.*;
import java.awt.*;

public class Sidebar extends JPanel {
    private JLabel appLogo;
    private TitleLabel appName;
    public SidebarItem addClientSidebarItem;
    public SidebarItem updateDeleteSidebarItem;
    public SidebarItem showClientsSidebarItem;
    public SidebarItem configureDBSidebarItem;



    public Sidebar() {
        buildSidebar();
    }

    private void buildSidebar() {

        //init components
        appLogo=new JLabel(AssetsProvider.fsteLogo78);
        appLogo.setBounds(47,4,78,78);

        appName=new TitleLabel("Application de\n","Gestion des Clients",11);
        appName.setBounds(23,83,126,30);

        addClientSidebarItem=new SidebarItem(new Point(0,130),"Ajouter un client");
        addClientSidebarItem.setActive(true);
        updateDeleteSidebarItem=new SidebarItem(new Point(0,160),"Modifier /Supprimer client");
        showClientsSidebarItem=new SidebarItem(new Point(0,190),"Afficher les clients");
        configureDBSidebarItem=new SidebarItem(new Point(0,220),"Configurer");

        //composing the U
        add(appLogo);
        add(appName);
        add(addClientSidebarItem);
        add(updateDeleteSidebarItem);
        add(showClientsSidebarItem);
        add(configureDBSidebarItem);
        setLayout(null);
        setBounds(0, 0, 182, 512);
        setBackground(AppColors.darkGreyColor);

    }
}
