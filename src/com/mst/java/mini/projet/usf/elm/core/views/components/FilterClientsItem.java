package com.mst.java.mini.projet.usf.elm.core.views.components;

import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FilterClientsItem extends JPanel {
    public JRadioButton radioButton;
    public FilterClientsItem(Rectangle bounds, String filterName)
    {
        super(new FlowLayout());
        JLabel filterLabel=new JLabel(filterName);
        filterLabel.setBorder(new EmptyBorder(0,3,0,0));
        filterLabel.setFont(new Font("Arial",Font.BOLD,15));
        filterLabel.setForeground(AppColors.black50Color);

        radioButton=new JRadioButton();

        add(filterLabel);
        setBounds(bounds);
        setVisible(true);
    }
}
