package com.mst.java.mini.projet.usf.elm.core.views.components;

import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.*;

public class MainDashboardContentArea extends JPanel {
    public DashAreaTitle title;
    public MainDashboardContentArea(){
        setLayout(null);
        setBounds(182,0,637,512);
        setBackground(AppColors.whiteColor);
        setVisible(false);

    }
}
