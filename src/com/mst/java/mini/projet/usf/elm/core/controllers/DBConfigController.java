package com.mst.java.mini.projet.usf.elm.core.controllers;

import com.mst.java.mini.projet.usf.elm.core.models.DBConfig;
import com.mst.java.mini.projet.usf.elm.core.views.ConfigureDatabaseView;
import com.mst.java.mini.projet.usf.elm.core.views.HomeView;
import com.mst.java.mini.projet.usf.elm.helpers.DBHelper;
import com.mst.java.mini.projet.usf.elm.helpers.DialogHelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class DBConfigController {
    private final ConfigureDatabaseView configureDatabaseView;
    private final DBHelper dbHelper;
    private HomeView homeView;

    public DBConfigController(ConfigureDatabaseView configureDatabaseView) {

        this.configureDatabaseView = configureDatabaseView;
        configureDatabaseView.addOnSaveConfigActionListener(new OnSaveConfigurationsActionLisnter());
        dbHelper = new DBHelper();
    }

    /**
     * Handles the save configurations action
     */


    private void handleOnSaveConfigurations() {
        handleSavingLoadingAnimation(true);

        final DBConfig databaseConfig = new DBConfig(
                configureDatabaseView.getServerAddress(),
                configureDatabaseView.getDBName(),
                configureDatabaseView.getTableName(),
                configureDatabaseView.getDbUsername(),
                configureDatabaseView.getDbPassword()

        );

        if (databaseConfig.hasEssentialConfigurations()) {
            DialogHelper.showErrorMessage(configureDatabaseView, "Erreur");
        } else {
            dbHelper.setDatabaseConfig(databaseConfig);
            try {
                boolean configsSaved = dbHelper.getDatabaseConfig().saveConfiguration();
                //switch to HomeView
                if (configsSaved) {
                    if (dbHelper.isDatabaseConfigured()) {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handleSavingLoadingAnimation(false);


                        homeView.showContent(homeView.getLoginView());
                        homeView.repaint();
                    }
                } else {
                    DialogHelper.showErrorMessage(configureDatabaseView, "Oops ! Une erreur inattendue s'est produite lors de la tentative d'enregistrement des configurations de la base de données. Veuillez réessayer!");
                }
            } catch (Exception e) {
                DialogHelper.showErrorMessage(configureDatabaseView, e.getMessage());
            }

        }

        handleSavingLoadingAnimation(false);

    }


    //this methods is just for showing a loading animation to the save configs button
    //This is good for not confusing the user and letting them that the program is in progress
    private void handleSavingLoadingAnimation(boolean isLoading) {
        if (isLoading) {
            configureDatabaseView.getSaveConfigsButton().setVisible(false);
            configureDatabaseView.getLoadingLabel().setVisible(true);
        } else {
            configureDatabaseView.getSaveConfigsButton().setVisible(true);
            configureDatabaseView.getLoadingLabel().setVisible(false);
        }

    }

    public void setHomeView(HomeView homeView) {
        this.homeView = homeView;
    }


    private class OnSaveConfigurationsActionLisnter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleOnSaveConfigurations();
        }
    }
}
