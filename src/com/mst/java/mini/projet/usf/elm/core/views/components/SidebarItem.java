package com.mst.java.mini.projet.usf.elm.core.views.components;

import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SidebarItem extends JPanel{
    private boolean isActive;
    private String itemLabelText;
    private JLabel itemLabel;

    public SidebarItem(Point position, String itemLabelText) {

        setLayout(new BorderLayout());
        itemLabel= new JLabel(itemLabelText);
        itemLabel.setFont(new Font("Arial",Font.BOLD,12));
        itemLabel.setBorder(new EmptyBorder(0,10,0,0));
        add(itemLabel, BorderLayout.CENTER);
        setBounds(position.x, position.y, 182, 30);
        setActive(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
        if(active){
            setBackground(AppColors.blueColor);
            itemLabel.setForeground(AppColors.whiteColor);
        }else{
            setBackground(AppColors.darkGreyColor);
            itemLabel.setForeground(AppColors.blueColor);
        }
    }

    public String getItemLabel() {
        return itemLabelText;
    }

    public void setItemLabel(String itemLabelText) {
        this.itemLabelText = itemLabelText;
    }



}
