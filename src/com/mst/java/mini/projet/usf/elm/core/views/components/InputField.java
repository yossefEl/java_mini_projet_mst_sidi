package com.mst.java.mini.projet.usf.elm.core.views.components;

import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.*;
import java.awt.Rectangle;

public class InputField extends JTextField {
    public InputField(Rectangle bounds){
        setBounds(bounds);
        setBackground(AppColors.lightGreyColor);
    }
}
