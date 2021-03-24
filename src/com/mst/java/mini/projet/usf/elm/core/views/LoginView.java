package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.helpers.AppColors;
import com.mst.java.mini.projet.usf.elm.helpers.AssetsProvider;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginView extends JPanel {


    public HomeView parent;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    //------- controllers -------


    public LoginView() {
        parent = (HomeView) SwingUtilities.getWindowAncestor(this);
        buildView();
    }

    private void buildView() {

        //init components

        //------- attributes -------
        JLabel appLogoLabel = new JLabel(AssetsProvider.fsteLogo150);
        appLogoLabel.setBounds(335, 59, 150, 150);

        JLabel appNameLabel = new JLabel();

        JLabel usernameLabel = new JLabel("Nom d’utiistateur");
        usernameLabel.setBounds(220, 209, 113, 17);
        usernameLabel.setBounds(220, 209, 113, 17);

        usernameField = new JTextField();
        usernameField.setBounds(216, 231, 388, 35);
        usernameField.setBackground(AppColors.lightGreyColor);

        JLabel passwordLabel = new JLabel("Mot de passe");
        passwordLabel.setBounds(220, 274, 90, 17);

        passwordField = new JPasswordField();
        passwordField.setBounds(216, 296, 388, 35);
        passwordField.setBackground(AppColors.lightGreyColor);
//        passwordField.setUI(new HintTextFieldUI("Password",true,AppColors.borderGreyColor));


        loginButton = new JButton("Se Connecter");
        loginButton.setBounds(216, 349, 388, 35);


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


    //getters and setters


    public char[] getPasswordInput() {
        return passwordField.getPassword();
    }

    public String getUsernameInput() {
        return usernameField.getText();
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void addAuthActionListener(ActionListener listener){
        loginButton.addActionListener(listener);

    }
}
