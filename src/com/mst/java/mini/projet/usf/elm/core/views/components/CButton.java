package com.mst.java.mini.projet.usf.elm.core.views.components;

import com.mst.java.mini.projet.usf.elm.helpers.AppColors;
import com.mst.java.mini.projet.usf.elm.helpers.PathHelper;

import javax.swing.JButton;
import java.awt.*;

//CButton -> Custom button
// this is for decorated and customized button component to avoid repeating the code
public class CButton extends JButton {


    public CButton(String text, Rectangle bounds, Color backgroundColor) {
        super(text);
        setBounds(bounds);
        setOpaque(true);
        if (PathHelper.isWindows()) {
            setBackground(backgroundColor);
            setForeground(AppColors.whiteColor);
        }


    }

}
