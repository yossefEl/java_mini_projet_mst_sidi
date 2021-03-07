package com.mst.java.mini.projet.usf.elm.core.views;

import com.mst.java.mini.projet.usf.elm.core.controllers.DatabaseController;
import com.mst.java.mini.projet.usf.elm.core.models.DatabaseConfigModel;
import com.mst.java.mini.projet.usf.elm.core.views.components.CButton;
import com.mst.java.mini.projet.usf.elm.core.views.components.InputField;
import com.mst.java.mini.projet.usf.elm.core.views.components.InputLabel;
import com.mst.java.mini.projet.usf.elm.core.views.components.TitleLabel;
import com.mst.java.mini.projet.usf.elm.helpers.AppColors;
import com.mst.java.mini.projet.usf.elm.helpers.AssetsProvider;
import com.mst.java.mini.projet.usf.elm.helpers.DialogHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigureDatabaseView extends JPanel implements ActionListener {

    JLabel appLogo;
    JLabel appLabel;
    JLabel loadingLabel;
    JLabel serverAddressLabel;
    JTextField serverAddressField;
    JLabel dbNameLabel;
    JTextField dbNameField;
    JLabel tableNameLabel;
    JTextField tableNameField;
    JLabel dbUsernameLabel;
    JTextField dbUsernameField;
    JLabel dbPasswordLabel;
    JTextField dbPasswordField;
    JButton saveConfigsButton;

    ///

    DatabaseController databaseController;

    public ConfigureDatabaseView() {
        databaseController = new DatabaseController(this);
        buildView();
    }

    private void buildView() {
        setLayout(null);

        //init components
        appLogo = new JLabel(AssetsProvider.fsteLogo150);
        appLogo.setBounds(336, 9, 150, 150);

        appLabel = new TitleLabel("Configurer", "la base données");
        appLabel.setBounds(262, 159, 800, 20);

        serverAddressLabel = new InputLabel("Adresse Serveur",
                new Rectangle(210, 208, 112, 17));
        serverAddressField = new InputField(new Rectangle(344, 198, 260, 35));

        dbNameLabel = new InputLabel("Base données",
                new Rectangle(210, 251, 112, 17));
        dbNameField = new InputField(new Rectangle(344, 242, 260, 35));

        tableNameLabel = new InputLabel("La table",
                new Rectangle(210, 295, 112, 17));
        tableNameField = new InputField(new Rectangle(344, 286, 260, 35));

        dbUsernameLabel = new InputLabel("Utilisateur",
                new Rectangle(210, 338, 112, 17));
        dbUsernameField = new InputField(new Rectangle(344, 330, 260, 35));

        dbPasswordLabel = new InputLabel("Mot de passe",
                new Rectangle(210, 382, 112, 17));
        dbPasswordField = new InputField(new Rectangle(344, 374, 260, 35));

        saveConfigsButton = new CButton("Terminer",
                new Rectangle(210, 424, 394, 35),
                AppColors.blueColor);
        saveConfigsButton.addActionListener(this);

        loadingLabel = new JLabel(AssetsProvider.loadingImage45,SwingConstants.CENTER);
        loadingLabel.setBounds(210, 424, 394, 45);
        loadingLabel.setVisible(false);

        //composing components


        add(appLogo);
        add(appLabel);
        add(serverAddressLabel);
        add(serverAddressField);
        add(dbNameLabel);
        add(dbNameField);
        add(tableNameLabel);
        add(tableNameField);
        add(dbUsernameLabel);
        add(dbUsernameField);
        add(dbPasswordLabel);
        add(dbPasswordField);
        add(saveConfigsButton);
        add(loadingLabel);
        setSize(819, 512);

        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Terminer")) {
            onSaveConfigurations();
        }
    }

    private void onSaveConfigurations() {
        handleSavingLoadingAnimation(true);
        final DatabaseConfigModel databaseConfig = new DatabaseConfigModel(
                serverAddressField.getText(),
                dbNameField.getText(),
                tableNameField.getText(),
                dbUsernameField.getText(),
                dbPasswordField.getText()

        );

        if (databaseConfig.hasEssentialConfigurations()) {
            DialogHelper.showErrorMessage(this, "Erruer");
        } else {
            databaseController.setDatabaseConfig(databaseConfig);
            try {
                boolean configsSaved = databaseController.saveDatabaseConfigurations();
                //switch to HomeView
                if (configsSaved) {
                    if (databaseController.isDatabaseConfigured()) {
                        handleSavingLoadingAnimation(false);
                        HomeView parent = (HomeView) SwingUtilities.getWindowAncestor(this);
                        parent.showContent(parent.loginView);
                        parent.repaint();
                    }
                } else {
                    DialogHelper.showErrorMessage(this, "Oops ! Une erreur inattendue s'est produite lors de la tentative d'enregistrement des configurations de la base de données. Veuillez réessayer!");
                }
            } catch (Exception e) {
                DialogHelper.showErrorMessage(this, e.getMessage());
            }

        }


        handleSavingLoadingAnimation(false);

    }


    //this methods is just for showing a loading animation to the save configs button
    //This is good for not confusing the user and letting them that the program is in progress
    private void handleSavingLoadingAnimation(boolean isLoading) {
        if (isLoading) {
            saveConfigsButton.setVisible(false);
            loadingLabel.setVisible(true);
        } else {
            saveConfigsButton.setVisible(true);
            loadingLabel.setVisible(false);
        }

    }
}
