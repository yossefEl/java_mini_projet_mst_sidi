package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.controllers.AuthController;
import com.mst.java.mini.projet.usf.elm.helpers.DBHelper;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;
import com.mst.java.mini.projet.usf.elm.helpers.AssetsProvider;

import javax.swing.*;

public class LoginView extends JPanel {



    //------- attributes -------
    JLabel appLogoLabel;
    JLabel appNameLabel;
    JLabel usernameLabel;
    JTextField usernameField;
    JLabel passwordLabel;
    JPasswordField passwordField;
    JButton loginButton;
    //------- controllers -------
    AuthController authController;
    DBHelper databaseController;
    HomeView parent;

    public LoginView() {
//        databaseController = new DatabaseController(this);
//        authController = new AuthController();
//        parent = (HomeView) SwingUtilities.getWindowAncestor(this);
        buildView();
    }

    private void buildView() {

        //init components

        appLogoLabel = new JLabel(AssetsProvider.fsteLogo150);
        appLogoLabel.setBounds(335,59,150,150);

        appNameLabel = new JLabel();

        usernameLabel=new JLabel("Nom d’utiistateur");
        usernameLabel.setBounds(220,209,113,17);
        
        usernameField = new JTextField();
        usernameField.setBounds(216,231,388,35);
        usernameField.setBackground(AppColors.lightGreyColor);

        passwordLabel=new JLabel("Mot de passe");
        passwordLabel.setBounds(220,274,90,17);

        passwordField = new JPasswordField();
        passwordField.setBounds(216,296,388,35);
//        passwordField.setUI(new HintTextFieldUI("Password",true,AppColors.borderGreyColor));


        loginButton = new JButton("Se Connecter");
        loginButton.setBounds(216,349,388,35);


        //composing the view
        add(appLogoLabel);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        setBackground(AppColors.whiteColor);
        setLayout(null);
        setSize(819, 512);
        setVisible(true);


    }


}
