package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.views.components.PrimaryButton;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    public LoginView(){
        buildView();
    }

    private void buildView() {
        setLayout(null);
        PrimaryButton primaryButton = new PrimaryButton();

        add(primaryButton.button);
        setVisible(true);
        setSize(820,500);

        setLocationRelativeTo(null);
    }
}
