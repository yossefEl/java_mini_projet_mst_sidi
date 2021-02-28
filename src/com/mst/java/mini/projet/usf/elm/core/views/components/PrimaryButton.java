package com.mst.java.mini.projet.usf.elm.core.views.components;

import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.JButton;
import java.awt.*;

public class PrimaryButton extends JButton{


    public PrimaryButton() {
        super("Text");
        setSize(100,20);
        setBorderPainted(false);
        setOpaque(true);
        setBackground(Color.RED);

    }

}
