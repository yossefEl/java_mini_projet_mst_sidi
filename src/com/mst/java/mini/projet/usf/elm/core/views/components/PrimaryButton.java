package com.mst.java.mini.projet.usf.elm.core.views.components;

import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.JButton;
import java.awt.*;

public class PrimaryButton {
    public JButton button;

    public PrimaryButton() {
        JButton btn = new JButton();
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.BLUE);
        btn.setVisible(true);
        button = btn;
    }

}
