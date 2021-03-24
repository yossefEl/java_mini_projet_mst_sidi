package com.mst.java.mini.projet.usf.elm.core.controllers;


import com.mst.java.mini.projet.usf.elm.core.models.Admin;
import com.mst.java.mini.projet.usf.elm.core.views.HomeView;
import com.mst.java.mini.projet.usf.elm.core.views.LoginView;
import com.mst.java.mini.projet.usf.elm.helpers.DialogHelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AuthController {

    //------- attributes ---------
    private final Admin admin;
    private final LoginView loginView;
    private final HomeView homeView;


    //-------constructors ---------
    public AuthController(LoginView loginView,HomeView homeView) {
        admin = new Admin();
        this.loginView = loginView;
        this.homeView=homeView;
        this.loginView.addAuthActionListener(new AuthActionListener());
    }


    //-------getters and setters ---------
    public Admin getAdmin() {
            return admin;
    }


    // listeners
    private class AuthActionListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Se Connecter")) {
                admin.setUsername(loginView.getUsernameInput());
                admin.setPassword(String.copyValueOf(loginView.getPasswordInput()));
                try {
                    if (admin.authenticate()) {
                        homeView.showContent(homeView.getDashboardView());
                    } else {
                        DialogHelper.showErrorMessage(loginView,
                                "Echec d'authentification",
                                "Votre mot de pass ou login est incorrect");
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                    DialogHelper.showErrorMessage(loginView,
                            "Une erreur est survenue:\n" + exception.getMessage());
                }
            }
        }
    }


}
