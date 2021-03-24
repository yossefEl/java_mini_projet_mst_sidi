package com.mst.java.mini.projet.usf.elm.core.views.components;

import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.JLabel;
import java.awt.*;

public class InputLabel extends JLabel {
    public InputLabel(String text,Rectangle bounds ){
        super(text);
        setFont(new Font("Arial",Font.BOLD,15));
        setForeground(AppColors.black50Color);
        setBounds(bounds);

    }
}
