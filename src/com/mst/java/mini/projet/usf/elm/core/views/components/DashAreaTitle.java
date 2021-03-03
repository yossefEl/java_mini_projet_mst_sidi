package com.mst.java.mini.projet.usf.elm.core.views.components;

import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.Font;

public class DashAreaTitle extends JLabel
{
    public  DashAreaTitle(Rectangle bounds, String titleText){
            super(titleText.toUpperCase());
            setFont(new Font("Arial",Font.BOLD,16));
            setForeground(AppColors.black50Color);
            setBounds(bounds);
    }
}
