package com.mst.java.mini.projet.usf.elm.core.views.components;

import com.mst.java.mini.projet.usf.elm.helpers.AppColors;
import com.mst.java.mini.projet.usf.elm.helpers.PathHelper;

import javax.swing.JButton;
import java.awt.*;

//Primary Button -> Custom button
// this is for decorated and customized button component to avoid repeating the code
public class PrimaryButton extends JButton {


    public PrimaryButton(String text, Rectangle bounds, Color backgroundColor) {
        super(text);
        setBounds(bounds);
        setOpaque(true);
        if (PathHelper.isWindows()) {
            //this decoration is only working under Windows OS
            //On MacOs Big Sur version (in my case) it is not valid
            setBackground(backgroundColor);
            setForeground(AppColors.whiteColor);
        }


    }

}
